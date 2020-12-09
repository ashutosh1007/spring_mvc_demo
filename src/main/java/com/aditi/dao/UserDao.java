package com.aditi.dao;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aditi.model.Login;
import com.aditi.model.UserDetails;
import com.aditi.repo.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userrepo;
	
	public void saveUser(UserDetails user) {
		/*
		 * if(loginrepo.existsById(login.getUserid())) {
		 * System.out.println("User Already Exists"); } else {
		 */
		userrepo.save(user);
		System.out.println("Saved");
		//}
	}
	
	public void deleteUser(int user_id) {
		userrepo.deleteById(user_id);
		System.out.println("User Deleted Successfully");
	}

	public UserDetails getUser(int user_id) {
		Optional<UserDetails> loginOpt = userrepo.findById(user_id);
	
		boolean res = loginOpt.isPresent();
		UserDetails userDetails = null;
		if(res) {
			userDetails = loginOpt.get();
		}
		System.out.println(userDetails);
		return userDetails;
	}

	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = userrepo.findAll();
		return users;
	}
}
