package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.Role;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DAO for role table
 *
 * Created by genbatis on 2016-10-10 15:52:49.
 */
@Component
public class RoleDAO {
    private SqlSession session;

    @Autowired
    public RoleDAO(SqlSession session) {
        this.session = session;
    }

    public Role get(String id) {
        return session.selectOne("getRoleById", id);
    }

    public Role getRole(Role role) {
        List<Role> roles = session.selectList("getRoles", role);

        if (roles.isEmpty())
            return null;

        return roles.get(0);
    }

    public List<Role> getList(Role role) {
        return session.selectList("getRoles", role);
    }

    public boolean add(Role role) {
        return session.insert("addRole", role) > 0;
    }

    public boolean update(Role role) {
        return session.update("modRole", role) > 0;
    }

    public boolean remove(String id) {
        return session.delete("delRole", id) > 0;
    }

    public boolean remove(List<String> ids) {
        return session.delete("delRoles", ids) > 0;
    }
}