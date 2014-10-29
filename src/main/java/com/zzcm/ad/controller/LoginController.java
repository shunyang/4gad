package com.zzcm.ad.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzcm.ad.model.User;
import com.zzcm.ad.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(Model model){
		User user=new User();
		model.addAttribute("user", user);
		return "user/login";
	}
	
	@RequestMapping("/signin")
	public String signin(Model model,User user){
		return "user/welcome";
	}
	
	@RequestMapping("/userlist")
	public String userList(Model model){
		List<User> userList=userService.findUserList();
		model.addAttribute("userList",userList);
		return "user/userlist";
	}
}
