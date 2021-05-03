package com.example.tokyorestauranttakeout.admin.models.role;

import lombok.Data;

import java.util.Date;

@Data
public class AdminRoleIndexModel {
    /** ID */
    public Integer id;
    /** ロール名 */
    public String name;
    /** 作成日時 */
    public Date createdAt;
    /** 更新日時 */
    public Date updatedAt;
}
