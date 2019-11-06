package com.woniuxy.domain;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer roomid;

    private Integer proid;

    private Integer port;

    private static final long serialVersionUID = 1L;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}