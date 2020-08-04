package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.responses.restaurants.AdminRestaurantsCreateFormResponse;

public interface AdminRestaurantsService {
    /**
     * 登録画面用レスポンス取得
     * @return
     */
    AdminRestaurantsCreateFormResponse getCreateFormResponse();
}
