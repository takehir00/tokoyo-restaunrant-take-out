package com.example.tokyorestauranttakeout.admin.services;


import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionIndexResponse;

public interface AdminQuestionService {

    /**
     * 一覧画面
     * @return
     */
    AdminQuestionIndexResponse getIndexResponse();

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

    /**
     * 更新画面
     * @param questionId
     * @return
     */
    AdminQuestionUpdateFormResponse getUpdateFormResponse(Integer questionId);

    /**
     * 更新
     * @param updateForm
     */
    void update(AdminQuestionUpdateForm updateForm);
}
