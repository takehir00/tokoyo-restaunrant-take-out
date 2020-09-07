package com.example.tokyorestauranttakeout.client.models.wardArea;

import com.example.tokyorestauranttakeout.client.models.wardArea.WardAreaMenuModel;
import lombok.Data;

import java.util.List;

@Data
public class WardAreaRestaurantModel {
    /** 店舗名*/
    public String name;
    /** 店舗紹介 */
    public String introduction;
    /** 店舗画像 */
    public String image;
    /** 店舗画像MIME-TYPE*/
    public String mimeType;
    /** メニューリスト */
    List<WardAreaMenuModel> menuModelList;
}
