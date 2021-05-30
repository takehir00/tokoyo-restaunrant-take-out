package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Question;
import com.example.tokyorestauranttakeout.entity.QuestionExample;
import com.example.tokyorestauranttakeout.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public interface QuestionRepository {

    /**
     * 登録
     * @param question
     */
    void create(Question question);

    /**
     * 全件取得
     * @return
     */
    List<Question> selectAll();

    /**
     * IDで取得
     * @param questionId
     * @return
     */
    Question selectById(Integer questionId);

    /**
     * 更新
     * @param question
     */
    void update(Question question);

    /**
     * 削除
     * @param id
     */
    void delete(Integer id);
}
