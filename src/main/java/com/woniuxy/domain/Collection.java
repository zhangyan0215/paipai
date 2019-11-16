package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

public class Collection implements Serializable {
    private Integer coid;

    private Integer uid;

    private Integer proid;

    private Date datetime;


    private static final long serialVersionUID = 1L;

	public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}