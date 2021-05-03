package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleCreateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminRoleService;
import com.example.tokyorestauranttakeout.security.AdminLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

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
    public ModelAndView index(@AuthenticationPrincipal AdminLoginUser adminLoginUser,
                              ModelAndView mav) {
        mav.addObject("account", adminLoginUser);
        mav.addObject("adminRoleIndexResponse", adminRoleService.getIndexResponse());
        mav.setViewName("admin/roles/index");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/register")
    public ModelAndView registerForm(@AuthenticationPrincipal AdminLoginUser adminLoginUser,
                                     ModelAndView mav,
                                     @ModelAttribute("modelMap") ModelMap modelMap) {
        AdminRoleCreateForm registerForm = new AdminRoleCreateForm();
        if (modelMap.get("registerForm") != null) {
            registerForm = (AdminRoleCreateForm) modelMap.get("registerForm");
        }
        mav.addObject("account", adminLoginUser);
        mav.addObject("registerForm", registerForm);
        mav.addObject("org.springframework.validation.BindingResult.registerForm", modelMap.get("bindingResult"));
        mav.setViewName("admin/roles/registerForm");
        return mav;
    }

    /**
     * 登録
     * @param registerForm
     * @param bindingResult
     * @param attributes
     * @return
     * @throws IOException
     */
    @Transactional
    @PostMapping("/register")
    public String register(
            @Validated @ModelAttribute("registerForm") AdminRoleCreateForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("registerForm",registerForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.ROLE +  "/register";
        }
        adminRoleService.create(registerForm);
        return "redirect:" + AdminServerPaths.ROLE;
    }
}
