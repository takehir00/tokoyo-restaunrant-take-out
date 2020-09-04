package com.example.tokyorestauranttakeout.admin.responses.menu;

import com.example.tokyorestauranttakeout.admin.models.menu.AdminMenuIndexModel;
import lombok.Data;

import java.util.List;

@Data
public class AdminMenuIndexResponse {
    public List<AdminMenuIndexModel> menuIndexModelList;
}
