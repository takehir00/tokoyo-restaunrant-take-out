package com.example.tokyorestauranttakeout.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionsController {
    /**
     * 問い合わせ画面
     * @param mav
     * @return
     */
    @GetMapping("/questions")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("questions/index");
        return mav;
    }
}
