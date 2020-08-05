package com.example.tokyorestauranttakeout.admin.forms.restaurant;

import lombok.Data;

@Data
public class AdminRestaurantCreateForm {
    public String name;
    public String address;
    public String phoneNumber;
    public String image;
    public String mimeType;
    public String introduction;
    public Integer genreId;
    public String fromTime;
    public String toTime;
    public Integer wardId;
}
