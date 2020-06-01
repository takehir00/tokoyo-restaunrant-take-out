package com.example.tokyorestauranttakeout.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminQuestionsController {
    /**
     * トップ画面表示
     * @param mav
     * @return
     */
    @GetMapping("/admin/questions")
    public ModelAndView index(ModelAndView mav) {
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
