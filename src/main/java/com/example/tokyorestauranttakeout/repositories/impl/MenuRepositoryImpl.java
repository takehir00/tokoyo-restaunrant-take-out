package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.CustomMenu;
import com.example.tokyorestauranttakeout.entity.Menu;
import com.example.tokyorestauranttakeout.entity.MenuExample;
import com.example.tokyorestauranttakeout.mapper.CustomMenuMapper;
import com.example.tokyorestauranttakeout.mapper.MenuMapper;
import com.example.tokyorestauranttakeout.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    @Autowired
    private final MenuMapper menuMapper;
    @Autowired
    private final CustomMenuMapper customMenuMapper;

    public MenuRepositoryImpl(MenuMapper mapper, CustomMenuMapper customMenuMapper) throws IOException {
        this.menuMapper = mapper;
        this.customMenuMapper = customMenuMapper;
    }

    /**
     * 全件取得
     * @return
     */
    public List<CustomMenu> selectAllWithRestaurant() {
        return customMenuMapper.select();
    }

    /**
     * 店舗IDで取得
     * @param restaurantId
     * @return
     */
    public List<Menu> selectByRestaurantId(Integer restaurantId) {
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andRestaurantIdEqualTo(restaurantId);
        return menuMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * IDで取得
     * @param id
     * @return
     */
    public CustomMenu selectByIdWithRestaurant(Integer id){
        return customMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * idで検索
     * @param id
     * @return
     * @throws IOException
     */
    public Menu selectById(Integer id){
        return menuMapper.selectByPrimaryKey(id);
    }

    /**
     * 登録
     * @param menu
     */
    public void create(Menu menu) {
        menuMapper.insert(menu);
    }

    /**
     * 更新
     * @param menu
     */
    public void update(Menu menu) {
        menuMapper.updateByPrimaryKeyWithBLOBs(menu);
    }

    /**
     * 削除
     * @param id
     */
    public void delete(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
