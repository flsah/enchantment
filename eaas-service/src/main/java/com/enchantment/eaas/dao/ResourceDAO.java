package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liushuang on 2016/9/19.
 */
@Component
public class ResourceDAO {
    private SqlSession session;

    @Autowired
    public ResourceDAO(SqlSession session) {
        this.session = session;
    }

    public Resource get(Resource resource) {
        return null;
    }

    public List<Resource> getList(Resource resource) {
        return null;
    }

    public boolean add(Resource resource) {
        return false;
    }

    public boolean update(Resource resource) {
        return false;
    }

    public boolean remove(Resource resource) {
        return false;
    }
}
