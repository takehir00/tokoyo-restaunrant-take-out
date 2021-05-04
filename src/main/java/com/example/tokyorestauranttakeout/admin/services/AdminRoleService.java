package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleDeleteFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleUpdateFormResponse;

public interface AdminRoleService {

    /**
     * 一覧画面
     * @return 一覧画面レスポンス
     */
    AdminRoleIndexResponse getIndexResponse();

    /**
     * 登録
     * @param registerForm 登録フォーム
     */
    void create(AdminRoleCreateForm registerForm);

    /**
     * 更新画面用レスポンス
     * @param roleId ロールID
     * @return 更新画面用レスポンス
     */
    AdminRoleUpdateFormResponse getUpdateFormResponse(Integer roleId);

    /**
     * 更新
     * @param roleId
     * @param updateForm 更新フォーム
     */
    void update(Integer roleId, AdminRoleUpdateForm updateForm);


    /**
     * 削除画面用レスポンス
     * @param roleId ロールID
     * @return 削除画面用レスポンス
     */
    AdminRoleDeleteFormResponse getDeleteFormResponse(Integer roleId);

    /**
     * 削除
     * @param roleId ロールID
     */
    void delete(Integer roleId);

}
