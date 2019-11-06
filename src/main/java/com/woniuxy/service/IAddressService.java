package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Address;

public interface IAddressService {

	void save(Address address);
	void delete(Integer aid);
	void update(Address address);
	Address findOne(Integer aid);
	List<Address> findAll();
}
