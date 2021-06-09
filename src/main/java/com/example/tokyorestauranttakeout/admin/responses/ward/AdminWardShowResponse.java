package com.example.tokyorestauranttakeout.admin.responses.ward;

import java.time.LocalDateTime;

public class AdminWardShowResponse {
    /** id */
    public Integer id;
    /** 名前 */
    public String name;
    /** 画像 */
    public String image;
    /** MIME_TYPE */
    public String mimeType;
    /** 作成日時 */
    public LocalDateTime createdAt;
    /** 更新日時 */
    public LocalDateTime updatedAt;
}
