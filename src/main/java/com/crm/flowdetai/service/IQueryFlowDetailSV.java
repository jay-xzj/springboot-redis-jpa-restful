package com.crm.flowdetai.service;

import java.rmi.RemoteException;
import java.util.List;

import com.crm.comm.Result;
import com.crm.flowdetail.pojo.InputAppDayFlowDO;
import com.crm.flowdetail.pojo.InputDayAndHourFlowDO;
import com.crm.flowdetail.pojo.InputDayFlowDO;
import com.crm.flowdetail.pojo.InputQueryFlowDetailDO;
import com.crm.flowdetail.pojo.InputVerificationModeDO;




public interface IQueryFlowDetailSV {

	public Result queryAppFlow(InputAppDayFlowDO inputParam)throws Exception;
	
	
}
