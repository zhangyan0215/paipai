package com.woniuxy.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
		return mapper.selectAll();
	}
<<<<<<< HEAD

	@Override
	public List<Product> findAll1(int i) {
		int a = i * 2;
		RowBounds rb = new RowBounds(a,2);
		return mapper.selectAll1(rb);
	}

	@Override
	public Integer findCountPage() {
		Integer c = mapper.selectCountPage();
		Integer a;
		if (c%2>0) {
			a = c/2+1;
		}else {
			a = c/2;
		}
		return a;
	}

=======
	
	//查找热门前n产品
	@Transactional
	@Override
	public List<Product> findByLooktimesTen(Integer num) {
		return mapper.selectByLooktimesTen(num);
	}
>>>>>>> branch 'dev' of git@github.com:zhangyan0215/paipai.git
}
