package com.example.tokyorestauranttakeout.admin.forms.wardArea;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class WardAreaUpdateForm {
    /** ID */
    public Integer id;
    /** エリア名 */
    public String name;
    /** 画像 */
    public MultipartFile image;
    /** 紐づく区ID */
    public Integer wardId;
    /** 画像更新フラグ */
    public boolean imageUpdateFlg;
    /** Base64画像 */
    public String imageConvertedByBase64;
    /** MIME_TYPE */
    public String mimeType;
}
