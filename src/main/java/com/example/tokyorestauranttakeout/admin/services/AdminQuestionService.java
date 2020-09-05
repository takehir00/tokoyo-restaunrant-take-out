package com.example.tokyorestauranttakeout.admin.services;


import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionCreateForm;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionCreateFormResponse;

public interface AdminQuestionService {
    /**
     * 登録画面用レスポンス取得
     * @return
     */
    AdminQuestionCreateFormResponse getCreateFormResponse();

    /**
     * 登録
     * @param registerForm
     */
    void create(AdminQuestionCreateForm registerForm);
}
