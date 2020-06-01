package com.example.tokyorestauranttakeout.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AdminWardAreasController {
    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("admin/ward-areas/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/{wardAreaId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long wardAreaId) {
        mav.setViewName("admin/restaurants/show");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.setViewName("admin/ward-areas/registerForm");
        return mav;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/update/{wardAreaId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Long wardAreaId) {
        mav.setViewName("admin/ward-areas/updateForm");
        return mav;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/delete/{wardAreaId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Long wardAreaId) {
        mav.setViewName("admin/ward-areas/deleteForm");
        return mav;
    }
}
