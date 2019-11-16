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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.Users;
import com.woniuxy.service.IUsersService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUsersService us;
	
	//注册用户（传入角色id以此来添加用户并同时在用户角色表进行数据添加）
	@PostMapping("{rid}")
	public void saveUser(@RequestBody Users user,@PathVariable Integer rid) {
		
		System.out.println("UserController.saveUser()");
		/* Integer roles = (Integer) map.get("roles"); */
		System.out.println(user.getPassword()+" " + user.getUsername()+rid);
		us.save(user,rid);
		
	}
	
	@RequestMapping("findByUsername/{username}")
	public String findByName(@PathVariable String username) {
		System.out.println("进入findByNAME-----------------"+username);
		List<Users> users = us.findByUsername(username);
		System.out.println(users);
		if(users.isEmpty()) {
			return "ok";
		}else {
			return "no";
		}
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
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
			System.out.println(subject.getSession().getId()+"login");
			System.out.println("认证成功");
			if(subject.hasRole("超级管理员")||subject.hasRole("普通管理员")) {
				return "index";
			}else if(subject.hasRole("卖家")||subject.hasRole("买家")) {
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
	
	//根据角色查找所有用户
	@RequestMapping("findAllUsersByroles")
	public List<Users> findAllSellers(@RequestBody Map map){
		Integer rid = (Integer) map.get("rid");
		List<Users> users = us.findAllUsersByroles(rid);
		return users;
	}
	
	@RequestMapping("isLogin")
	public Map<String, Object> isLogin() {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Map<String, Object> map = new HashMap<>();
		map.put("status",subject.isAuthenticated()?200:500);
		map.put("username", username);
		if(username!=null) {
			map.put("users", us.findByUsername(username));
		}
		return map;
	}
	
}
