package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.CustomMenu;
import com.example.tokyorestauranttakeout.entity.MenuExample;
import com.example.tokyorestauranttakeout.mapper.CustomMenuMapper;
import com.example.tokyorestauranttakeout.mapper.MenuMapper;
import com.example.tokyorestauranttakeout.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MenuRepository {
    @Autowired
    private final MenuMapper menuMapper;
    @Autowired
    private final CustomMenuMapper customMenuMapper;

    public MenuRepository(MenuMapper mapper, CustomMenuMapper customMenuMapper) throws IOException {
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
     * idで検索
     * @param id
     * @return
     * @throws IOException
     */
    public Menu selectById(Integer id) throws IOException {
        MenuExample example = new MenuExample();
        return menuMapper.selectByExample(example).get(0);
    }

    /**
     * 登録
     * @param menu
     */
    public void create(Menu menu) {
        menuMapper.insert(menu);
    }
}
