package com.woniuxy.web.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.woniuxy.domain.Collection;
import com.woniuxy.service.ICollectionService;
@RestController
@RequestMapping("collections")
public class CollectionController {
	@Resource
	ICollectionService collectionServiceImpl;
	@PostMapping
	public void save(@RequestBody Collection collection) {
		collectionServiceImpl.save(collection);
	}
	@DeleteMapping("{coid}")
	public void delete(@PathVariable Integer coid) {
		collectionServiceImpl.delete(coid);
	}
	@PutMapping
	public void update(@RequestBody Collection collection) {
		collectionServiceImpl.update(collection);
	}
	@GetMapping
	public List<Collection> findAll() {
		return collectionServiceImpl.findAll();
	}
	@GetMapping("{coid}")
	public Collection findOne(@PathVariable Integer coid) {
		return collectionServiceImpl.findOne(coid);
	}
	
	
}
