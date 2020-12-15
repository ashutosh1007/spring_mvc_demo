package com.aditi.repo;

import com.aditi.model.LoanDetails;
import com.aditi.model.VehicleDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VehicleRepository extends CrudRepository<VehicleDetails, Integer> {

	@Query(value="select * from LoanDetails where application_status = :status", nativeQuery = true)
	List<LoanDetails> fetchLoans(@Param("status") String status);
}
