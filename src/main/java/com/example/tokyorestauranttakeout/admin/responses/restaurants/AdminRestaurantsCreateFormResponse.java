package com.example.tokyorestauranttakeout.admin.responses.restaurants;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;

import java.util.List;

public class AdminRestaurantsCreateFormResponse {
    /** プルダウン用区リスト */
    public List<PullDownFormWardModel> wardList;
    /** 登録フォーム */
    public AdminRestaurantCreateForm registerForm;
}
