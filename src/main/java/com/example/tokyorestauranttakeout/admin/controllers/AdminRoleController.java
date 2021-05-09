package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleUpdateFormResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminRoleService;
import com.example.tokyorestauranttakeout.security.admin.AdminLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{roleId}")
    public ModelAndView updateForm(@AuthenticationPrincipal AdminLoginUser adminLoginUser,
                                   ModelAndView mav,
                                   @PathVariable Integer roleId,
                                   @ModelAttribute("modelMap") ModelMap modelMap) {
        // バリデーションエラーがあった場合
        if (modelMap.get("updateForm") != null) {
            AdminRoleUpdateForm updateForm =
                    (AdminRoleUpdateForm) modelMap.get("updateForm");
            mav.addObject("roleId", roleId);
            mav.addObject("updateForm", updateForm);
        } else {
            AdminRoleUpdateFormResponse updateFormResponse = adminRoleService.getUpdateFormResponse(roleId);
            mav.addObject("roleId", updateFormResponse.getRoleId());
            mav.addObject("updateForm", updateFormResponse.getUpdateForm());
        }
        mav.addObject("account", adminLoginUser);
        mav.addObject("org.springframework.validation.BindingResult.updateForm", modelMap.get("bindingResult"));
        mav.setViewName("admin/roles/updateForm");
        return mav;
    }

    /**
     * 更新
     * @param updateForm
     * @param bindingResult
     * @param attributes
     * @return
     * @throws IOException
     */
    @Transactional
    @PostMapping("/update/{roleId}")
    public String update(
            @Validated @ModelAttribute("updateForm") AdminRoleUpdateForm updateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes,
            @PathVariable Integer roleId) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("updateForm", updateForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.ROLE + "/update/" + roleId;
        }
        adminRoleService.update(roleId,updateForm);
        return "redirect:" + AdminServerPaths.ROLE;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{roleId}")
    public ModelAndView deleteForm(@AuthenticationPrincipal AdminLoginUser adminLoginUser,
                                   ModelAndView mav,
                                   @PathVariable Integer roleId) {
        mav.addObject("account", adminLoginUser);
        mav.addObject("deleteFormResponse",
                adminRoleService.getDeleteFormResponse(roleId));
        mav.setViewName("admin/roles/deleteForm");
        return mav;
    }

    /**
     * 削除
     * @return
     * @throws IOException
     */
    @Transactional
    @PostMapping("/delete/{roleId}")
    public String delete(
            @PathVariable Integer roleId) throws IOException {
        adminRoleService.delete(roleId);
        return "redirect:" + AdminServerPaths.ROLE;
    }
}
