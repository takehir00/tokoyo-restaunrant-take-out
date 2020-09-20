package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminAccountService;
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
public class AdminAccountController extends AdminControllerBase {
    
    @Autowired
    AdminAccountService adminAccountService;
    
    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/accounts")
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.addObject("accountIndexResponse", adminAccountService.getIndexResponse());
        mav.setViewName("admin/accounts/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/accounts/{accountId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer accountId) {
        mav.addObject("account", getAccount());
        mav.addObject("showResponse",
                adminAccountService.getShowResponse(accountId));
        mav.setViewName("admin/accounts/show");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/accounts/register")
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
    @PostMapping("/admin/accounts/register")
    public String register(
            @ModelAttribute("registerForm") AdminAccountCreateForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminAccountService.create(registerForm);
        return "redirect:/admin/accounts";
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/accounts/update/{accountId}")
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
    @PostMapping("/admin/accounts/update")
    public String update(
            @ModelAttribute("updateForm") AdminAccountUpdateForm updateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminAccountService.update(updateForm);
        return "redirect:/admin/accounts";
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/accounts/delete/{accountId}")
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
    @PostMapping("/admin/accounts/delete")
    public String delete(
            @ModelAttribute("deleteForm") AdminAccountDeleteForm deleteForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminAccountService.delete(deleteForm);
        return "redirect:/admin/accounts";
    }
}
