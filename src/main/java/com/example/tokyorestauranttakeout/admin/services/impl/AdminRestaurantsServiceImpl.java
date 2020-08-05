package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;
import com.example.tokyorestauranttakeout.admin.models.wardArea.AdminWardAreaIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.AdminRestaurantsCreateFormResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminRestaurantsService;
import com.example.tokyorestauranttakeout.entity.CustomWardArea;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRestaurantsServiceImpl implements AdminRestaurantsService {

    @Autowired
    WardRepository wardRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

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

    }
}
