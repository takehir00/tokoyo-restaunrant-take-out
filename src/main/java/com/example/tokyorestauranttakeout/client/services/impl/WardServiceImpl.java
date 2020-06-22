package com.example.tokyorestauranttakeout.client.services.impl;

import com.example.tokyorestauranttakeout.client.models.WardIndexModel;
import com.example.tokyorestauranttakeout.client.responses.WardIndexResponse;
import com.example.tokyorestauranttakeout.client.services.WardService;
import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WardServiceImpl implements WardService {
    @Autowired
    WardRepository wardRepository;

    @Override
    public WardIndexResponse getIndexResponse() {
        List<Ward> wardList = wardRepository.selectAll();
        WardIndexResponse response = new WardIndexResponse();
        response.wardIndexModelList =
                wardList.stream().map(ward -> {
                    WardIndexModel wardIndexModel = new WardIndexModel();
                    wardIndexModel.id = ward.getId();
                    wardIndexModel.image = ward.getImage();
                    wardIndexModel.name = ward.getName();
                    wardIndexModel.mimeType = ward.getMimeType();
                    return wardIndexModel;
                }).collect(Collectors.toList());
        return response;
    }
}
