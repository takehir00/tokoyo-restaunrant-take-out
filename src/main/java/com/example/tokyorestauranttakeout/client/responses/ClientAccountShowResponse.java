package com.example.tokyorestauranttakeout.client.responses;

import com.example.tokyorestauranttakeout.entity.ClientAccount;
import lombok.Data;

@Data
public class ClientAccountShowResponse {

    /**
     * クライアントアカウント
     */
    public ClientAccount clientAccount;
}
