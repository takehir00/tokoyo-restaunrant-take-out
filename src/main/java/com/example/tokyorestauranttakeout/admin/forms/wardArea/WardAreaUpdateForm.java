package com.example.tokyorestauranttakeout.admin.forms.wardArea;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class WardAreaUpdateForm {
    /** ID */
    public Integer id;

    /** エリア名 */
    @NotEmpty(message = "入力してください")
    @Size(max = 100, message = "100文字以下で入力してください")
    public String name;

    /** 画像 */
    public MultipartFile image;

    /** 紐づく区ID */
    @NotNull(message = "入力してください")
    public Integer wardId;

    /** 画像更新フラグ */
    @NotNull(message = "入力してください")
    public boolean imageUpdateFlg;

    /** Base64画像 */
    public String imageConvertedByBase64;

    /** MIME_TYPE */
    public String mimeType;
}
