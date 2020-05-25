package com.example.tokyorestauranttakeout.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminWardsController {

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("admin/wards/index");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.setViewName("admin/wards/registerForm");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/update")
    public ModelAndView updateForm(ModelAndView mav) {
        mav.setViewName("admin/wards/updateForm");
        return mav;
    }
}
