package com.aditi;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aditi.model.Login;
import com.aditi.model.UserDetails;
import com.aditi.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/save",consumes="application/json")
	@CrossOrigin
	public String saveUser(@RequestBody UserDetails user) {
		userService.saveUser(user);
		System.out.println(user);
		
		/*
		 * System.out.println(login); ModelMap map = new ModelMap();
		 * map.addAttribute("id", login.getUserid()); map.addAttribute("pwd",
		 * login.getPassword()); */
		//return new ModelAndView("Data Saved");
		
		return "User Data Saved";	 
	}
	
	@RequestMapping(value="/verifyuser/{id}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String verifyUser(@PathVariable("id") int userid, @PathVariable("password") String password) {
		
		String result = userService.checkUser(userid,password);
		return "Welcome";
		
	}
	
	@RequestMapping("/getallusers")
	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = userService.getAllUsers();
		return users;
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "User Data Deleted Successfully";
	}
}
