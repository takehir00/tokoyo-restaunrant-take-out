package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.CustomRestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomRestaurantMapper {
    /**
     * 全件取得
     * @return
     */
    List<CustomRestaurant> select();

    /**
     * IDで取得
     * @param id
     * @return
     */
    CustomRestaurant selectByPrimaryKey(@Param("id")Integer id);
}
