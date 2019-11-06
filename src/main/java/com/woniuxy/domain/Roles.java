package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Set;

public class Roles implements Serializable {
    private Integer rid;

    private String rname;

    private String info;
    
    private Set<Users>users;
    
    private Set<Permissions>permissions;

    private static final long serialVersionUID = 1L;

    public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}

	public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

	@Override
	public String toString() {
		return "Roles [rid=" + rid + ", rname=" + rname + ", info=" + info + "]";
	}
}