package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionIndexResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminQuestionService;
import com.example.tokyorestauranttakeout.entity.Question;
import com.example.tokyorestauranttakeout.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AdminQuestionUpdateFormResponse getUpdateFormResponse(Integer questionId) {
        AdminQuestionUpdateFormResponse response = new AdminQuestionUpdateFormResponse();
        Question question = questionRepository.selectById(questionId);
        AdminQuestionUpdateForm updateForm = new AdminQuestionUpdateForm();
        BeanUtils.copyProperties(question, updateForm);
        response.updateForm = updateForm;
        return response;
    }

    @Override
    public void update(AdminQuestionUpdateForm updateForm) {
        Question question = questionRepository.selectById(updateForm.getId());
        if (question != null) {
            Date now = new Date();
            BeanUtils.copyProperties(updateForm, question);
            question.setUpdatedAt(now);
            questionRepository.update(question);
        }
    }

    @Override
    public AdminQuestionIndexResponse getIndexResponse() {
        AdminQuestionIndexResponse response = new AdminQuestionIndexResponse();
        List<Question> questionList = questionRepository.selectAll();
        response.questionIndexModelList =
                questionList.stream()
                        .map(question -> {
                            AdminQuestionIndexModel adminQuestionIndexModel = new AdminQuestionIndexModel();
                            BeanUtils.copyProperties(question, adminQuestionIndexModel);
                            return adminQuestionIndexModel;
                        }).collect(Collectors.toList());

        return response;
    }
}
