package com.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{

	List<User> findByUserId(Long userId);

	List<User> findByAddress(String address);
	
}
