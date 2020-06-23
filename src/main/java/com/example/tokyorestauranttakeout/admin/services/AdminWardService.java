package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.WardRegisterForm;
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
     * 区一覧画面ようレスポンス取得
     * @return
     */
    AdminWardShowResponse getShowResponse(Integer wardId);

    /**
     * 区登録
     * @param wardRegisterForm
     */
    void create(WardRegisterForm wardRegisterForm) throws IOException;

}
