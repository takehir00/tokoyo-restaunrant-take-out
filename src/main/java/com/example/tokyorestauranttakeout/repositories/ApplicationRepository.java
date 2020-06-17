package com.example.tokyorestauranttakeout.repositories;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ApplicationRepository {
    protected final SqlSession sqlSession;

    public ApplicationRepository() throws IOException {
        String resource = "mapper/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(is);
        this.sqlSession = sqlSessionFactory.openSession(true);
    }
}
