package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.services.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(AdminServerPaths.ROLE)
public class AdminRoleController {

    @Autowired
    AdminRoleService adminRoleService;

    /**
     * トップ画面表示
     * @param mav mav
     * @return トップ画面
     */
    @GetMapping
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("account", null);
        mav.addObject("adminRoleIndexResponse", adminRoleService.getIndexResponse());
        mav.setViewName("admin/roles/index");
        return mav;
    }
}
