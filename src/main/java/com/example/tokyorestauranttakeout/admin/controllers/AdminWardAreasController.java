package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.AdminWardAreaDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminCommonPullDownService;
import com.example.tokyorestauranttakeout.admin.services.AdminWardAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping(AdminServerPaths.WARD_AREA)
public class AdminWardAreasController extends AdminControllerBase {
    @Autowired
    AdminWardAreaService adminWardAreaService;

    @Autowired
    AdminCommonPullDownService adminCommonPullDownService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.addObject("wardAreaIndexResponse", adminWardAreaService.getIndexResponse());
        mav.setViewName("admin/ward-areas/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/{wardAreaId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer wardAreaId) {
        mav.addObject("account", getAccount());
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
    @GetMapping("/register")
    public ModelAndView registerForm(
            ModelAndView mav,
            @ModelAttribute("modelMap") ModelMap modelMap) {
        WardAreaRegisterForm wardAreaRegisterForm = new WardAreaRegisterForm();
        if (modelMap.get("wardAreaRegisterForm") != null) {
            wardAreaRegisterForm = (WardAreaRegisterForm) modelMap.get("wardRegisterForm");
        }
        mav.addObject("account", getAccount());
        mav.addObject("wardAreaRegisterForm", wardAreaRegisterForm);
        mav.addObject("org.springframework.validation.BindingResult.wardAreaRegisterForm", modelMap.get("bindingResult"));
        mav.addObject("createFormResponse",
                adminWardAreaService.getCreateFormResponse());
        mav.setViewName("admin/ward-areas/registerForm");
        return mav;
    }


    @Transactional
    @PostMapping("/register")
    public String register(
            @Validated @ModelAttribute("wardAreaRegisterForm") WardAreaRegisterForm wardAreaRegisterForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("wardAreaRegisterForm",wardAreaRegisterForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.WARD_AREA + "/register";
        }
        adminWardAreaService.create(wardAreaRegisterForm);
        return "redirect:" + AdminServerPaths.WARD_AREA;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{wardAreaId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer wardAreaId,
                                   @ModelAttribute("modelMap") ModelMap modelMap) {
        mav.addObject("account", getAccount());
        mav.addObject("wardAreaUpdateForm",
                adminWardAreaService.getUpdateForm(
                        wardAreaId,
                        (WardAreaUpdateForm) modelMap.get("wardAreaUpdateForm")));
        mav.addObject("org.springframework.validation.BindingResult.wardAreaUpdateForm", modelMap.get("bindingResult"));
        mav.addObject("pullDownWardList", adminCommonPullDownService.getWardList());
        mav.setViewName("admin/ward-areas/updateForm");
        return mav;
    }

    /**
     * 更新
     * @param wardAreaUpdateForm
     * @param bindingResult
     * @param attributes
     * @return
     */
    @Transactional
    @PostMapping("/update")
    public String update(
            @Validated @ModelAttribute("wardAreaUpdateForm") WardAreaUpdateForm wardAreaUpdateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("wardAreaUpdateForm",wardAreaUpdateForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.WARD_AREA + "/update/" + wardAreaUpdateForm.getId();
        }
        adminWardAreaService.update(wardAreaUpdateForm);
        return "redirect:" + AdminServerPaths.WARD_AREA;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{wardAreaId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer wardAreaId) {
        mav.addObject("account", getAccount());
        mav.addObject("deleteFormResponse",
                adminWardAreaService.getDeleteFormResponse(wardAreaId));
        mav.setViewName("admin/ward-areas/deleteForm");
        return mav;
    }

    /**
     * 削除
     * @param wardAreaDeleteForm
     * @param bindingResult
     * @param attributes
     * @return
     */
    @Transactional
    @PostMapping("/delete")
    public String delete(@ModelAttribute("wardAreaDeleteForm") AdminWardAreaDeleteForm wardAreaDeleteForm,
                               BindingResult bindingResult,
                               RedirectAttributes attributes) {
        adminWardAreaService.delete(wardAreaDeleteForm);
        return "redirect:" + AdminServerPaths.WARD_AREA;
    }
}
