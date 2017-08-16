package com.crm.cfgdata.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.cfgdata.base.domain.BsStaticData;

public interface BsStaticDataRepository extends JpaRepository<BsStaticData,Long>{
	
    List<BsStaticData> findByCodeType(String codeType);

}
