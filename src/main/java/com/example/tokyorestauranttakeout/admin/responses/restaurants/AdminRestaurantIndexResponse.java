package com.example.tokyorestauranttakeout.admin.responses.restaurants;

import com.example.tokyorestauranttakeout.admin.models.restaurants.AdminRestaurantIndexModel;
import lombok.Data;

import java.util.List;

@Data
public class AdminRestaurantIndexResponse {
    /** 店舗モデルリスト　*/
    public List<AdminRestaurantIndexModel> restaurantIndexModelList;
}
