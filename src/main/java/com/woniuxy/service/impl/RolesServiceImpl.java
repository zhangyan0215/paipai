package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RolesMapper;
import com.woniuxy.domain.Roles;
import com.woniuxy.service.IRolesService;
@Service
public class RolesServiceImpl implements IRolesService {

	@Autowired
	private RolesMapper mapper;

	@Transactional
	@Override
	public void save(Roles roles) {
		mapper.insert(roles);
	}

	@Transactional
	@Override
	public void delete(Integer rid) {
		mapper.deleteByPrimaryKey(rid);
	}

	@Transactional
	@Override
	public void update(Roles roles) {
		mapper.updateByPrimaryKeySelective(roles);
	}

	@Transactional(readOnly = true)
	@Override
	public Roles findOne(Integer rid) {
		return mapper.selectByPrimaryKey(rid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Roles> findAll() {
		return mapper.selectByExample(null);
	}

}
