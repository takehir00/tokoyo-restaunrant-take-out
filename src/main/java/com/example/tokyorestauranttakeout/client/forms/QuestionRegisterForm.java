package com.example.tokyorestauranttakeout.client.forms;

import lombok.Data;

@Data
public class QuestionRegisterForm {
    private String title;
    private String text;
    private String senderMailAddress;
}
