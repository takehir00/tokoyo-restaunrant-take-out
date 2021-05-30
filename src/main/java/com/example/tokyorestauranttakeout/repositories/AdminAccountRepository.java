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

public interface AdminAccountRepository {

    /**
     * アカウント名で検索
     * @param name
     * @return
     */
    Optional<AdminAccount> selectByName(String name);

    /**
     * 登録
     * @param account
     */
    void create(AdminAccount account);

    /**
     * 全件取得
     * @return
     */
    List<AdminAccount> selectAll();

    /**
     * IDで取得
     * @param accountId
     * @return
     */
    AdminAccount selectById(Integer accountId);

    /**
     * 更新
     * @param account
     */
    void update(AdminAccount account);

    /**
     * 削除
     * @param id
     */
    void delete(Integer id);
}
