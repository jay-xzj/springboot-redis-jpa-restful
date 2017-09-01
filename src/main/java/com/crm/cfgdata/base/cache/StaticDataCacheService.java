package com.crm.cfgdata.base.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.cfgdata.base.domain.BsStaticData;
import com.crm.cfgdata.base.repository.BsStaticDataRepository;
import com.crm.comm.config.CacheConfig;



@Component
public class StaticDataCacheService implements CacheConfig {
	
	private HashMap<String,HashMap<String,Object>>maps = new HashMap<String,HashMap<String,Object>>();
    @Autowired
    private  BsStaticDataRepository bsStaticDataRepository;
    
    //获取缓存的数据结构
    public HashMap<String,HashMap<String,Object>> getMap(){
    		return this.maps;
    }
    
    //根据CodeType获取List
    public List<BsStaticData> getList(String key){
    		if(StringUtils.isBlank(key)) {
    			return null;
    		}
        if(maps.isEmpty()){
           refreshAll();
        }
        if(null == maps.get(key)){
            return null;
        }
        HashMap<String,Object> tmpmap= maps.get(key);       
        List<BsStaticData> list =new ArrayList();        
        for (Map.Entry entry : tmpmap.entrySet()) {           	  
        		BsStaticData data = (BsStaticData) entry.getValue();   
        		list.add(data);
        }       
        return list;
    }
    
    //根据codeType和CodeValue获取对象
    public BsStaticData getObj(String key,String code){
    	    if(StringUtils.isBlank(key)||StringUtils.isBlank(code)) {
    	    		return null;
    	    }
        if(maps.isEmpty()){
           refreshAll();
        }
        if(null == maps.get(key)){
            return null;
        }
        return  (BsStaticData) maps.get(key).get(code);
    }

    
    //添加缓存
    public void addMaps(BsStaticData bsStaticData){
    		addToMaps(bsStaticData);
        bsStaticDataRepository.save(bsStaticData);
    }
    
    //刷新缓存
    public boolean refreshOne(BsStaticData bsStaticData){
        if(StringUtils.isNotBlank(bsStaticData.getCodeType())){
        		addToMaps(bsStaticData);
            return true;
        }
        return false;
    }
    
    //从数据库读取
    public void refreshAll(){
        maps.clear();
        List<BsStaticData> bsStaticDataList= bsStaticDataRepository.findAll();
        if(bsStaticDataList!=null) {
	        for(BsStaticData bsStaticData : bsStaticDataList){        		
	        		addToMaps(bsStaticData);
	        		//System.out.println(bsStaticData.getCodeType() +"|"+bsStaticData.getCodeValue());
	        }	       
        }
    }

	
    //加入maps
    public void addToMaps(BsStaticData bsStaticData){
    		String codeType = bsStaticData.getCodeType();
    		String codeValue = bsStaticData.getCodeValue();
    		if(StringUtils.isNotBlank(codeType)) {
    			if(maps.containsKey(codeType)) {
	    			HashMap tmpmap = maps.get(codeType);
	    			if(StringUtils.isNotBlank(codeValue)){
	    				tmpmap.put(codeValue, bsStaticData);
	    				maps.put(codeType, tmpmap);
	    			}
    			}
   		   else {
   			   if(StringUtils.isNotBlank(codeValue)) {
   				   HashMap<String,Object> tmpmap = new HashMap<String,Object>();
   				   tmpmap.put(codeValue, bsStaticData);
   				   maps.put(codeType, tmpmap);
   			   }
   		   }
    		}
    }
}
