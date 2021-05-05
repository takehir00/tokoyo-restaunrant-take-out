package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.ClientServerPaths;
import com.example.tokyorestauranttakeout.client.services.WardAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(ClientServerPaths.WARD_AREA)
public class WardAreasController {

    @Autowired
    WardAreaService wardAreaService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/{wardAreaId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer wardAreaId) {
        mav.addObject("wardAreaShowResponse", wardAreaService.getShowResponse(wardAreaId));
        mav.setViewName("client/wardAreas/show");
        return mav;
    }
}
