package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.responses.WardAreaIndexResponse;
import com.example.tokyorestauranttakeout.client.responses.WardAreaShowResponse;

public interface WardAreaService {
    /**
     * 区index画面用レスポンスを返却
     * @return
     */
    public WardAreaIndexResponse getIndexResponse();

    /**
     * 区内エリア詳細画面レスポンス
     * @return
     * @param wardAreaId
     */
    WardAreaShowResponse getShowResponse(Integer wardAreaId);
}
