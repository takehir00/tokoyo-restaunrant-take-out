package com.example.tokyorestauranttakeout.client.services.impl;

import com.example.tokyorestauranttakeout.client.forms.ClientAccountCreateForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountDeleteForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountUpdateForm;
import com.example.tokyorestauranttakeout.client.responses.ClientAccountShowResponse;
import com.example.tokyorestauranttakeout.client.services.ClientAccountService;
import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import com.example.tokyorestauranttakeout.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    ClientAccountRepository clientAccountRepository;

    @Override
    public ClientAccountShowResponse getShowResponse(Integer accountId) {
        ClientAccountShowResponse response = new ClientAccountShowResponse();
        response.clientAccount = clientAccountRepository.selectById(accountId);
        return response;
    }

    @Override
    public void create(ClientAccountCreateForm registerForm) {
        Date now = new Date();
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setEmail(registerForm.getEmail());
        clientAccount.setPassword(PasswordUtil.encode(registerForm.getPassword()));
        clientAccount.setCreatedAt(now);
        clientAccount.setUpdatedAt(now);
        clientAccountRepository.create(clientAccount);
    }

    @Override
    public void update(ClientAccountUpdateForm updateForm) {

    }

    @Override
    public ClientAccountUpdateForm getUpdateFormResponse(Integer accountId) {
        return null;
    }

    @Override
    public ClientAccountDeleteForm getDeleteFormResponse(Integer accountId) {
        return null;
    }

    @Override
    public void delete(ClientAccountDeleteForm deleteForm) {

    }
}
