package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.entity.WardExample;
import com.example.tokyorestauranttakeout.mapper.WardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public interface WardRepository {

    /**
     * 全件取得
     * @return
     */
    List<Ward> selectAll();

    /**
     * 登録
     * @param ward
     */
    void create(Ward ward);

    /**
     * IDで取得
     * @param wardId
     * @return
     */
    Ward selectById(Integer wardId);

    /**
     * 更新
     * @param ward
     */
    void update(Ward ward);

    /**
     * 削除
     * @param wardId
     */
    void delete(Integer wardId);
}
