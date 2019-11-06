package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.OrdersMapper;
import com.woniuxy.domain.Orders;
import com.woniuxy.service.IOrdersService;

public class OrdersServiceImpl implements IOrdersService {

	@Autowired
	private OrdersMapper mapper;

	@Transactional
	@Override
	public void save(Orders orders) {
		mapper.insert(orders);
	}

	@Transactional
	@Override
	public void delete(Integer oid) {
		mapper.deleteByPrimaryKey(oid);
	}

	@Transactional
	@Override
	public void update(Orders orders) {
		mapper.updateByPrimaryKeySelective(orders);
	}

	@Transactional
	@Override
	public Orders findOne(Integer oid) {
		return mapper.selectByPrimaryKey(oid);
	}

	@Transactional
	@Override
	public List<Orders> findAll() {
		return mapper.selectByExample(null);
	}

}
