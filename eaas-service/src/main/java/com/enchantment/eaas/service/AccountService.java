package com.enchantment.eaas.service;

import com.enchantment.eaas.dao.AccountDAO;
import com.enchantment.eaas.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liushuang on 2016/9/12.
 */
@Service
public class AccountService {
    @Autowired
    private AccountDAO dao;

    public Account getById(int id) {
        return dao.selectById(id);
    }
}
