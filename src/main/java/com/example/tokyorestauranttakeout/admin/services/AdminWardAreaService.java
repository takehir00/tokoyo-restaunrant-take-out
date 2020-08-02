package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.wardArea.AdminWardAreaDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.wardArea.*;

import java.io.IOException;

public interface AdminWardAreaService {

    /**
     * 一覧画面用レスポンス取得
     * @return
     */
    AdminWardAreaIndexResponse getIndexResponse();

    /**
     * 登録
     * @param wardAreaRegisterForm
     */
    void create(WardAreaRegisterForm wardAreaRegisterForm) throws IOException;

    /**
     * 登録画面用レスポンス取得
     * @return
     */
    AdminWardAreaCreateFormResponse getCreateFormResponse();

    /**
     * 詳細画面用レスポンス取得
     * @param wardAreaId
     * @return
     */
    AdminWardAreaShowResponse getShowResponse(Integer wardAreaId);

    /**
     * 更新フォーム取得
     * @param wardAreaId
     * @return
     */
    AdminWardAreaUpdateFormResponse getUpdateForm(Integer wardAreaId);

    /**
     * 更新
     * @param wardAreaUpdateForm
     */
    void update(WardAreaUpdateForm wardAreaUpdateForm) throws IOException;

    /**
     * 削除フォーム取得
     * @param wardAreaId
     * @return
     */
    AdminWardAreaDeleteFormResponse getDeleteFormResponse(Integer wardAreaId);

    /**
     * 削除
     * @param wardAreaDeleteForm
     */
    void delete(AdminWardAreaDeleteForm wardAreaDeleteForm);
}
