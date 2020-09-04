package com.example.tokyorestauranttakeout.admin.forms.menu;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdminMenuRegisterForm {
    public String name;
    public Integer price;
    public MultipartFile image;
    public String mimeType;
    public Integer restaurantId;
    public Integer priority;
}
