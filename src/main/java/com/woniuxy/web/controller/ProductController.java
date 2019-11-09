package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
