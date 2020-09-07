package com.example.tokyorestauranttakeout.client.services.impl;

import com.example.tokyorestauranttakeout.client.models.wardArea.WardAreaIndexModel;
import com.example.tokyorestauranttakeout.client.models.wardArea.WardAreaMenuModel;
import com.example.tokyorestauranttakeout.client.models.wardArea.WardAreaRestaurantModel;
import com.example.tokyorestauranttakeout.client.responses.WardAreaIndexResponse;
import com.example.tokyorestauranttakeout.client.responses.WardAreaShowResponse;
import com.example.tokyorestauranttakeout.client.services.WardAreaService;
import com.example.tokyorestauranttakeout.entity.Menu;
import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.repositories.MenuRepository;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import com.example.tokyorestauranttakeout.repositories.WardAreaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WardAreaServiceImpl implements WardAreaService {

    @Autowired
    WardAreaRepository wardAreaRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuRepository menuRepository;

    @Override
    public WardAreaIndexResponse getIndexResponse() {
        WardAreaIndexResponse response = new WardAreaIndexResponse();
        List<WardArea> wardAreaList = wardAreaRepository.selectAll();
        response.wardAreaIndexModelList =
                wardAreaList.stream()
                        .map(wardArea -> {
                            WardAreaIndexModel wardAreaIndexModel = new WardAreaIndexModel();
                            BeanUtils.copyProperties(wardArea, wardAreaIndexModel);
                            return wardAreaIndexModel;
                        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public WardAreaShowResponse getShowResponse(Integer wardAreaId) {
        WardAreaShowResponse response = new WardAreaShowResponse();
        WardArea wardArea = wardAreaRepository.selectById(wardAreaId);
        response.setWardAreaName(wardArea.getName());

        //店舗リスト生成
        List<WardAreaRestaurantModel> restaurantModelList = new ArrayList<>();
        List<Restaurant> restaurantList =
                restaurantRepository.selectByWardAreaId(wardArea.getId());
        restaurantList.forEach(restaurant -> {
            WardAreaRestaurantModel restaurantModel = new WardAreaRestaurantModel();
            BeanUtils.copyProperties(restaurant, restaurantModel);
            //メニューリスト生成
            List<Menu> menuList = menuRepository.selectByRestaurantId(restaurant.getId());
            restaurantModel.setMenuModelList(
                    menuList.stream()
                            .map(menu -> {
                                WardAreaMenuModel menuModel = new WardAreaMenuModel();
                                menuModel.setName(menu.getName());
                                return menuModel;
                            }).collect(Collectors.toList()));
            restaurantModelList.add(restaurantModel);
        });
        response.setRestaurantModelList(restaurantModelList);

        return response;
    }
}
