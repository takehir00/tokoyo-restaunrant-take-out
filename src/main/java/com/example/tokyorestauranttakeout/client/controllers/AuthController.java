package com.example.tokyorestauranttakeout.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client/auth")
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
}
