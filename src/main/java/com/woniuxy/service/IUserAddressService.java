package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.UserAddress;

public interface IUserAddressService {

	void save(UserAddress userAddress);
	void delete(Integer uaid);
	void update(UserAddress userAddress);
	UserAddress findOne(Integer uaid);
	List<UserAddress> findAll();
}
