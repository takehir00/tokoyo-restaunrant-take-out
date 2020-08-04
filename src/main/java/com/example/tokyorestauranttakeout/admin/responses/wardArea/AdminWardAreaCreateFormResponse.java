package com.example.tokyorestauranttakeout.admin.responses.wardArea;

import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaRegisterForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;

import java.util.List;

public class AdminWardAreaCreateFormResponse {
    /** プルダウン用区リスト */
    public List<PullDownFormWardModel> wardList;
    /** 登録フォーム */
    public WardAreaRegisterForm registerForm;
}
