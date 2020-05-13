package com.example.tokyorestauranttakeout.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WardController {

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("templates/wards/index");
        return mav;
    }
}
