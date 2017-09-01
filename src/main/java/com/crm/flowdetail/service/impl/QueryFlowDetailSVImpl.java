package com.crm.flowdetail.service.impl;


import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.crm.comm.Result;
import com.crm.comm.ResultMsg;
import com.crm.comm.cfgdata.base.util.CollectionsUtil;
import com.crm.comm.cfgdata.base.util.DateUtil;
import com.crm.comm.cfgdata.base.util.GetterUtil;
import com.crm.comm.cfgdata.base.util.StringUtil;
import com.crm.flowdetai.service.IQueryFlowDetailSV;
import com.crm.flowdetail.model.InputAppDayFlowDO;
import com.crm.flowdetail.model.InputQueryFlowDetailDO;
import com.crm.flowdetail.model.OutputNewDayFlowDO;
import com.crm.flowdetail.model.OutputNewDayFlowListDO;
import com.crm.flowdetail.model.OutputQueryFlowDetailDO;

import com.crm.comm.exception.ServiceException;
import com.crm.esb.invoke.SoapUtil;
import com.crm.esb.invoke.intercode.ESBInterFaceCode;
import com.crm.esb.invoke.pojo.RespParam;
import com.crm.comm.ResultGenerator;


@Service
public class QueryFlowDetailSVImpl implements IQueryFlowDetailSV{

	/*@Override
	//查询上网日志
	public Result queryFlowDetail(InputQueryFlowDetailDO inputParam) {
		// TODO Auto-generated method stub
		OutputQueryFlowDetailDO outPut = new OutputQueryFlowDetailDO();
		DecimalFormat df = new DecimalFormat("######0.00");  
		
		String billId = inputParam.getBillId();//手机号码
		String startDate = inputParam.getStartDate();//开始时间
		String endDate = inputParam.getEndDate();//结束时间
		String pageIndex = inputParam.getPageIndex();//页码
		String pageSize = inputParam.getPageSize();//每页数量
		
		if(StringUtil.isEmpty(billId)){
			ExceptionUtil.throwBusinessException("SOS0000000", "手机号码不能为空");
		}
		if(StringUtil.isEmpty(startDate) || StringUtil.isEmpty(endDate)){
			ExceptionUtil.throwBusinessException("SOS0000000", "查询时间不能为空");
		}

		String serviceName = ESBInterFaceCode.SRV_ESB_CS_QRY_RECORD_ONLINELOG_001;
        String methodName = ESBInterFaceCode.MN_ESB_CS_QRY_RECORD_ONLINELOG_001;
		com.asiainfo.scrm.module.res.flowdetail.xbeans.esb_cs_qry_record_onlinelog_001.BUSI_INFO busiInfo = new com.asiainfo.scrm.module.res.flowdetail.xbeans.esb_cs_qry_record_onlinelog_001.BUSI_INFO();
		busiInfo.setBILL_ID(billId);
		busiInfo.setSTART_DATE(startDate);
		busiInfo.setEND_DATE(endDate);
		busiInfo.setPAGE_NUM(pageIndex);
		busiInfo.setPAGE_COUNT(pageSize);
		RespParam respParam = EsbSoapUtil.invokeMethod(serviceName, methodName, busiInfo);
		
		if(respParam.isSuccess()){
			outPut.setRESULT_COUNT(respParam.getBusiInfo().get("COUNT")==null?"0":respParam.getBusiInfo().get("COUNT").toString());
			
			List<Map<String, Object>> flowList = CollectionsUtil
					.getListBusiInfo(respParam.getBusiInfo(), "FLOW_DETAIL_LIST",
							"FLOW_DETAIL_INFO");
			
			if(null != flowList && flowList.size()>0){
				List<QueryFlowDetailDO> list = new ArrayList<QueryFlowDetailDO>();
				QueryFlowDetailDO qryFlow = null;
				for(Map map:flowList){
					qryFlow = new QueryFlowDetailDO();
					String ip = GetterUtil.getString(map.get("HOST"));
					if(StringUtil.isNotEmpty(ip) && "\\N".equals(ip)){
						ip = "";
					}
					qryFlow.setHOURS(GetterUtil.getString(map.get("USED_DATE")));//使用时段
					qryFlow.setFIRST_APPLY(GetterUtil.getString(map.get("APP_TYPE")));//应用大类
					qryFlow.setSECOND_APPLY(GetterUtil.getString(map.get("APP_SUB_TYPE")));//应用小类
					qryFlow.setIP(ip);//应用域名
					qryFlow.setFLOW(df.format(Double.parseDouble(GetterUtil.getString(map.get("FLOW")))/1024));//流量大小
					list.add(qryFlow);
				}
				
				outPut.setFLOW_LIST(list);
			}
			
		}else{
			ExceptionUtil.throwBusinessException("SOS0000000", null!=respParam.getReturnMsg()?respParam.getReturnMsg():"系统异常，请联系系统管理员！");
		}
		return outPut;
	}*/
	
	//查询当月应用流量TOP N的APP清单
	public Result queryAppFlow(InputAppDayFlowDO inputParam) throws Exception{
			// TODO Auto-generated method stub
			OutputNewDayFlowListDO outPut = new OutputNewDayFlowListDO();
			List<OutputNewDayFlowDO> outPutList = new ArrayList<OutputNewDayFlowDO>();
			DecimalFormat df = new DecimalFormat("######0");  
			DecimalFormat df1 = new DecimalFormat("######0.00");   
			
			//String queryDate ="201608";
			String queryDate = inputParam.getQUERY_DATE();//查询年月
			String billId = inputParam.getBILL_ID();//号码
			String flowTotal = "";
	
			
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
	        String methodName = ESBInterFaceCode.MN_ESB_CS_QRY_RECORD_TOPN_001;
	        com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001.BUSI_INFO busiInfo = new com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001.BUSI_INFO();
			busiInfo.setBILL_ID(billId);
			busiInfo.setSTART_DATE(startDate);
			busiInfo.setEND_DATE(endDate);
			if(StringUtil.isEmpty(inputParam.getTOP_AMOUNT())){
				busiInfo.setTOP_AMOUNT("5");
			}else{
				busiInfo.setTOP_AMOUNT(inputParam.getTOP_AMOUNT());

			}
			//busiInfo.setTOP_AMOUNT("5");
			RespParam respParam =SoapUtil.invokeMethodForResp(serviceName,busiInfo);
			
			if(respParam.isSuccess()){
				
				List<Map<String, Object>> flowAppList = CollectionsUtil
						.getListBusiInfo(respParam.getBusiInfo(), "APP_FLOW_LIST",
								"APP_FLOW_INFO");
				if(null != flowAppList && flowAppList.size()>0){
					OutputNewDayFlowDO dayFlow = null;
					for(Map map:flowAppList){
						dayFlow = new OutputNewDayFlowDO();
						//dayFlow.setIS_SHOW(GetterUtil.getString(map.get("APP_CODE")));//应用编号
						dayFlow.setAPP_CODE(GetterUtil.getString(map.get("APP_CODE")));//应用编号
						dayFlow.setNAME(GetterUtil.getString(map.get("APP_NAME")));//应用名称
						String flow = GetterUtil.getString(map.get("APP_FLOW"));//流量大小，单位为KB
						String percent = GetterUtil.getString(map.get("APP_PERCENT"));//百分比
						if(StringUtil.isEmpty(flow)){
							dayFlow.setPERCENT("0");
							dayFlow.setAMOUNT("0.00");
						}else{
							String amount = String.valueOf(df1.format(Double.parseDouble(flow)/1024));//大小单位为MB
							dayFlow.setPERCENT(percent);
							dayFlow.setAMOUNT(amount);
						}
						
						outPutList.add(dayFlow);
					}
					
					//排个序
					Comparator com = new Comparator(){
						public int compare(Object o1, Object o2) {
							double price1 = Double.parseDouble(((OutputNewDayFlowDO)o1).getAMOUNT().toString());				
							double price2 = Double.parseDouble(((OutputNewDayFlowDO)o2).getAMOUNT().toString());
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
					
					outPut.setFLOW_APPLY_LIST(outPutList);
				}
			}else{
				throw new ServiceException(null!=respParam.getReturnMsg()?respParam.getReturnMsg():"系统异常，请联系系统管理员！");
			}
			
			return ResultGenerator.genSuccessResult(outPut);
		}

}
