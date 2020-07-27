package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.forms.ward.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.wardArea.AdminWardAreaIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.wardArea.AdminWardAreaShowResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminWardAreaService;
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
public class AdminWardAreasController {
    @Autowired
    AdminWardAreaService adminWardAreaService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas")
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("wardAreaIndexResponse", adminWardAreaService.getIndexResponse());
        mav.setViewName("admin/ward-areas/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/{wardAreaId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer wardAreaId) {
        AdminWardAreaShowResponse m = adminWardAreaService.getShowResponse(wardAreaId);
        mav.addObject("wardAreaShowResponse",
                adminWardAreaService.getShowResponse(wardAreaId));
        mav.setViewName("admin/ward-areas/show");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.addObject("createFormResponse", adminWardAreaService.getCreateFormResponse());
        mav.setViewName("admin/ward-areas/registerForm");
        return mav;
    }


    @Transactional
    @PostMapping("/admin/ward-areas/register")
    public String register(
            @ModelAttribute("wardAreaRegisterForm") WardAreaRegisterForm wardAreaRegisterForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminWardAreaService.create(wardAreaRegisterForm);
        return "redirect:/admin/ward-areas";
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/update/{wardAreaId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer wardAreaId) {
        WardAreaUpdateForm form =
                adminWardAreaService.getUpdateForm(wardAreaId);
        mav.setViewName("admin/ward-areas/updateForm");
        return mav;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/ward-areas/delete/{wardAreaId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer wardAreaId) {
        mav.setViewName("admin/ward-areas/deleteForm");
        return mav;
    }
}
