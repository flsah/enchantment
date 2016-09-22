package com.enchantment.eaas.domain;

/**
 * <p>HTTP Response Entity</p>
 *
 * Created by liushuang on 9/22/16.
 */
public class ResponseEntity {
    private int status;

    private String msg;

    private Object data;

    private String extend;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
