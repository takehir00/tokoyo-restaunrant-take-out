package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuRegisterFormResponse;
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
}
