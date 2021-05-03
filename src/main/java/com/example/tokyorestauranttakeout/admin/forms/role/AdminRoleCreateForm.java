package com.example.tokyorestauranttakeout.admin.forms.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdminRoleCreateForm {
    @NotEmpty(message = "{validate.common.notEmpty}")
    private String name;
}
