package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.WardRegisterForm;
import com.example.tokyorestauranttakeout.admin.services.AdminWardService;
import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AdminWardServiceImpl implements AdminWardService {
    @Autowired
    WardRepository wardRepository;

    @Override
    public void create(WardRegisterForm wardRegisterForm) {
        Date now = new Date();
        Ward ward = new Ward();
        ward.setName(wardRegisterForm.name);
        ward.setImage(wardRegisterForm.image);
        ward.setCreatedAt(now);
        wardRepository.create(ward);
    }
}
