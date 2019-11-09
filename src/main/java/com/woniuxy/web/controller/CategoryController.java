package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Category;
import com.woniuxy.service.ICategoryService;

@RestController
@RequestMapping("categorys")
public class CategoryController {
	
	@Autowired
	private ICategoryService service;
	@PostMapping
	public void save(@RequestBody Category category) {
		service.save(category);
	}
	@DeleteMapping("{cid}")
	public void delete(@PathVariable Integer cid) {
		service.delete(cid);
	}
	@PutMapping
	public void update(@RequestBody Category category) {
		service.update(category);
	}
	@GetMapping
	public List<Category> findAll() {
		return service.findAll();
	}
	@GetMapping("{cid}")
	public Category findOne(@PathVariable Integer cid) {
		return service.findOne(cid);
	}

}
