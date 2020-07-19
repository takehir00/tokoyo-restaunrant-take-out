package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomWardAreaMapper {
    List<CustomWardArea> select();
}
