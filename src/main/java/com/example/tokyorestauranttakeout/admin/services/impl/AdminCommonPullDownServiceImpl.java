package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;
import com.example.tokyorestauranttakeout.admin.services.AdminCommonPullDownService;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminCommonPullDownServiceImpl implements AdminCommonPullDownService {
    @Autowired
    WardRepository wardRepository;

    @Override
    public List<PullDownFormWardModel> getWardList() {
        return wardRepository.selectAll().stream()
                .map(ward -> {
                    PullDownFormWardModel wardModel = new PullDownFormWardModel();
                    wardModel.id = ward.getId();
                    wardModel.name = ward.getName();
                    return wardModel;
                }).collect(Collectors.toList());
    }
}
