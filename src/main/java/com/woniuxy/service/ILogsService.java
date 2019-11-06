package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Logs;

public interface ILogsService {

	void save(Logs logs);
	void update(Logs logs);
	void delete(Integer lid);
	Logs findOne(Integer lid);
	List<Logs> findAll();
}
