package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.UserRoleRel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class UserRoleDAO {
    private SqlSession session;

    @Autowired
    public UserRoleDAO(SqlSession session) {
        this.session = session;
    }

    public UserRoleRel get(UserRoleRel userRoleRel) {
        return null;
    }

    public List<UserRoleRel> getList(UserRoleRel userRoleRel) {
        return null;
    }

    public boolean add(UserRoleRel userRoleRel) {
        return false;
    }

    public boolean update(UserRoleRel userRoleRel) {
        return false;
    }

    public boolean remove(UserRoleRel userRoleRel) {
        return false;
    }
}
