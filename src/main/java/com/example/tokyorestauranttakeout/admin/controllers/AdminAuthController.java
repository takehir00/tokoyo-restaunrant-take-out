package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(AdminServerPaths.AUTH)
public class AdminAuthController {
    /**
     * ログイン画面
     *
     * @param mav
     * @return
     */
    @GetMapping("/login")
    public ModelAndView loginForm(ModelAndView mav) {
        mav.setViewName("/admin/auth/loginForm");
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
        return "redirect:" + AdminServerPaths.ROOT;
    }

    /**
     * ログイン失敗時の画面遷移
     *
     * @return
     */
    @PostMapping("/failure")
    public String loginFailure() {
        return "redirect:" + AdminServerPaths.AUTH + "/login";
    }

    /**
     * ログアウト画面
     *
     * @param mav
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logoutForm(ModelAndView mav) {
        mav.setViewName("/admin/auth/logoutForm");
        return mav;
    }
}
