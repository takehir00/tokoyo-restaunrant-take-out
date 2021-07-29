package com.example.tokyorestauranttakeout.fixtures;


import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.mapper.ClientAccountMapper;
import com.example.tokyorestauranttakeout.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

/**
 * クライアントアカウントテストデータ
 */
public final class ClientAccountFixture {


    /**
     * クライアントアカウントマッパー
     */
    private ClientAccountMapper clientAccountMapper;

    /**
     * クライアントアカウント1
     */
    private final ClientAccount clientAccount1;

    /**
     * クライアントアカウント2
     */
    private final ClientAccount clientAccount2;

    /**
     * クライアントアカウント3
     */
    private final ClientAccount clientAccount3;

    public ClientAccountFixture(ClientAccountMapper clientAccountMapper) {
        this.clientAccountMapper = clientAccountMapper;

        LocalDateTime now = DateTimeUtil.now();
        this.clientAccount1 = new ClientAccount();
        clientAccount1.setId(1001);
        clientAccount1.setEmail("test-mail1");
        clientAccount1.setPassword("test-password1");
        clientAccount1.setName("test-name1");
        clientAccount1.setImageUrl("test-image-url1");
        clientAccount1.setCreatedAt(now);
        clientAccount1.setUpdatedAt(now);

        this.clientAccount2 = new ClientAccount();
        clientAccount2.setId(1002);
        clientAccount2.setEmail("test-mail2");
        clientAccount2.setPassword("test-password2");
        clientAccount2.setName("test-name2");
        clientAccount2.setImageUrl("test-image-url2");
        clientAccount2.setCreatedAt(now);
        clientAccount2.setUpdatedAt(now);

        this.clientAccount3 = new ClientAccount();
        clientAccount3.setId(1003);
        clientAccount3.setEmail("test-mail3");
        clientAccount3.setPassword("test-password3");
        clientAccount3.setName("test-name3");
        clientAccount3.setImageUrl("test-image-url3");
        clientAccount3.setCreatedAt(now);
        clientAccount3.setUpdatedAt(now);
    }

    /**
     * テスト用データを登録
     */
    public void insert() {
        clientAccountMapper.insert(clientAccount1);
        clientAccountMapper.insert(clientAccount2);
        clientAccountMapper.insert(clientAccount3);
    }

    /**
     * @return クライアントアカウント1
     */
    public ClientAccount getClientAccount1() {
        return clientAccount1;
    }

    /**
     * @return クライアントアカウント2
     */
    public ClientAccount getClientAccount2() {
        return clientAccount2;
    }

    /**
     * @return クライアントアカウント3
     */
    public ClientAccount getClientAccount3() {
        return clientAccount3;
    }
}
