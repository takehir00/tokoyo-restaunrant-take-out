package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuRegisterForm;
import com.example.tokyorestauranttakeout.admin.forms.menu.AdminMenuUpdateForm;
import com.example.tokyorestauranttakeout.admin.forms.restaurant.AdminRestaurantUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.common.PullDownFormRestaurantModel;
import com.example.tokyorestauranttakeout.admin.models.menu.AdminMenuIndexModel;
import com.example.tokyorestauranttakeout.admin.models.menu.AdminMenuShowModel;
import com.example.tokyorestauranttakeout.admin.responses.menu.*;
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
    public AdminMenuShowResponse getShowResponse(Integer menuId) {
        AdminMenuShowResponse response = new AdminMenuShowResponse();
        CustomMenu customMenu = menuRepository.selectByIdWithRestaurant(menuId);

        AdminMenuShowModel showModel = new AdminMenuShowModel();
        BeanUtils.copyProperties(customMenu, showModel);
        response.showModel = showModel;

        return response;
    }

    @Override
    public AdminMenuDeleteFormResponse getDeleteFormResponse(Integer menuId) {
        AdminMenuDeleteFormResponse response = new AdminMenuDeleteFormResponse();
        AdminMenuDeleteForm deleteForm = new AdminMenuDeleteForm();
        CustomMenu customMenu = menuRepository.selectByIdWithRestaurant(menuId);
        BeanUtils.copyProperties(customMenu, deleteForm);
        response.deleteForm = deleteForm;
        return response;
    }

    @Override
    public void delete(AdminMenuDeleteForm deleteForm) {
        menuRepository.delete(deleteForm.getId());
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

    @Override
    public AdminMenuUpdateFormResponse getUpdateFormResponse(Integer menuId) {
        AdminMenuUpdateFormResponse response = new AdminMenuUpdateFormResponse();

        AdminMenuUpdateForm updateForm = new AdminMenuUpdateForm();

        Menu menu = menuRepository.selectById(menuId);
        BeanUtils.copyProperties(menu,updateForm);
        updateForm.imageConvertedByBase64 = menu.getImage();
        response.updateForm = updateForm;

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
    public void update(AdminMenuUpdateForm updateForm) throws IOException {
        Menu menu = menuRepository.selectById(updateForm.getId());
        if (menu != null) {
            Date now = new Date();
            BeanUtils.copyProperties(updateForm, menu);

            if (updateForm.imageUpdateFlg) {
                if (updateForm.image != null) {
                    menu.setImage(FileUtil.encodeBase64(
                            updateForm.image));
                    menu.setMimeType(
                            updateForm.image.getContentType());
                } else {
                    menu.setImage(null);
                    menu.setMimeType(null);
                }
            }
            menuRepository.update(menu);
        }
    }
}
