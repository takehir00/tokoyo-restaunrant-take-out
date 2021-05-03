package com.example.tokyorestauranttakeout.admin.responses.role;

import com.example.tokyorestauranttakeout.admin.models.role.AdminRoleIndexModel;
import lombok.Data;

import java.util.List;

@Data
public class AdminRoleIndexResponse {
    public List<AdminRoleIndexModel> adminRoleIndexModelList;
}
