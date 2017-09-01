package com.crm.flowdetai.service;

import java.rmi.RemoteException;
import java.util.List;

import com.crm.comm.Result;
import com.crm.flowdetail.model.InputAppDayFlowDO;
import com.crm.flowdetail.model.InputDayAndHourFlowDO;
import com.crm.flowdetail.model.InputDayFlowDO;
import com.crm.flowdetail.model.InputQueryFlowDetailDO;
import com.crm.flowdetail.model.InputVerificationModeDO;




public interface IQueryFlowDetailSV {

	public Result queryAppFlow(InputAppDayFlowDO inputParam)throws Exception;
	
	
}
