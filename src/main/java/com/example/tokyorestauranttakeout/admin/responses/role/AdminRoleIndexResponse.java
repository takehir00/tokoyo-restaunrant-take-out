package com.example.tokyorestauranttakeout.admin.responses.role;

import com.example.tokyorestauranttakeout.admin.models.role.AdminRoleModel;
import lombok.Data;

import java.util.List;

@Data
public class AdminRoleIndexResponse {
    public List<AdminRoleModel> adminRoleModelList;
}
