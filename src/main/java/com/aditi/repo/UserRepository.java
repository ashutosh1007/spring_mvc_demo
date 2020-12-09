package com.aditi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer>{

}
