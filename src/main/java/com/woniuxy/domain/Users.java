package com.woniuxy.domain;

import java.io.Serializable;

public class Users implements Serializable {
    private Integer uid;

    private String username;

    private String password;

    private String salt;

    private String photo;

    private Integer status;

    private static final long serialVersionUID = 1L;
    
    private UserAddress userAddress;
    
    

    public UserAddress getUseraddress() {
		return userAddress;
	}

	public void setUseraddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
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

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", photo="
				+ photo + ", status=" + status + "]";
	}
    
    
}