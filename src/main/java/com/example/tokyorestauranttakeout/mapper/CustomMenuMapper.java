package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.CustomMenu;
import com.example.tokyorestauranttakeout.entity.Menu;
import com.example.tokyorestauranttakeout.entity.MenuExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomMenuMapper {
    /**
     * 全件取得
     * @return
     */
    List<CustomMenu> select();

    CustomMenu selectByPrimaryKey(@Param("id")Integer id);
}