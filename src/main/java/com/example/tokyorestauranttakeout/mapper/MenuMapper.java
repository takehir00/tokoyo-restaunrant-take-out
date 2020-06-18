package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    public Menu selectById(Integer id);
}
