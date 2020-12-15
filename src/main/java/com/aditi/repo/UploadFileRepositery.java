package com.aditi.repo;

import com.aditi.model.EmployeeDetails;
import com.aditi.model.LoanDetails;
import com.aditi.model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UploadFileRepositery extends JpaRepository<UploadFile, Integer> {

}
