package com.example.tokyorestauranttakeout.admin.forms.menu;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdminMenuUpdateForm {
    public Integer id;
    public String name;
    public Integer price;
    public MultipartFile image;
    public String mimeType;
    public Integer restaurantId;
    public Integer priority;
    /** 画像更新フラグ */
    public boolean imageUpdateFlg;
    /** Base64画像 */
    public String imageConvertedByBase64;
}
