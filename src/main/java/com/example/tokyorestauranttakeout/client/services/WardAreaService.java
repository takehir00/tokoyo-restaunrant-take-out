package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.responses.WardAreaIndexResponse;
import com.example.tokyorestauranttakeout.client.responses.WardIndexResponse;

public interface WardAreaService {
    /**
     * 区index画面用レスポンスを返却
     * @return
     */
    public WardAreaIndexResponse getIndexResponse();
}
