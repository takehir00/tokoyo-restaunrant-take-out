package com.example.tokyorestauranttakeout.repositories;

import com.example.tokyorestauranttakeout.entity.AdminRole;

import java.util.List;
import java.util.Optional;

/**
 * 管理画面ロールリポジトリインターフェース
 */
public interface AdminRoleRepository {

    /**
     * 取得
     * @param id ID
     * @return 管理画面ロール
     */
    Optional<AdminRole> get(Integer id);

    /**
     * 登録
     * @param adminRole 管理画面ロール
     */
    void create(AdminRole adminRole);

    /**
     * 一覧取得
     * @return 管理画面ロール一覧リスト
     */
    List<AdminRole> selectAll();

    /**
     * 削除
     * @param id 管理画面ロールID
     */
    void delete(Integer id);
}
