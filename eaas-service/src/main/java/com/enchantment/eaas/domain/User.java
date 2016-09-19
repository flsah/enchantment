package com.enchantment.eaas.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by liushuang on 2016/9/19.
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String lname;
    private String ename;
    private int sex;
    private String mobile;
    private String tel;
    private String mail;
    private String fax;
    private String zipcode;
    private String address;
    private int passwd1;
    private int passwd2;
    private int passwd3;
    private int passwd4;
    private int passwd5;
    private int status;
    private Date util;
    Timestamp mdate;
    private String mid;
    private int otype;
    private String photourl;
    private int remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPasswd1() {
        return passwd1;
    }

    public void setPasswd1(int passwd1) {
        this.passwd1 = passwd1;
    }

    public int getPasswd2() {
        return passwd2;
    }

    public void setPasswd2(int passwd2) {
        this.passwd2 = passwd2;
    }

    public int getPasswd3() {
        return passwd3;
    }

    public void setPasswd3(int passwd3) {
        this.passwd3 = passwd3;
    }

    public int getPasswd4() {
        return passwd4;
    }

    public void setPasswd4(int passwd4) {
        this.passwd4 = passwd4;
    }

    public int getPasswd5() {
        return passwd5;
    }

    public void setPasswd5(int passwd5) {
        this.passwd5 = passwd5;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUtil() {
        return util;
    }

    public void setUtil(Date util) {
        this.util = util;
    }

    public Timestamp getMdate() {
        return mdate;
    }

    public void setMdate(Timestamp mdate) {
        this.mdate = mdate;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getOtype() {
        return otype;
    }

    public void setOtype(int otype) {
        this.otype = otype;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }
}
