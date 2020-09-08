package com.example.tokyorestauranttakeout.client.responses;

import com.example.tokyorestauranttakeout.client.models.wardArea.WardAreaRestaurantModel;
import lombok.Data;

import java.util.List;

@Data
public class WardAreaShowResponse {
    public String wardAreaName;
    public List<WardAreaRestaurantModel> restaurantModelList;
}
