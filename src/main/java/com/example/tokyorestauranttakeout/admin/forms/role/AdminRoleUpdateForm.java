package com.example.tokyorestauranttakeout.admin.forms.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdminRoleUpdateForm {

    /**
     * ロール名
     */
    @NotEmpty(message = "{validate.common.notEmpty}")
    public String name;
}
