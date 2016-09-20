package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.UserGroupRel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class UserGroupDAO {
    private SqlSession session;

    @Autowired
    public UserGroupDAO(SqlSession session) {
        this.session = session;
    }

    public UserGroupRel get(UserGroupRel userGroupRel) {
        return null;
    }

    public List<UserGroupRel> getList(UserGroupRel userGroupRel) {
        return null;
    }

    public boolean add(UserGroupRel userGroupRel) {
        return false;
    }

    public boolean update(UserGroupRel userGroupRel) {
        return false;
    }

    public boolean remove(UserGroupRel userGroupRel) {
        return false;
    }
}
