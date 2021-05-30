package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.Question;
import com.example.tokyorestauranttakeout.entity.QuestionExample;
import com.example.tokyorestauranttakeout.mapper.QuestionMapper;
import com.example.tokyorestauranttakeout.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
    @Autowired
    private final QuestionMapper questionMapper;

    public QuestionRepositoryImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    /**
     * 登録
     * @param question
     */
    public void create(Question question) {
        questionMapper.insert(question);
    }

    /**
     * 全件取得
     * @return
     */
    public List<Question> selectAll() {
        QuestionExample example = new QuestionExample();
        return questionMapper.selectByExample(example);
    }

    /**
     * IDで取得
     * @param questionId
     * @return
     */
    public Question selectById(Integer questionId) {
        return questionMapper.selectByPrimaryKey(questionId);
    }

    /**
     * 更新
     * @param question
     */
    public void update(Question question) {
        questionMapper.updateByPrimaryKey(question);
    }

    /**
     * 削除
     * @param id
     */
    public void delete(Integer id) {
        questionMapper.deleteByPrimaryKey(id);
    }
}
