package com.example.tokyorestauranttakeout.client.forms;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class QuestionRegisterForm {
    @NotEmpty(message = "入力してください")
    @Size(max = 100, message = "100文字以下で入力してください")
    private String title;

    @NotEmpty(message = "入力してください")
    @Size(max = 10000, message = "10000文字以下で入力してください")
    private String text;

    @NotEmpty(message = "入力してください")
    @Email(message = "メールアドレスの形式で入力してください")
    private String senderMailAddress;
}
