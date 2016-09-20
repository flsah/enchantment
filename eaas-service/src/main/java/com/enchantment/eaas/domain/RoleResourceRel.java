package com.enchantment.eaas.domain;

import java.io.Serializable;

/**
 * Created by liushuang on 2016/9/20.
 */
public class RoleResourceRel implements Serializable {
    private String rolid;
    private String resid;

    public String getRolid() {
        return rolid;
    }

    public void setRolid(String rolid) {
        this.rolid = rolid;
    }

    public String getResid() {
        return resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }
}
