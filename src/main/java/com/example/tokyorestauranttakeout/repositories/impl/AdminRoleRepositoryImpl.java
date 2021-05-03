package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.AdminRole;
import com.example.tokyorestauranttakeout.entity.AdminRoleExample;
import com.example.tokyorestauranttakeout.mapper.AdminRoleMapper;
import com.example.tokyorestauranttakeout.repositories.AdminRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRoleRepositoryImpl implements AdminRoleRepository {

    private final AdminRoleMapper adminRoleMapper;

    /**
     * 依存関係を指定して生成
     * @param adminRoleMapper 管理画面ロールマッパー
     */
    public AdminRoleRepositoryImpl(AdminRoleMapper adminRoleMapper) {
        this.adminRoleMapper = adminRoleMapper;
    }

    @Override
    public void create(AdminRole adminRole) {
        adminRoleMapper.insert(adminRole);
    }

    @Override
    public List<AdminRole> selectAll() {
        AdminRoleExample example = new AdminRoleExample();
        return adminRoleMapper.selectByExample(example);
    }

    @Override
    public void delete(Integer id) {
        adminRoleMapper.deleteByPrimaryKey(id);
    }
}
