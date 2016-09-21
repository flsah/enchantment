package com.enchantment.eaas.controller;

import com.enchantment.eaas.domain.User;
import com.enchantment.eaas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The controller which to handle the request about user entity.<br/>
 *
 * Created by liushuang on 2016/9/19.
 */
@RestController
@RequestMapping(value = "/v1/user", produces = "application/json")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Select one user information by user id
     *
     * @param id user identity
     * @return user information
     */
    @RequestMapping(value = "/get/{id}",
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
    public boolean auth(@RequestBody User user) {
        return service.login(user);
    }

    /**
     * Add one user into db
     * <p>Request method is <code>PUT</code></p>
     *
     * @param user new user information
     * @return true if add successfully, otherwise false
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public boolean useradd(User user) {
        return service.addUser(user);
    }

    /**
     * Delete one user from db
     * <p>Request method is <code>DELETE</code></p>
     *
     * @param id user identity to be deleted
     * @return true if delete successfully, otherwise false
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public boolean userdel(@PathVariable("id") String id) {
        return service.removeUser(id);
    }

    /**
     * Update one user information
     * <p>Request method is <code>PUT</code></p>
     *
     * @param user new user information for changing
     * @return true if modify successfully, otherwise false
     */
    @RequestMapping(value = "/mod", method = RequestMethod.PUT)
    public boolean usermod(User user) {
        return service.updateUser(user);
    }
}
