package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.CollectionMapper;
import com.woniuxy.domain.Collection;
import com.woniuxy.service.ICollectionService;

public class CollectionServiceImpl implements ICollectionService {

	@Autowired
	private CollectionMapper mapper;

	@Transactional
	@Override
	public void save(Collection collection) {
		mapper.insert(collection);
	}

	@Transactional
	@Override
	public void delete(Integer coid) {
		mapper.deleteByPrimaryKey(coid);
	}

	@Transactional
	@Override
	public void update(Collection collection) {
		mapper.updateByPrimaryKeySelective(collection);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection findOne(Integer coid) {
		return mapper.selectByPrimaryKey(coid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Collection> findAll() {
		return mapper.selectByExample(null);
	}

}
