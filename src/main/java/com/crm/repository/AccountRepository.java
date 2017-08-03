package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.domain.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
	
}
