package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DAO for resource table
 *
 * Created by genbatis on 2016-10-10 15:52:34.
 */
@Component
public class ResourceDAO {
    private SqlSession session;

    @Autowired
    public ResourceDAO(SqlSession session) {
        this.session = session;
    }

    public Resource get(String id) {
        return session.selectOne("getResourceById", id);
    }

    public Resource getResource(Resource resource) {
        List<Resource> resources = session.selectList("getResources", resource);

        if (resources.isEmpty())
            return null;

        return resources.get(0);
    }

    public List<Resource> getList(Resource resource) {
        return session.selectList("getResources", resource);
    }

    public boolean add(Resource resource) {
        return session.insert("addResource", resource) > 0;
    }

    public boolean update(Resource resource) {
        return session.update("modResource", resource) > 0;
    }

    public boolean remove(String id) {
        return session.delete("delResource", id) > 0;
    }

    public boolean remove(List<String> ids) {
        return session.delete("delResources", ids) > 0;
    }
}