package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.role.AdminRoleModel;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleDeleteFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleUpdateFormResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminRoleService;
import com.example.tokyorestauranttakeout.entity.AdminRole;
import com.example.tokyorestauranttakeout.repositories.AdminRoleRepository;
import com.example.tokyorestauranttakeout.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    AdminRoleRepository adminRoleRepository;

    @Override
    public AdminRoleIndexResponse getIndexResponse() {
        AdminRoleIndexResponse response = new AdminRoleIndexResponse();
        List<AdminRole> roleList = adminRoleRepository.selectAll();
        response.adminRoleModelList =
                roleList.stream()
                        .map(role -> {
                            AdminRoleModel adminRoleModel = new AdminRoleModel();
                            BeanUtils.copyProperties(role, adminRoleModel);
                            return adminRoleModel;
                        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public void create(AdminRoleCreateForm registerForm) {
        Date now = DateUtil.now();
        AdminRole adminRole = new AdminRole();
        adminRole.setName(registerForm.getName());
        adminRole.setCreatedAt(now);
        adminRole.setUpdatedAt(now);
        adminRoleRepository.create(adminRole);
    }

    @Override
    public AdminRoleUpdateFormResponse getUpdateFormResponse(Integer roleId) {
        AdminRoleUpdateFormResponse response = new AdminRoleUpdateFormResponse();

        AdminRole adminRole = adminRoleRepository.get(roleId)
                .orElseThrow(RuntimeException::new);

        AdminRoleUpdateForm updateForm = new AdminRoleUpdateForm();
        updateForm.setName(adminRole.getName());

        response.roleId = adminRole.getId();
        response.updateForm = updateForm;
        return response;
    }

    @Override
    public void update(Integer roleId, AdminRoleUpdateForm updateForm) {
        AdminRole adminRole = adminRoleRepository.get(roleId)
                .orElseThrow(RuntimeException::new);
        adminRole.setName(updateForm.getName());

        adminRoleRepository.update(adminRole);
    }

    @Override
    public AdminRoleDeleteFormResponse getDeleteFormResponse(Integer roleId) {
        AdminRoleDeleteFormResponse response = new AdminRoleDeleteFormResponse();

        AdminRole adminRole = adminRoleRepository.get(roleId)
                .orElseThrow(RuntimeException::new);

        AdminRoleModel model = new AdminRoleModel();
        model.id = adminRole.getId();
        model.name = adminRole.getName();
        model.createdAt = adminRole.getCreatedAt();
        model.updatedAt = adminRole.getUpdatedAt();

        response.adminRoleModel = model;
        return response;
    }

    @Override
    public void delete(Integer roleId) {
        adminRoleRepository.delete(roleId);
    }
}
