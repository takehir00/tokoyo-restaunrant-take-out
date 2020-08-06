package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.AdminRestaurantIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.AdminRestaurantsCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminRestaurantsService;
import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import com.example.tokyorestauranttakeout.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRestaurantsServiceImpl implements AdminRestaurantsService {

    @Autowired
    WardRepository wardRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public AdminRestaurantIndexResponse getIndexResponse() {
        return null;
    }

    @Override
    public AdminRestaurantsCreateFormResponse getCreateFormResponse() {
        AdminRestaurantsCreateFormResponse response = new AdminRestaurantsCreateFormResponse();
        response.wardList =
                wardRepository.selectAll().stream()
                        .map(ward -> {
                            PullDownFormWardModel wardModel = new PullDownFormWardModel();
                            wardModel.id = ward.getId();
                            wardModel.name = ward.getName();
                            return wardModel;
                        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public void create(AdminRestaurantCreateForm registerForm) {
        Date now = new Date();
        Restaurant restaurant = new Restaurant();
        restaurant.setName(registerForm.getName());
        restaurant.setAddress(registerForm.getAddress());
        restaurant.setPhoneNumber(registerForm.getPhoneNumber());
        restaurant.setIntroduction(registerForm.getIntroduction());
        restaurant.setFromTime(registerForm.getFromTime());
        restaurant.setToTime(registerForm.getToTime());
        restaurant.setWardId(registerForm.getWardId());
        restaurant.setCreatedAt(now);
        restaurant.setUpdatedAt(now);
        if (registerForm.image != null ) {
            try {
                restaurant.setImage(FileUtil.encodeBase64(
                        registerForm.getImage()));
            } catch (IOException e) {
                throw new RuntimeException("ファイル処理エラー");
            }
            restaurant.setMimeType(
                    registerForm.image.getContentType());
        }
        restaurantRepository.create(restaurant);
    }
}
