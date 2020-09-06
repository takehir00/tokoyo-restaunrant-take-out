package com.example.tokyorestauranttakeout.client.services.impl;

import com.example.tokyorestauranttakeout.client.models.WardAreaIndexModel;
import com.example.tokyorestauranttakeout.client.responses.WardAreaIndexResponse;
import com.example.tokyorestauranttakeout.client.services.WardAreaService;
import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.repositories.WardAreaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WardAreaServiceImpl implements WardAreaService {

    @Autowired
    WardAreaRepository wardAreaRepository;

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
}
