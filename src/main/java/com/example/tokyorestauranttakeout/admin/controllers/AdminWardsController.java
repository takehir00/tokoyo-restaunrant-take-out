package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.forms.ward.WardDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.ward.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.ward.WardUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.ward.AdminWardDeleteResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminWardService;
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
public class AdminWardsController extends AdminControllerBase {

    @Autowired
    AdminWardService adminWardService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards")
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.addObject("wardIndexResponse", adminWardService.getIndexResponse());
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
                             @PathVariable Integer wardId) {
        mav.addObject("account", getAccount());
        mav.addObject("ward", adminWardService.getShowResponse(wardId));
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
        mav.addObject("account", getAccount());
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
            RedirectAttributes attributes) throws IOException {
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
                                   @PathVariable Integer wardId) {
        mav.addObject("account", getAccount());
        mav.addObject("wardUpdateForm", adminWardService.getUpdateForm(wardId));
        mav.setViewName("admin/wards/updateForm");
        return mav;
    }

    /**
     * 更新画面表示
     * @return
     */
    @Transactional
    @PostMapping("/admin/wards/update")
    public String update(@ModelAttribute("wardUpdateForm") WardUpdateForm wardUpdateForm) {
        adminWardService.update(wardUpdateForm);
        return "redirect:/admin/wards";
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/wards/delete/{wardId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer wardId) {
        mav.addObject("account", getAccount());
        mav.addObject("deleteFormResponse",adminWardService.getDeleteFormResponse(wardId));
        mav.setViewName("admin/wards/deleteForm");
        return mav;
    }

    /**
     * 削除画面
     * @return
     */
    @PostMapping("/admin/wards/delete")
    public String delete(
            @ModelAttribute("wardDeleteForm") WardDeleteForm wardDeleteForm) {
        adminWardService.delete(wardDeleteForm.getId());
        return "redirect:/admin/wards";
    }
}
