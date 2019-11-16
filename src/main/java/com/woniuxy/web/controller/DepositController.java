package com.woniuxy.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Deposit;
import com.woniuxy.service.IDepositService;

@RestController
@RequestMapping("deposit")
public class DepositController {                //保证金

	@Resource
	private IDepositService depositServiceImpl;
	
	@GetMapping       //添加用户保证金
	public void save(@RequestBody Deposit deposit) {
		
		depositServiceImpl.save(deposit);
		
	}
	
	@DeleteMapping("{did}")         //拍卖结束归还保证金
	public void delete(@PathVariable Integer did) {
		depositServiceImpl.delete(did);
	}
}
