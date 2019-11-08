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
public class OrederController {

	@Autowired
	private IOrdersService service;

	@PostMapping
	public void save(@RequestBody Orders orders) {
		System.out.println("OrederController.save()");
	}

	@PutMapping
	public void update(@RequestBody Orders orders) {
		System.out.println("OrederController.update()");
	}

	@DeleteMapping
	public void delete(Integer oid) {
		System.out.println("OrederController.delete()");
	}

	@GetMapping("{oid}")
	public Orders findOne(@PathVariable Integer oid) {
		System.out.println("OrederController.findOne()");
		return null;
	}

	@GetMapping
	public List<Orders> findAll() {
		System.out.println("OrederController.findAll()");
		return null;
	}
}
