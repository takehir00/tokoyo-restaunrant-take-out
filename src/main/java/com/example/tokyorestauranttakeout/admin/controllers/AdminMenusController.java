package com.example.tokyorestauranttakeout.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMenusController {
    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("admin/menus/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/{menuId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long menuId) {
        mav.setViewName("admin/menus/index");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.setViewName("admin/menus/registerForm");
        return mav;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/update/{menuId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Long menuId) {
        mav.setViewName("admin/menus/updateForm");
        return mav;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/delete/{wardId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Long menuId) {
        mav.setViewName("admin/menus/deleteForm");
        return mav;
    }
}
