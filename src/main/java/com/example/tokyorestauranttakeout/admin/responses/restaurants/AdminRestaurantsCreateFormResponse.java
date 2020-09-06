package com.example.tokyorestauranttakeout.admin.responses.restaurants;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardAreaModel;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;

import java.util.List;

public class AdminRestaurantsCreateFormResponse {
    /** プルダウン用区リスト */
    public List<PullDownFormWardModel> wardList;
    /** プルダウン用区リスト */
    public List<PullDownFormWardAreaModel> wardAreaList;
    /** 登録フォーム */
    public AdminRestaurantCreateForm registerForm;
}
