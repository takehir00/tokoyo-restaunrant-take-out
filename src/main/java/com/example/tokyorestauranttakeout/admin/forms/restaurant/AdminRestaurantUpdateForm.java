package com.example.tokyorestauranttakeout.admin.forms.restaurant;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdminRestaurantUpdateForm {
    public Integer id;
    public String name;
    public String address;
    public String phoneNumber;
    public MultipartFile image;
    public String mimeType;
    public String introduction;
    public Integer genreId;
    public String fromTime;
    public String toTime;
    public Integer wardId;
    public Integer wardAreaId;
    /** 画像更新フラグ */
    public boolean imageUpdateFlg;
    /** Base64画像 */
    public String imageConvertedByBase64;
}
