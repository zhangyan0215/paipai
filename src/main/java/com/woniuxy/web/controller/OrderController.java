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

import com.woniuxy.domain.Orders;
import com.woniuxy.service.IOrdersService;

@RestController
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private IOrdersService service;

	@PostMapping
	public void save(@RequestBody Orders orders) {
//		service.save(orders);  
	}

	@PutMapping
	public void update(@RequestBody Orders orders) {
		service.update(orders);
	}

	@DeleteMapping("{oid}")
	public void delete(@PathVariable Integer oid) {
		service.delete(oid);
	}

	@GetMapping("{oid}")
	public Orders findOne(@PathVariable Integer oid) {
		return service.findOne(oid);
	}

	@GetMapping
	public List<Orders> findAll() {
		return service.findAll();
	}
}
