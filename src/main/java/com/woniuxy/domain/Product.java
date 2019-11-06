package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer proid;

    private String pname;

    private Double startPrice;

    private Date startTime;

    private Date endTime;

    private Integer looktimes;

    private String photo;

    private Integer status;

    private Integer cid;

    private Integer aid;

    private Double addmoney;

    private Integer uid;

    private static final long serialVersionUID = 1L;

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getLooktimes() {
        return looktimes;
    }

    public void setLooktimes(Integer looktimes) {
        this.looktimes = looktimes;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Double getAddmoney() {
        return addmoney;
    }

    public void setAddmoney(Double addmoney) {
        this.addmoney = addmoney;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}