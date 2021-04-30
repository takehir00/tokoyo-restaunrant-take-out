package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.client.forms.ClientAccountCreateForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountDeleteForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountUpdateForm;
import com.example.tokyorestauranttakeout.client.services.ClientAccountService;
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
@RequestMapping("/client/accounts")
public class ClientAccountController {

    @Autowired
    ClientAccountService clientAccountService;

    /**
     * 詳細画面
     * @param mav
     * @return
     */
    @GetMapping("/{accountId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer accountId) {
        mav.addObject("showResponse",
                clientAccountService.getShowResponse(accountId));
        mav.setViewName("client/accounts/show");
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
        ClientAccountCreateForm registerForm = new ClientAccountCreateForm();
        if (modelMap.get("registerForm") != null) {
            registerForm = (ClientAccountCreateForm) modelMap.get("registerForm");
        }
        mav.addObject("registerForm", registerForm);
        mav.addObject("org.springframework.validation.BindingResult.registerForm", modelMap.get("bindingResult"));
        mav.setViewName("client/accounts/registerForm");
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
            @Validated @ModelAttribute("registerForm") ClientAccountCreateForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("registerForm",registerForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:/client/accounts/register";
        }
        clientAccountService.create(registerForm);
        return "redirect:/client/login";
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{accountId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer accountId,
                                   @ModelAttribute("modelMap") ModelMap modelMap) {

        ClientAccountUpdateForm updateForm;
        if (modelMap.get("updateForm") != null) {
            updateForm = (ClientAccountUpdateForm) modelMap.get("updateForm");
        } else {
            updateForm = clientAccountService.getUpdateFormResponse(accountId);
        }
        mav.addObject("updateForm", updateForm);
        mav.addObject("org.springframework.validation.BindingResult.updateForm", modelMap.get("bindingResult"));
        mav.setViewName("client/accounts/updateForm");
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
            @Validated @ModelAttribute("updateForm") ClientAccountUpdateForm updateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("updateForm", updateForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:/client/accounts/update/" + updateForm.id;
        }
        clientAccountService.update(updateForm);
        return "redirect:/client/accounts";
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{accountId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer accountId) {
        mav.addObject("deleteFormResponse",
                clientAccountService.getDeleteFormResponse(accountId));
        mav.setViewName("client/accounts/deleteForm");
        return mav;
    }

    /**
     * 削除
     * @param attributes
     * @return
     * @throws IOException
     */
    @Transactional
    @DeleteMapping("/delete/{accountId}")
    public String delete(
            @PathVariable Integer accountId,
            RedirectAttributes attributes) throws IOException {
        clientAccountService.delete(accountId);
        return "redirect:/client/accounts";
    }
}
