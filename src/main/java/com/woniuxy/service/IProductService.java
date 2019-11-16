package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Product;

public interface IProductService {

	void save(Product product);
	void delete(Integer proid);
	void update(Product product);
	Product findOne(Integer proid);
	List<Product> findAll();
	List<Product> findAll1(int i);
	Integer findCountPage();
}
