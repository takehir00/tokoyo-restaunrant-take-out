package com.example.tokyorestauranttakeout.admin.forms.wardArea;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class WardAreaUpdateForm {
    public Integer id;
    public String name;
    public MultipartFile image;
    public Integer wardId;
}