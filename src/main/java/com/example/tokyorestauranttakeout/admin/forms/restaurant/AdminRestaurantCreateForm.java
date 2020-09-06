package com.example.tokyorestauranttakeout.admin.forms.restaurant;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class AdminRestaurantCreateForm {
    public String name;
    public String address;
    public String phoneNumber;
    public MultipartFile image;
    public String mimeType;
    public String introduction;
    public Integer genreId;
    public String fromTime;
    public String toTime;
    public Integer wardId;
    public Integer wardAreaId;
}
