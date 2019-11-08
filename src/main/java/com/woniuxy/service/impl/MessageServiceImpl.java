package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.MessageMapper;
import com.woniuxy.domain.Message;
import com.woniuxy.service.IMessageService;
@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private MessageMapper mapper;

	@Transactional
	@Override
	public void save(Message message) {
		mapper.insert(message);
	}

	@Transactional
	@Override
	public void update(Message message) {
		mapper.updateByPrimaryKeySelective(message);
	}

	@Transactional
	@Override
	public void delete(Integer mid) {
		mapper.deleteByPrimaryKey(mid);
	}

	@Transactional(readOnly = true)
	@Override
	public Message findOne(Integer mid) {
		return mapper.selectByPrimaryKey(mid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Message> findAll() {
		return mapper.selectByExample(null);
	}

}
