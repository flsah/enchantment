package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.Role;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class RoleDAO {
    private SqlSession session;

    @Autowired
    public RoleDAO(SqlSession session) {
        this.session = session;
    }

    public Role get(Role role) {
        return null;
    }

    public List<Role> getList(Role role) {
        return null;
    }

    public List<Role> getRolesByUser(String userId) {
        return null;
    }

    public boolean add(Role role) {
        return false;
    }

    public boolean update(Role role) {
        return false;
    }

    public boolean remove(Role role) {
        return false;
    }
}
