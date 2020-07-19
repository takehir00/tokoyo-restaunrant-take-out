package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.entity.WardAreaExample;
import com.example.tokyorestauranttakeout.mapper.CustomWardAreaMapper;
import com.example.tokyorestauranttakeout.mapper.WardAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WardAreaRepository {
    @Autowired
    private final WardAreaMapper wardAreaMapper;
    @Autowired
    private final CustomWardAreaMapper customWardAreaMapper;

    public WardAreaRepository(WardAreaMapper wardAreaMapper, CustomWardAreaMapper customWardAreaMapper) {
        this.wardAreaMapper = wardAreaMapper;
        this.customWardAreaMapper = customWardAreaMapper;
    }

    /**
     * 全件取得
     * @return
     */
    public List<WardArea> selectAll() {
        WardAreaExample example = new WardAreaExample();
        return wardAreaMapper.selectByExample(example);
    }

    /**
     * 全件取得
     * @return
     */
    public List<CustomWardArea> selectAllWithWard() {
        return customWardAreaMapper.select();
    }

    /**
     * 登録
     * @param wardArea
     */
    public void create(WardArea wardArea) {
        wardAreaMapper.insert(wardArea);
    }


}
