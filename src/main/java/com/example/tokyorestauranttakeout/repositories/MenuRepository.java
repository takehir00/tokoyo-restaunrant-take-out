package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.MenuExample;
import com.example.tokyorestauranttakeout.mapper.MenuMapper;
import com.example.tokyorestauranttakeout.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MenuRepository {
    @Autowired
    private final MenuMapper mapper;

    public MenuRepository(MenuMapper mapper) throws IOException {
        this.mapper = mapper;
    }

    /**
     * idで検索
     * @param id
     * @return
     * @throws IOException
     */
    public Menu selectById(Integer id) throws IOException {
        MenuExample example = new MenuExample();
        return mapper.selectByExample(example).get(0);
    }
}
