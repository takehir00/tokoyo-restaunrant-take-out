package com.example.tokyorestauranttakeout.admin.services;


import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionDeleteForm;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionDeleteFormResponse;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionShowResponse;

public interface AdminQuestionService {

    /**
     * 一覧画面
     * @return
     */
    AdminQuestionIndexResponse getIndexResponse();

    /**
     * 詳細画面
     * @param questionId
     * @return
     */
    AdminQuestionShowResponse getShowResponse(Integer questionId);

    /**
     * 登録画面用レスポンス取得
     * @return
     */
    AdminQuestionCreateFormResponse getCreateFormResponse();

    /**
     * 登録
     * @param registerForm
     */
    void create(AdminQuestionRegisterForm registerForm);

    /**
     * 更新画面
     * @param questionId
     * @param updateForm
     * @return
     */
    AdminQuestionUpdateForm getUpdateForm(Integer questionId, AdminQuestionUpdateForm updateForm);

    /**
     * 更新
     * @param updateForm
     */
    void update(AdminQuestionUpdateForm updateForm);

    /**
     * 削除画面
     * @param questionId
     * @return
     */
    AdminQuestionDeleteFormResponse getDeleteFormResponse(Integer questionId);

    /**
     * 削除
     * @param deleteForm
     */
    void delete(AdminQuestionDeleteForm deleteForm);
}
