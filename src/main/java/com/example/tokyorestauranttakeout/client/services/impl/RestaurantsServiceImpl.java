package com.example.tokyorestauranttakeout.client.services.impl;

import com.example.tokyorestauranttakeout.client.models.restaurants.RestaurantMenuModel;
import com.example.tokyorestauranttakeout.client.models.restaurants.RestaurantShowModel;
import com.example.tokyorestauranttakeout.client.responses.RestaurantsShowResponse;
import com.example.tokyorestauranttakeout.client.services.RestaurantsService;
import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.repositories.MenuRepository;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RestaurantsServiceImpl implements RestaurantsService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuRepository menuRepository;

    @Override
    public RestaurantsShowResponse getShowResponse(Integer restaurantId) {
        RestaurantsShowResponse response = new RestaurantsShowResponse();
        RestaurantShowModel showModel = new RestaurantShowModel();
        Restaurant restaurant =
                restaurantRepository.selectById(restaurantId);
        BeanUtils.copyProperties(restaurant, showModel);
        showModel.setMenuModelList(
                menuRepository.selectByRestaurantId(restaurantId).stream()
                        .map(menu -> {
                            RestaurantMenuModel restaurantMenuModel = new RestaurantMenuModel();
                            BeanUtils.copyProperties(menu, restaurantMenuModel);
                            return restaurantMenuModel;
                        }).collect(Collectors.toList()));

        response.showModel = showModel;

        return response;
    }
}
