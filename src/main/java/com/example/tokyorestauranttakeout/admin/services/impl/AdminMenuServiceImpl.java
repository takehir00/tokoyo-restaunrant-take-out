package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.models.menu.AdminMenuIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuIndexResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminMenuService;
import com.example.tokyorestauranttakeout.entity.CustomMenu;
import com.example.tokyorestauranttakeout.entity.Menu;
import com.example.tokyorestauranttakeout.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu getById(Integer id) throws IOException {
        return menuRepository.selectById(id);
    }

    @Override
    public AdminMenuIndexResponse getIndexResponse() {
        AdminMenuIndexResponse response = new AdminMenuIndexResponse();
        List<CustomMenu> customMenuList = menuRepository.selectAllWithRestaurant();
        response.setMenuIndexModelList(
                customMenuList.stream()
                        .map(customMenu -> {
                            AdminMenuIndexModel adminMenuIndexModel = new AdminMenuIndexModel();
                            adminMenuIndexModel.id = customMenu.getId();
                            adminMenuIndexModel.name = customMenu.getName();
                            adminMenuIndexModel.price = customMenu.getPrice();
                            adminMenuIndexModel.restaurantName = customMenu.getRestaurantName();
                            adminMenuIndexModel.createdAt = customMenu.getCreatedAt();
                            adminMenuIndexModel.updatedAt = customMenu.getUpdatedAt();
                            return adminMenuIndexModel;
                        }).collect(Collectors.toList()));
        return response;
    }
}
