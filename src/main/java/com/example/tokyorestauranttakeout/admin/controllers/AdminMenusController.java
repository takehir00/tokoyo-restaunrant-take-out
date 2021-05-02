package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminCommonPullDownService;
import com.example.tokyorestauranttakeout.admin.services.AdminMenuService;
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
@RequestMapping(AdminServerPaths.MENU)
public class AdminMenusController extends AdminControllerBase  {
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    AdminCommonPullDownService adminCommonPullDownService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(ModelAndView mav) throws IOException {
        mav.addObject("account", getAccount());
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
    @GetMapping("/{menuId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer menuId) {
        mav.addObject("account", getAccount());
        mav.addObject("showResponse",
                adminMenuService.getShowResponse(menuId));

        mav.setViewName("admin/menus/show");
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
        AdminMenuRegisterForm registerForm = new AdminMenuRegisterForm();
        if (modelMap.get("registerForm") != null) {
            registerForm = (AdminMenuRegisterForm) modelMap.get("registerForm");
        }

        mav.addObject("account", getAccount());
        mav.addObject("registerForm", registerForm);
        mav.addObject("org.springframework.validation.BindingResult.registerForm", modelMap.get("bindingResult"));
        mav.addObject("pullDownRestaurantList", adminCommonPullDownService.getRestaurantList());
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
    @PostMapping("/register")
    public String register(
            @Validated @ModelAttribute("registerForm") AdminMenuRegisterForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("registerForm",registerForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.MENU + "/register";
        }
        adminMenuService.create(registerForm);
        return "redirect:" + AdminServerPaths.MENU;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{menuId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer menuId,
                                   @ModelAttribute("modelMap") ModelMap modelMap) {
        mav.addObject("account", getAccount());
        mav.addObject("updateForm",
                adminMenuService.getUpdateFormResponse(
                        menuId,
                        (AdminMenuUpdateForm) modelMap.get("updateForm")));
        mav.addObject("org.springframework.validation.BindingResult.updateForm", modelMap.get("bindingResult"));
        mav.addObject("pullDownRestaurantList", adminCommonPullDownService.getRestaurantList());
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
    @PostMapping("/update")
    public String update(
            @Validated @ModelAttribute("updateForm") AdminMenuUpdateForm updateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("updateForm",updateForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.MENU + "/update/" + updateForm.getId();
        }
        adminMenuService.update(updateForm);
        return "redirect:" + AdminServerPaths.MENU;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{menuId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer menuId) {
        mav.addObject("account", getAccount());
        mav.addObject("deleteFormResponse",
                adminMenuService.getDeleteFormResponse(menuId));
        mav.setViewName("admin/menus/deleteForm");
        return mav;
    }

    /**
     * 削除
     * @param deleteForm
     * @param bindingResult
     * @param attributes
     * @return
     * @throws IOException
     */
    @Transactional
    @PostMapping("/delete")
    public String delete(
            @ModelAttribute("deleteForm") AdminMenuDeleteForm deleteForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminMenuService.delete(deleteForm);
        return "redirect:" + AdminServerPaths.MENU;
    }
}
