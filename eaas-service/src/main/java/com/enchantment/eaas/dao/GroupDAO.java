package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.Group;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class GroupDAO {
    private SqlSession session;

    @Autowired
    public GroupDAO(SqlSession session) {
        this.session = session;
    }

    public Group get(Group group) {
        return null;
    }

    public List<Group> getList(Group group) {
        return null;
    }

    public boolean add(Group group) {
        return false;
    }

    public boolean update(Group group) {
        return false;
    }

    public boolean remove(Group group) {
        return false;
    }
}
