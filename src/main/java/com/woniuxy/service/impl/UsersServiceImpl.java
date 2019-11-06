package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UsersMapper;
import com.woniuxy.domain.Users;
import com.woniuxy.service.IUsersService;

public class UsersServiceImpl implements IUsersService {

	@Autowired
	private UsersMapper mapper;

	@Transactional
	@Override
	public void save(Users users) {
		mapper.insert(users);
	}

	@Transactional
	@Override
	public void delete(Integer uid) {
		mapper.deleteByPrimaryKey(uid);
	}

	@Transactional
	@Override
	public void update(Users users) {
		mapper.updateByPrimaryKeySelective(users);
	}

	@Transactional(readOnly = true)
	@Override
	public Users findOne(Integer uid) {
		return mapper.selectByPrimaryKey(uid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Users> findAll() {
		return mapper.selectByExample(null);
	}

}
