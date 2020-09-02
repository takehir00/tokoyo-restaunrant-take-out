package com.example.tokyorestauranttakeout.admin.services;

import com.example.tokyorestauranttakeout.entity.Menu;

import java.io.IOException;

public interface AdminMenuService {
    /**
     * IDで取得
     * @param id
     * @return
     */
    public Menu getById(Integer id) throws IOException;
}
