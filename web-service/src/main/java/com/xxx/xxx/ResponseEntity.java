package com.xxx.xxx;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by liushuang on 2016/9/26.
 */
@JsonRootName("ResponseEntity")
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
