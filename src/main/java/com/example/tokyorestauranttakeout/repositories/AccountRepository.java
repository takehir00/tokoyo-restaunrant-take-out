package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Account;
import com.example.tokyorestauranttakeout.entity.AccountExample;
import com.example.tokyorestauranttakeout.entity.AccountExample.Criteria;
import com.example.tokyorestauranttakeout.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountRepository {

    @Autowired
    private final AccountMapper accountMapper;

    public AccountRepository(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    /**
     * アカウント名で検索
     * @param name
     * @return
     */
    public Optional<Account> selectByName(String name) {
        AccountExample example = new AccountExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);

        List<Account> accountList = accountMapper.selectByExample(example);

        if (accountList.isEmpty()) {
            return Optional.empty();
        }
        //アカウント名は一意なので１件目を取得
        return Optional.of(accountList.get(0));
    }

    /**
     * 登録
     * @param account
     */
    public void create(Account account) {
        accountMapper.insert(account);
    }

    /**
     * 全件取得
     * @return
     */
    public List<Account> selectAll() {
        AccountExample example = new AccountExample();
        return accountMapper.selectByExample(example);
    }

    /**
     * IDで取得
     * @param accountId
     * @return
     */
    public Account selectById(Integer accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    /**
     * 更新
     * @param account
     */
    public void update(Account account) {
        accountMapper.updateByPrimaryKey(account);
    }

    /**
     * 削除
     * @param id
     */
    public void delete(Integer id) {
       accountMapper.deleteByPrimaryKey(id);
    }
}
