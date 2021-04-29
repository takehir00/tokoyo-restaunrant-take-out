package com.example.tokyorestauranttakeout.client.forms;

import com.example.tokyorestauranttakeout.client.validators.IsExistsEmail;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@Data
public class ClientAccountCreateForm {

    @NotEmpty(message = "{validate.common.notEmpty}")
    @IsExistsEmail
    public String email;

    @NotEmpty(message = "{validate.common.notEmpty}")
    public String password;

    @NotEmpty(message = "{validate.common.notEmpty}")
    public String passwordDigest;

    /**
     * パスワードダイジェスト比較チェック
     */
    @AssertTrue(message = "{validate.account.isValidPasswordDigest}")
    public boolean isValidPasswordDigest() {
        if (StringUtils.isEmpty(passwordDigest)) {
            return true;
        } else {
            return password.equals(passwordDigest);
        }
    }
}
