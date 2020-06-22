package com.example.tokyorestauranttakeout.admin.forms;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class WardRegisterForm {

    public String name;
    public MultipartFile image;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
}
