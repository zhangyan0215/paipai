package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Message;

public interface IMessageService {

	void save(Message message);
	void update(Message message);
	void delete(Integer mid);
	Message findOne(Integer mid);
	List<Message> findAll();
}
