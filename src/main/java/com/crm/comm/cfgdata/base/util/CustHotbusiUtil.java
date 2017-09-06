/*
 * Copyright (c) 2012-2014 by Asiainfo Linkage
 * All rights reserved.
 * $Id: CustHotbusiUtil.java 23847 2015-03-19 07:54:09Z guoyu $
 */
package com.crm.comm.cfgdata.base.util;


import com.asiainfo.utils.StringUtil;


/**
 * @User: mayc
 * @Date: 2014年7月4日
 * @Time: 下午4:07:28
 * @version $Revision: 23847 $ $Date: 2015-03-19 15:54:09 +0800 (周四, 19 三月 2015) $
 */
public class CustHotbusiUtil {
    
    
    public static String[] FLOWUNITS = {"b","kb","mb","gb","tb","pb","eb","zb","yb","bb","m","g","t","p","e","z","y"};
    public static boolean isFlowData(String accUnit){
    	if(StringUtil.isNotBlank(accUnit)){
    		for(String unit:FLOWUNITS){
        		if(unit.equalsIgnoreCase(accUnit)) return true;
        	}	
    	}
    	return false;	
    }
    
}
