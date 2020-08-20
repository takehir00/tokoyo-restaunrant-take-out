package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.*;

import java.io.IOException;

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

    /**
     * 更新画面レスポンス取得
     * @param restaurantId
     */
    AdminRestaurantsUpdateFormResponse getUpdateFormResponse(Integer restaurantId);

    /**
     * 更新
     * @param restaurantUpdateForm
     */
    void update(AdminRestaurantUpdateForm restaurantUpdateForm) throws IOException;

    /**
     * 削除画面
     * @param restaurantId
     * @return
     */
    AdminRestaurantsDeleteFormResponse getDeleteFormResponse(Integer restaurantId);
}
