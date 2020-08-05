package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantRepository {
    @Autowired
    private final RestaurantMapper restaurantMapper;

    public RestaurantRepository(RestaurantMapper restaurantMapper) {
        this.restaurantMapper = restaurantMapper;
    }

    /**
     * 登録
     * @param restaurant
     */
    public void create(Restaurant restaurant) {
        restaurantMapper.insert(restaurant);
    }
}
