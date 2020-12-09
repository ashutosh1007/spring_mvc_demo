package com.aditi.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.dao.UserDao;
import com.aditi.model.Login;
import com.aditi.model.UserDetails;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public String checkUser(int user_id, String password) {
		UserDetails userDetails = dao.getUser(user_id);
		if(userDetails==null) {
			System.out.println("User not Found");
		} else if ((userDetails.getUser_id() == user_id) && userDetails.getPassword().equals(password) )
		{
			String str = "welcome";
			System.out.println("Welcome " + userDetails.getF_name());
			return str;
			
		} else {
			System.out.println("Invalid Credentials");
		}
		return null;
	}
	
	public void saveUser(UserDetails user) {
		dao.saveUser(user);	
	}
	
	public void deleteUser(int user_id) {
		dao.deleteUser(user_id);
	}

	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = dao.getAllUsers();
		return users;
	}
}
