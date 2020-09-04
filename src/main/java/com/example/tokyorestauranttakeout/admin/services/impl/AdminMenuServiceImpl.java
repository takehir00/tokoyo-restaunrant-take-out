package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormRestaurantModel;
import com.example.tokyorestauranttakeout.admin.models.menu.AdminMenuIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.menu.AdminMenuRegisterFormResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminMenuService;
import com.example.tokyorestauranttakeout.entity.CustomMenu;
import com.example.tokyorestauranttakeout.entity.Menu;
import com.example.tokyorestauranttakeout.repositories.MenuRepository;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import com.example.tokyorestauranttakeout.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

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

    @Override
    public AdminMenuRegisterFormResponse getRegisterFormResponse() {
        AdminMenuRegisterFormResponse response = new AdminMenuRegisterFormResponse();
        response.restaurantList =
                restaurantRepository.selectAll().stream()
                        .map(restaurant -> {
                            PullDownFormRestaurantModel pullDownFormRestaurantModel = new PullDownFormRestaurantModel();
                            pullDownFormRestaurantModel.id = restaurant.getId();
                            pullDownFormRestaurantModel.name = restaurant.getName();
                            return pullDownFormRestaurantModel;
                        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public void create(AdminMenuRegisterForm registerForm) {
        Date now = new Date();
        Menu menu = new Menu();
        BeanUtils.copyProperties(registerForm, menu);
        menu.setCreatedAt(now);
        menu.setUpdatedAt(now);
        if (registerForm.image != null ) {
            try {
                menu.setImage(FileUtil.encodeBase64(
                        registerForm.getImage()));
            } catch (IOException e) {
                throw new RuntimeException("ファイル処理エラー");
            }
            menu.setMimeType(
                    registerForm.image.getContentType());
        }
        menuRepository.create(menu);
    }
}
