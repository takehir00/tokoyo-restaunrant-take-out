package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomWardAreaMapper {
    List<CustomWardArea> select();

    CustomWardArea selectByPk(@Param("id") Integer id);
}
