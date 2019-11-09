package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RoomMapper;
import com.woniuxy.domain.Room;
import com.woniuxy.service.IRoomService;
@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomMapper mapper;

	@Transactional
	@Override
	public void save(Room room) {
		mapper.insert(room);
	}

	@Transactional
	@Override
	public void delete(Integer roomid) {
		mapper.deleteByPrimaryKey(roomid);
	}

	@Transactional
	@Override
	public void update(Room room) {
		mapper.updateByPrimaryKeySelective(room);
	}

	@Transactional(readOnly = true)
	@Override
	public Room findOne(Integer roomid) {
		return mapper.selectByPrimaryKey(roomid);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Room> findAll() {
		System.out.println("222222");
		List<Room> rooms = mapper.selectAll();
		System.out.println(rooms);
		return rooms;
	}
}
