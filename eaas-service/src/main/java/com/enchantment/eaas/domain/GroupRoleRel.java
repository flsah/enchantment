package com.enchantment.eaas.domain;

import java.io.Serializable;

/**
 * Created by liushuang on 2016/9/20.
 */
public class GroupRoleRel implements Serializable {
    private String gid;
    private String rid;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
