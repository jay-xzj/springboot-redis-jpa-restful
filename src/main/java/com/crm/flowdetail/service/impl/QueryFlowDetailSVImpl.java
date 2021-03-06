package com.crm.flowdetail.service.impl;


import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.cfgdata.base.constant.CustomerConst.CustConst;
import com.crm.cfgdata.base.cache.CfgWsClientCacheService;
import com.crm.cfgdata.base.cache.StaticDataCacheService;
import com.crm.cfgdata.base.domain.BsStaticData;
import com.crm.cfgdata.base.domain.CfgWsClient;
import com.crm.comm.Result;
import com.crm.comm.ResultMsg;
import com.crm.comm.cfgdata.base.util.CollectionsUtil;
import com.crm.comm.cfgdata.base.util.CustHotbusiUtil;
import com.crm.comm.cfgdata.base.util.DateUtil;
import com.crm.comm.cfgdata.base.util.GetterUtil;
import com.crm.comm.cfgdata.base.util.StringUtil;
import com.crm.flowdetail.pojo.InputAppDayFlowDO;
import com.crm.flowdetail.pojo.InputDayAndHourFlowDO;
import com.crm.flowdetail.pojo.InputTotalFlowDO;
import com.crm.flowdetail.pojo.OutputDayAndHourFlowDO;
import com.crm.flowdetail.pojo.OutputDayAndHourFlowListDO;
import com.crm.flowdetail.pojo.OutputDayFlowDO;
import com.crm.flowdetail.pojo.OutputDayFlowListDO;
import com.crm.flowdetail.pojo.OutputNewDayFlowDO;
import com.crm.flowdetail.pojo.OutputNewDayFlowListDO;
import com.crm.flowdetail.pojo.OutputTotalFlowDO;
import com.crm.flowdetail.service.IQueryFlowDetailSV;
import com.crm.comm.exception.ServiceException;
import com.crm.esb.invoke.SoapUtil;
import com.crm.esb.invoke.intercode.ESBInterFaceCode;
import com.crm.esb.invoke.pojo.RespParam;
import com.crm.comm.ResultGenerator;


@Service
public class QueryFlowDetailSVImpl implements IQueryFlowDetailSV{
	
	@Autowired
	private StaticDataCacheService staticDataCacheService;
	
	@Autowired
	private CfgWsClientCacheService cfgWsClientCacheService;

	//查询应用在各日期和小时分布情况（4003）
	public Result queryAppFlow(InputDayAndHourFlowDO inputParam)throws Exception {
			// TODO Auto-generated method stub
			OutputDayAndHourFlowListDO output = new OutputDayAndHourFlowListDO();
			List<OutputDayAndHourFlowDO> outPutList = new ArrayList<OutputDayAndHourFlowDO>();  
			DecimalFormat df = new DecimalFormat("######0"); 
			String queryDate = inputParam.getQUERY_DATE();//查询年月日
			String billId = inputParam.getBILL_ID();//号码
			String appCode = inputParam.getAPP_CODE();
			//String sumType= inputParam.getSUM_TYPE();
			
			String sumType = "";
			
			if(StringUtil.isEmpty(billId)){
				throw new ServiceException(ResultMsg.SOS00000001.getValue());			
			}
			if(StringUtil.isEmpty(queryDate)){
				throw new ServiceException(ResultMsg.SOS00000002.getValue());
			}

			if(queryDate.length()==6){//查询按月，查日
				queryDate+="01";
				sumType = "2";				
			}else {
				sumType = "1";//查小时
			}
			
			if(queryDate.length()>8){//查询按天，查小时
				queryDate=queryDate.substring(0, 8);				
			}
			
					
			String serviceName = ESBInterFaceCode.SRV_ESB_CS_QRY_RECORD_FLOW_002;
	        //String methodName = ESBInterFaceCode.MN_ESB_CS_QRY_RECORD_FLOW_002;
			CfgWsClient cfgWsClient =cfgWsClientCacheService.getObj(serviceName);
	        com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_002.BUSI_INFO busiInfo = new com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_002.BUSI_INFO();
			busiInfo.setBILL_ID(billId);
			busiInfo.setAPP_CODE(appCode);
			busiInfo.setSUM_TYPE(sumType);
			busiInfo.setQUERY_DATE(queryDate);
			RespParam respParam = SoapUtil.invokeMethodForResp(cfgWsClient, busiInfo);
			
			if(respParam.isSuccess()){				
				List<Map<String, Object>> flowAppList = CollectionsUtil.getListBusiInfo(respParam.getBusiInfo(), "FLOW_DAY_LIST","FLOW_DAY_INFO");
				if(flowAppList==null||flowAppList.size()==0) {
					return ResultGenerator.genNoDataResult("查询无数据");
				}
				else {
					Integer flowTotal =0;//各个flow相加
					Integer amount =flowAppList.size();//amount默认为list的size
					OutputDayAndHourFlowDO dayFlow = null;
					Integer count=0;
					Date date =new Date();
					String dateString =DateUtil.date2String(date, "yyyyMMdd");
					
					for(Map map:flowAppList){
						dayFlow = new OutputDayAndHourFlowDO();
						if(sumType.equals("1")){
							dayFlow.setUSED_DATE(GetterUtil.getString(map.get("DAY")).substring(0, 10));
						}else{
							dayFlow.setUSED_DATE(GetterUtil.getString(map.get("DAY")).substring(0, 8));
						}
						String flow = GetterUtil.getString(map.get("FLOW_DAY"));//流量大小，单位为KB
						if(StringUtil.isEmpty(flow)){
							dayFlow.setFLOW(0);
							dayFlow.setFLOW(null);
						}else{
							Integer flowInt = Integer.valueOf(df.format(Double.parseDouble(flow)/1024));//大小单位为MB
							dayFlow.setFLOW(flowInt);
							flowTotal +=flowInt;
						}
						
						
						if(sumType.equals("2")&&dayFlow.getFLOW()==0&&Integer.valueOf(dayFlow.getUSED_DATE()).intValue()>=Integer.valueOf(dateString).intValue()) {
							count =count+1;
							dayFlow.setFLOW(null);							
						}
						
						outPutList.add(dayFlow);
					}

					output.setFLOW_TOTAL(flowTotal);
					output.setAMOUNT(amount-count);
					
					//排个序
					Comparator com = new Comparator(){
						public int compare(Object o1, Object o2) {
							double price1 = Double.parseDouble(((OutputDayAndHourFlowDO)o1).getUSED_DATE().toString());				
							double price2 = Double.parseDouble(((OutputDayAndHourFlowDO)o2).getUSED_DATE().toString());
							if(price1 < price2){
								return -1;
							}else if(price1 == price2){
								return 0;
							}else{
								return 1;
							}
						}
					};
					Collections.sort(outPutList,com);				
					output.setAPP_FLOW_LIST(outPutList);
				}
			}else{
				throw new ServiceException(null!=respParam.getReturnMsg()?respParam.getReturnMsg():"系统异常，请联系系统管理员！");
			}
			
			return ResultGenerator.genSuccessResult(output);
		}
	
	//查询当月应用流量TOP N的APP清单
	public Result queryTopApp(InputAppDayFlowDO inputParam) throws Exception{
			// TODO Auto-generated method stub
			OutputNewDayFlowListDO outPut = new OutputNewDayFlowListDO();
			List<OutputNewDayFlowDO> outPutList = new ArrayList<OutputNewDayFlowDO>();
			DecimalFormat df = new DecimalFormat("######0");  
			
			//String queryDate ="201608";
			String queryDate = inputParam.getQUERY_DATE();//查询年月
			String billId = inputParam.getBILL_ID();//号码
			
			if(StringUtil.isEmpty(billId)){
				throw new ServiceException(ResultMsg.SOS00000001.getValue());
			}
			if(StringUtil.isEmpty(queryDate)){
				throw new ServiceException(ResultMsg.SOS00000002.getValue());
			}
			String startDate = null;
			String endDate = null;
			if(queryDate.length()==10){//查询某小时
				 startDate = queryDate+"0000";
				 endDate = queryDate+"5959";
			}
			if(queryDate.length()==8){//查询某日
				startDate = queryDate+"000000";
				 endDate = queryDate+"235959";
			}
			if(queryDate.length()==6){//查询某月
				int year = Integer.parseInt(queryDate.substring(0, 4));
				int month = Integer.parseInt(queryDate.substring(4, 6));
				int day = DateUtil.getDaysByYearMonth(year,month);
				 startDate = queryDate.substring(0, 4)+queryDate.substring(4, 6)+"01000000";
				 endDate = queryDate.substring(0, 4)+queryDate.substring(4, 6)+String.valueOf(day)+"235959";
			}
			
			String serviceName = ESBInterFaceCode.SRV_ESB_CS_QRY_RECORD_TOPN_001;
	        //String methodName = ESBInterFaceCode.MN_ESB_CS_QRY_RECORD_TOPN_001;
			CfgWsClient cfgWsClient =cfgWsClientCacheService.getObj(serviceName);
	        com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001.BUSI_INFO busiInfo = new com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001.BUSI_INFO();
			busiInfo.setBILL_ID(billId);
			busiInfo.setSTART_DATE(startDate);
			busiInfo.setEND_DATE(endDate);
			if(inputParam.getTOP_AMOUNT()==null||StringUtil.isEmpty(inputParam.getTOP_AMOUNT().toString())){
				busiInfo.setTOP_AMOUNT("10");
			}else{
				busiInfo.setTOP_AMOUNT(inputParam.getTOP_AMOUNT().toString());
			}
			RespParam respParam =SoapUtil.invokeMethodForResp(cfgWsClient,busiInfo);		
			if(respParam.isSuccess()){						
				List<Map<String, Object>> flowAppList = CollectionsUtil.getListBusiInfo(respParam.getBusiInfo(), "APP_FLOW_LIST","APP_FLOW_INFO");
				
				if(flowAppList==null||flowAppList.size()==0) {
					return ResultGenerator.genNoDataResult("查询无数据");
				}
				else{
					OutputNewDayFlowDO dayFlow = null;
					for(Map map:flowAppList){
						dayFlow = new OutputNewDayFlowDO();
						//dayFlow.setIS_SHOW(GetterUtil.getString(map.get("APP_CODE")));//应用编号
						dayFlow.setAPP_CODE(GetterUtil.getString(map.get("APP_CODE")));//应用编号
						dayFlow.setAPP_NAME(GetterUtil.getString(map.get("APP_NAME")));//应用名称
						String flow = GetterUtil.getString(map.get("APP_FLOW"));//流量大小，单位为KB						
						if(StringUtil.isEmpty(flow)){
							dayFlow.setAPP_FLOW(0);
						}else{
							Integer amount = Integer.valueOf(df.format(Double.parseDouble(flow)/1024));//大小单位为MB
							dayFlow.setAPP_FLOW(amount);
						}						
						outPutList.add(dayFlow);
					}
					
					//排个序
					Comparator com = new Comparator(){
						public int compare(Object o1, Object o2) {
							double price1 = Double.parseDouble(((OutputNewDayFlowDO)o1).getAPP_FLOW().toString());				
							double price2 = Double.parseDouble(((OutputNewDayFlowDO)o2).getAPP_FLOW().toString());
							if(price1 > price2){
								return -1;
							}else if(price1 == price2){
								return 0;
							}else{
								return 1;
							}
						}
					};
					Collections.sort(outPutList,com);					
					outPut.setAPP_FLOW_LIST(outPutList);
				}
			}else{
				throw new ServiceException(null!=respParam.getReturnMsg()?respParam.getReturnMsg():"系统异常，请联系系统管理员！");
			}
			
			return ResultGenerator.genSuccessResult(outPut);
		}
	
	//查询每日流量详情--DPI
	public Result queryMonthDPIByDay(InputAppDayFlowDO inputParam)throws Exception {
			// TODO Auto-generated method stub
			Map flowDayMap = new HashMap();
			OutputDayFlowListDO outPut = new OutputDayFlowListDO();
			DecimalFormat df = new DecimalFormat("######0");  			
			List<OutputDayFlowDO> flowDayList = new ArrayList<OutputDayFlowDO>();//每日流量
			
			String queryDate = inputParam.getQUERY_DATE();
			String billId = inputParam.getBILL_ID();
			String sumType = inputParam.getSUM_TYPE();
		
			if(StringUtil.isEmpty(billId)){
				throw new ServiceException(ResultMsg.SOS00000001.getValue());	
			}
			if(StringUtil.isEmpty(queryDate)){
				throw new ServiceException(ResultMsg.SOS00000002.getValue());	
			}
			if(StringUtil.isEmpty(sumType)) {
				sumType = "2";////目前支持天的查询	
			}
			
			if(queryDate.length()>=6){
				queryDate=queryDate.substring(0,6)+"01";
			}else{
				throw new ServiceException(ResultMsg.SOS00000003.getValue());	
			}
	
			String serviceName = ESBInterFaceCode.SRV_ESB_CS_QRY_RECORD_FLOW_001;
	        //String methodName = ESBInterFaceCode.MN_ESB_CS_QRY_RECORD_FLOW_001;
			CfgWsClient cfgWsClient =cfgWsClientCacheService.getObj(serviceName);
			com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_001.BUSI_INFO busiInfo = new com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_001.BUSI_INFO();
			busiInfo.setSUM_TYPE(sumType);
			busiInfo.setBILL_ID(billId);
			busiInfo.setQUERY_DATE(queryDate);
			
			RespParam respParam = SoapUtil.invokeMethodForResp(cfgWsClient, busiInfo);
			
			if(respParam.isSuccess()){
				String flowTotal = respParam.getBusiInfo().get("FLOW_TOTAL")==null?"0":respParam.getBusiInfo().get("FLOW_TOTAL").toString();
				String freeFlow = respParam.getBusiInfo().get("FREE_FLOW")==null?"0":respParam.getBusiInfo().get("FREE_FLOW").toString();
				String payFlow = respParam.getBusiInfo().get("PAY_FLOW")==null?"0":respParam.getBusiInfo().get("PAY_FLOW").toString();
				
				//设置总流量和套餐内流量		
				Integer freeAmount = Integer.valueOf(df.format(Double.parseDouble(freeFlow)/1024));//大小单位为MB
				Integer payAmount = Integer.valueOf(df.format(Double.parseDouble(payFlow)/1024));//大小单位为MB
				Integer totalAmount =Integer.valueOf(df.format(Double.parseDouble(flowTotal)/1024));//大小单位为MB
				outPut.setFLOW_TOTAL(totalAmount);
				outPut.setPAY_FLOW(payAmount);
				outPut.setFREE_FLOW(freeAmount);

				List<Map<String, Object>> flowAppList = CollectionsUtil.getListBusiInfo(respParam.getBusiInfo(), "FLOW_DAY_LIST","FLOW_DAY_INFO");
				
				if(flowAppList==null||flowAppList.size()==0) {
					return ResultGenerator.genNoDataResult("查询无数据");
				}
				else{
					outPut.setAMOUNT(flowAppList.size());
					//设置每日流量，先按天数排序，由小到大
					Comparator com1 = new Comparator(){
						public int compare(Object o1, Object o2) {
							double price1 = Double.parseDouble(((Map)o1).get("DAY").toString());				
							double price2 = Double.parseDouble(((Map)o2).get("DAY").toString());
							if(price1 > price2){
								return 1;
							}else if(price1 == price2){
								return 0;
							}else{
								return -1;
							}
						}
					};
					Collections.sort(flowAppList,com1);
					
					OutputDayFlowDO dayFlow = null;
					
					Integer count=0;
					Date date =new Date();
					String dateString =DateUtil.date2String(date, "yyyyMMdd");
					
					for(Map map:flowAppList){
						String amount = GetterUtil.getString(map.get("FLOW_DAY")) != null?GetterUtil.getString(map.get("FLOW_DAY")):"0";
						dayFlow = new OutputDayFlowDO();
						if(sumType.equals("1")){
							dayFlow.setDAY(GetterUtil.getString(map.get("DAY")).substring(0, 10));
						}else{
							dayFlow.setDAY(GetterUtil.getString(map.get("DAY")).substring(0, 8));
						}
						dayFlow.setFLOW_DAY(Integer.parseInt(String.valueOf(df.format(Double.parseDouble(amount)/1024))));

						//如天数没到，送null
						if(sumType.equals("2")&&dayFlow.getFLOW_DAY()==0&&Integer.valueOf(dayFlow.getDAY()).intValue()>=Integer.valueOf(dateString).intValue()) {
							count =count+1;
							dayFlow.setFLOW_DAY(null);							
						}
						
						flowDayList.add(dayFlow);
					}
				}
					outPut.setFLOW_DAY_LIST(flowDayList);
			}
			else{
				throw new ServiceException(null!=respParam.getReturnMsg()?respParam.getReturnMsg():"系统异常，请联系系统管理员！");
			}			
			return ResultGenerator.genSuccessResult(outPut);			
		}
	
	public Result queryTotalFlow(InputTotalFlowDO inputParam)throws Exception {
		// TODO Auto-generated method stub
		Map flowDayMap = new HashMap();
		OutputTotalFlowDO outPut = new OutputTotalFlowDO();
		DecimalFormat df = new DecimalFormat("######0"); 
		
		//先查询已使用流量
		List<OutputDayFlowDO> flowDayList = new ArrayList<OutputDayFlowDO>();//已使用的每日流量
		
		String queryDate = inputParam.getQUERY_DATE();
		String billId = inputParam.getBILL_ID();
		String sumType = "2";//按天计算
		String queryMonth="";
	
		if(StringUtil.isEmpty(billId)){
			throw new ServiceException(ResultMsg.SOS00000001.getValue());	
		}
		if(StringUtil.isEmpty(queryDate)){
			throw new ServiceException(ResultMsg.SOS00000002.getValue());	
		}
		
		
		if(queryDate.length()>=6){
			queryDate=queryDate.substring(0,6)+"01";
			queryMonth=queryDate.substring(0,6);
			
		}else{
			throw new ServiceException(ResultMsg.SOS00000003.getValue());	
		}

		String serviceName = ESBInterFaceCode.SRV_ESB_CS_QRY_RECORD_FLOW_001;
        //String methodName = ESBInterFaceCode.MN_ESB_CS_QRY_RECORD_FLOW_001;
		CfgWsClient cfgWsClient =cfgWsClientCacheService.getObj(serviceName);
		com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_001.BUSI_INFO busiInfo = new com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_001.BUSI_INFO();
		busiInfo.setSUM_TYPE(sumType);
		busiInfo.setBILL_ID(billId);
		busiInfo.setQUERY_DATE(queryDate);
		
		RespParam respParam = SoapUtil.invokeMethodForResp(cfgWsClient, busiInfo);
		
		if(respParam.isSuccess()){
			
			if(respParam.getBusiInfo().get("FLOW_TOTAL")==null
					&&respParam.getBusiInfo().get("FREE_FLOW")==null
						&&respParam.getBusiInfo().get("PAY_FLOW")==null) {
				return ResultGenerator.genNoDataResult("查询订购总量无数据");
			}
			String flowTotal = respParam.getBusiInfo().get("FLOW_TOTAL")==null?"0":respParam.getBusiInfo().get("FLOW_TOTAL").toString();
			String freeFlow = respParam.getBusiInfo().get("FREE_FLOW")==null?"0":respParam.getBusiInfo().get("FREE_FLOW").toString();
			String payFlow = respParam.getBusiInfo().get("PAY_FLOW")==null?"0":respParam.getBusiInfo().get("PAY_FLOW").toString();
			
			//设置总流量和套餐内流量		//大小单位为MB		
			outPut.setUSED_FLOW(Integer.valueOf(df.format(Double.parseDouble(flowTotal)/1024)));
			outPut.setPAY_FLOW(Integer.valueOf(df.format(Double.parseDouble(payFlow)/1024)));
			outPut.setFREE_FLOW(Integer.valueOf(df.format(Double.parseDouble(freeFlow)/1024)));
		}
		else{
			throw new ServiceException(null!=respParam.getReturnMsg()?respParam.getReturnMsg():"系统异常，请联系系统管理员！");
		}

		//获取免费资源清单
        List<BsStaticData> staticList = staticDataCacheService.getList(CustConst.RTA_ALL_SUM_FREE_CODE);
        if(staticList==null||staticList.size()==0) {
			throw new ServiceException("免费资源清单未配置");
        }
        
		//查询用户订购的流量
		String serviceName2 = ESBInterFaceCode.SRV_ESB_CS_QRY_USED_FREERES_001;
        //String methodName2 = ESBInterFaceCode.MN_ESB_CS_QRY_USED_FREERES_001;
		CfgWsClient cfgWsClient2 =cfgWsClientCacheService.getObj(serviceName2); 
        com.crm.flowdetail.xbeans.esb_cs_qry_used_freeres_001.BUSI_INFO busiInfo2 = 
        		new com.crm.flowdetail.xbeans.esb_cs_qry_used_freeres_001.BUSI_INFO();
        busiInfo2.setBILL_ID(billId);        
        busiInfo2.setQUERY_MONTH(queryMonth);
        busiInfo2.setRELAT_TYPE("1");//个人免费资源
        RespParam respParam2 = SoapUtil.invokeMethodForResp(cfgWsClient2,busiInfo2);
        
        //double flowUsage = 0;
		double maxDataFlow=0;

        if(respParam2.isSuccess()){
	        	List<Map<String,Object>> freeResInfos = CollectionsUtil.getListBusiInfo(respParam2.getBusiInfo(), "FREE_RES_LIST","FREE_RES_INFO");        
	        	if(freeResInfos==null||freeResInfos.size()==0) {
				return ResultGenerator.genNoDataResult("查询已使用总量无数据");
	        	}
	        	else{
	        		for(BsStaticData staticData : staticList){
					String codeValue = staticData.getCodeValue();
					for (Map map: freeResInfos) {
						String accCode = GetterUtil.getString(map.get("ACC_CODE"));
						String accUnit = GetterUtil.getString(map.get("ACC_UNIT"));
						String rollOverFlag = GetterUtil.getString(map.get("ROLLOVER_FLAG"));
						if(codeValue.equals(accCode) && CustHotbusiUtil.isFlowData(accUnit)){
							if ("1".equals(rollOverFlag)) {
//								C.	本月已使用结转流量：
//								条件：ROLLOVER_FLAG = 1
//								公式：本月使用结转流量 = REAL_USE（实际使用数量） - HISTORY_USED（历史使用量）
								//flowUsage += GetterUtil.getDouble(map.get("REAL_USE").toString()) -
										//GetterUtil.getDouble(map.get("HISTORY_USED").toString());
//								B.	历史结转流量 = 本月可使用的结转流量
//								条件：ROLLOVER_FLAG = 1
//								公式：历史结转流量 = FREE_TOTAL（免费数量）- HISTORY_USED（历史使用量）									
								maxDataFlow += GetterUtil.getDouble(map.get("FREE_TOTAL").toString())-
										GetterUtil.getDouble(map.get("HISTORY_USED").toString());
							} else {
								//flowUsage += GetterUtil.getDouble(map.get("REAL_USE").toString());
								maxDataFlow+= GetterUtil.getDouble(map.get("FREE_TOTAL").toString());
							}
						}
					}
				}        		
	        		outPut.setALL_FLOW(Integer.valueOf(df.format(maxDataFlow/1024)));
			}	   	        	
        }else {
			throw new ServiceException(null!=respParam2.getReturnMsg()?respParam2.getReturnMsg():"系统异常，请联系系统管理员！");
        }
		//查询总流量		
		return ResultGenerator.genSuccessResult(outPut);	
	}
	
	//校验手机号码
	public RespParam checkBceRule(String billId,String checkId,String checkType,List<Map> bceList) throws Exception {
			
		String serviceName = ESBInterFaceCode.SRV_ESB_SO_PERSONAL_ORDER_CHECK_003;
		CfgWsClient cfgWsClient =cfgWsClientCacheService.getObj(serviceName);
		
		com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO paramInfo = null;
		com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.BUSI_INFO busiInfo = new com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.BUSI_INFO();
		com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_LIST paramList = new com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_LIST();
		List<com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO> bcelist = new ArrayList<com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO>();
			  
		busiInfo.setBILL_ID(billId);
		busiInfo.setCHECK_ID(checkId);
		busiInfo.setCHECK_TYPE(checkType);
		
		if(bceList!=null&&(bceList.size()>0)){
			for (int i = 0; i < bceList.size(); i++) {
				paramInfo = new com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO();
				paramInfo.setKEY((String) bceList.get(i).get("KEY"));
				paramInfo.setVALUE((String) bceList.get(i).get("VALUE"));
				bcelist.add(paramInfo);
		   }
		}
		  
		if(bcelist!=null&&(bcelist.size()>0)){
			paramList.setPARAM_INFO(bcelist.toArray(new com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO[0]));
		    	busiInfo.setPARAM_LIST(paramList);
		}
		
	    RespParam respParam = SoapUtil.invokeMethodForResp(cfgWsClient, busiInfo);
	    
	    return respParam;
	  
		/*if(respParam.isSuccess()){
        		List<Map<String,Object>> freeResInfos = CollectionsUtil.getListBusiInfo(respParam.getBusiInfo(), "FREE_RES_LIST","FREE_RES_INFO");
		}*/
		
	}
			

}
