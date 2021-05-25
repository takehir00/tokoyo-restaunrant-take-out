package com.example.tokyorestauranttakeout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ログ出力用インターセプター.
 */
public class LoggingInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("from:");
        sb.append(request.getRemoteAddr());
        sb.append("method:");
        sb.append(request.getMethod());
        sb.append("path:");
        sb.append(request.getRequestURI());
        logger.info(sb.toString());
        return true;
    }
}
