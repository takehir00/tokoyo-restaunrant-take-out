package com.example.tokyorestauranttakeout.admin.responses.menu;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormRestaurantModel;

import java.util.List;

public class AdminMenuUpdateFormResponse {
    /** プルダウン用区リスト */
    public List<PullDownFormRestaurantModel> restaurantList;
    /** 更新フォーム */
    public AdminMenuUpdateForm updateForm;
}
