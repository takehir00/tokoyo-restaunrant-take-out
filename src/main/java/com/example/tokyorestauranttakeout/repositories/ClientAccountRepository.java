package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.entity.ClientAccountExample;
import com.example.tokyorestauranttakeout.mapper.ClientAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientAccountRepository {

    @Autowired
    private final ClientAccountMapper mapper;

    public ClientAccountRepository(ClientAccountMapper mapper) {
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

        if (clientAccountList.isEmpty()) {
            return Optional.empty();
        }
        //メールアドレスは一意なので１件目を取得
        return Optional.of(clientAccountList.get(0));
    }

    /**
     * IDで取得
     * @param accountId ID
     * @return クライアントアカウント
     */
    public ClientAccount selectById(Integer accountId) {
        return mapper.selectByPrimaryKey(accountId);
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
