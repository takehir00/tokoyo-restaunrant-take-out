package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.entity.WardExample;
import com.example.tokyorestauranttakeout.mapper.WardMapper;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class WardRepositoryImpl implements WardRepository {
    @Autowired
    private final WardMapper mapper;

    public WardRepositoryImpl(WardMapper mapper) throws IOException {
        this.mapper = mapper;
    }

    /**
     * 全件取得
     * @return
     */
    public List<Ward> selectAll() {
        WardExample example = new WardExample();
        return mapper.selectByExample(example);
    }

    /**
     * 登録
     * @param ward
     */
    public void create(Ward ward) {
        mapper.insert(ward);
    }

    /**
     * IDで取得
     * @param wardId
     * @return
     */
    public Ward selectById(Integer wardId) {
        return mapper.selectByPrimaryKey(wardId);
    }

    /**
     * 更新
     * @param ward
     */
    public void update(Ward ward) {
        mapper.updateByPrimaryKey(ward);
    }

    /**
     * 削除
     * @param wardId
     */
    public void delete(Integer wardId) {
        mapper.deleteByPrimaryKey(wardId);
    }
}
