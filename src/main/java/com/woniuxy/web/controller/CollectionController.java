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

import com.woniuxy.domain.Collection;
import com.woniuxy.service.ICollectionService;

@RestController
@RequestMapping("collections")
public class CollectionController {

	@Autowired
	private ICollectionService service;
	
	@GetMapping
	public List<Collection> findAll() {
		return service.findAll();
	}
	@PostMapping
	public void save(@RequestBody Collection collection) {
		service.save(collection);
	}
	@DeleteMapping("{coid}")
	public void delete(@PathVariable Integer coid) {
		service.delete(coid);
	}
	@PutMapping
	public void update(@RequestBody Collection collection) {
		service.update(collection);
	}
	//通过用户查询收藏
	@GetMapping("{uid}")
	public List<Collection> findByUid(@PathVariable Integer uid) {
		return service.findByUid(uid);
	}
}