package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.RoleResourceRel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class RoleResourceDAO {
    private SqlSession session;

    @Autowired
    public RoleResourceDAO(SqlSession session) {
        this.session = session;
    }

    public RoleResourceRel get(RoleResourceRel roleResourceRel) {
        return null;
    }

    public List<RoleResourceRel> getList(RoleResourceRel roleResourceRel) {
        return null;
    }

    public boolean add(RoleResourceRel roleResourceRel) {
        return false;
    }

    public boolean update(RoleResourceRel roleResourceRel) {
        return false;
    }

    public boolean remove(RoleResourceRel roleResourceRel) {
        return false;
    }
}
