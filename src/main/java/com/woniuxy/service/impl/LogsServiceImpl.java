package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.LogsMapper;
import com.woniuxy.domain.Logs;
import com.woniuxy.service.ILogsService;

public class LogsServiceImpl implements ILogsService {

	@Autowired
	private LogsMapper mapper;

	@Transactional
	@Override
	public void save(Logs logs) {
		mapper.insert(logs);
	}

	@Transactional
	@Override
	public void update(Logs logs) {
		mapper.updateByPrimaryKeySelective(logs);
	}

	@Transactional
	@Override
	public void delete(Integer lid) {
		mapper.deleteByPrimaryKey(lid);
	}

	@Transactional(readOnly = true)
	@Override
	public Logs findOne(Integer lid) {
		return mapper.selectByPrimaryKey(lid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Logs> findAll() {
		return mapper.selectByExample(null);
	}

}
