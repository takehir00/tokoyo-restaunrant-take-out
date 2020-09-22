package com.example.tokyorestauranttakeout.admin.responses.account;

import com.example.tokyorestauranttakeout.admin.models.account.AdminAccountIndexModel;
import lombok.Data;

import java.util.List;

@Data
public class AdminAccountIndexResponse {
    public List<AdminAccountIndexModel> accountIndexModelList;
}
