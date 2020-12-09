package com.aditi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping("/verifyuser/{id}/{password}")
	public String verifyUser(@PathVariable("id") int userid, @PathVariable("password") String password) {
		
		String result = userService.checkUser(userid,password);
		
		return result;
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "User Data Deleted Successfully";
	}
}
