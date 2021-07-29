package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionDeleteForm;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionDeleteFormResponse;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.question.AdminQuestionUpdateFormResponse;
import com.example.tokyorestauranttakeout.admin.models.question.AdminQuestionShowModel;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.question.AdminQuestionShowResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminQuestionService;
import com.example.tokyorestauranttakeout.entity.Question;
import com.example.tokyorestauranttakeout.repositories.QuestionRepository;
import com.example.tokyorestauranttakeout.util.DateTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public void create(AdminQuestionRegisterForm registerForm) {
        LocalDateTime now = DateTimeUtil.now();
        Question question = new Question();
        BeanUtils.copyProperties(registerForm, question);
        question.setCreatedAt(now);
        question.setUpdatedAt(now);
        questionRepository.create(question);
    }

    @Override
    public AdminQuestionUpdateForm getUpdateForm(Integer questionId, AdminQuestionUpdateForm updateFormRequest) {
        AdminQuestionUpdateForm updateForm = new AdminQuestionUpdateForm();

        if (updateFormRequest != null) {
            updateForm = updateFormRequest;
        } else {
            Question question = questionRepository.selectById(questionId);
            BeanUtils.copyProperties(question, updateForm);
        }
        return updateForm;
    }

    @Override
    public void update(AdminQuestionUpdateForm updateForm) {
        Question question = questionRepository.selectById(updateForm.getId());
        if (question != null) {
            LocalDateTime now = DateTimeUtil.now();
            BeanUtils.copyProperties(updateForm, question);
            question.setUpdatedAt(now);
            questionRepository.update(question);
        }
    }

    @Override
    public AdminQuestionDeleteFormResponse getDeleteFormResponse(Integer questionId) {
        AdminQuestionDeleteFormResponse response = new AdminQuestionDeleteFormResponse();
        Question question = questionRepository.selectById(questionId);
        AdminQuestionDeleteForm deleteForm = new AdminQuestionDeleteForm();
        BeanUtils.copyProperties(question, deleteForm);
        response.deleteForm = deleteForm;
        return response;
    }

    @Override
    public void delete(AdminQuestionDeleteForm deleteForm) {
        questionRepository.delete(deleteForm.getId());
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

    @Override
    public AdminQuestionShowResponse getShowResponse(Integer questionId) {
        AdminQuestionShowResponse response = new AdminQuestionShowResponse();
        Question question = questionRepository.selectById(questionId);
        AdminQuestionShowModel showModel = new AdminQuestionShowModel();
        BeanUtils.copyProperties(question, showModel);
        response.showModel = showModel;
        return response;
    }
}
