package com.woniuxy.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Message;
import com.woniuxy.service.IMessageService;

@RestController
@RequestMapping("messages")
public class MessageController {
	@Autowired
	private IMessageService service;
	
	@PostMapping
	public void saveMessage(@RequestBody Message message) {
		
		service.save(message);
	
	}
	
	
	
	@DeleteMapping
	public void deleteMessage(Integer mid) {
		service.delete(mid);
	}
	@RequestMapping("/update")
	public void updateMessage(@RequestBody Message message) {
		System.out.println(123);
		service.update(message);
	}
	@GetMapping("{mid}")
	public Message findByMessageId(@PathVariable Integer mid) {
		return service.findOne(mid);
	}
	@GetMapping
	public List<Message> findAll() {
		return service.findAll();
	}
	
	
	
}
