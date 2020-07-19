package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaRegisterForm;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaCreateFormWardModel;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.wardArea.AdminWardAreaCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.wardArea.AdminWardAreaIndexResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminWardAreaService;
import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.repositories.WardAreaRepository;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import com.example.tokyorestauranttakeout.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminWardAreaServiceImpl implements AdminWardAreaService {

    @Autowired
    WardAreaRepository wardAreaRepository;
    @Autowired
    WardRepository wardRepository;

    @Override
    public AdminWardAreaIndexResponse getIndexResponse() {
        AdminWardAreaIndexResponse response = new AdminWardAreaIndexResponse();
        List<CustomWardArea> customWardAreaList =
                wardAreaRepository.selectAllWithWard();
        response.setWardAreaIndexModelList(
                customWardAreaList.stream().map(customWardArea -> {
                    AdminWardAreaIndexModel adminWardAreaIndexModel = new AdminWardAreaIndexModel();
                    adminWardAreaIndexModel.id = customWardArea.getId();
                    adminWardAreaIndexModel.name = customWardArea.getName();
                    adminWardAreaIndexModel.wardName = customWardArea.getWardName();
                    adminWardAreaIndexModel.createdAt = customWardArea.getCreatedAt();
                    adminWardAreaIndexModel.updatedAt = customWardArea.getUpdatedAt();
                    return adminWardAreaIndexModel;
        }).collect(Collectors.toList()));
        return response;
    }

    @Override
    public void create(WardAreaRegisterForm wardAreaRegisterForm) throws IOException {
        Date now = new Date();
        WardArea wardArea = new WardArea();
        wardArea.setName(wardAreaRegisterForm.getName());
        if (wardAreaRegisterForm.image != null ) {
            wardArea.setImage(FileUtil.encodeBase64(
                    wardAreaRegisterForm.image));
            wardArea.setMimeType(
                    wardAreaRegisterForm.image.getContentType());
        }
        wardArea.setWardId(wardAreaRegisterForm.getWardId());
        wardArea.setCreatedAt(now);
        wardArea.setUpdatedAt(now);
        wardAreaRepository.create(wardArea);
    }

    @Override
    public AdminWardAreaCreateFormResponse getCreateFormResponse() {
        AdminWardAreaCreateFormResponse response = new AdminWardAreaCreateFormResponse();
        response.wardList =
                wardRepository.selectAll().stream()
                        .map(ward -> {
                            AdminWardAreaCreateFormWardModel wardModel = new AdminWardAreaCreateFormWardModel();
                            wardModel.id = ward.getId();
                            wardModel.name = ward.getName();
                            return wardModel;
                        }).collect(Collectors.toList());
        return response;
    }
}
