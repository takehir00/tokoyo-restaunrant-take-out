package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminQuestionService;
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
@RequestMapping(AdminServerPaths.QUESTION)
public class AdminQuestionsController extends AdminControllerBase {

    @Autowired
    AdminQuestionService adminQuestionService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("account", getAccount());
        mav.addObject("questionIndexResponse", adminQuestionService.getIndexResponse());
        mav.setViewName("admin/questions/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/{questionId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Integer questionId) {
        mav.addObject("account", getAccount());
        mav.addObject("showResponse",
                adminQuestionService.getShowResponse(questionId));
        mav.setViewName("admin/questions/show");
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
        AdminQuestionRegisterForm registerForm = new AdminQuestionRegisterForm();

        if (modelMap.get("registerForm") != null) {
            registerForm = (AdminQuestionRegisterForm) modelMap.get("registerForm");
        }

        mav.addObject("account", getAccount());
        mav.addObject("registerForm", registerForm);
        mav.addObject("org.springframework.validation.BindingResult.registerForm", modelMap.get("bindingResult"));
        mav.setViewName("admin/questions/registerForm");
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
            @Validated @ModelAttribute("registerForm") AdminQuestionRegisterForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("registerForm",registerForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.QUESTION + "/register";
        }
        adminQuestionService.create(registerForm);
        return "redirect:" + AdminServerPaths.QUESTION;
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/update/{questionId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Integer questionId,
                                   @ModelAttribute("modelMap") ModelMap modelMap) {

        mav.addObject("account", getAccount());
        mav.addObject("updateForm",
                adminQuestionService.getUpdateForm(
                        questionId,
                        (AdminQuestionUpdateForm) modelMap.get("updateForm")));
        mav.addObject(
                "org.springframework.validation.BindingResult.updateForm",
                modelMap.get("bindingResult"));
        mav.setViewName("admin/questions/updateForm");
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
            @Validated @ModelAttribute("updateForm") AdminQuestionUpdateForm updateForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("updateForm",updateForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + AdminServerPaths.QUESTION + "/update/" + updateForm.getId();
        }
        adminQuestionService.update(updateForm);
        return "redirect:" + AdminServerPaths.QUESTION;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/delete/{questionId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Integer questionId) {
        mav.addObject("account", getAccount());
        mav.addObject("deleteFormResponse",
                adminQuestionService.getDeleteFormResponse(questionId));
        mav.setViewName("admin/questions/deleteForm");
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
            @ModelAttribute("deleteForm") AdminQuestionDeleteForm deleteForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminQuestionService.delete(deleteForm);
        return "redirect:" + AdminServerPaths.QUESTION;
    }
}
