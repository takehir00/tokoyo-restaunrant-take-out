package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.ClientServerPaths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(ClientServerPaths.AUTH)
public class AuthController {

    /**
     * ログイン画面
     * @param mav
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("client/auth/loginForm");
        return mav;
    }

    /**
     * ログイン
     *
     * @param
     * @return
     */
    @PostMapping("/login")
    public String login() {

        return "forward:/authenticate";
    }

    /**
     * ログイン成功時の画面遷移
     *
     * @param
     * @return
     */
    @PostMapping("/success")
    public String loginSuccess() {
        return "redirect:" + ClientServerPaths.PUB;
    }

    /**
     * ログイン失敗時の画面遷移
     *
     * @return
     */
    @PostMapping("/failure")
    public String loginFailure() {
        return "redirect:" + ClientServerPaths.AUTH + "/login";
    }

    /**
     * ログアウト画面
     *
     * @param mav
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logoutForm(ModelAndView mav) {
        mav.setViewName("/client/auth/logoutForm");
        return mav;
    }
}
