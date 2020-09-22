package com.example.tokyorestauranttakeout.admin.forms.menu;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AdminMenuUpdateForm {
    public Integer id;

    @NotEmpty(message = "入力してください")
    @Size(max = 100, message = "100文字以下で入力してください")
    public String name;

    @NotNull(message = "入力してください")
    @Max(value = 1000000,message = "1000000円以下で入力してください")
    public Integer price;

    public MultipartFile image;

    public String mimeType;

    @NotNull(message = "入力してください")
    public Integer restaurantId;

    public Integer priority;

    /** 画像更新フラグ */
    @NotNull(message = "入力してください")
    public boolean imageUpdateFlg;

    /** Base64画像 */
    public String imageConvertedByBase64;
}
