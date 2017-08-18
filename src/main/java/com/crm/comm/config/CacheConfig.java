package com.crm.comm.config;


import java.util.Map;

public interface CacheConfig {
	//public Map<String,Object> getMap();
    //public Object getMap(String key);
    //public void addMaps(Object object);
    //public boolean refreshOne(Object object);
    public void refreshAll();
}
