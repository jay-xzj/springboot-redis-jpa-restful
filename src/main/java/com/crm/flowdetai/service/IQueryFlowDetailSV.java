package com.crm.flowdetai.service;



import com.crm.comm.Result;
import com.crm.flowdetail.pojo.InputAppDayFlowDO;
import com.crm.flowdetail.pojo.InputDayAndHourFlowDO;





public interface IQueryFlowDetailSV {

	public Result queryTopApp(InputAppDayFlowDO inputParam)throws Exception;
	public Result queryAppFlow(InputDayAndHourFlowDO inputParam)throws Exception;
	public Result queryMonthDPIByDay(InputAppDayFlowDO inputParam)throws Exception;

	
}
