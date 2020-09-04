package com.example.tokyorestauranttakeout.admin.responses.menu;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormRestaurantModel;

import java.util.List;

public class AdminMenuRegisterFormResponse {
    /** プルダウン用区リスト */
    public List<PullDownFormRestaurantModel> restaurantList;
    /** 登録フォーム */
    public AdminMenuRegisterForm registerForm;
}
