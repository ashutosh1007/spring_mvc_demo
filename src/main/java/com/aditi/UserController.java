package com.aditi;

import java.util.HashMap;
import java.util.List;

//import org.apache.catalina.User;
import com.aditi.model.*;
import com.aditi.repo.EmployeeRepository;
import com.aditi.repo.LoanRepository;
import com.aditi.repo.UserRepository;
import com.aditi.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aditi.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userrepo;

	@PostMapping(path ="/save",consumes="application/json")
	@CrossOrigin
	public int saveUser(@RequestBody UserDetails user) {
		user.setRole("User");
		userService.saveUser(user);		
		System.out.println(user);
		return 1;
	}
	
	@RequestMapping("/verifyuser/{email_id}/{password}")
	public HashMap<String, Object> verifyUser(@PathVariable("email_id") String email_id, @PathVariable("password") String password) {
		return userService.checkUser(email_id,password);
	}
	
	@RequestMapping("/getallusers")
	public List<UserDetails> getAllUsers() {	
		List<UserDetails> users = userService.getAllUsers();
		return users;	
	}

	@PostMapping(path= "/apply-loan",consumes="application/json")
	public int applyLoan(@RequestBody LoanApplication loanApplication) {

		LoanDetails loanDetails = new LoanDetails(
				loanApplication.getLoan_amount(),
				loanApplication.getLoan_tenure(),
				loanApplication.getRoi(),
				loanApplication.getEmi(),
				loanApplication.getAccount_type(),
				5000,
				"Applied",
				"OK",
				loanApplication.getUser_id()
		);
		loanRepository.saveAndFlush(loanDetails);
		loanRepository.flush();
		loanDetails=loanRepository.findAll().get(loanRepository.findAll().size()-1);
		System.out.println(loanDetails.getLoanid());

		VehicleDetails vehicleDetails = new VehicleDetails(
				loanApplication.getVehicle_company(),
				loanApplication.getVehicle_model(),
				loanApplication.getEx_showroom_price(),
				loanApplication.getOn_road_price(),
				loanDetails.getLoanid()
		);
		vehicleRepository.save(vehicleDetails);

		EmployeeDetails employeeDetails = new EmployeeDetails(
				loanApplication.getCompany_name(),
				loanApplication.getMonthly_income(),
				loanApplication.getWork_experience(),
				loanApplication.getType_of_emp(),
				loanApplication.getExisting_emi(),
				loanApplication.getUser_id()
		);
		employeeRepository.save(employeeDetails);
		return loanDetails.getLoanid();
	}
	
	@RequestMapping("/get-details/{user_id}")
	public UserDetails getDetails(@PathVariable("user_id") int  user_id) {
		return  userrepo.findById(user_id).get();
	}

	@RequestMapping("/getallloans/{user_id}")
	public List<LoanDetails> getAllLoans(@PathVariable("user_id") int user_id) {
		return loanRepository.fetchLoansByUserid(user_id);
	}

}
