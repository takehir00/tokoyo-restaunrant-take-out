package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuRegisterFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuUpdateFormResponse;
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
     */
    AdminMenuUpdateFormResponse getUpdateFormResponse(Integer menuId);

    /**
     * 更新
     * @param updateForm
     */
    void update(AdminMenuUpdateForm updateForm) throws IOException;
}
