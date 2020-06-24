package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.WardUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.AdminWardDeleteResponse;
import com.example.tokyorestauranttakeout.admin.responses.AdminWardIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.AdminWardShowResponse;

import java.io.IOException;

public interface AdminWardService {
    /**
     * 区一覧画面用レスポンス取得
     * @return
     */
    AdminWardIndexResponse getIndexResponse();

    /**
     * 区詳細画面レスポンス取得
     * @return
     */
    AdminWardShowResponse getShowResponse(Integer wardId);

    /**
     * 区登録
     * @param wardRegisterForm
     */
    void create(WardRegisterForm wardRegisterForm) throws IOException;

    /**
     * 更新フォーム取得
     * @param wardId
     * @return
     */
    WardUpdateForm getUpdateForm(Integer wardId);

    /**
     * 更新
     * @param wardUpdateForm
     */
    void update(WardUpdateForm wardUpdateForm);

    /**
     * 削除
     * @param wardId
     */
    void delete(Integer wardId);

    /**
     * 削除画面用レスポンス
     * @param wardId
     * @return
     */
    AdminWardDeleteResponse getDeleteFormResponse(Integer wardId);
}
