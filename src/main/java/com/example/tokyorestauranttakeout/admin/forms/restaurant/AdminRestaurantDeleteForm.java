package com.example.tokyorestauranttakeout.admin.forms.restaurant;

import lombok.Data;

import java.util.Date;

@Data
public class AdminRestaurantDeleteForm {
    /** ID */
    public Integer id;
    /** 区名 */
    public String name;
    /** 住所 */
    public String address;
    /** 住所 */
    public String phoneNumber;
    /** 画像base64 */
    public String image;
    /** mimeType */
    public String mimeType;
    /** 紹介 */
    public String introduction;
    /** 開店時間 */
    public String fromTime;
    /** 閉店時間 */
    public String toTime;
    /** エリア名 */
    public String wardName;
    /** 作成日時 */
    public Date createdAt;
    /** 更新日時 */
    public Date updatedAt;
}
