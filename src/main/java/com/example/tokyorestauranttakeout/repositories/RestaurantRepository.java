package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.CustomRestaurant;
import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.entity.RestaurantExample;
import com.example.tokyorestauranttakeout.mapper.CustomRestaurantMapper;
import com.example.tokyorestauranttakeout.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantRepository {
    @Autowired
    private final RestaurantMapper restaurantMapper;

    @Autowired
    private final CustomRestaurantMapper customRestaurantMapper;

    public RestaurantRepository(RestaurantMapper restaurantMapper, CustomRestaurantMapper customRestaurantMapper) {
        this.restaurantMapper = restaurantMapper;
        this.customRestaurantMapper = customRestaurantMapper;
    }

    /**
     * 全件取得
     * @return
     */
    public List<Restaurant> selectAll() {
        RestaurantExample example = new RestaurantExample();
        return restaurantMapper.selectByExample(example);
    }

    /**
     * 区テーブルと結合し全件取得
     * @return
     */
    public List<CustomRestaurant> selectAllWithWard() {
        return customRestaurantMapper.select();
    }

    /**
     * 登録
     * @param restaurant
     */
    public void create(Restaurant restaurant) {
        restaurantMapper.insert(restaurant);
    }

    /**
     * 区テーブルと結合しIDで取得
     * @param restaurantId
     * @return
     */
    public CustomRestaurant selectByIdWithWard(Integer restaurantId) {
        return customRestaurantMapper.selectByPrimaryKey(restaurantId);
    }
}
