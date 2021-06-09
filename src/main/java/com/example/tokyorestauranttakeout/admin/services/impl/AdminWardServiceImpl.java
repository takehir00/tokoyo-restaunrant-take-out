package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.ward.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.ward.WardUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.ward.AdminWardIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.ward.AdminWardDeleteResponse;
import com.example.tokyorestauranttakeout.admin.responses.ward.AdminWardIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.ward.AdminWardShowResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminWardService;
import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import com.example.tokyorestauranttakeout.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class AdminWardServiceImpl implements AdminWardService {
    @Autowired
    WardRepository wardRepository;

    @Override
    public AdminWardIndexResponse getIndexResponse() {
        AdminWardIndexResponse response = new AdminWardIndexResponse();
        response.wardIndexModelList =
                wardRepository.selectAll().stream()
                        .map(ward -> {
                            AdminWardIndexModel adminWardIndexModel = new AdminWardIndexModel();
                            adminWardIndexModel.id = ward.getId();
                            adminWardIndexModel.name = ward.getName();
                            adminWardIndexModel.createdAt = ward.getCreatedAt();
                            adminWardIndexModel.updatedAt = ward.getUpdatedAt();
                            return adminWardIndexModel;
                        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public AdminWardShowResponse getShowResponse(Integer wardId) {
        Ward ward = wardRepository.selectById(wardId);
        AdminWardShowResponse response = new AdminWardShowResponse();
        response.id = ward.getId();
        response.name = ward.getName();
        response.image = ward.getImage();
        response.mimeType = ward.getMimeType();
        response.createdAt = ward.getCreatedAt();
        response.updatedAt = ward.getUpdatedAt();
        return response;
    }

    @Override
    public void create(WardRegisterForm wardRegisterForm) throws IOException {
        LocalDateTime now = DateTimeUtil.now();
        Ward ward = new Ward();
        ward.setName(wardRegisterForm.name);
        byte[] data = wardRegisterForm.getImage().getBytes();
        String base64str = Base64.getEncoder().encodeToString(data);
        ward.setImage(base64str);
        ward.setMimeType(wardRegisterForm.image.getContentType());
        ward.setCreatedAt(now);
        ward.setUpdatedAt(now);
        wardRepository.create(ward);
    }

    @Override
    public WardUpdateForm getUpdateForm(Integer wardId) {
        Ward ward = wardRepository.selectById(wardId);
        WardUpdateForm form = new WardUpdateForm();
        form.id = ward.getId();
        form.name = ward.getName();
        return form;
    }

    @Override
    public void update(WardUpdateForm wardUpdateForm) {
        LocalDateTime now = DateTimeUtil.now();
        Ward ward = wardRepository.selectById(wardUpdateForm.id);
        ward.setName(wardUpdateForm.name);
        ward.setUpdatedAt(now);
        wardRepository.update(ward);
    }

    @Override
    public void delete(Integer wardId) {
        wardRepository.delete(wardId);
    }

    @Override
    public AdminWardDeleteResponse getDeleteFormResponse(Integer wardId) {
        Ward ward = wardRepository.selectById(wardId);
        AdminWardDeleteResponse response = new AdminWardDeleteResponse();
        response.id = ward.getId();
        response.name = ward.getName();
        response.image = ward.getImage();
        response.mimeType = ward.getMimeType();
        response.createdAt = ward.getCreatedAt();
        response.updatedAt = ward.getUpdatedAt();
        return response;
    }
}
