package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.Group;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DAO for group table
 *
 * Created by genbatis on 2016-10-10 14:39:32.
 */
@Component
public class GroupDAO {
    private SqlSession session;

    @Autowired
    public GroupDAO(SqlSession session) {
        this.session = session;
    }

    public Group get(String id) {
        return session.selectOne("getGroupById", id);
    }

    public Group getGroup(Group group) {
        List<Group> groups = session.selectList("getGroups", group);

        if (groups.isEmpty())
            return null;

        return groups.get(0);
    }

    public List<Group> getList(Group group) {
        return session.selectList("getGroups", group);
    }

    public boolean add(Group group) {
        return session.insert("addGroup", group) > 0;
    }

    public boolean update(Group group) {
        return session.update("modGroup", group) > 0;
    }

    public boolean remove(String id) {
        return session.delete("delGroup", id) > 0;
    }

    public boolean remove(List<String> ids) {
        return session.delete("delGroups", ids) > 0;
    }
}