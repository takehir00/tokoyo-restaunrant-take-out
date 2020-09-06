package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.client.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WardsController {
    //一旦豊島区のみでサービス運営するのでこのクラス不要
//    @Autowired
//    WardService wardService;
//
//    /**
//     * トップ画面表示
//     * @param mav
//     * @return
//     */
//    @GetMapping("/")
//    public ModelAndView index(ModelAndView mav) {
//        mav.addObject("wardIndexResponse", wardService.getIndexResponse());
//        mav.setViewName("client/wards/index");
//        return mav;
//    }
}
