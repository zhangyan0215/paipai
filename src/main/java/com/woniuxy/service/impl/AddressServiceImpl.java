package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.AddressMapper;
import com.woniuxy.domain.Address;
import com.woniuxy.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressMapper mapper;

	@Transactional
	@Override
	public void save(Address address) {
		mapper.insert(address);
	}

	@Transactional
	@Override
	public void delete(Integer aid) {
		mapper.deleteByPrimaryKey(aid);
	}

	@Transactional
	@Override
	public void update(Address address) {
		mapper.updateByPrimaryKeySelective(address);
	}

	@Transactional(readOnly = true)
	@Override
	public Address findOne(Integer aid) {
		return mapper.selectByPrimaryKey(aid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Address> findAll() {
		return mapper.selectByExample(null);
	}
}
