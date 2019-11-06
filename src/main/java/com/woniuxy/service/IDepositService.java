package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Deposit;

public interface IDepositService {

	void save(Deposit deposit);
	void update(Deposit deposit);
	void delete(Integer did);
	Deposit findOne(Integer did);
	List<Deposit> findAll();
}
