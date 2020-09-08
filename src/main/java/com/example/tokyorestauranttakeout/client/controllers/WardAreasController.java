package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.client.services.WardAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WardAreasController {

    @Autowired
    WardAreaService wardAreaService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("wardAreaIndexResponse", wardAreaService.getIndexResponse());
        mav.setViewName("client/wardAreas/index");
        return mav;
    }

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/wardarea/{wardAreaId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer wardAreaId) {
        mav.addObject("wardAreaShowResponse", wardAreaService.getShowResponse(wardAreaId));
        mav.setViewName("client/wardAreas/show");
        return mav;
    }
}
