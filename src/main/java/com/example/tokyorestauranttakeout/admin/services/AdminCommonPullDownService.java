package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormRestaurantModel;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardAreaModel;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;

import java.util.List;

public interface AdminCommonPullDownService {
    /**
     * プルダウン用区リストの取得
     * @return
     */
    List<PullDownFormWardModel> getWardList();

    /**
     * プルダウン用区内エリアリストの取得
     * @return
     */
    List<PullDownFormWardAreaModel> getWardAreaList();

    /**
     * プルダウン用店舗リスト
     * @return
     */
    List<PullDownFormRestaurantModel> getRestaurantList();
}
