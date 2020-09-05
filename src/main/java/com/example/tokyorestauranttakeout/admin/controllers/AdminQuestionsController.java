package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionCreateForm;
import com.example.tokyorestauranttakeout.admin.services.AdminQuestionService;
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
public class AdminQuestionsController {

    @Autowired
    AdminQuestionService adminQuestionService;

    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/questions")
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("questionIndexResponse", adminQuestionService.getIndexResponse());
        mav.setViewName("admin/questions/index");
        return mav;
    }

    /**
     * 詳細画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/questions/{questionId}")
    public ModelAndView show(ModelAndView mav,
                             @PathVariable Long questionId) {
        mav.setViewName("admin/questions/show");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/questions/register")
    public ModelAndView registerForm(ModelAndView mav) {
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
    @PostMapping("/admin/questions/register")
    public String register(
            @ModelAttribute("registerForm") AdminQuestionCreateForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        adminQuestionService.create(registerForm);
        return "redirect:/admin/questions";
    }

    /**
     * 更新画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/questions/update/{questionId}")
    public ModelAndView updateForm(ModelAndView mav,
                                   @PathVariable Long questionId) {
        mav.setViewName("admin/questions/updateForm");
        return mav;
    }

    /**
     * 削除画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/questions/delete/{questionId}")
    public ModelAndView deleteForm(ModelAndView mav,
                                   @PathVariable Long questionId) {
        mav.setViewName("admin/questions/deleteForm");
        return mav;
    }
}
