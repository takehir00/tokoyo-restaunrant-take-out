package com.example.tokyorestauranttakeout.admin.forms.question;

import lombok.Data;

import java.util.Date;

@Data
public class AdminQuestionDeleteForm {
    private Integer id;
    private String title;
    private String text;
    private String senderMailAddress;
    private Boolean resolvedFlg;
    private Date createdAt;
    private Date updatedAt;
}
