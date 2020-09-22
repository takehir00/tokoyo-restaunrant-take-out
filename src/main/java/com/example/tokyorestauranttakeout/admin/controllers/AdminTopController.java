package com.example.tokyorestauranttakeout.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminTopController extends AdminControllerBase {

    @GetMapping("/admin")
    public ModelAndView top(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.setViewName("admin/top/index");
        return mav;
    }
}
