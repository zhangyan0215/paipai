package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Room;
import com.woniuxy.service.IRoomService;

@RestController
@RequestMapping("room")
public class RoomController {
	@Autowired
	private IRoomService service;
	
	@GetMapping
	public List<Room> findAll(){
		return service.findAll();  //aa
	}
}
