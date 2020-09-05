package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


@Controller
public class AdminMenusController {
    @Autowired
    AdminMenuService adminMenuService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus")
    public ModelAndView index(ModelAndView mav) throws IOException {
        mav.addObject("menuIndexResponse",
                adminMenuService.getIndexResponse());
        mav.setViewName("admin/menus/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/{menuId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long menuId) {
        mav.setViewName("admin/menus/index");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.addObject("registerFormResponse", adminMenuService.getRegisterFormResponse());
        mav.setViewName("admin/menus/registerForm");
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
    @PostMapping("/admin/menus/register")
    public String register(
            @ModelAttribute("registerForm") AdminMenuRegisterForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminMenuService.create(registerForm);
        return "redirect:/admin/menus";
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/update/{menuId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer menuId) {
        mav.addObject("updateFormResponse",adminMenuService.getUpdateFormResponse(menuId));
        mav.setViewName("admin/menus/updateForm");
        return mav;
    }

    /**
     * 更新
     * @param updateForm
     * @param bindingResult
     * @param attributes
     * @return
     */
    @Transactional
    @PostMapping("/admin/menus/update")
    public String update(
            @ModelAttribute("updateForm") AdminMenuUpdateForm updateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminMenuService.update(updateForm);
        return "redirect:/admin/menus";
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/menus/delete/{wardId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Long menuId) {
        mav.setViewName("admin/menus/deleteForm");
        return mav;
    }
}
