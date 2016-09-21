package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DAO for user entity
 *
 * Created by liushuang on 2016/9/19.
 */
@Component
public class UserDAO {
    private SqlSession session;

    @Autowired
    public UserDAO(SqlSession session) {
        this.session = session;
    }

    public User get(String id) {
        return session.selectOne("getUserById", id);
    }

    public User getUser(User user) {
        List<User> users = session.selectList("getUsers", user);

        if (users.isEmpty())
            return null;

        return users.get(0);
    }

    public List<User> getList(User user) {
        return session.selectList("getUsers", user);
    }

    public boolean add(User user) {
        return session.insert("addUser", user) > 0;
    }

    public boolean update(User user) {
        return session.update("modUser", user) > 0;
    }

    public boolean remove(String id) {
        return session.delete("delUser", id) > 0;
    }

    public boolean remove(List<String> ids) {
        return session.delete("delUsers", ids) > 0;
    }
}
