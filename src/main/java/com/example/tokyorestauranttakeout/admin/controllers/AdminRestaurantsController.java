package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminRestaurantsService;
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
public class AdminRestaurantsController extends AdminControllerBase {

    @Autowired
    AdminRestaurantsService adminRestaurantsService;
    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants")
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
    @GetMapping("/admin/restaurants/{restaurantId}")
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
    @GetMapping("/admin/restaurants/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.addObject("registerFormResponse", adminRestaurantsService.getCreateFormResponse());
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
    @PostMapping("/admin/restaurants/register")
    public String register(
            @ModelAttribute("registerForm") AdminRestaurantCreateForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminRestaurantsService.create(registerForm);
        return "redirect:/admin/restaurants";
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants/update/{restaurantId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer restaurantId) {
        mav.addObject("account", getAccount());
        adminRestaurantsService.getUpdateFormResponse(restaurantId);
        mav.addObject("updateFormResponse",
                adminRestaurantsService.getUpdateFormResponse(restaurantId));
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
    @PostMapping("/admin/restaurants/update")
    public String update(
            @ModelAttribute("restaurantUpdateForm") AdminRestaurantUpdateForm restaurantUpdateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminRestaurantsService.update(restaurantUpdateForm);
        return "redirect:/admin/restaurants";
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/restaurants/delete/{restaurantId}")
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
    @PostMapping("/admin/restaurants/delete")
    public String delete(
            @ModelAttribute("deleteForm") AdminRestaurantDeleteForm deleteForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminRestaurantsService.delete(deleteForm);
        return "redirect:/admin/restaurants";
    }
}
