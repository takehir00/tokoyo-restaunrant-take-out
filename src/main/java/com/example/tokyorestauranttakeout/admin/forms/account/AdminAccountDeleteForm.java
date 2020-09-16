package com.example.tokyorestauranttakeout.admin.forms.account;

import lombok.Data;

import java.util.Date;

@Data
public class AdminAccountDeleteForm {
    /** ID */
    public Integer id;
    /** アカウント名 */
    public String name;
    /** 作成日時 */
    public Date createdAt;
    /** 更新日時 */
    public Date updatedAt;
}
