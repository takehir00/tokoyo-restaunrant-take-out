package com.example.tokyorestauranttakeout.client.services.impl;

import com.example.tokyorestauranttakeout.client.forms.QuestionRegisterForm;
import com.example.tokyorestauranttakeout.client.services.QuestionService;
import com.example.tokyorestauranttakeout.entity.Question;
import com.example.tokyorestauranttakeout.repositories.QuestionRepository;
import com.example.tokyorestauranttakeout.util.DateTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void create(QuestionRegisterForm registerForm) {
        LocalDateTime now = DateTimeUtil.now();
        Question question = new Question();
        BeanUtils.copyProperties(registerForm, question);
        question.setResolvedFlg(false);
        question.setCreatedAt(now);
        question.setUpdatedAt(now);
        questionRepository.create(question);
    }
}
