package com.example.tokyorestauranttakeout.admin.responses.question;

import lombok.Data;

import java.util.Date;

@Data
public class AdminQuestionIndexModel {
    /** ID */
    public Integer id;
    /** 問い合わせ件名 */
    private String title;
    /** 解決済みフラグ */
    private Boolean resolvedFlg;
    /** 作成日時 */
    public Date createdAt;
    /** 更新日時 */
    public Date updatedAt;
}
