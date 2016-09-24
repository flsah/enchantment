package com.enchantment.eaas.service;

import com.enchantment.eaas.CacheUtil;
import com.enchantment.eaas.Utils;
import com.enchantment.eaas.dao.RoleDAO;
import com.enchantment.eaas.dao.UserDAO;
import com.enchantment.eaas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import static com.enchantment.eaas.Constants.OPER_N;
import static com.enchantment.eaas.Constants.STAT_INIT;

/**
 * <p>User operation service</p>
 *
 * Created by liushuang on 2016/9/19.
 */
@Service
public class UserService {
    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private CacheUtil cache;

    @Autowired
    public UserService(UserDAO userDAO, RoleDAO roleDAO,
                       CacheUtil cache) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.cache = cache;
    }

    public User auth(User user) {
        return userDAO.getUser(user);
    }

    public User getUser(String id) {
        return userDAO.get(id);
    }

    public List<User> getUsers(User user) {
        return userDAO.getList(user);
    }

    public boolean addUser(User user, final String cuid) {
        user.setId(Utils.buildHashCode(user));
        user.setStatus(STAT_INIT);
        user.setMdate(new Timestamp(System.currentTimeMillis()));
        user.setMid(cuid);
        user.setOtype(OPER_N);
        return userDAO.add(user);
    }

    public boolean updateUser(User user) {
        return userDAO.update(user);
    }

    public boolean removeUser(String id) {
        return userDAO.remove(id);
    }

    public boolean removeUsers(List<String> ids) {
        return userDAO.remove(ids);
    }
}
