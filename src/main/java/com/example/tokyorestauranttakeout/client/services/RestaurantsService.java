package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.responses.RestaurantsShowResponse;

public interface RestaurantsService {

    /**
     * 店舗詳細画面レスポンス
     * @param restaurantId
     * @return
     */
    RestaurantsShowResponse getShowResponse(Integer restaurantId);
}
