package com.example.tokyorestauranttakeout.admin.forms.restaurant;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AdminRestaurantUpdateForm {
    public Integer id;

    @NotEmpty(message = "入力してください")
    @Size(max = 100, message = "100文字以下で入力してください")
    public String name;

    @NotEmpty(message = "入力してください")
    @Size(max = 100, message = "1000文字以下で入力してください")
    public String address;

    @NotEmpty(message = "入力してください")
    @Size(max = 100, message = "100文字以下で入力してください")
    public String phoneNumber;

    public MultipartFile image;

    public String mimeType;

    @Size(max = 2000, message = "2000文字以下で入力してください")
    public String introduction;

    public Integer genreId;

    public String fromTime;

    public String toTime;

    @NotNull(message = "入力してください")
    public Integer wardId;

    @NotNull(message = "入力してください")
    public Integer wardAreaId;

    /** 画像更新フラグ */
    @NotNull(message = "入力してください")
    public boolean imageUpdateFlg;

    /** Base64画像 */
    public String imageConvertedByBase64;
}
