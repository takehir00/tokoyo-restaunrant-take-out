package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.forms.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.services.AdminWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminWardsController {

    @Autowired
    AdminWardService adminWardService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("admin/wards/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/{wardId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long wardId) {
        mav.setViewName("admin/wards/show");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.setViewName("admin/wards/registerForm");
        return mav;
    }

    /**
     * 登録
     * @param wardRegisterForm
     * @param bindingResult
     * @param attributes
     * @return
     */
    @Transactional
    @PostMapping("/admin/wards/register")
    public String register(
            @ModelAttribute("wardRegisterForm") WardRegisterForm wardRegisterForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) {
        MultipartFile image = wardRegisterForm.getImage();
        adminWardService.create(wardRegisterForm);
        return "redirect:/admin/wards";
    }


    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/update/{wardId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Long wardId) {
        mav.setViewName("admin/wards/updateForm");
        return mav;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/delete/{wardId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Long wardId) {
        mav.setViewName("admin/wards/deleteForm");
        return mav;
    }
}
