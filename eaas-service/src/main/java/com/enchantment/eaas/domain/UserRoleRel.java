package com.enchantment.eaas.domain;

import java.io.Serializable;

/**
 * Created by liushuang on 2016/9/20.
 */
public class UserRoleRel implements Serializable {
    private String uid;
    private String rid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
