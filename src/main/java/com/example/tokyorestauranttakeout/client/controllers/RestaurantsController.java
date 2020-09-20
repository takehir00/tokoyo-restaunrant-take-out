package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.client.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantsController {

    @Autowired
    RestaurantsService restaurantsService;

    /**
     * 飲食店一覧画面表示
     * @param mav
     * @return
     */
    @GetMapping("/client/restaurants")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("client/restaurants/index");
        return mav;
    }

    /**
     * 飲食店詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/client/restaurants/{restaurantId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer restaurantId) {
        mav.addObject("restaurantsShowResponse",
                restaurantsService.getShowResponse(restaurantId));
        mav.setViewName("client/restaurants/show");
        return mav;
    }
}
