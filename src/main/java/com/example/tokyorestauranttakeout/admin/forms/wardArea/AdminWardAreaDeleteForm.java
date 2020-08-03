package com.example.tokyorestauranttakeout.admin.forms.wardArea;

import lombok.Data;

import java.util.Date;
@Data
public class AdminWardAreaDeleteForm {
    /** ID */
    public Integer id;
    /** 区内エリア名 */
    public String name;
    /** 所属区名 */
    public String wardName;
    /** 画像 */
    public String image;
    /** MIME_TYPE */
    public String mimeType;
    /** 作成日時 */
    public Date createdAt;
    /** 更新日時 */
    public Date updatedAt;
}
