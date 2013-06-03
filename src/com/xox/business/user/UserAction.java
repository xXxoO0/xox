package com.xox.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserAction {

	@Autowired
	UserService userService;
	
	@RequestMapping("/xox/user")
	@ResponseBody
	public String get(){
		userService.aaa();
		return "123123";
	}
}
