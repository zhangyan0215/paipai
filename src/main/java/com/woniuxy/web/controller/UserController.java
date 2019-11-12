package com.woniuxy.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Users;
import com.woniuxy.service.IUsersService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUsersService us;
	
	/* @PostMapping */
	
	@RequestMapping("save")
	public void saveUser(@RequestBody Users user,Integer roles) {
		
		System.out.println("UserController.saveUser()");
		System.out.println(user.getPassword()+" " + user.getUsername());
		us.save(user,roles);
	}
	
	@PutMapping
	public void update(Users user) {
		us.update(user);
	}
	
	@GetMapping
	public List<Users> findAllUsers(){
		System.out.println("UserController.findAllUsers()");
		List<Users> users = us.findAll();
		return users;
	}
	
	@GetMapping("{uid}")
	public Users findOneUsers(@PathVariable Integer uid){
		Users user = us.findOne(uid);
		return user;
	}
	
	@RequestMapping("login")
	public String login(String username,String password){
		System.out.println("login................");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
			System.out.println("认证成功");
			if(subject.hasRole("超级管理员")||subject.hasRole("普通管理员")) {
				return "index";
			}else {
				return "login";
			}
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			System.out.println("认证失败");
			e.printStackTrace();
			return "login";
		}
	}
	
	@RequestMapping("findAllUsersByroles")
	public List<Users> findAllSellers(@RequestBody Map map){
		Integer rid = (Integer) map.get("rid");
		List<Users> users = us.findAllUsersByroles(rid);
		System.out.println(users);
		return users;
	}
	
}
