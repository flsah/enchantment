package com.enchantment.eaas.controller;

import com.enchantment.eaas.domain.User;
import com.enchantment.eaas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liushuang on 2016/9/19.
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/{id}",
            method = {RequestMethod.POST, RequestMethod.GET})
    public User getUser(@PathVariable("id") String id) {
        return service.getUser(id);
    }

    /**
     * User authentication
     *
     * @param user including login name and password of user
     * @return true if user is exists, otherwise false
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public boolean auth(User user) {
        return service.login(user);
    }
}
