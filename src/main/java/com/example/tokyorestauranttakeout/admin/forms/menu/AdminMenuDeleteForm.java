package com.example.tokyorestauranttakeout.admin.forms.menu;

import lombok.Data;

import java.util.Date;

@Data
public class AdminMenuDeleteForm {
    /** ID */
    public Integer id;
    /** メニュー名 */
    public String name;
    /** 価格 */
    public Integer price;
    /** 画像base64 */
    public String image;
    /** mimeType */
    public String mimeType;
    /** 優先度 */
    public Integer priority;
    /** レストラン名 */
    public String restaurantName;
    /** 作成日時 */
    public Date createdAt;
    /** 更新日時 */
    public Date updatedAt;
}
