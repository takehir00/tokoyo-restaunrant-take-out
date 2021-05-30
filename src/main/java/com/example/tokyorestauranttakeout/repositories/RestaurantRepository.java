package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.CustomRestaurant;
import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.entity.RestaurantExample;
import com.example.tokyorestauranttakeout.entity.RestaurantExample.Criteria;
import com.example.tokyorestauranttakeout.mapper.CustomRestaurantMapper;
import com.example.tokyorestauranttakeout.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public interface RestaurantRepository {

    /**
     * 全件取得
     * @return
     */
    List<Restaurant> selectAll();

    /**
     * 全件取得
     * @return
     */
    List<Restaurant> selectByWardAreaId(Integer wardAreaId);

    /**
     * 区テーブルと結合し全件取得
     * @return
     */
    List<CustomRestaurant> selectAllWithWard();

    /**
     * 登録
     * @param restaurant
     */
    void create(Restaurant restaurant);

    /**
     * 区テーブルと結合しIDで取得
     * @param restaurantId
     * @return
     */
    CustomRestaurant selectByIdWithWard(Integer restaurantId);

    /**
     * IDで検索
     * @param id
     * @return
     */
    Restaurant selectById(Integer id);

    /**
     * 更新
     * @param restaurant
     */
    void update(Restaurant restaurant);

    /**
     * 削除
     * @param wardId
     */
    void delete (Integer wardId);
}
