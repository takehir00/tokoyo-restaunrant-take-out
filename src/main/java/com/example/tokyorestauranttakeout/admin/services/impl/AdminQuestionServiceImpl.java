package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionCreateForm;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminQuestionService;
import com.example.tokyorestauranttakeout.entity.Question;
import com.example.tokyorestauranttakeout.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminQuestionServiceImpl implements AdminQuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public AdminQuestionCreateFormResponse getCreateFormResponse() {
        AdminQuestionCreateFormResponse response = new AdminQuestionCreateFormResponse();
        return response;
    }

    @Override
    public void create(AdminQuestionCreateForm registerForm) {
        Date now = new Date();
        Question question = new Question();
        BeanUtils.copyProperties(registerForm, question);
        question.setCreatedAt(now);
        question.setUpdatedAt(now);
        questionRepository.create(question);
    }
}
