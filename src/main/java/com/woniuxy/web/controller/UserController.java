package com.woniuxy.web.controller;

import java.util.List;

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
		System.out.println(roles);
		us.save(user,roles); 
	}
	
	@PutMapping
	public void update(Users user) {
		us.update(user);
	}
	
	@GetMapping
	public List<Users> findAllUsers(){
		List<Users> users = us.findAll();
		return users;
	}
	
	@GetMapping("{uid}")
	public Users findOneUsers(@PathVariable Integer uid){
		Users user = us.findOne(uid);
		return user;
	}
	
	@RequestMapping("login")
	public String save(String username,String password){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
			System.out.println("认证成功");
			return "index";
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			System.out.println("认证失败");
			e.printStackTrace();
			return "login";
		}
	}
}
