package com.example.tokyorestauranttakeout.client.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClientAccountCreateForm {
    @NotEmpty(message = "入力してください")
    public String email;
    @NotEmpty(message = "入力してください")
    public String password;
}
