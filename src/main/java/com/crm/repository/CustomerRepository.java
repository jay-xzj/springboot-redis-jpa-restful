package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
}
