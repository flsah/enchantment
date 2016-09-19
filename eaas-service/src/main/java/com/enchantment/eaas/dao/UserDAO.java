package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class UserDAO {
    @Autowired
    private SqlSession session;

    public User get(User user) {
        return null;
    }

    public List<User> getList(User user) {
        return null;
    }

    public boolean add(User user) {
        return false;
    }

    public boolean update(User user) {
        return false;
    }

    public boolean remove(User user) {
        return false;
    }
}
