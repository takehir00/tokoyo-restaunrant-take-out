package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.services.AdminMenuService;
import com.example.tokyorestauranttakeout.model.Menu;
import com.example.tokyorestauranttakeout.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu getById(Integer id) throws IOException {
        return menuRepository.selectById(id);
    }
}
