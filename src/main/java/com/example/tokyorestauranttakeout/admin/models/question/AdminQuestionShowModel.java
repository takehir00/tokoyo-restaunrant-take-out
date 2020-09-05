package com.example.tokyorestauranttakeout.admin.models.question;

import lombok.Data;

import java.util.Date;

@Data
public class AdminQuestionShowModel {
    public Integer id;
    private String title;
    private String text;
    private String senderMailAddress;
    private Boolean resolvedFlg;
    public Date createdAt;
    public Date updatedAt;
}
