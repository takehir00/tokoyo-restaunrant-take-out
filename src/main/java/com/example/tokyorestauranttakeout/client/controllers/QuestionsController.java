package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.client.forms.QuestionRegisterForm;
import com.example.tokyorestauranttakeout.client.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    /**
     * 問い合わせ画面
     * @param mav
     * @return
     */
    @GetMapping("/client/questions")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("client/questions/index");
        return mav;
    }

    /**
     * 問い合わせ登録
     * @param registerForm
     * @param bindingResult
     * @param attributes
     * @return
     * @throws IOException
     */
    @Transactional
    @PostMapping("/client/questions/register")
    public String register(
            @ModelAttribute("registerForm") QuestionRegisterForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        questionService.create(registerForm);
        return "redirect:/";
    }
}
