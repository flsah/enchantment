package com.enchantment.eaas.service;

import com.enchantment.eaas.dao.GroupDAO;
import com.enchantment.eaas.domain.Group;
import com.enchantment.eaas.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import static com.enchantment.eaas.Constants.OPER_N;
import static com.enchantment.eaas.Constants.STAT_INIT;

/**
 * <p>Group operation service</p>
 *
 * Created by genbatis on 2016-10-10 14:39:32.
 */
@Service
public class GroupService {
    private GroupDAO groupDAO;

    @Autowired
    public GroupService(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public Group getGroup(String id) {
        return groupDAO.get(id);
    }

    public List<Group> getGroups(Group group) {
        return groupDAO.getList(group);
    }

    public boolean addGroup(Group group) {
        group.setId(Utils.buildHashCode(group));
        group.setStatus(STAT_INIT);
        group.setMdate(new Timestamp(System.currentTimeMillis()));
        group.setOtype(OPER_N);
        return groupDAO.add(group);
    }

    public boolean updateGroup(Group group) {
        return groupDAO.update(group);
    }

    public boolean removeGroup(String id) {
        return groupDAO.remove(id);
    }

    public boolean removeGroups(List<String> ids) {
        return groupDAO.remove(ids);
    }
}