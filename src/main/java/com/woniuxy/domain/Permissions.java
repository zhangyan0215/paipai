package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Set;

public class Permissions implements Serializable {
    private Integer pid;

    private String pname;

    private String info;
    
    private Set<Roles>roles;

    private static final long serialVersionUID = 1L;

    public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

	@Override
	public String toString() {
		return "Permissions [pid=" + pid + ", pname=" + pname + ", info=" + info + "]";
	}
}