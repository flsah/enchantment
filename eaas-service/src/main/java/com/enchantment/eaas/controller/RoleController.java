package com.enchantment.eaas.controller;

import com.enchantment.eaas.domain.ResponseEntity;
import com.enchantment.eaas.domain.Role;
import com.enchantment.eaas.service.RoleService;

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
 * The controller that to handle the request about role entity.<br/>
 *
 * Created by genbatis on 2016-10-10 15:52:49.
 */
@RestController
@RequestMapping(value = "/v1/role", produces = "application/json")
public class RoleController {
    private static final Logger L = LoggerFactory.getLogger(RoleController.class);

    private RoleService service;

    @Autowired
    public RoleController(RoleService service) {
        this.service = service;
    }

    /**
     * Select one role information by role id
     *
     * @param id role identity
     * @return role information
     */
    @RequestMapping(value = "/get/{id}",
            method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity getRole(@PathVariable("id") String id) {
        L.debug("Get role, id = " + id);
        Role reRole = service.getRole(id);
        ResponseEntity entity = new ResponseEntity();

        if (reRole != null) {
            L.debug("Get successfully.");
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reRole);
        } else {
            L.debug("Get failed.");
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * Select role information by conditions
     *
     * @return role information
     */
    @RequestMapping(value = "/gets", method = RequestMethod.POST)
    public ResponseEntity getRole(Role role) {
        L.debug("Get role " + role);
        List<Role> reRoles = service.getRoles(role);
        ResponseEntity entity = new ResponseEntity();

        if (reRoles != null) {
            entity.setStatus(RESPONSE_STATUS_SUC);
            entity.setData(reRoles);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }

        return entity;
    }

    /**
     * Add one role into db
     * <p>Request method is <code>PUT</code></p>
     *
     * @param role new role information
     * @return Response entity which contains response data and status
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity roleAdd(@RequestBody Role role) {
        ResponseEntity entity = new ResponseEntity();
        if (service.addRole(role)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Update one role information
     * <p>Request method is <code>PUT</code></p>
     *
     * @param role new role information for changing
     * @return true if modify successfully, otherwise false
     */
    @RequestMapping(value = "/mod", method = RequestMethod.PUT)
    public ResponseEntity roleMod(Role role) {
        ResponseEntity entity = new ResponseEntity();
        if (service.updateRole(role)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Delete one role from db
     * <p>Request method is <code>DELETE</code></p>
     *
     * @param id role identity to be deleted
     * @return true if delete successfully, otherwise false
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity roleDel(@PathVariable("id") String id) {
        ResponseEntity entity = new ResponseEntity();
        if (service.removeRole(id)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }

    /**
     * Delete role from db
     * <p>Request method is <code>DELETE</code></p>
     *
     * @param ids role identitys to be deleted
     * @return true if delete successfully, otherwise false
     */
    @RequestMapping(value = "/dels", method = RequestMethod.DELETE)
    public ResponseEntity roleDel(List<String> ids) {
        ResponseEntity entity = new ResponseEntity();
        if (service.removeRoles(ids)) {
            entity.setStatus(RESPONSE_STATUS_SUC);
        } else {
            entity.setStatus(RESPONSE_STATUS_FAL);
        }
        return entity;
    }
}
