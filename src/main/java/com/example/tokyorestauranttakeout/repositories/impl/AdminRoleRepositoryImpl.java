package com.example.tokyorestauranttakeout.repositories.impl;

import com.example.tokyorestauranttakeout.entity.AdminRole;
import com.example.tokyorestauranttakeout.entity.AdminRoleExample;
import com.example.tokyorestauranttakeout.mapper.AdminRoleMapper;
import com.example.tokyorestauranttakeout.repositories.AdminRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRoleRepositoryImpl implements AdminRoleRepository {

    @Autowired
    AdminRoleMapper adminRoleMapper;

    @Override
    public Optional<AdminRole> get(Integer id) {
        return Optional.ofNullable(adminRoleMapper.selectByPrimaryKey(id));
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
