package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Collection;

public interface ICollectionService {

	void save(Collection collection);
	void delete(Integer coid);
	void update(Collection collection);
	Collection findOne(Integer coid);
	List<Collection> findAll();
}
