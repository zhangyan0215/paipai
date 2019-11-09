package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message implements Serializable {
    private Integer mid;

    private String content;

    
    private Date pubdate;

    private static final long serialVersionUID = 1L;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

	@Override
	public String toString() {
		return "Message [mid=" + mid + ", content=" + content + ", pubdate=" + pubdate + "]";
	}
    
}