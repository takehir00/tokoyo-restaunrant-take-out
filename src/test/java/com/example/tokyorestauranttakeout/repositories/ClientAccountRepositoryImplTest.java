package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.fixtures.ClientAccountFixture;
import com.example.tokyorestauranttakeout.mapper.ClientAccountMapper;
import com.example.tokyorestauranttakeout.repositories.impl.ClientAccountRepositoryImpl;
import com.example.tokyorestauranttakeout.util.DateTimeUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.assertj.core.api.Assertions.assertThat;



/**
 * クライアントアカウントリポジトリクラスのテスト
 * MybatisTestアノテーションでテストにおいてmapper beanをdiできる
 */
@MybatisTest
@AutoConfigureTestDatabase(replace = NONE)
public class ClientAccountRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * クライアントアカウントマッパー
     */
    @Autowired
    private ClientAccountMapper clientAccountMapper;

    /**
     * テスト対象のリポジトリ
     */
    private ClientAccountRepository repository;

    /**
     * クライアントアカウントテストデータ
     */
    private ClientAccountFixture clientAccountFixture;

    /**
     * メールアドレス
     */
    private String email;

    /**
     * パスワード
     */
    private String password;


    /**
     * アカウント名
     */
    private String name;

    /**
     * 画像URL
     */
    private String imageUrl;

    /**
     * 事前準備
     */
    @BeforeEach
    public void setUp() {
        this.email = "test-new-mail";
        this.password = "test-new-password";
        this.name = "test-new-name";
        this.imageUrl = "test-new-image-url";

        this.repository = new ClientAccountRepositoryImpl(clientAccountMapper);

        //事前データ投入
        this.clientAccountFixture = new ClientAccountFixture(clientAccountMapper);
        clientAccountFixture.insert();
    }

    /**
     * 事後処理
     */
    @AfterEach
    public void tearDown() {

    }

    /**
     * 登録のテスト
     */
    @Test
    public void testCreate() {
        LocalDateTime now = DateTimeUtil.now();
        int id = 100000;
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(id);
        clientAccount.setEmail(email);
        clientAccount.setPassword(password);
        clientAccount.setName(name);
        clientAccount.setImageUrl(imageUrl);
        clientAccount.setCreatedAt(now);
        clientAccount.setUpdatedAt(now);

        repository.create(clientAccount);

        ClientAccount result = jdbcTemplate.
                queryForObject("select * from client_account where id = " + id, (resultSet, rowNum) -> {
                    ClientAccount resultClientAccount = new ClientAccount();
                    resultClientAccount.setId(resultSet.getInt("id"));
                    resultClientAccount.setName(resultSet.getString("name"));
                    resultClientAccount.setEmail(resultSet.getString("email"));
                    resultClientAccount.setPassword(resultSet.getString("password"));
                    resultClientAccount.setImageUrl(resultSet.getString("image_url"));
                    resultClientAccount.setCreatedAt(DateTimeUtil.toLocalDatetime(
                            resultSet.getDate("created_at"),
                            resultSet.getTime("created_at")));
                    resultClientAccount.setUpdatedAt(DateTimeUtil.toLocalDatetime(
                            resultSet.getDate("updated_at"),
                            resultSet.getTime("updated_at")));
                    return resultClientAccount;
                });
        // 結果の確認
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getEmail()).isEqualTo(email);
        assertThat(result.getPassword()).isEqualTo(password);
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getImageUrl()).isEqualTo(imageUrl);
        assertThat(result.getCreatedAt()).isEqualTo(now);
        assertThat(result.getUpdatedAt()).isEqualTo(now);
    }
}
