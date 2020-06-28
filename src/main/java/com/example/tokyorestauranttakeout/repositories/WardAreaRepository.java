package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.entity.WardAreaExample;
import com.example.tokyorestauranttakeout.mapper.WardAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WardAreaRepository {
    @Autowired
    private final WardAreaMapper mapper;

    public WardAreaRepository(WardAreaMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 全件取得
     * @return
     */
    public List<WardArea> selectAll() {
        WardAreaExample example = new WardAreaExample();
        return mapper.selectByExample(example);
    }



    /**
     * 登録
     * @param wardArea
     */
    public void create(WardArea wardArea) {
        mapper.insert(wardArea);
    }
}
