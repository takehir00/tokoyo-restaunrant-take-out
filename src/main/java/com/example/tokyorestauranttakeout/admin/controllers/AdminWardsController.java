package com.example.tokyorestauranttakeout.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/{wardId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long wardId) {
        mav.setViewName("admin/wards/show");
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
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/update/{wardId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Long wardId) {
        mav.setViewName("admin/wards/updateForm");
        return mav;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/delete/{wardId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Long wardId) {
        mav.setViewName("admin/wards/deleteForm");
        return mav;
    }
}
