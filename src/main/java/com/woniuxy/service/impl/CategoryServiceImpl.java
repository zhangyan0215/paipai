package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.CategoryMapper;
import com.woniuxy.domain.Category;
import com.woniuxy.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryMapper mapper;

	@Transactional
	@Override
	public void save(Category category) {
		mapper.insert(category);
	}

	@Transactional
	@Override
	public void delete(Integer cid) {
		mapper.deleteByPrimaryKey(cid);
	}

	@Transactional
	@Override
	public void update(Category category) {
		mapper.updateByPrimaryKeySelective(category);
	}

	@Transactional(readOnly = true)
	@Override
	public Category findOne(Integer cid) {
		return mapper.selectByPrimaryKey(cid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> findAll() {
		return mapper.selectByExample(null);
	}

}
