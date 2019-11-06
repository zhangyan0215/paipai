package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.History;

public interface IHistoryService {

	void save(History history);
	void update(History history);
	void delete(Integer hid);
	History findOne(Integer hid);
	List<History> findAll();
}
