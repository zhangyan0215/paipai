package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.DepositMapper;
import com.woniuxy.domain.Deposit;
import com.woniuxy.service.IDepositService;
@Service
public class DepositServiceImpl implements IDepositService {

	@Autowired
	private DepositMapper mapper;

	@Transactional
	@Override
	public void save(Deposit deposit) {
		mapper.insert(deposit);
	}

	@Transactional
	@Override
	public void update(Deposit deposit) {
		mapper.updateByPrimaryKeySelective(deposit);
	}

	@Transactional
	@Override
	public void delete(Integer did) {
		mapper.deleteByPrimaryKey(did);
	}

	@Transactional(readOnly = true)
	@Override
	public Deposit findOne(Integer did) {
		return mapper.selectByPrimaryKey(did);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Deposit> findAll() {
		return mapper.selectByExample(null);
	}

}
