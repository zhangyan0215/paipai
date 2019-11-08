package com.woniuxy.service.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UsersMapper;
import com.woniuxy.dao.UsersRolesMapper;
import com.woniuxy.domain.Users;
import com.woniuxy.domain.UsersRolesKey;
import com.woniuxy.service.IUsersService;

public class UsersServiceImpl implements IUsersService {

	@Autowired
	private UsersMapper mapper;
	
	@Autowired
	private UsersRolesMapper urm;
	
	@Autowired
	private UsersRolesKey urk;

	@Transactional
	@Override
	public void save(Users users,Integer roles) {
		String password = users.getPassword();
		String salt= "abc";
		users.setSalt(salt);
		SimpleHash sh = new SimpleHash("md5", password,salt , 1024);
		users.setPassword(sh.toHex());
		urk.setUid(users.getUid()); 
		urk.setRid(roles); 
		urm.insert(urk);
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
