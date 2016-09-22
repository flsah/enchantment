package com.enchantment.eaas.service;

import static com.enchantment.eaas.Constants.*;
import static java.util.stream.Collectors.toList;

import com.alibaba.druid.support.json.JSONUtils;
import com.enchantment.eaas.CacheUtil;
import com.enchantment.eaas.Utils;
import com.enchantment.eaas.dao.RoleDAO;
import com.enchantment.eaas.dao.UserDAO;
import com.enchantment.eaas.domain.Role;
import com.enchantment.eaas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    public boolean login(User user, HttpSession session) {
        User reUser = auth(user);

        if (reUser == null)
            return false;

        session.setAttribute(TOKEN_CUID, user.getId());

        cache.push(user.getId(), JSONUtils.toJSONString(reUser));

        List<Role> roles = roleDAO.getRolesByUser(user.getId());
        List<String> strR = new ArrayList<>(roles.size());
        roles.stream().map(role -> JSONUtils.toJSONString(role)).collect(toList());

        return true;
    }

    public boolean logout(HttpSession session) {
        Object cuid = session.getAttribute(TOKEN_CUID);
        if (cuid == null)
            return true;

//        cache

        return true;
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
