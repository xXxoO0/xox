package com.xox.business.user;

import java.util.List;

import org.springframework.web.context.ContextLoader;

import com.xox.model.dao.UserDao;
import com.xox.model.entity.User;

public class UserService {

	//UserDao userDao;
	

	
	public void aaa(){
		UserDao userDao = (UserDao )ContextLoader.getCurrentWebApplicationContext().getBean("userDao");
		List<User> list=userDao.findByWhere("");
		System.out.println(list.get(0).getName());
		User user=new User();
		user.setDeleted(0L);
		user.setName("zhangsan");
		user.setNickname("zhangsan");
		user.setPassword("123");
		user.setRole(1L);
		userDao.insert(user);
	}
}
