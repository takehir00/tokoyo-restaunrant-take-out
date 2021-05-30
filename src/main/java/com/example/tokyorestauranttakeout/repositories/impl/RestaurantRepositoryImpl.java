package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.CustomRestaurant;
import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.entity.RestaurantExample;
import com.example.tokyorestauranttakeout.mapper.CustomRestaurantMapper;
import com.example.tokyorestauranttakeout.mapper.RestaurantMapper;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    @Autowired
    private final RestaurantMapper restaurantMapper;

    @Autowired
    private final CustomRestaurantMapper customRestaurantMapper;

    public RestaurantRepositoryImpl(RestaurantMapper restaurantMapper, CustomRestaurantMapper customRestaurantMapper) {
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
     * 全件取得
     * @return
     */
    public List<Restaurant> selectByWardAreaId(Integer wardAreaId) {
        RestaurantExample example = new RestaurantExample();
        RestaurantExample.Criteria criteria = example.createCriteria();
        criteria.andWardAreaIdEqualTo(wardAreaId);
        return restaurantMapper.selectByExampleWithBLOBs(example);
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

    /**
     * IDで検索
     * @param id
     * @return
     */
    public Restaurant selectById(Integer id) {
        return restaurantMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新
     * @param restaurant
     */
    public void update(Restaurant restaurant) {
        restaurantMapper.updateByPrimaryKeyWithBLOBs(restaurant);
    }

    /**
     * 削除
     * @param wardId
     */
    public void delete (Integer wardId) {
        restaurantMapper.deleteByPrimaryKey(wardId);
    }
}
