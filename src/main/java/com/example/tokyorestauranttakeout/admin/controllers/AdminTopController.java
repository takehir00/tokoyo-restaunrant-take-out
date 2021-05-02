package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(AdminServerPaths.ROOT)
public class AdminTopController extends AdminControllerBase {

    @GetMapping
    public ModelAndView top(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.setViewName("admin/top/index");
        return mav;
    }
}
