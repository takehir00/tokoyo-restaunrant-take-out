package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.models.AdminWardIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.AdminWardIndexResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminWardService;
import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
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
    public void create(WardRegisterForm wardRegisterForm) throws IOException {
        Date now = new Date();
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
}
