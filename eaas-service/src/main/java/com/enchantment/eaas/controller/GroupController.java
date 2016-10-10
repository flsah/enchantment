package com.enchantment.eaas.controller;

import com.enchantment.eaas.domain.ResponseEntity;
import com.enchantment.eaas.domain.Group;
import com.enchantment.eaas.service.GroupService;

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
 * The controller that to handle the request about group entity.<br/>
 *
 * Created by genbatis on 2016-10-10 14:39:32.
 */
@RestController
@RequestMapping(value = "/v1/group", produces = "application/json")
public class GroupController {
    private static final Logger L = LoggerFactory.getLogger(GroupController.class);

    private GroupService service;

    @Autowired
    public GroupController(GroupService service) {
        this.service = service;
    }

    /**
     * Select one group information by group id
     *
     * @param id group identity
     * @return group information
     */
    @RequestMapping(value = "/get/{id}",
            method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity getGroup(@PathVariable("id") String id) {
        L.debug("Get group, id = " + id);
        Group reGroup = service.getGroup(id);
        ResponseEntity entity = new ResponseEntity();

        if (reGroup != null) {
            L.debug("Get successfully.");
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reGroup);
        } else {
            L.debug("Get failed.");
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * Select group information by conditions
     *
     * @return group information
     */
    @RequestMapping(value = "/gets", method = RequestMethod.POST)
    public ResponseEntity getGroup(Group group) {
        L.debug("Get group " + group);
        List<Group> reGroups = service.getGroups(group);
        ResponseEntity entity = new ResponseEntity();

        if (reGroups != null) {
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reGroups);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * Add one group into db
     * <p>Request method is <code>PUT</code></p>
     *
     * @param group new group information
     * @return Response entity which contains response data and status
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity groupAdd(@RequestBody Group group) {
        ResponseEntity entity = new ResponseEntity();
        if (service.addGroup(group)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Update one group information
     * <p>Request method is <code>PUT</code></p>
     *
     * @param group new group information for changing
     * @return true if modify successfully, otherwise false
     */
    @RequestMapping(value = "/mod", method = RequestMethod.PUT)
    public ResponseEntity groupMod(Group group) {
        ResponseEntity entity = new ResponseEntity();
        if (service.updateGroup(group)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Delete one group from db
     * <p>Request method is <code>DELETE</code></p>
     *
     * @param id group identity to be deleted
     * @return true if delete successfully, otherwise false
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity groupDel(@PathVariable("id") String id) {
        ResponseEntity entity = new ResponseEntity();
        if (service.removeGroup(id)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Delete group from db
     * <p>Request method is <code>DELETE</code></p>
     *
     * @param ids group identitys to be deleted
     * @return true if delete successfully, otherwise false
     */
    @RequestMapping(value = "/dels", method = RequestMethod.DELETE)
    public ResponseEntity groupDel(List<String> ids) {
        ResponseEntity entity = new ResponseEntity();
        if (service.removeGroups(ids)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }
}