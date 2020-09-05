package com.example.tokyorestauranttakeout.admin.responses.wardArea;

import com.example.tokyorestauranttakeout.admin.forms.wardArea.WardAreaUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;

import java.util.List;

public class AdminWardAreaUpdateFormResponse {
    /** プルダウン用区リスト */
    public List<PullDownFormWardModel> wardList;
    /** 登録フォーム */
    public WardAreaUpdateForm updateForm;

}
