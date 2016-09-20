package com.enchantment.eaas.service;

import com.enchantment.eaas.dao.UserDAO;
import com.enchantment.eaas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Service
public class UserService {
    private UserDAO dao;

    @Autowired
    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    public boolean login(User user) {
        return dao.get(user) != null;
    }

    public User getUser(String id) {
        User user = new User();
        user.setId(id);
        return dao.get(user);
    }

    public List<User> getUsers(User user) {
        return dao.getList(user);
    }

    public boolean addUser(User user) {
        return dao.add(user);
    }

    public boolean updateUser(User user) {
        return dao.update(user);
    }

    public boolean removeUser(String id) {
        User user = new User();
        user.setId(id);
        return dao.remove(user);
    }
}
