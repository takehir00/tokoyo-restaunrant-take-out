package com.example.tokyorestauranttakeout.admin.responses.question;

import lombok.Data;

import java.util.List;

@Data
public class AdminQuestionIndexResponse {
    /** 問い合わせモデルリスト */
    public List<AdminQuestionIndexModel> questionIndexModelList;
}
