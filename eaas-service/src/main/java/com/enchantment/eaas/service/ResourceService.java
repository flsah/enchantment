package com.enchantment.eaas.service;

import com.enchantment.eaas.dao.ResourceDAO;
import com.enchantment.eaas.domain.Resource;
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
 * <p>Resource operation service</p>
 *
 * Created by genbatis on 2016-10-10 15:52:34.
 */
@Service
public class ResourceService {
    private ResourceDAO resourceDAO;

    @Autowired
    public ResourceService(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    public Resource getResource(String id) {
        return resourceDAO.get(id);
    }

    public List<Resource> getResources(Resource resource) {
        return resourceDAO.getList(resource);
    }

    public boolean addResource(Resource resource) {
        resource.setId(Utils.buildHashCode(resource));
        resource.setStatus(STAT_INIT);
        resource.setMdate(new Timestamp(System.currentTimeMillis()));
        resource.setOtype(OPER_N);
        return resourceDAO.add(resource);
    }

    public boolean updateResource(Resource resource) {
        return resourceDAO.update(resource);
    }

    public boolean removeResource(String id) {
        return resourceDAO.remove(id);
    }

    public boolean removeResources(List<String> ids) {
        return resourceDAO.remove(ids);
    }
}