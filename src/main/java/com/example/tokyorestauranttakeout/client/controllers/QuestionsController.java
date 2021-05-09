package com.example.tokyorestauranttakeout.client.controllers;

import com.example.tokyorestauranttakeout.ClientServerPaths;
import com.example.tokyorestauranttakeout.client.forms.QuestionRegisterForm;
import com.example.tokyorestauranttakeout.client.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping(ClientServerPaths.QUESTION)
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    /**
     * 問い合わせ画面
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(
            ModelAndView mav,
            @ModelAttribute("modelMap") ModelMap modelMap) {

        QuestionRegisterForm registerForm = new QuestionRegisterForm();
        if (modelMap.get("registerForm") != null) {
            registerForm = (QuestionRegisterForm) modelMap.get("registerForm");
        }

        mav.addObject("registerForm", registerForm);
        mav.addObject("org.springframework.validation.BindingResult.registerForm", modelMap.get("bindingResult"));
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
    @PostMapping("/register")
    public String register(
            @Validated @ModelAttribute("registerForm") QuestionRegisterForm registerForm,
            BindingResult bindingResult,
            RedirectAttributes attributes) throws IOException {
        if (bindingResult.hasErrors()) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("registerForm",registerForm);
            modelMap.addAttribute("bindingResult", bindingResult);
            attributes.addFlashAttribute("modelMap",modelMap);
            return "redirect:" + ClientServerPaths.QUESTION;
        }
        questionService.create(registerForm);
        return "redirect:" + ClientServerPaths.PUB;
    }
}
