package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormRestaurantModel;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardAreaModel;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;
import com.example.tokyorestauranttakeout.admin.services.AdminCommonPullDownService;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import com.example.tokyorestauranttakeout.repositories.WardAreaRepository;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminCommonPullDownServiceImpl implements AdminCommonPullDownService {
    @Autowired
    WardRepository wardRepository;
    @Autowired
    WardAreaRepository wardAreaRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<PullDownFormWardModel> getWardList() {
        return wardRepository.selectAll().stream()
                .map(ward -> {
                    PullDownFormWardModel wardModel = new PullDownFormWardModel();
                    wardModel.id = ward.getId();
                    wardModel.name = ward.getName();
                    return wardModel;
                }).collect(Collectors.toList());
    }

    @Override
    public List<PullDownFormWardAreaModel> getWardAreaList() {
        return wardAreaRepository.selectAll().stream()
                .map(wardArea -> {
                    PullDownFormWardAreaModel pullDownFormWardAreaModel = new PullDownFormWardAreaModel();
                    pullDownFormWardAreaModel.id = wardArea.getId();
                    pullDownFormWardAreaModel.name = wardArea.getName();
                    return pullDownFormWardAreaModel;
                }).collect(Collectors.toList());
    }

    @Override
    public List<PullDownFormRestaurantModel> getRestaurantList() {
        return restaurantRepository.selectAll().stream()
                .map(restaurant -> {
                    PullDownFormRestaurantModel pullDownFormRestaurantModel = new PullDownFormRestaurantModel();
                    pullDownFormRestaurantModel.id = restaurant.getId();
                    pullDownFormRestaurantModel.name = restaurant.getName();
                    return pullDownFormRestaurantModel;
                }).collect(Collectors.toList());
    }
}
