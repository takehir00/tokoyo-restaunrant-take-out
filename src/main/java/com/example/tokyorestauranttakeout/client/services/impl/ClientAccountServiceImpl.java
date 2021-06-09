package com.example.tokyorestauranttakeout.client.services.impl;

import com.example.tokyorestauranttakeout.client.forms.ClientAccountCreateForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountDeleteForm;
import com.example.tokyorestauranttakeout.client.forms.ClientAccountUpdateForm;
import com.example.tokyorestauranttakeout.client.responses.ClientAccountShowResponse;
import com.example.tokyorestauranttakeout.client.services.ClientAccountService;
import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import com.example.tokyorestauranttakeout.util.DateTimeUtil;
import com.example.tokyorestauranttakeout.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    private final ClientAccountRepository clientAccountRepository;

    private final PasswordUtil passwordUtil;

    public ClientAccountServiceImpl(ClientAccountRepository clientAccountRepository, PasswordUtil passwordUtil) {
        this.clientAccountRepository = clientAccountRepository;
        this.passwordUtil = passwordUtil;
    }

    @Override
    public ClientAccountShowResponse getShowResponse(Integer accountId) {
        ClientAccountShowResponse response = new ClientAccountShowResponse();
        response.clientAccount = clientAccountRepository.selectById(accountId)
                // TODO 独自例外作ってハンドリングして
                // TODO アカウントが利用できません、ログインし直すかアカウントを登録し直してください画面を表示する。
                .orElseThrow(RuntimeException::new);
        return response;
    }

    @Override
    public void create(ClientAccountCreateForm registerForm) {
        LocalDateTime now = DateTimeUtil.now();
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setEmail(registerForm.getEmail());
        clientAccount.setPassword(passwordUtil.encode(registerForm.getPassword()));
        clientAccount.setCreatedAt(now);
        clientAccount.setUpdatedAt(now);
        clientAccountRepository.create(clientAccount);
    }

    @Override
    public void update(ClientAccountUpdateForm updateForm) {
        ClientAccount clientAccount = clientAccountRepository.selectById(updateForm.id)
                // TODO 独自例外作ってハンドリングして
                // TODO アカウントが利用できません、ログインし直すかアカウントを登録し直してください画面を表示する。
                .orElseThrow(RuntimeException::new);
        clientAccount.setName(updateForm.name);
        clientAccount.setUpdatedAt(DateTimeUtil.now());
        clientAccountRepository.update(clientAccount);
    }

    @Override
    public ClientAccountUpdateForm getUpdateFormResponse(Integer accountId) {

        ClientAccount clientAccount = clientAccountRepository.selectById(accountId)
                // TODO 独自例外作ってハンドリングして
                // TODO アカウントが利用できません、ログインし直すかアカウントを登録し直してください画面を表示する。
                .orElseThrow(RuntimeException::new);
        ClientAccountUpdateForm updateForm = new ClientAccountUpdateForm();
        updateForm.id = clientAccount.getId();
        updateForm.name = clientAccount.getName();
        return updateForm;
    }

    @Override
    public ClientAccountDeleteForm getDeleteFormResponse(Integer accountId) {
        ClientAccount clientAccount = clientAccountRepository.selectById(accountId)
                // TODO 独自例外作ってハンドリングして
                // TODO アカウントが利用できません、ログインし直すかアカウントを登録し直してください画面を表示する。
                .orElseThrow(RuntimeException::new);
        ClientAccountDeleteForm deleteForm = new ClientAccountDeleteForm();
        deleteForm.id = clientAccount.getId();
        return deleteForm;
    }

    @Override
    public void delete(Integer accountId) {
        clientAccountRepository.delete(accountId);
    }
}
