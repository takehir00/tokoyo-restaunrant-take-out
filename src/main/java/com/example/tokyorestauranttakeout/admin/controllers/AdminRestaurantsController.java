package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.services.AdminRestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminRestaurantsController {

    @Autowired
    AdminRestaurantsService adminRestaurantsService;
    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("admin/restaurants/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants/{restaurantId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long restaurantId) {
        mav.setViewName("admin/restaurants/show");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.addObject("registerForm", adminRestaurantsService.getCreateFormResponse());
        mav.setViewName("admin/restaurants/registerForm");
        return mav;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants/update/{restaurantId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Long restaurantId) {
        mav.setViewName("admin/restaurants/updateForm");
        return mav;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants/delete/{restaurantId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Long restaurantId) {
        mav.setViewName("admin/restaurants/deleteForm");
        return mav;
    }
}
