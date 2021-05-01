package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminCommonPullDownService;
import com.example.tokyorestauranttakeout.admin.services.AdminRestaurantsService;
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
@RequestMapping(AdminServerPaths.RESTAURANT)
public class AdminRestaurantsController extends AdminControllerBase {

    @Autowired
    AdminRestaurantsService adminRestaurantsService;
    @Autowired
    AdminCommonPullDownService adminCommonPullDownService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("")
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.addObject("restaurantIndexResponse",
                adminRestaurantsService.getIndexResponse());
        mav.setViewName("admin/restaurants/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/{restaurantId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer restaurantId) {
        mav.addObject("account", getAccount());
        mav.addObject("showResponse",
                adminRestaurantsService.getShowResponse(restaurantId));

        mav.setViewName("admin/restaurants/show");
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
        AdminRestaurantCreateForm registerForm = new AdminRestaurantCreateForm();
        if (modelMap.get("registerForm") != null) {
            registerForm = (AdminRestaurantCreateForm) modelMap.get("registerForm");
        }

        mav.addObject("account", getAccount());
        mav.addObject("registerForm", registerForm);
        mav.addObject("org.springframework.validation.BindingResult.registerForm", modelMap.get("bindingResult"));
        mav.addObject("pullDownWardList", adminCommonPullDownService.getWardList());
        mav.addObject("pullDownWardAreaList", adminCommonPullDownService.getWardAreaList());
        mav.setViewName("admin/restaurants/registerForm");
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
            @Validated @ModelAttribute("registerForm") AdminRestaurantCreateForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("registerForm",registerForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.RESTAURANT + "/register";
        }
        adminRestaurantsService.create(registerForm);
        return "redirect:" + AdminServerPaths.RESTAURANT;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{restaurantId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer restaurantId,
                                   @ModelAttribute("modelMap") ModelMap modelMap) {

        mav.addObject("account", getAccount());
        mav.addObject("restaurantUpdateForm",
                adminRestaurantsService.getUpdateForm(restaurantId,
                        (AdminRestaurantUpdateForm) modelMap.get("restaurantUpdateForm")));
        mav.addObject("org.springframework.validation.BindingResult.registerForm", modelMap.get("bindingResult"));
        mav.addObject("pullDownWardList", adminCommonPullDownService.getWardList());
        mav.addObject("pullDownWardAreaList", adminCommonPullDownService.getWardAreaList());
        mav.setViewName("admin/restaurants/updateForm");
        return mav;
    }

    /**
     * 更新
     * @param restaurantUpdateForm
     * @param bindingResult
     * @param attributes
     * @return
     * @throws IOException
     */
    @Transactional
    @PostMapping("/update")
    public String update(
            @Validated @ModelAttribute("restaurantUpdateForm") AdminRestaurantUpdateForm restaurantUpdateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("restaurantUpdateForm",restaurantUpdateForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.RESTAURANT + "/update/" + restaurantUpdateForm.getId();
        }
        adminRestaurantsService.update(restaurantUpdateForm);
        return "redirect:" + AdminServerPaths.RESTAURANT;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{restaurantId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer restaurantId) {
        mav.addObject("account", getAccount());
        mav.addObject("deleteFormResponse",adminRestaurantsService.getDeleteFormResponse(restaurantId));
        mav.setViewName("admin/restaurants/deleteForm");
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
            @ModelAttribute("deleteForm") AdminRestaurantDeleteForm deleteForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminRestaurantsService.delete(deleteForm);
        return "redirect:" + AdminServerPaths.RESTAURANT;
    }
}
