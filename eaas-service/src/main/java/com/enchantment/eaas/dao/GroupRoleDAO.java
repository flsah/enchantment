package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.GroupRoleRel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class GroupRoleDAO {
    private SqlSession session;

    @Autowired
    public GroupRoleDAO(SqlSession session) {
        this.session = session;
    }

    public GroupRoleRel get(GroupRoleRel groupRoleRel) {
        return null;
    }

    public List<GroupRoleRel> getList(GroupRoleRel groupRoleRel) {
        return null;
    }

    public boolean add(GroupRoleRel groupRoleRel) {
        return false;
    }

    public boolean update(GroupRoleRel groupRoleRel) {
        return false;
    }

    public boolean remove(GroupRoleRel groupRoleRel) {
        return false;
    }
}
