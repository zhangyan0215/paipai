package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Deposit;
import com.woniuxy.service.IDepositService;

@RestController
@RequestMapping("deposits")
public class DepositController {
	
	@Autowired
	private IDepositService service;

	@GetMapping("/fbu/{uid}")
	public List<Deposit> findByUid(@PathVariable Integer uid) {
		return service.findByUid(uid);
	}
}
