package com.example.tokyorestauranttakeout.client.responses;

import com.example.tokyorestauranttakeout.client.models.WardIndexModel;
import lombok.Data;

import java.util.List;


public class WardIndexResponse {
    /**　indexアクション用区モデルリスト */
    public List<WardIndexModel> wardIndexModelList;
}
