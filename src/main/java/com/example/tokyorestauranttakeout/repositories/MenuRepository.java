package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.mapper.MenuMapper;
import com.example.tokyorestauranttakeout.entity.Menu;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MenuRepository extends ApplicationRepository {

    public MenuRepository() throws IOException {
    }

    /**
     * idで検索
     * @param id
     * @return
     * @throws IOException
     */
    public Menu selectById(Integer id) throws IOException {
            MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
            return mapper.selectById(id);
    }
}
