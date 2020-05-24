package com.example.tokyorestauranttakeout.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantsController {
    /**
     * 飲食店一覧画面表示
     * @param mav
     * @return
     */
    @GetMapping("/restaurants")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("restaurants/index");
        return mav;
    }

    /**
     * 飲食店詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/restaurants/{restaurantId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long restaurantId) {
        mav.setViewName("restaurants/show");
        return mav;
    }
}
