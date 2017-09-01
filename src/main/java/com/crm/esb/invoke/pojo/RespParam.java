package com.crm.esb.invoke.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.crm.cfgdata.base.constant.SCRMConstants;
import com.crm.comm.cfgdata.base.util.StringUtil;



@SuppressWarnings("serial")
public class RespParam implements Serializable {
    private Map<String,Object> busiInfo;
    private Map<String,String> pubInfo;
    public RespParam(){
        this.busiInfo = new HashMap<String,Object>();
        this.pubInfo = new HashMap<String,String>();
    }
    
    public Map<String, Object> getBusiInfo() {
       return busiInfo;
    }
    public Map<String, Object> busiInfo2Map() {
        if(StringUtil.isBlank(busiInfo)) return new HashMap<String,Object>();
        return (Map<String, Object>) busiInfo.get(SCRMConstants.EsbConstant.BUSI_INFO);
    }
    
    @SuppressWarnings("unchecked")
	public void setBusiInfo(Map<String, Object> busiInfo) {
    	Map<String, Object> retBusinfo = this.busiInfo;
    	if(busiInfo!=null&busiInfo.size()!=0){
    		retBusinfo = (Map<String, Object>) busiInfo.get(SCRMConstants.EsbConstant.BUSI_INFO);
    	}
        this.busiInfo = retBusinfo;
    }
    
    public Map<String, String> getPubInfo() {
        return pubInfo;
    }
    public void setPubInfo(Map<String, String> pubInfo) {
        this.pubInfo = pubInfo;
    }
    
    public boolean isSuccess(){
        String strRetCode = getReturnCode();
        	if(StringUtil.isBlank(strRetCode)) {
        		return false;
        	}        
        int retCode = Integer.parseInt(strRetCode);
        if(SCRMConstants.EsbConstant.ESB_SUCCESS_CODE.equals(String.valueOf(retCode))) return true;
        return false;
    }
    
    public String getReturnMsg(){
        return pubInfo.get(SCRMConstants.EsbConstant.RESULT_MSG);
    }
    public String getReturnMsg(String defaultMsg){
        String retMsg = getReturnMsg();
        if(StringUtil.isEmpty(retMsg)) {
        	retMsg = defaultMsg;
        }
        return retMsg;
    }
    
    /*public String getAsString(String key){
        Object objString = getBusiInfo().get(key);
        return ObjectUtil.obj2String(objString);
    }*/
    
    public String getReturnCode(){
        return pubInfo.get(SCRMConstants.EsbConstant.RESULT_CODE);
    }
}
