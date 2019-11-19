package com.woniuxy.web.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Users;
import com.woniuxy.service.IUsersService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUsersService us;

	// 注册用户（传入角色id以此来添加用户并同时在用户角色表进行数据添加）
	@PostMapping("{rid}")
	public void saveUser(@RequestBody Users user, @PathVariable Integer rid) {
		System.out.println("UserController.saveUser()");
		System.out.println(user.getPassword() + " " + user.getUsername() + rid);
		us.save(user, rid);
	}
	
	//修改用户
	@PutMapping
	public void update(Users user) {
		us.update(user);
	}

	//查询所有
	@GetMapping
	public List<Users> findAllUsers() {
		System.out.println("UserController.findAllUsers()");
		List<Users> users = us.findAll();
		return users;
	}

	@GetMapping("{uid}")
	public Users findOneUsers(@PathVariable Integer uid) {
		Users user = us.findOne(uid);
		return user;
	}
	
	// 查询用户名是否被使用
	@RequestMapping("findByUsername/{username}")
	public String findByName(@PathVariable String username) {
		System.out.println("进入findByNAME-----------------" + username);
		List<Users> users = us.findByUsername(username);
		System.out.println(users);
		if (users.isEmpty()) {
			return "ok";
		} else {
			return "no";
		}
	}

	// 前台登录
	@RequestMapping("/indexlogin")
	public Users indexlogin(@RequestBody Users users) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());
		subject.login(token);
		return us.findByUsername(users.getUsername()).get(0);
	}

	// 后台登录
	@RequestMapping("/login")
	public String login(@RequestBody Users users) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());
		subject.login(token);
		try {
			subject.login(token);
			System.out.println(subject.getSession().getId() + "login");
			System.out.println("认证成功");
			if (subject.hasRole("超级管理员") || subject.hasRole("普通管理员")) {
				return "index";
			} else {
				return "login";
			}
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			System.out.println("认证失败");
			e.printStackTrace();
			return "login";
		}
	}

	// 根据角色查找所有用户(后台方法)
	@SuppressWarnings("rawtypes")
	@RequestMapping("findAllUsersByroles")
	public List<Users> findAllSellers(@RequestBody Map map) {
		Integer rid = (Integer) map.get("rid");
		List<Users> users = us.findAllUsersByroles(rid);
		return users;
	}

	// 检查用户是否登陆
	@RequestMapping("isLogin")
	public Map<String, Object> isLogin() {
		Subject subject = SecurityUtils.getSubject();
		Map<String, Object> map = new HashMap<>();
		map.put("isLogin", subject.isAuthenticated());
		return map;
	}

}
