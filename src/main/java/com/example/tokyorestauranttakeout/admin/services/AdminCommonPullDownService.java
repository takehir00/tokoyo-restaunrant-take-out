package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;

import java.util.List;

public interface AdminCommonPullDownService {
    /**
     * プルダウン用区リストの取得
     * @return
     */
    List<PullDownFormWardModel> getWardList();
}
