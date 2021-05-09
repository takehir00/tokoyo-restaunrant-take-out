package com.example.tokyorestauranttakeout.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * カスタムLoginUrlAuthenticationEntryPoint
 */
public class CustomLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private static final Log logger = LogFactory
            .getLog(CustomLoginUrlAuthenticationEntryPoint.class);

    private boolean forceHttps = false;

    private boolean useForward = false;

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * @param loginFormUrl URL where the login page can be found. Should either be
     *                     relative to the web-app context path (include a leading {@code /}) or an absolute
     *                     URL.
     */
    public CustomLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        String redirectUrl = null;

        if (useForward) {

            if (forceHttps && "http".equals(request.getScheme())) {
                redirectUrl = buildHttpsRedirectUrlForRequest(request);
            }

            if (redirectUrl == null) {
                String loginForm = determineUrlToUseForThisRequest(request, response,
                        authException);

                if (logger.isDebugEnabled()) {
                    logger.debug("Server side forward to: " + loginForm);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(loginForm);

                dispatcher.forward(request, response);

                return;
            }
        }
        else {
            redirectUrl = buildRedirectUrlToLoginPage(request, response, authException);

            // ログイン画面用フラッシュメッセージの設定
            List<FlashMap> flashMapList = new ArrayList<>();
            FlashMap flashMap = new FlashMap();
            flashMap.addTargetRequestParam("loginRequired","loginが必要です。");
            flashMap.put("hoge","piyo");
            flashMapList.add(flashMap);
            // ぬるぽ、調査時間かかりすぎたので一旦断念。またいつか。
            FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
            flashMapManager.saveOutputFlashMap(flashMap,request,response);
        }

        redirectStrategy.sendRedirect(request, response, redirectUrl);
    }
}
