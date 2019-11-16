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

import com.woniuxy.domain.UserAddress;
import com.woniuxy.service.IUserAddressService;

@RestController
@RequestMapping("useraddresss")
public class UserAddressController {

	@Autowired
	private IUserAddressService service;
	
	@PostMapping
	public void save(@RequestBody UserAddress userAddress) {
		service.save(userAddress);
	}
	@DeleteMapping
	public void delete(@PathVariable Integer uaid) {
		service.delete(uaid);
	}
	@PutMapping
	public void update(@RequestBody UserAddress userAddress) {
		service.update(userAddress);
	}
	@GetMapping("{uaid}")
	public UserAddress findOne(@PathVariable Integer uaid) {
		return service.findOne(uaid);
	}
	@GetMapping
	public List<UserAddress> findAll() {
		return service.findAll();
	}
	@GetMapping("/uads/{uid}")
	public List<UserAddress> findByUid(@PathVariable Integer uid) {
		return service.findByUid(uid);
	}
}
