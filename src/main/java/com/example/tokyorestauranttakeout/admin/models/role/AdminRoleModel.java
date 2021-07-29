package com.example.tokyorestauranttakeout.admin.models.role;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AdminRoleModel {
    /** ID */
    public Integer id;
    /** ロール名 */
    public String name;
    /** 作成日時 */
    public LocalDateTime createdAt;
    /** 更新日時 */
    public LocalDateTime updatedAt;
}
