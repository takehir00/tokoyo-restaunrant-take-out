package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleIndexResponse;

public interface AdminRoleService {

    /**
     * 一覧画面
     * @return 一覧画面レスポンス
     */
    AdminRoleIndexResponse getIndexResponse();
}
