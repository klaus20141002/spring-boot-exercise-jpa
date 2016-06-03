package com.julie.mikaelson.common.user.controller;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.julie.mikaelson.common.user.model.User;
import com.julie.mikaelson.common.user.repository.UserRepository;



@Controller
public class UserCtroller {
	
	private final Logger logger = Logger.getLogger(UserCtroller.class) ;
	

	@Autowired
	private UserRepository userRepository ;
	
	@RequestMapping({"/","/home"})
	public String showHome() {
		logger.error("==============Go to Home=========================");
		return "index";
	}
	
	
	@RequestMapping("/users")
	@ResponseBody
	public String showUser() {
		for(User u :userRepository.findAll() ) {
			logger.error(u);
		}
		return "success";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addUser() {
		User user = new User() ;
		user.setUsername("niklaus Mikaelson");
		user.setPassword("123456");
		user.setEmail("love20141002@126.com");
		user.setPhone("15603648363");
		user.setAccount(String.valueOf(UUID.randomUUID().toString()));
		userRepository.save(user) ;
		logger.error(user);
		return "success";
		
	}
	
	
}
