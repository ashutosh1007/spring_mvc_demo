package com.aditi.repo;

import com.aditi.model.EmployeeDetails;
import com.aditi.model.LoanDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<EmployeeDetails, Integer> {

	@Query(value="select * from LoanDetails where application_status = :status", nativeQuery = true)
	List<LoanDetails> fetchLoans(@Param("status") String status);
}
