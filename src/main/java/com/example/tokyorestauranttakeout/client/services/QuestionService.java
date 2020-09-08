package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.forms.QuestionRegisterForm;

public interface QuestionService {

    /**
     * 登録
     * @param registerForm
     */
    void create(QuestionRegisterForm registerForm);
}
