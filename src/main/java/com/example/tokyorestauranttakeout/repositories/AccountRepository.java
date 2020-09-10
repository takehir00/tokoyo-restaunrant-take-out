package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.Account;
import com.example.tokyorestauranttakeout.entity.AccountExample;
import com.example.tokyorestauranttakeout.entity.AccountExample.Criteria;
import com.example.tokyorestauranttakeout.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public Account selectByName(String name) {
        AccountExample example = new AccountExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);

        List<Account> accountList = accountMapper.selectByExample(example);
        //アカウント名は一意なので１件目を取得
        return accountList.get(0);
    }
}
