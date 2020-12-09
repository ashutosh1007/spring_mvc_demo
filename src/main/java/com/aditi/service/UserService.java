package com.aditi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.dao.UserDao;
import com.aditi.model.Login;
import com.aditi.model.UserDetails;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public String checkUser(int user_id, String password) {
		UserDetails userDetails = dao.getUser(user_id);
		if(userDetails==null) {
			return "User not Found";
		}else if ((userDetails.getUser_id() == user_id) && userDetails.getPassword().equals(password) )
		{
			return "Welcome " + userDetails.getF_name();
		}else {
			return "Invalid Credentials";
		}
		
	}
	
	public void saveUser(UserDetails user) {
		dao.saveUser(user);	
	}
	
	public void deleteUser(int user_id) {
		dao.deleteUser(user_id);
	}
}
