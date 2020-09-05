package com.example.tokyorestauranttakeout.admin.forms.question;

import lombok.Data;

@Data
public class AdminQuestionUpdateForm {
    public Integer id;
    private String title;
    private String text;
    private String senderMailAddress;
    private Boolean resolvedFlg;
}
