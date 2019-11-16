package com.woniuxy.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Product;
import com.woniuxy.service.IProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private IProductService service;
	
	@GetMapping
	public List<Product> findAll() {
		return service.findAll();
	}
	
	@GetMapping("front")
	public List<Product> findAll1(@RequestParam int page) {
		return service.findAll1(page);
	}
	
	@GetMapping("countpage")
	public Map<String, Object> findAll1() {
		int max = (Integer) service.findCountPage();
		Map< String, Object> map = new HashMap<>();
		map.put("max", max);
		List<Integer> clist = new ArrayList<>(max);
		for (Integer i = 0; i < max; i++) {
			clist.add(i+1);
		};
		map.put("clist", clist);
		return map;
	}
 
} 
