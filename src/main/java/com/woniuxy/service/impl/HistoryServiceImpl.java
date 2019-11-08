package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.HistoryMapper;
import com.woniuxy.domain.History;
import com.woniuxy.service.IHistoryService;
@Service
public class HistoryServiceImpl implements IHistoryService {

	@Autowired
	private HistoryMapper mapper;

	@Transactional
	@Override
	public void save(History history) {
		mapper.insert(history);
	}

	@Transactional
	@Override
	public void update(History history) {
		mapper.updateByPrimaryKeySelective(history);
	}

	@Transactional
	@Override
	public void delete(Integer hid) {
		mapper.deleteByPrimaryKey(hid);
	}

	@Transactional(readOnly = true)
	@Override
	public History findOne(Integer hid) {
		return mapper.selectByPrimaryKey(hid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<History> findAll() {
		return mapper.selectByExample(null);
	}

}
