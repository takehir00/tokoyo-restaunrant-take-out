package com.example.tokyorestauranttakeout.admin.forms.ward;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class WardUpdateForm {
    public Integer id;
    public String name;
    public MultipartFile image;
}