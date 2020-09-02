package com.example.tokyorestauranttakeout.admin.responses.wardArea;

import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaIndexModel;
import lombok.Data;

import java.util.List;

@Data
public class AdminWardAreaIndexResponse {
    /** 一覧画面用区内エリアモデルリスト */
    public List<AdminWardAreaIndexModel> wardAreaIndexModelList;
}
