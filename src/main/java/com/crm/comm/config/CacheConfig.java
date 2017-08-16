package com.crm.comm.config;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.crm.comm.domain.SysParam;
import com.crm.repository.SysParamRepository;


@Component
public class CacheConfig {
	
	private HashMap<String,HashMap<String,String>>maps = new HashMap<String,HashMap<String,String>>();
	
    @Autowired
    private SysParamRepository sysParamRepository;
    
    public HashMap<String,HashMap<String,String>> getHashMap(){
    		return maps;
    }
    
    public void init() {
    		 maps.clear();
    	 	 List<SysParam> sysParamList = sysParamRepository.findAll();  
         for(SysParam sysParam : sysParamList){ 
      	   		String sysCode = sysParam.getParamCode();
      	   		String sysKey = sysParam.getParamKey();
      	   		String sysValue = sysParam.getParamValue();       	   		
      	   		addMaps(sysCode,sysKey,sysValue);
          }
    }

    public String getValue(String code,String key){
    		//map为空，从数据库读取
        if(maps.isEmpty()){
        		init();
        }      
        if(maps.containsKey(code)) {
        		HashMap<String,String> sysmap=maps.get(code);
        		return sysmap.get(key);
        }
        else {
        		return null;
        }
               
    }

    //是否存在，无则加入map
    public void addMaps(String code, String key,String value){
    		if(maps.containsKey(code)) {
   			HashMap<String,String> sysmap = maps.get(code);
   			sysmap.put(key,value);
   		}
   		else {
   			HashMap<String,String> tmpmap = new HashMap<String,String>();
   			tmpmap.put(key, value);
   			maps.put(code, tmpmap);
   		}
    }
    
    public boolean isMapExist(String code, String key){
    		if(maps.containsKey(code)) {
   			HashMap<String,String> sysmap = maps.get(code);
   			if(sysmap.containsKey(key)) {
   				return true;
   			}else {
   				return false;
   			}
   		}
   		else {
   			return false;
   		}
    }
    
    //加入数据库
    public void addToData(SysParam sysParam) {
    		List<SysParam> sysParamList = sysParamRepository.findByParamCodeAndParamKey(sysParam.getParamCode(), sysParam.getParamKey());
    		if (sysParamList!=null&&sysParamList.size()!=0) {
    			
    		}
    		else {
    			sysParamRepository.save(sysParam);
    		}
    		
    }
    

}
