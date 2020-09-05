package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Question;
import com.example.tokyorestauranttakeout.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionRepository {

    @Autowired
    private final QuestionMapper questionMapper;

    public QuestionRepository(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    /**
     * 登録
     * @param question
     */
    public void create(Question question) {
        questionMapper.insert(question);
    }
}
