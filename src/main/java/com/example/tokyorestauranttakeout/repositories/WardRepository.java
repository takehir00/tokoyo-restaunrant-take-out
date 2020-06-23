package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.entity.WardExample;
import com.example.tokyorestauranttakeout.mapper.WardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WardRepository {
    @Autowired
    private final WardMapper mapper;

    public WardRepository(WardMapper mapper) throws IOException {
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
}
