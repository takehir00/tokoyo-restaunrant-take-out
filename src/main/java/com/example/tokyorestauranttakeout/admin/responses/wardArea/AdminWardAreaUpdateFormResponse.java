package com.example.tokyorestauranttakeout.admin.responses.wardArea;

import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaFormWardModel;

import java.util.List;

public class AdminWardAreaUpdateFormResponse {
    /** プルダウン用区リスト */
    public List<AdminWardAreaFormWardModel> wardList;
    /** 登録フォーム */
    public WardAreaUpdateForm updateForm;

}
