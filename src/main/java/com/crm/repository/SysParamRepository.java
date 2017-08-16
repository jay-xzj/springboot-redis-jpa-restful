package com.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.comm.domain.SysParam;

public interface SysParamRepository extends JpaRepository<SysParam,Long>{
	
    List<SysParam> findByParamCodeAndParamKey(String paramCode,String paramKey);

}
