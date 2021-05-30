package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.entity.WardAreaExample;
import com.example.tokyorestauranttakeout.entity.WardAreaExample.Criteria;
import com.example.tokyorestauranttakeout.mapper.CustomWardAreaMapper;
import com.example.tokyorestauranttakeout.mapper.WardAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public interface WardAreaRepository {
    /**
     * IDで取得
     * @param id
     * @return
     */
    WardArea selectById(Integer id);

    /**
     * 全件取得
     * @return
     */
    List<WardArea> selectAll();

    /**
     * 区テーブルと結合し全件取得
     * @return
     */
    List<CustomWardArea> selectAllWithWard();

    /**
     * 区テーブルと結合しIDで取得
     * @return
     */
    CustomWardArea selectByIDWithWard(Integer id);

    /**
     * 登録
     * @param wardArea
     */
    void create(WardArea wardArea);

    /**
     * 更新
     * @param wardArea
     */
    void update(WardArea wardArea);

    /**
     * 削除
     * @param id
     */
    void delete(Integer id);

    /**
     * 区IDで検索
     * @param wardId
     * @return
     */
    List<WardArea> selectByWardId(Integer wardId);
}
