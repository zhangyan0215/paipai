package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.PermissionsMapper;
import com.woniuxy.domain.Permissions;
import com.woniuxy.service.IPermissionsService;

public class PermissionsServiceImpl implements IPermissionsService {

	@Autowired
	private PermissionsMapper mapper;

	@Transactional
	@Override
	public void save(Permissions permissions) {
		mapper.insert(permissions);
	}

	@Transactional
	@Override
	public void delete(Integer pid) {
		mapper.deleteByPrimaryKey(pid);
	}

	@Transactional
	@Override
	public void update(Permissions permissions) {
		mapper.updateByPrimaryKeySelective(permissions);
	}

	@Transactional(readOnly = true)
	@Override
	public Permissions findOne(Integer pid) {
		return mapper.selectByPrimaryKey(pid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Permissions> findAll() {
		return mapper.selectByExample(null);
	}

}
