package com.example.tokyorestauranttakeout.admin.forms.ward;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class WardUpdateForm {
    public Integer id;
    @NotEmpty(message = "入力してください")
    @Size(max = 100, message = "100文字以下で入力してください")
    public String name;
    public MultipartFile image;
}
