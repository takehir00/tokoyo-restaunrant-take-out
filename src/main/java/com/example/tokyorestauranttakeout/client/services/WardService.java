package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.responses.WardIndexResponse;

public interface WardService {
    /**
     * 区index画面用レスポンスを返却
     * @return
     */
    public WardIndexResponse getIndexResponse();
}
