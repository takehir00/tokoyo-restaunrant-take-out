package com.example.tokyorestauranttakeout.client.models.restaurants;

import lombok.Data;

@Data
public class RestaurantMenuModel {
    public Integer id;

    public String name;

    public Integer price;

    public String image;

    public String mimeType;

    public Integer priority;
}
