package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.ProductMapper;
import com.woniuxy.domain.Product;
import com.woniuxy.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper mapper;

	@Transactional
	@Override
	public void save(Product product) {
		mapper.insert(product);
	}

	@Transactional
	@Override
	public void delete(Integer proid) {
		mapper.deleteByPrimaryKey(proid);
	}

	@Transactional
	@Override
	public void update(Product product) {
		mapper.updateByPrimaryKeySelective(product);
	}

	@Transactional
	@Override
	public Product findOne(Integer proid) {
		return mapper.selectByPrimaryKey(proid);
	}

	@Transactional
	@Override
	public List<Product> findAll() {
		return mapper.selectByExample(null);
	}

}
