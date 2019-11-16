package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Deposit;
import com.woniuxy.service.IDepositService;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("deposits")
public class DepositController { // 保证金

	@Resource
	private IDepositService depositServiceImpl;

	@GetMapping // 添加用户保证金
	public void save(@RequestBody Deposit deposit) {

		depositServiceImpl.save(deposit);

	}

	@DeleteMapping("{did}") // 拍卖结束归还保证金
	public void delete(@PathVariable Integer did) {
		depositServiceImpl.delete(did);
	}

	@GetMapping("/fbu/{uid}")
	public List<Deposit> findByUid(@PathVariable Integer uid) {
		return depositServiceImpl.findByUid(uid);
	}
}
