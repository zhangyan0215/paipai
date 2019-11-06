package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Category;

public interface ICategoryService {

	void save(Category category);
	void delete(Integer cid);
	void update(Category category);
	Category findOne(Integer cid);
	List<Category> findAll();
	
}
