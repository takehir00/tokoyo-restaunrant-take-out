package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.forms.ClientAccountCreateForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountDeleteForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountUpdateForm;
import com.example.tokyorestauranttakeout.client.responses.ClientAccountShowResponse;

public interface ClientAccountService {

    /**
     * アカウント詳細画面用レスポンス
     * @return
     * @param accountId
     */
    ClientAccountShowResponse getShowResponse(Integer accountId);

    /**
     * 登録
     */
    void create(ClientAccountCreateForm registerForm);

    /**
     * 更新
     * @param updateForm
     */
    void update(ClientAccountUpdateForm updateForm);

    /**
     * 更新画面用レスポンス
     * @param accountId
     * @return
     */
    ClientAccountUpdateForm getUpdateFormResponse(Integer accountId);

    /**
     * 削除画面用レスポンス
     * @param accountId
     * @return
     */
    ClientAccountDeleteForm getDeleteFormResponse(Integer accountId);

    /**
     * 削除
     * @param accountId
     */
    void delete(Integer accountId);
}
