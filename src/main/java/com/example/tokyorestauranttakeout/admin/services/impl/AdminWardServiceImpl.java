package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.services.AdminWardService;
import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

@Service
public class AdminWardServiceImpl implements AdminWardService {
    @Autowired
    WardRepository wardRepository;

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
        wardRepository.create(ward);
    }
}
