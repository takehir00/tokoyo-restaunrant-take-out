package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardAreaModel;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormWardModel;
import com.example.tokyorestauranttakeout.admin.models.restaurants.AdminRestaurantIndexModel;
import com.example.tokyorestauranttakeout.admin.models.restaurants.AdminRestaurantShowModel;
import com.example.tokyorestauranttakeout.admin.responses.restaurants.*;
import com.example.tokyorestauranttakeout.admin.services.AdminRestaurantsService;
import com.example.tokyorestauranttakeout.entity.CustomRestaurant;
import com.example.tokyorestauranttakeout.entity.Restaurant;
import com.example.tokyorestauranttakeout.repositories.RestaurantRepository;
import com.example.tokyorestauranttakeout.repositories.WardAreaRepository;
import com.example.tokyorestauranttakeout.repositories.WardRepository;
import com.example.tokyorestauranttakeout.util.DateTimeUtil;
import com.example.tokyorestauranttakeout.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRestaurantsServiceImpl implements AdminRestaurantsService {

    @Autowired
    WardRepository wardRepository;
    @Autowired
    WardAreaRepository wardAreaRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public AdminRestaurantIndexResponse getIndexResponse() {
        AdminRestaurantIndexResponse response = new AdminRestaurantIndexResponse();

        List<CustomRestaurant> restaurantList =
                restaurantRepository.selectAllWithWard();

        response.restaurantIndexModelList =
                restaurantList.stream()
                        .map(restaurant -> {
                            AdminRestaurantIndexModel restaurantIndexModel = new AdminRestaurantIndexModel();
                            restaurantIndexModel.id = restaurant.getId();
                            restaurantIndexModel.name = restaurant.getName();
                            restaurantIndexModel.address = restaurant.getAddress();
                            restaurantIndexModel.wardName = restaurant.getWardName();
                            restaurantIndexModel.createdAt = restaurant.getCreatedAt();
                            restaurantIndexModel.updatedAt = restaurant.getUpdatedAt();
                            return restaurantIndexModel;
                        }).collect(Collectors.toList());

        return response;
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

        response.wardAreaList =
                wardAreaRepository.selectAll().stream()
                        .map(wardArea -> {
                            PullDownFormWardAreaModel pullDownFormWardAreaModel = new PullDownFormWardAreaModel();
                            pullDownFormWardAreaModel.id = wardArea.getId();
                            pullDownFormWardAreaModel.name = wardArea.getName();
                            return pullDownFormWardAreaModel;
                        }).collect(Collectors.toList());

        return response;
    }

    @Override
    public void create(AdminRestaurantCreateForm registerForm) {
        LocalDateTime now = DateTimeUtil.now();
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

    @Override
    public AdminRestaurantShowResponse getShowResponse(Integer restaurantId) {
        AdminRestaurantShowResponse response = new AdminRestaurantShowResponse();

        CustomRestaurant customRestaurant =
                restaurantRepository.selectByIdWithWard(restaurantId);
        AdminRestaurantShowModel showModel = new AdminRestaurantShowModel();
        BeanUtils.copyProperties(customRestaurant, showModel);
        response.showModel = showModel;

        return response;
    }

    @Override
    public AdminRestaurantUpdateForm getUpdateForm(Integer restaurantId, AdminRestaurantUpdateForm restaurantUpdateFormRequest) {
        AdminRestaurantUpdateForm updateForm = new AdminRestaurantUpdateForm();

        if (restaurantUpdateFormRequest != null) {
            updateForm = restaurantUpdateFormRequest;
        } else {
            Restaurant restaurant = restaurantRepository.selectById(restaurantId);
            BeanUtils.copyProperties(restaurant,updateForm);
            updateForm.imageConvertedByBase64 = restaurant.getImage();
        }

        return updateForm;
    }

    @Override
    public void update(AdminRestaurantUpdateForm restaurantUpdateForm) throws IOException {
        Restaurant restaurant =
                restaurantRepository.selectById(restaurantUpdateForm.getId());
        if (restaurant != null) {
            LocalDateTime now = DateTimeUtil.now();
            BeanUtils.copyProperties(restaurantUpdateForm, restaurant);

            if (restaurantUpdateForm.imageUpdateFlg) {
                if (restaurantUpdateForm.image != null) {
                    restaurant.setImage(FileUtil.encodeBase64(
                            restaurantUpdateForm.image));
                    restaurant.setMimeType(
                            restaurantUpdateForm.image.getContentType());
                } else {
                    restaurant.setImage(null);
                    restaurant.setMimeType(null);
                }
            }
            restaurant.setUpdatedAt(now);
            restaurantRepository.update(restaurant);
        }
    }

    @Override
    public AdminRestaurantsDeleteFormResponse getDeleteFormResponse(Integer restaurantId) {
        AdminRestaurantsDeleteFormResponse response = new AdminRestaurantsDeleteFormResponse();
        AdminRestaurantDeleteForm deleteForm = new AdminRestaurantDeleteForm();
        CustomRestaurant customRestaurant =
                restaurantRepository.selectByIdWithWard(restaurantId);
        BeanUtils.copyProperties(customRestaurant, deleteForm);
        response.deleteForm = deleteForm;
        return response;
    }

    @Override
    public void delete(AdminRestaurantDeleteForm deleteForm) {
        restaurantRepository.delete(deleteForm.getId());
    }
}
