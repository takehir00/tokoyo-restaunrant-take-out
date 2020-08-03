package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.wardArea.AdminWardAreaDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaFormWardModel;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaIndexModel;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaShowModel;
import com.example.tokyorestauranttakeout.admin.responses.wardArea.*;
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
                            AdminWardAreaFormWardModel wardModel = new AdminWardAreaFormWardModel();
                            wardModel.id = ward.getId();
                            wardModel.name = ward.getName();
                            return wardModel;
                        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public AdminWardAreaShowResponse getShowResponse(Integer wardAreaId) {
        AdminWardAreaShowResponse response = new AdminWardAreaShowResponse();

        AdminWardAreaShowModel showModel = new AdminWardAreaShowModel();
        CustomWardArea customWardArea =
                wardAreaRepository.selectByIDWithWard(wardAreaId);
        showModel.id = customWardArea.getId();
        showModel.name = customWardArea.getName();
        showModel.wardName = customWardArea.getWardName();
        showModel.image = customWardArea.getImage();
        showModel.mimeType = customWardArea.getMimeType();
        showModel.createdAt = customWardArea.getCreatedAt();
        showModel.updatedAt = customWardArea.getUpdatedAt();

        response.wardAreaShowModel = showModel;
        return response;
    }

    @Override
    public AdminWardAreaUpdateFormResponse getUpdateForm(Integer wardAreaId) {
        AdminWardAreaUpdateFormResponse response = new AdminWardAreaUpdateFormResponse();

        WardAreaUpdateForm updateForm = new WardAreaUpdateForm();
        WardArea wardArea = wardAreaRepository.selectById(wardAreaId);
        updateForm.id = wardArea.getId();
        updateForm.name = wardArea.getName();
        updateForm.wardId = wardArea.getWardId();
        updateForm.imageConvertedByBase64 = wardArea.getImage();
        updateForm.mimeType = wardArea.getMimeType();
        response.updateForm = updateForm;

        response.wardList = wardRepository.selectAll().stream()
                .map(ward -> {
                    AdminWardAreaFormWardModel wardModel = new AdminWardAreaFormWardModel();
                    wardModel.id = ward.getId();
                    wardModel.name = ward.getName();
                    return wardModel;
                }).collect(Collectors.toList());
        return response;
    }

    @Override
    public void update(WardAreaUpdateForm wardAreaUpdateForm) throws IOException {
        WardArea wardArea =
                wardAreaRepository.selectById(wardAreaUpdateForm.getId());
        if (wardArea != null) {
            Date now = new Date();
            wardArea.setName(wardAreaUpdateForm.getName());

            if (wardAreaUpdateForm.imageUpdateFlg) {
                if (wardAreaUpdateForm.image != null ) {
                    wardArea.setImage(FileUtil.encodeBase64(
                            wardAreaUpdateForm.image));
                    wardArea.setMimeType(
                            wardAreaUpdateForm.image.getContentType());
                } else {
                    wardArea.setImage(null);
                    wardArea.setMimeType(null);
                }
            }

            wardArea.setWardId(wardAreaUpdateForm.getWardId());
            wardArea.setUpdatedAt(now);
            wardAreaRepository.update(wardArea);
        }
    }

    @Override
    public AdminWardAreaDeleteFormResponse getDeleteFormResponse(Integer wardAreaId) {
        AdminWardAreaDeleteFormResponse response = new AdminWardAreaDeleteFormResponse();

        AdminWardAreaDeleteForm deleteForm = new AdminWardAreaDeleteForm();
        CustomWardArea customWardArea =
                wardAreaRepository.selectByIDWithWard(wardAreaId);
        deleteForm.id = customWardArea.getId();
        deleteForm.name = customWardArea.getName();
        deleteForm.wardName = customWardArea.getWardName();
        deleteForm.image = customWardArea.getImage();
        deleteForm.mimeType = customWardArea.getMimeType();
        deleteForm.createdAt = customWardArea.getCreatedAt();
        deleteForm.updatedAt = customWardArea.getUpdatedAt();

        response.deleteForm = deleteForm;
        return response;

    }

    @Override
    public void delete(AdminWardAreaDeleteForm wardAreaDeleteForm) {
        wardAreaRepository.delete(wardAreaDeleteForm.id);
    }
}
