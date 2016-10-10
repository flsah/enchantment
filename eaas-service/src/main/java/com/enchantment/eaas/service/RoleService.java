package com.enchantment.eaas.service;

import com.enchantment.eaas.dao.RoleDAO;
import com.enchantment.eaas.domain.Role;
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
 * <p>Role operation service</p>
 *
 * Created by genbatis on 2016-10-10 15:52:49.
 */
@Service
public class RoleService {
    private RoleDAO roleDAO;

    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public Role getRole(String id) {
        return roleDAO.get(id);
    }

    public List<Role> getRoles(Role role) {
        return roleDAO.getList(role);
    }

    public boolean addRole(Role role) {
        role.setId(Utils.buildHashCode(role));
        role.setStatus(STAT_INIT);
        role.setMdate(new Timestamp(System.currentTimeMillis()));
        role.setOtype(OPER_N);
        return roleDAO.add(role);
    }

    public boolean updateRole(Role role) {
        return roleDAO.update(role);
    }

    public boolean removeRole(String id) {
        return roleDAO.remove(id);
    }

    public boolean removeRoles(List<String> ids) {
        return roleDAO.remove(ids);
    }
}