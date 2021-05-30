package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.forms.ClientAccountCreateForm;
import com.example.tokyorestauranttakeout.client.services.impl.ClientAccountServiceImpl;
import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import com.example.tokyorestauranttakeout.util.PasswordUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ClientAccountServiceImplTest {

    /**
     * クライアントアカウントリポジトリー
     */
    private ClientAccountRepository clientAccountRepository;

    /**
     * パスワード関連ユーティリティー
     */
    private PasswordUtil passwordUtil;

    /**
     * テスト対象のサービスクラス
     */
    private ClientAccountServiceImpl service;

    @BeforeEach
    public void setUp() {
        passwordUtil = mock(PasswordUtil.class);
        clientAccountRepository = mock(ClientAccountRepository.class);
        service = new ClientAccountServiceImpl(clientAccountRepository, passwordUtil);
    }

    /**
     * クライアントアカウント登録のテスト
     */
    @Test
    public void testCreate() {
        String email = "test-mail";
        String password = "test-password";
        String passwordDigest = "test-passwordDigest";
        String encodedPassword = "encoded-test-password";

        // モック設定
        when(passwordUtil.encode(password)).thenReturn(encodedPassword);

        // テスト用リクエストフォーム
        ClientAccountCreateForm registerForm = new ClientAccountCreateForm();
        registerForm.email = email;
        registerForm.password = password;
        registerForm.passwordDigest = passwordDigest;

        // 登録機能が正常に動作するか確認
        service.create(registerForm);

        // テスト用クライアントアカウントエンティティ
        ArgumentCaptor<ClientAccount> clientAccountCaptor =
                ArgumentCaptor.forClass(ClientAccount.class);

        // パスワード関連ユーティリティー呼び出し確認
        verify(passwordUtil, times(1))
                .encode(password);

        // クライアントアカウントリポジトリー呼び出し確認、引数の値が正しいか
        verify(clientAccountRepository, times(1))
                .create(clientAccountCaptor.capture());
        assertThat(email).isEqualTo(clientAccountCaptor.getValue().getEmail());
        assertThat(encodedPassword).isEqualTo(clientAccountCaptor.getValue().getPassword());
    }
}
