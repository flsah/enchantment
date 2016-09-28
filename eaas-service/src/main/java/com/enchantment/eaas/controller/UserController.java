package com.enchantment.eaas.controller;

import com.enchantment.eaas.domain.ResponseEntity;
import com.enchantment.eaas.domain.User;
import com.enchantment.eaas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.enchantment.eaas.Constants.RESPONSE_STATUS_FAL;
import static com.enchantment.eaas.Constants.RESPONSE_STATUS_SUC;

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
    public ResponseEntity getUser(@PathVariable("id") String id) {
        User reUser = service.getUser(id);
        ResponseEntity entity = new ResponseEntity();

        if (reUser != null) {
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reUser);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * User authentication
     *
     * @param user including login name and password of user
     * @return true if user is exists, otherwise false
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity auth(@RequestBody User user) {
        ResponseEntity entity = new ResponseEntity();
        User reUser = service.auth(user);

        if (reUser != null) {
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reUser.getId());
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * Add one user into db
     * <p>Request method is <code>PUT</code></p>
     *
     * @param user new user information
     * @param cuid current user id
     * @return true if add successfully, otherwise false
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity useradd(@RequestBody User user,
                                  @ModelAttribute String cuid) {
        ResponseEntity entity = new ResponseEntity();
        if (service.addUser(user, cuid)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
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
