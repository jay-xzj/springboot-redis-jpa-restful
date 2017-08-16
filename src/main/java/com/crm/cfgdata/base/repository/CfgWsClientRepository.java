package com.crm.cfgdata.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.cfgdata.base.domain.CfgWsClient;

public interface CfgWsClientRepository extends JpaRepository<CfgWsClient,Long>{
	
    List<CfgWsClient> findByCfgWsClientCode(String cfgWsClientCode);

}
