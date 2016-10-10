package com.enchantment.eaas.controller;

import com.enchantment.eaas.domain.ResponseEntity;
import com.enchantment.eaas.domain.Resource;
import com.enchantment.eaas.service.ResourceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.enchantment.eaas.Constants.RESPONSE_STATUS_FAL;
import static com.enchantment.eaas.Constants.RESPONSE_STATUS_SUC;

/**
 * The controller that to handle the request about resource entity.<br/>
 *
 * Created by genbatis on 2016-10-10 15:52:34.
 */
@RestController
@RequestMapping(value = "/v1/resource", produces = "application/json")
public class ResourceController {
    private static final Logger L = LoggerFactory.getLogger(ResourceController.class);

    private ResourceService service;

    @Autowired
    public ResourceController(ResourceService service) {
        this.service = service;
    }

    /**
     * Select one resource information by resource id
     *
     * @param id resource identity
     * @return resource information
     */
    @RequestMapping(value = "/get/{id}",
            method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity getResource(@PathVariable("id") String id) {
        L.debug("Get resource, id = " + id);
        Resource reResource = service.getResource(id);
        ResponseEntity entity = new ResponseEntity();

        if (reResource != null) {
            L.debug("Get successfully.");
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reResource);
        } else {
            L.debug("Get failed.");
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * Select resource information by conditions
     *
     * @return resource information
     */
    @RequestMapping(value = "/gets", method = RequestMethod.POST)
    public ResponseEntity getResource(Resource resource) {
        L.debug("Get resource " + resource);
        List<Resource> reResources = service.getResources(resource);
        ResponseEntity entity = new ResponseEntity();

        if (reResources != null) {
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reResources);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * Add one resource into db
     * <p>Request method is <code>PUT</code></p>
     *
     * @param resource new resource information
     * @return Response entity which contains response data and status
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity resourceAdd(@RequestBody Resource resource) {
        ResponseEntity entity = new ResponseEntity();
        if (service.addResource(resource)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Update one resource information
     * <p>Request method is <code>PUT</code></p>
     *
     * @param resource new resource information for changing
     * @return true if modify successfully, otherwise false
     */
    @RequestMapping(value = "/mod", method = RequestMethod.PUT)
    public ResponseEntity resourceMod(Resource resource) {
        ResponseEntity entity = new ResponseEntity();
        if (service.updateResource(resource)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Delete one resource from db
     * <p>Request method is <code>DELETE</code></p>
     *
     * @param id resource identity to be deleted
     * @return true if delete successfully, otherwise false
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity resourceDel(@PathVariable("id") String id) {
        ResponseEntity entity = new ResponseEntity();
        if (service.removeResource(id)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Delete resource from db
     * <p>Request method is <code>DELETE</code></p>
     *
     * @param ids resource identitys to be deleted
     * @return true if delete successfully, otherwise false
     */
    @RequestMapping(value = "/dels", method = RequestMethod.DELETE)
    public ResponseEntity resourceDel(List<String> ids) {
        ResponseEntity entity = new ResponseEntity();
        if (service.removeResources(ids)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }
}
