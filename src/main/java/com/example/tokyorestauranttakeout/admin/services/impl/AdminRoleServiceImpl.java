package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.models.role.AdminRoleIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.role.AdminRoleIndexResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminRoleService;
import com.example.tokyorestauranttakeout.entity.AdminRole;
import com.example.tokyorestauranttakeout.repositories.AdminRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        response.adminRoleIndexModelList =
                roleList.stream()
                        .map(role -> {
                            AdminRoleIndexModel adminRoleIndexModel = new AdminRoleIndexModel();
                            BeanUtils.copyProperties(role, adminRoleIndexModel);
                            return adminRoleIndexModel;
                        }).collect(Collectors.toList());
        return response;
    }
}
