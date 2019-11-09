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

import com.woniuxy.domain.Address;
import com.woniuxy.service.IAddressService;
@RestController
@RequestMapping("addresss")
public class AddressController {
	
		@Autowired
		private IAddressService service;
		@PostMapping
		public void save(@RequestBody Address address) {
			service.save(address);
		}
		@DeleteMapping("{aid}")
		public void delete(@PathVariable Integer aid) {
			service.delete(aid);
		}
		@PutMapping
		public void update(@RequestBody Address address) {
			service.update(address);
		}
		@GetMapping
		public List<Address> findAll() {
			return service.findAll();
		}
		@GetMapping("{aid}")
		public Address findOne(@PathVariable Integer aid) {
			return service.findOne(aid);
		}

}
