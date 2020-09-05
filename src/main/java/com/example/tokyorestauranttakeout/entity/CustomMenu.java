package com.example.tokyorestauranttakeout.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CustomMenu {

        private Integer id;

        private String name;

        private Integer price;

        private String image;

        private String mimeType;

        private Integer restaurantId;

        private String restaurantName;

        private Integer priority;

        private Date createdAt;

        private Date updatedAt;

}
