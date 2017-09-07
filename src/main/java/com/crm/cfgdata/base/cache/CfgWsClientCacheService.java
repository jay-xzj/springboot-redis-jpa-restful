package com.crm.cfgdata.base.cache;

import java.util.HashMap;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.cfgdata.base.domain.CfgWsClient;
import com.crm.cfgdata.base.repository.CfgWsClientRepository;
import com.crm.comm.config.CacheConfig;


@Component
public class CfgWsClientCacheService implements CacheConfig {
	
	private HashMap<String,Object>maps = new HashMap<String,Object>();
    @Autowired
    private  CfgWsClientRepository cfgWsClientRepository;
    
    //获取缓存的数据结构
    public HashMap<String,Object> getMap(){
    		return this.maps;
    }
    
    
    //根据ClientCode获取对象
    public CfgWsClient getObj(String key){
    	    if(StringUtils.isBlank(key)) {
    	    		return null;
    	    }
        if(maps.isEmpty()){
           refreshAll();
        }
        if(null == maps.get(key)){
            return null;
        }
        return  (CfgWsClient) maps.get(key);
    }

    
    //添加缓存
    public void addMaps(CfgWsClient cfgWsClient){
    		addToMaps(cfgWsClient);
        cfgWsClientRepository.save(cfgWsClient);
    }
    
    //刷新缓存
    public boolean refreshOne(CfgWsClient cfgWsClient){
        if(StringUtils.isNotBlank(cfgWsClient.getCfgWsClientCode())){
        		addToMaps(cfgWsClient);
            return true;
        }
        return false;
    }
    
    //从数据库读取
    public void refreshAll(){
        maps.clear();
        List<CfgWsClient> cfgWsClientList= cfgWsClientRepository.findAll();
        if(cfgWsClientList!=null) {
	        for(CfgWsClient cfgWsClient : cfgWsClientList){        		
	        		addToMaps(cfgWsClient);
	        		//System.out.println(bsStaticData.getCodeType() +"|"+bsStaticData.getCodeValue());
	        }	       
        }
    }

	
    //加入maps
    public void addToMaps(CfgWsClient cfgWsClient){
    		String clientCode = cfgWsClient.getCfgWsClientCode();
    		if(StringUtils.isNotBlank(clientCode)) {
    			maps.put(clientCode, cfgWsClient);  			
   		}
    	}
    
}
