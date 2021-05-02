package com.example.tokyorestauranttakeout.client.forms;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ClientAccountUpdateForm {
    @NotNull(message = "{validate.common.notNull}")
    public Integer id;
    @NotEmpty(message = "{validate.common.notEmpty}")
    @Size(max = 100,message = "101{validate.common.max}")
    public String name;
}
