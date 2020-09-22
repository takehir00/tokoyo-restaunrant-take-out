package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.menu.*;
import com.example.tokyorestauranttakeout.entity.Menu;

import java.io.IOException;

public interface AdminMenuService {
    /**
     * IDで取得
     * @param id
     * @return
     */
    public Menu getById(Integer id) throws IOException;

    AdminMenuIndexResponse getIndexResponse();

    /**
     * 登録画面レスポンス取得
     * @return
     */
    AdminMenuRegisterFormResponse getRegisterFormResponse();

    /**
     * 登録
     * @param registerForm
     */
    void create(AdminMenuRegisterForm registerForm);

    /**
     * 更新画面レスポンス取得
     * @param menuId
     * @param updateForm
     */
    AdminMenuUpdateForm getUpdateFormResponse(Integer menuId, AdminMenuUpdateForm updateForm);

    /**
     * 更新
     * @param updateForm
     */
    void update(AdminMenuUpdateForm updateForm) throws IOException;

    /**
     * 詳細画面レスポンス取得
     * @param menuId
     * @return
     */
    AdminMenuShowResponse getShowResponse(Integer menuId);

    /**
     * 削除画面レスポンス取得
     * @param menuId
     * @return
     */
    AdminMenuDeleteFormResponse getDeleteFormResponse(Integer menuId);

    /**
     * 削除
     * @param deleteForm
     */
    void delete(AdminMenuDeleteForm deleteForm);
}
