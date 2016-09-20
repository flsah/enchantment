package com.enchantment.eaas.domain;

import java.io.Serializable;

/**
 * Created by liushuang on 2016/9/20.
 */
public class UserGroupRel implements Serializable {
    private String uid;
    private String gid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }
}
