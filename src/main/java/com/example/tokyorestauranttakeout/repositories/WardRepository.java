package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.entity.WardExample;
import com.example.tokyorestauranttakeout.mapper.WardMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WardRepository extends ApplicationRepository {
    public WardRepository() throws IOException {
    }

    /**
     * 全件取得
     * @return
     */
    public List<Ward> selectAll() {
        WardMapper mapper = sqlSession.getMapper(WardMapper.class);
        WardExample example = new WardExample();
        return mapper.selectByExample(example);
    }

    /**
     * 登録
     * @param ward
     */
    public void create(Ward ward) {
        WardMapper mapper = sqlSession.getMapper(WardMapper.class);
        mapper.insert(ward);
        //auto-commitがtrueの場合は不要
        //sqlSession.commit();
    }
}
