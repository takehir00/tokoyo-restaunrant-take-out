package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.entity.WardAreaExample;
import com.example.tokyorestauranttakeout.mapper.CustomWardAreaMapper;
import com.example.tokyorestauranttakeout.mapper.WardAreaMapper;
import com.example.tokyorestauranttakeout.repositories.WardAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WardAreaRepositoryImpl implements WardAreaRepository {
    @Autowired
    private final WardAreaMapper wardAreaMapper;
    @Autowired
    private final CustomWardAreaMapper customWardAreaMapper;

    public WardAreaRepositoryImpl(WardAreaMapper wardAreaMapper, CustomWardAreaMapper customWardAreaMapper) {
        this.wardAreaMapper = wardAreaMapper;
        this.customWardAreaMapper = customWardAreaMapper;
    }

    /**
     * IDで取得
     * @param id
     * @return
     */
    public WardArea selectById(Integer id) {
        return wardAreaMapper.selectByPrimaryKey(id);
    }

    /**
     * 全件取得
     * @return
     */
    public List<WardArea> selectAll() {
        WardAreaExample example = new WardAreaExample();
        return wardAreaMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 区テーブルと結合し全件取得
     * @return
     */
    public List<CustomWardArea> selectAllWithWard() {
        return customWardAreaMapper.select();
    }

    /**
     * 区テーブルと結合しIDで取得
     * @return
     */
    public CustomWardArea selectByIDWithWard(Integer id) {
        return customWardAreaMapper.selectByPk(id);
    }

    /**
     * 登録
     * @param wardArea
     */
    public void create(WardArea wardArea) {
        wardAreaMapper.insert(wardArea);
    }

    /**
     * 更新
     * @param wardArea
     */
    public void update(WardArea wardArea) {
        wardAreaMapper.updateByPrimaryKeyWithBLOBs(wardArea);
    }

    /**
     * 削除
     * @param id
     */
    public void delete(Integer id) {
        wardAreaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 区IDで検索
     * @param wardId
     * @return
     */
    public List<WardArea> selectByWardId(Integer wardId) {
        WardAreaExample example = new WardAreaExample();
        WardAreaExample.Criteria criteria = example.createCriteria();
        criteria.andWardIdEqualTo(wardId);
        return wardAreaMapper.selectByExample(example);
    }
}
