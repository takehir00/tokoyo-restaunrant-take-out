package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping(AdminServerPaths.ACCOUNT)
public class AdminAccountController extends AdminControllerBase {
    
    @Autowired
    AdminAccountService adminAccountService;
    
    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.addObject("accountIndexResponse", adminAccountService.getIndexResponse());
        mav.setViewName("admin/accounts/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * 一覧画面に表示するだけで情報量十分なのでとりあえず実装しない
     * @param mav
     * @return
     */


    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/register")
    public ModelAndView registerForm(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.setViewName("admin/accounts/registerForm");
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
            @ModelAttribute("registerForm") AdminAccountCreateForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminAccountService.create(registerForm);
        return "redirect:" + AdminServerPaths.ACCOUNT;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{accountId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer accountId) {
        mav.addObject("account", getAccount());
        mav.addObject("updateFormResponse",
                adminAccountService.getUpdateFormResponse(accountId));
        mav.setViewName("admin/accounts/updateForm");
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
    @PostMapping("/update")
    public String update(
            @ModelAttribute("updateForm") AdminAccountUpdateForm updateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminAccountService.update(updateForm);
        return "redirect:" + AdminServerPaths.ACCOUNT;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{accountId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer accountId) {
        mav.addObject("account", getAccount());
        mav.addObject("deleteFormResponse",
                adminAccountService.getDeleteFormResponse(accountId));
        mav.setViewName("admin/accounts/deleteForm");
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
            @ModelAttribute("deleteForm") AdminAccountDeleteForm deleteForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminAccountService.delete(deleteForm);
        return "redirect:" + AdminServerPaths.ACCOUNT;
    }
}
