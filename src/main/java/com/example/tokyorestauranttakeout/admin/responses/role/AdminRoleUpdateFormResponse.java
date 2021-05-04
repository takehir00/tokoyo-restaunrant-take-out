package com.example.tokyorestauranttakeout.admin.responses.role;

import com.example.tokyorestauranttakeout.admin.forms.role.AdminRoleUpdateForm;
import lombok.Data;

@Data
public class AdminRoleUpdateFormResponse {
    /**
     * ロールID
     */
    public Integer roleId;

    /**
     * 更新フォーム
     */
    public AdminRoleUpdateForm updateForm;
}
