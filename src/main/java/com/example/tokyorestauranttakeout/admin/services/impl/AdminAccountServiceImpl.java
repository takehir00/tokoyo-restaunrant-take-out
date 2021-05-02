package com.example.tokyorestauranttakeout.admin.services.impl;

import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountCreateForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountDeleteForm;
import com.example.tokyorestauranttakeout.admin.forms.account.AdminAccountUpdateForm;
import com.example.tokyorestauranttakeout.admin.models.account.AdminAccountIndexModel;
import com.example.tokyorestauranttakeout.admin.responses.account.AdminAccountDeleteFormResponse;
import com.example.tokyorestauranttakeout.admin.responses.account.AdminAccountIndexResponse;
import com.example.tokyorestauranttakeout.admin.responses.account.AdminAccountUpdateFormResponse;
import com.example.tokyorestauranttakeout.admin.services.AdminAccountService;
import com.example.tokyorestauranttakeout.entity.Account;
import com.example.tokyorestauranttakeout.repositories.AccountRepository;
import com.example.tokyorestauranttakeout.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminAccountServiceImpl implements AdminAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AdminAccountIndexResponse getIndexResponse() {
        AdminAccountIndexResponse response = new AdminAccountIndexResponse();
        List<Account> accountList = accountRepository.selectAll();
        response.accountIndexModelList =
                accountList.stream()
                        .map(account -> {
                            AdminAccountIndexModel adminAccountIndexModel = new AdminAccountIndexModel();
                            BeanUtils.copyProperties(account, adminAccountIndexModel);
                            return adminAccountIndexModel;
                        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public Object getShowResponse(Integer questionId) {
        return null;
    }

    @Override
    public void create(AdminAccountCreateForm registerForm) {
        Date now = DateUtil.now();
        Account account = new Account();
        account.setName(registerForm.getName());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPassword(encoder.encode(registerForm.getPassword()));
        account.setCreatedAt(now);
        account.setUpdatedAt(now);
        accountRepository.create(account);
    }

    @Override
    public AdminAccountUpdateFormResponse getUpdateFormResponse(Integer accountId) {
        AdminAccountUpdateFormResponse response = new AdminAccountUpdateFormResponse();
        Account account = accountRepository.selectById(accountId);
        AdminAccountUpdateForm updateForm = new AdminAccountUpdateForm();
        BeanUtils.copyProperties(account, updateForm);
        response.updateForm = updateForm;
        return response;
    }

    @Override
    public void update(AdminAccountUpdateForm updateForm) {
        Account account = accountRepository.selectById(updateForm.getId());
        if (account != null) {
            account.setName(updateForm.getName());
            account.setUpdatedAt(DateUtil.now());
            accountRepository.update(account);
        }
    }

    @Override
    public AdminAccountDeleteFormResponse getDeleteFormResponse(Integer accountId) {
        AdminAccountDeleteFormResponse response = new AdminAccountDeleteFormResponse();
        Account account = accountRepository.selectById(accountId);
        AdminAccountDeleteForm deleteForm = new AdminAccountDeleteForm();
        BeanUtils.copyProperties(account, deleteForm);
        response.deleteForm = deleteForm;
        return response;
    }

    @Override
    public void delete(AdminAccountDeleteForm deleteForm) {
        accountRepository.delete(deleteForm.getId());
    }
}
