package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UserAddressMapper;
import com.woniuxy.domain.UserAddress;
import com.woniuxy.service.IUserAddressService;
@Service
public class UserAddressServiceImpl implements IUserAddressService {

	@Autowired
	private UserAddressMapper mapper;

	@Transactional
	@Override
	public void save(UserAddress userAddress) {
		mapper.insert(userAddress);
	}

	@Transactional
	@Override
	public void delete(Integer uaid) {
		mapper.deleteByPrimaryKey(uaid);
	}

	@Transactional
	@Override
	public void update(UserAddress userAddress) {
		mapper.updateByPrimaryKeySelective(userAddress);
	}

	@Transactional(readOnly = true)
	@Override
	public UserAddress findOne(Integer uaid) {
		return mapper.selectByPrimaryKey(uaid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserAddress> findAll() {
		return mapper.selectByExample(null);
	}

}
