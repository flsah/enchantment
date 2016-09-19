package com.enchantment.eaas.controller;

import com.enchantment.eaas.domain.Account;
import com.enchantment.eaas.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liushuang on 2016/9/12.
 */
@RestController
@RequestMapping(value = "/account", produces = "application/json")
public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping(value = "/{id}",
            method = {RequestMethod.POST, RequestMethod.GET})
    public Account getOne(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/login",
            method = {RequestMethod.POST, RequestMethod.GET})
    public Account check(Account account) {
        return service.getById(account.getId());
    }
}
