package com.aditi;

import com.aditi.repo.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditi.model.LoanDetails;
import com.aditi.service.LoanService;
import com.aditi.service.UserService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
@ComponentScan("com.aditi")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoanService loanService;

	@Autowired
	private LoanRepository loanrepo;
	
	@RequestMapping("/getallloans/{status}")
	public List<LoanDetails> getAllLoans(@PathVariable("status") String status) {
		System.out.println(status);
		return  loanService.getAllLoans(status);
	}

	@RequestMapping("/set-loan-status/{loan_id}/{status}")
	public HashMap<String, Object> setLoanStatus(@PathVariable("loan_id") int loan_id, @PathVariable("status") String status) {
		LoanDetails loanDetails= loanrepo.findById(loan_id).get();
		loanDetails.setApplication_status(status);
		loanrepo.save(loanDetails);

		HashMap<String, Object> map = new HashMap<>();
		map.put("status", status);

		return map;
		//return  status;
	}

}
