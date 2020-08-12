package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.AdminRestaurantIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.AdminRestaurantShowResponse;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.AdminRestaurantsCreateFormResponse;

public interface AdminRestaurantsService {

    /**
     * 一覧画面
     * @return
     */
    AdminRestaurantIndexResponse getIndexResponse();

    /**
     * 登録画面用レスポンス取得
     * @return
     */
    AdminRestaurantsCreateFormResponse getCreateFormResponse();

    /**
     * 登録
     * @param registerForm
     */
    void create(AdminRestaurantCreateForm registerForm);

    /**
     * 詳細画面
     * @param restaurantId
     * @return
     */
    AdminRestaurantShowResponse getShowResponse(Integer restaurantId);
}
