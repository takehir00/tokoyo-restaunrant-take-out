package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.admin.forms.WardRegisterForm;

import java.io.IOException;

public interface AdminWardService {

    /**
     * 区登録
     * @param wardRegisterForm
     */
    public void create(WardRegisterForm wardRegisterForm) throws IOException;

}
