package com.example.tokyorestauranttakeout.client.forms;

import com.example.tokyorestauranttakeout.client.validators.IsExistsEmail;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@Data
public class ClientAccountCreateForm {

    @NotEmpty(message = "入力してください")
    @IsExistsEmail
    public String email;

    @NotEmpty(message = "入力してください")
    public String password;

    @NotEmpty(message = "入力してください")
    public String passwordDigest;

    /**
     * パスワードダイジェスト比較チェック
     */
    @AssertTrue(message = "確認パスワードが誤っています")
    public boolean isValidPasswordDigest() {
        if (StringUtils.isEmpty(passwordDigest)) {
            return true;
        } else {
            return password.equals(passwordDigest);
        }
    }
}
