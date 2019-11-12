package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Product;

public interface IProductService {

	void save(Product product);
	void delete(Integer proid);
	void update(Product product);
	Product findOne(Integer proid);
	List<Product> findAll();
	 //查找热门前n产品
	List<Product> findByLooktimesTen(Integer num);
}
