package com.example.tokyorestauranttakeout.client.services;

import com.example.tokyorestauranttakeout.client.forms.ClientAccountCreateForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountDeleteForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountUpdateForm;
import com.example.tokyorestauranttakeout.client.responses.ClientAccountShowResponse;
import com.example.tokyorestauranttakeout.client.services.impl.ClientAccountServiceImpl;
import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import com.example.tokyorestauranttakeout.util.PasswordUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Date;
import java.util.Optional;

/**
 * クライアントアカウントサービスクラスのテスト
 */
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

    /**
     * アカウントID
     */
    private Integer accountId;

    /**
     * メールアドレス
     */
    private String email;

    /**
     * パスワード
     */
    private String password;

    /**
     * 再入力パスワード
     */
    private String passwordDigest;

    /**
     * エンコード後パスワード
     */
    private String encodedPassword;

    /**
     * アカウント名
     */
    private String name;

    /**
     * 事前準備
     */
    @BeforeEach
    public void setUp() {
        this.accountId = 1;
        this.email = "test-mail";
        this.password = "test-password";
        this.passwordDigest = "test-passwordDigest";
        this.encodedPassword = "encoded-test-password";
        this.name = "test-name";

        passwordUtil = mock(PasswordUtil.class);
        clientAccountRepository = mock(ClientAccountRepository.class);
        service = new ClientAccountServiceImpl(clientAccountRepository, passwordUtil);
    }

    /**
     * クライアントアカウント詳細画面取得のテスト
     */
    @Test
    public void testGetShowResponse() {
        Integer accountId = 1;
        Date now = new Date();
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setEmail(email);
        clientAccount.setPassword(password);
        clientAccount.setCreatedAt(now);
        clientAccount.setUpdatedAt(now);
        // モック設定
        when(clientAccountRepository.selectById(accountId)).thenReturn(Optional.of(clientAccount));

        // クライアントアカウント詳細画面取得の実行
        ClientAccountShowResponse result = service.getShowResponse(accountId);

        // 結果の確認
        assertThat(clientAccount).isEqualTo(result.getClientAccount());

        // 呼び出し確認
        verify(clientAccountRepository,times(1))
                .selectById(accountId);
    }

    /**
     * クライアントアカウント詳細画面取得・クライアントアカウントが存在しないときのテスト
     */
    @Test
    public void testGetShowResponseButClientAccountIsNotExists() {
        // モック設定
        when(clientAccountRepository.selectById(accountId))
                .thenReturn(Optional.empty());

        // 結果の確認
        assertThatThrownBy(() -> {
            service.getShowResponse(accountId);})
                .isInstanceOf(RuntimeException.class);

        // 呼び出し確認
        verify(clientAccountRepository,times(1))
                .selectById(accountId);
    }

    /**
     * クライアントアカウント登録のテスト
     */
    @Test
    public void testCreate() {
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

    /**
     * クライアントアカウント更新のテスト
     */
    @Test
    public void testUpdate() {
        // モック設定
        when(passwordUtil.encode(password)).thenReturn(encodedPassword);
        Date now = new Date();
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setEmail(email);
        clientAccount.setPassword(password);
        clientAccount.setCreatedAt(now);
        clientAccount.setUpdatedAt(now);
        when(clientAccountRepository.selectById(accountId))
                .thenReturn(Optional.of(clientAccount));

        // テスト用リクエストフォーム
        ClientAccountUpdateForm updateForm = new ClientAccountUpdateForm();
        updateForm.id = accountId;
        updateForm.name = password;

        // 更新機能が正常に動作するか確認
        service.update(updateForm);

        // テスト用クライアントアカウントエンティティ
        ArgumentCaptor<ClientAccount> clientAccountCaptor =
                ArgumentCaptor.forClass(ClientAccount.class);

        // クライアントアカウントリポジトリー呼び出し確認、引数の値が正しいか
        verify(clientAccountRepository, times(1))
                .update(clientAccountCaptor.capture());
        assertThat(email).isEqualTo(clientAccountCaptor.getValue().getEmail());
        assertThat(encodedPassword).isEqualTo(clientAccountCaptor.getValue().getPassword());
    }

    /**
     * クライアントアカウント更新フォーム取得のテスト
     */
    @Test
    public void testGetUpdateFormResponse() {
        Date now = new Date();
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(accountId);
        clientAccount.setEmail(email);
        clientAccount.setName(name);
        clientAccount.setPassword(password);
        clientAccount.setCreatedAt(now);
        clientAccount.setUpdatedAt(now);
        // モック設定
        when(clientAccountRepository.selectById(accountId)).thenReturn(Optional.of(clientAccount));

        // クライアントアカウント更新フォーム取得の実行
        ClientAccountUpdateForm result = service.getUpdateFormResponse(accountId);

        // 結果の確認
        assertThat(accountId).isEqualTo(result.getId());
        assertThat(name).isEqualTo(result.getName());

        // 呼び出し確認
        verify(clientAccountRepository,times(1))
                .selectById(accountId);

    }

    /**
     * クライアントアカウント更新フォーム取得・クライアントアカウントが存在しないときのテスト
     */
    @Test
    public void testGetUpdateFormResponseButClientAccountIsNotExists() {
        // モック設定
        when(clientAccountRepository.selectById(accountId))
                .thenReturn(Optional.empty());

        // 結果の確認
        assertThatThrownBy(() -> {
            service.getUpdateFormResponse(accountId);})
                .isInstanceOf(RuntimeException.class);

        // 呼び出し確認
        verify(clientAccountRepository,times(1))
                .selectById(accountId);
    }

    /**
     * クライアントアカウント削除フォーム取得のテスト
     */
    @Test
    public void testGetDeleteFormResponse() {
        Date now = new Date();
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(accountId);
        clientAccount.setEmail(email);
        clientAccount.setName(name);
        clientAccount.setPassword(password);
        clientAccount.setCreatedAt(now);
        clientAccount.setUpdatedAt(now);
        // モック設定
        when(clientAccountRepository.selectById(accountId)).thenReturn(Optional.of(clientAccount));

        // クライアントアカウント詳細画面取得の実行
        ClientAccountDeleteForm result = service.getDeleteFormResponse(accountId);

        // 結果の確認
        assertThat(accountId).isEqualTo(result.getId());

        // 呼び出し確認
        verify(clientAccountRepository,times(1))
                .selectById(accountId);
    }

    /**
     * クライアントアカウント削除フォーム取得・クライアントアカウントが存在しないときのテスト
     */
    @Test
    public void testGetDeleteFormResponseButClientAccountIsNotExists() {
        // モック設定
        when(clientAccountRepository.selectById(accountId))
                .thenReturn(Optional.empty());

        // 結果の確認
        assertThatThrownBy(() -> {
            service.getDeleteFormResponse(accountId);})
                .isInstanceOf(RuntimeException.class);

        // 呼び出し確認
        verify(clientAccountRepository,times(1))
                .selectById(accountId);
    }

    /**
     * クライアントアカウント削除のテスト
     */
    @Test
    public void testDelete() {
        // 削除機能が正常に動作するかのテスト
        service.delete(accountId);

        // 呼び出し確認
        verify(clientAccountRepository,times(1))
                .delete(accountId);
    }
}
