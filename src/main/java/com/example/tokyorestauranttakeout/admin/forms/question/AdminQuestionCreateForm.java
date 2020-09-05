package com.example.tokyorestauranttakeout.admin.forms.question;

import lombok.Data;


@Data
public class AdminQuestionCreateForm {
    private String title;
    private String text;
    private String senderMailAddress;
    private Boolean resolvedFlg;
}
