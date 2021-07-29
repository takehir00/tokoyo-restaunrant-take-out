package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.entity.ClientAccountExample;
import com.example.tokyorestauranttakeout.mapper.ClientAccountMapper;
import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientAccountRepositoryImpl implements ClientAccountRepository {
    @Autowired
    private final ClientAccountMapper mapper;

    public ClientAccountRepositoryImpl(ClientAccountMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * メールアドレスで検索
     * @param email
     * @return
     */
    public Optional<ClientAccount> selectByEmail(String email) {
        ClientAccountExample example = new ClientAccountExample();
        ClientAccountExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);

        List<ClientAccount> clientAccountList = mapper.selectByExample(example);

        //メールアドレスは一意なので１件目を取得
        return Optional.ofNullable(clientAccountList.get(0));
    }

    /**
     * IDで取得
     * @param accountId ID
     * @return クライアントアカウント
     */
    public Optional<ClientAccount> selectById(Integer accountId) {
        return Optional.ofNullable(mapper.selectByPrimaryKey(accountId));
    }

    /**
     * 全権取得
     * @return クライアントアカウントリスト
     */
    public List<ClientAccount> selectAll() {
        ClientAccountExample example = new ClientAccountExample();
        return mapper.selectByExample(example);
    }

    /**
     * 登録
     * @param clientAccount クライアントアカウント
     */
    public void create(ClientAccount clientAccount) {
        mapper.insert(clientAccount);
    }

    /**
     * 更新
     * @param clientAccount
     */
    public void update(ClientAccount clientAccount) {
        mapper.updateByPrimaryKey(clientAccount);
    }

    /**
     * 削除
     * @param id
     */
    public void delete(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
}
