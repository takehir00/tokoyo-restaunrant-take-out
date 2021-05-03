package com.example.tokyorestauranttakeout.admin.forms.account;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdminAccountCreateForm {
    @NotEmpty(message = "{validate.common.notEmpty}")
    private String name;
    @NotEmpty(message = "{validate.common.notEmpty}")
    private String password;
}
