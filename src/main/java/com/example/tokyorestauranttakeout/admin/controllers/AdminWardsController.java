package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.ward.WardDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.ward.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.ward.WardUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.ward.AdminWardDeleteResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping(AdminServerPaths.WARD)
public class AdminWardsController extends AdminControllerBase {

    @Autowired
    AdminWardService adminWardService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping
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
    @GetMapping("/{wardId}")
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
    @GetMapping("/register")
    public ModelAndView registerForm(
            ModelAndView mav,
            @ModelAttribute("modelMap") ModelMap modelMap) {

        WardRegisterForm wardRegisterForm = new WardRegisterForm();
        if (modelMap.get("wardRegisterForm") != null) {
            wardRegisterForm = (WardRegisterForm) modelMap.get("wardRegisterForm");
        }
        mav.addObject("wardRegisterForm", wardRegisterForm);
        mav.addObject("org.springframework.validation.BindingResult.wardRegisterForm", modelMap.get("bindingResult"));
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
    @PostMapping("/register")
    public String register(
            @Validated @ModelAttribute("wardRegisterForm") WardRegisterForm wardRegisterForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("wardRegisterForm",wardRegisterForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.WARD + "/register";
        }
        adminWardService.create(wardRegisterForm);
        return "redirect:/admin/wards";
    }


    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{wardId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer wardId,
                                   @ModelAttribute("modelMap") ModelMap modelMap) {
        mav.addObject("account", getAccount());
        if (modelMap.get("wardUpdateForm") == null) {
            mav.addObject("wardUpdateForm", adminWardService.getUpdateForm(wardId));
        } else {
            mav.addObject("wardUpdateForm", modelMap.get("wardUpdateForm"));
        }
        mav.addObject("org.springframework.validation.BindingResult.wardUpdateForm", modelMap.get("bindingResult"));

        mav.setViewName("admin/wards/updateForm");
        return mav;
    }

    /**
     * 更新画面表示
     * @return
     */
    @Transactional
    @PostMapping("/update")
    public String update(
            @Validated @ModelAttribute("wardUpdateForm") WardUpdateForm wardUpdateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("wardUpdateForm",wardUpdateForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.WARD + "/update/" + wardUpdateForm.getId();
        }
        adminWardService.update(wardUpdateForm);
        return "redirect:" + AdminServerPaths.WARD;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{wardId}")
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
    @PostMapping("/delete")
    public String delete(
            @ModelAttribute("wardDeleteForm") WardDeleteForm wardDeleteForm) {
        adminWardService.delete(wardDeleteForm.getId());
        return "redirect:" + AdminServerPaths.WARD;
    }
}
