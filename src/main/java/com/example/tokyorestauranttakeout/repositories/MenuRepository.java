package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.CustomMenu;
import com.example.tokyorestauranttakeout.entity.MenuExample;
import com.example.tokyorestauranttakeout.entity.MenuExample.Criteria;
import com.example.tokyorestauranttakeout.mapper.CustomMenuMapper;
import com.example.tokyorestauranttakeout.mapper.MenuMapper;
import com.example.tokyorestauranttakeout.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public interface MenuRepository {

    /**
     * 全件取得
     * @return
     */
    List<CustomMenu> selectAllWithRestaurant();

    /**
     * 店舗IDで取得
     * @param restaurantId
     * @return
     */
    List<Menu> selectByRestaurantId(Integer restaurantId);

    /**
     * IDで取得
     * @param id
     * @return
     */
    CustomMenu selectByIdWithRestaurant(Integer id);

    /**
     * idで検索
     * @param id
     * @return
     * @throws IOException
     */
    Menu selectById(Integer id);

    /**
     * 登録
     * @param menu
     */
    void create(Menu menu);

    /**
     * 更新
     * @param menu
     */
    void update(Menu menu);

    /**
     * 削除
     * @param id
     */
    void delete(Integer id);
}
