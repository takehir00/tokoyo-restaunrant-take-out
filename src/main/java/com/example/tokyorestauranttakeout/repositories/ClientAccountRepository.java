package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.entity.ClientAccountExample;
import com.example.tokyorestauranttakeout.mapper.ClientAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ClientAccountRepository {

    /**
     * メールアドレスで検索
     * @param email
     * @return
     */
    Optional<ClientAccount> selectByEmail(String email);

    /**
     * IDで取得
     * @param accountId ID
     * @return クライアントアカウント
     */
    Optional<ClientAccount> selectById(Integer accountId);

    /**
     * 全権取得
     * @return クライアントアカウントリスト
     */
    List<ClientAccount> selectAll();

    /**
     * 登録
     * @param clientAccount クライアントアカウント
     */
    void create(ClientAccount clientAccount);

    /**
     * 更新
     * @param clientAccount
     */
    void update(ClientAccount clientAccount);

    /**
     * 削除
     * @param id
     */
    void delete(Integer id);

}
