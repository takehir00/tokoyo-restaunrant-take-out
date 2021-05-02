package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.AdminAccount;
import com.example.tokyorestauranttakeout.entity.AdminAccount;
import com.example.tokyorestauranttakeout.entity.AdminAccountExample;
import com.example.tokyorestauranttakeout.entity.AdminAccountExample.Criteria;
import com.example.tokyorestauranttakeout.mapper.AdminAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdminAccountRepository {

    @Autowired
    private final AdminAccountMapper accountMapper;

    public AdminAccountRepository(AdminAccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    /**
     * アカウント名で検索
     * @param name
     * @return
     */
    public Optional<AdminAccount> selectByName(String name) {
        AdminAccountExample example = new AdminAccountExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);

        List<AdminAccount> accountList = accountMapper.selectByExample(example);

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
    public void create(AdminAccount account) {
        accountMapper.insert(account);
    }

    /**
     * 全件取得
     * @return
     */
    public List<AdminAccount> selectAll() {
        AdminAccountExample example = new AdminAccountExample();
        return accountMapper.selectByExample(example);
    }

    /**
     * IDで取得
     * @param accountId
     * @return
     */
    public AdminAccount selectById(Integer accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    /**
     * 更新
     * @param account
     */
    public void update(AdminAccount account) {
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
