package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Logs;
import com.woniuxy.service.ILogsService;

@RestController
@RequestMapping("logs")
public class LogsController {
	
	@Autowired
	private ILogsService service;
	
	@PostMapping
	public void saveLogs(Logs log) {
		service.save(log);
	}
	@DeleteMapping
	public void deleteLogs(Integer lid) {
	service.delete(lid);
	
	}
	@GetMapping("{lid}")
	public Logs findByLogsid(Integer lid) {
		return service.findOne(lid);
	}
	@GetMapping
	public List<Logs> findAll(){
		return service.findAll();
	}
	@PutMapping
	public void updateLogs(Logs log) {
		service.update(log);
		}
	}
