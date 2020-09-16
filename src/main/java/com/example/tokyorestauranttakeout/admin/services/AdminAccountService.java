package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.account.AdminAccountIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.account.AdminAccountDeleteFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.account.AdminAccountIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.account.AdminAccountUpdateFormResponse;

public interface AdminAccountService {
    /**
     * 一覧画面
     * @return
     */
    AdminAccountIndexResponse getIndexResponse();

    /**
     * 詳細画面
     * @param accountId
     * @return
     */
    Object getShowResponse(Integer accountId);

    /**
     * 更新画面
     * @param accountId
     * @return
     */
    AdminAccountUpdateFormResponse getUpdateFormResponse(Integer accountId);

    /**
     * 削除画面
     * @param accountId
     * @return
     */
    AdminAccountDeleteFormResponse getDeleteFormResponse(Integer accountId);

    void create(AdminAccountCreateForm registerForm);

    void update(AdminAccountUpdateForm updateForm);

    void delete(AdminAccountDeleteForm deleteForm);
}
