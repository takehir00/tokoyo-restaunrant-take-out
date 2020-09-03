package com.example.tokyorestauranttakeout.admin.responses.restaurants;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;

import java.util.List;

public class AdminRestaurantsUpdateFormResponse {
    /** プルダウン用区リスト */
    public List<PullDownFormWardModel> wardList;
    /** 更新フォーム */
    public AdminRestaurantUpdateForm updateForm;
}
