package com.crm.flowdetail.web;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.comm.Result;
import com.crm.comm.ResultGenerator;
import com.crm.comm.domain.User;
import com.crm.comm.repository.UserRepository;
import com.crm.comm.service.UserService;
import com.crm.flowdetail.pojo.InputAppDayFlowDO;
import com.crm.flowdetail.pojo.InputDayAndHourFlowDO;
import com.crm.flowdetail.pojo.InputQueryFlowDetailDO;
import com.crm.flowdetail.pojo.InputTotalFlowDO;
import com.crm.flowdetail.pojo.OutputDayAndHourFlowDO;
import com.crm.flowdetail.pojo.OutputDayAndHourFlowListDO;
import com.crm.flowdetail.pojo.OutputDayFlowDO;
import com.crm.flowdetail.pojo.OutputDayFlowListDO;
import com.crm.flowdetail.pojo.OutputNewDayFlowDO;
import com.crm.flowdetail.pojo.OutputNewDayFlowListDO;
import com.crm.flowdetail.pojo.OutputTotalFlowDO;
import com.crm.flowdetail.service.impl.QueryFlowDetailSVImpl;


@RestController
@RequestMapping("/FlowDetail")
public class FlowDetailController {
	
	@Autowired
	QueryFlowDetailSVImpl queryFlowDetailSVImpl;
		
	@PostMapping("/QueryTopApp")
    public Result queryTopApp(@RequestBody InputAppDayFlowDO req) throws Exception{
    		Result result = queryFlowDetailSVImpl.queryTopApp(req);
    		return result;
    }
	
	@PostMapping("/QueryAppFlow")
    public Result queryAppFlow(@RequestBody InputDayAndHourFlowDO req) throws Exception{
    		Result result = queryFlowDetailSVImpl.queryAppFlow(req);
    		return result;
    }
	
	@PostMapping("/QueryAllMonthToDay")
    public Result queryAllMonthToDay(@RequestBody InputAppDayFlowDO req) throws Exception{
    		Result result = queryFlowDetailSVImpl.queryMonthDPIByDay(req);
    		return result;
    }
	
	@PostMapping("/QueryTotalFlow")
	public Result queryTotalFlow(@RequestBody InputTotalFlowDO req) throws Exception{
		Result result = queryFlowDetailSVImpl.queryTotalFlow(req);
		return result;
	}
	
	@PostMapping("/QueryAppFlowTest")
    public Result queryAppFlowTest(@RequestBody InputDayAndHourFlowDO req) throws Exception{
		Thread.sleep(5000);
		OutputDayAndHourFlowListDO output = new OutputDayAndHourFlowListDO();
		List<OutputDayAndHourFlowDO> outPutList = new ArrayList<OutputDayAndHourFlowDO>();  	
		output.setFLOW_TOTAL(1024);
		if(req.getQUERY_DATE().length()==6) {
			output.setAMOUNT(11);
			for(int i=1;i<=30;i++) {
				OutputDayAndHourFlowDO a1 = new OutputDayAndHourFlowDO();
				if(i<10) {
					a1.setUSED_DATE("2017090"+String.valueOf(i));
					a1.setFLOW(50);
				}
				else if(i<=11){
					a1.setUSED_DATE("201709"+String.valueOf(i));
					a1.setFLOW(100);
				}else {
					a1.setUSED_DATE("201709"+String.valueOf(i));
					a1.setFLOW(null);
				}
				outPutList.add(a1);
			}
			
		}
		else if(req.getQUERY_DATE().length()==8) {
			output.setAMOUNT(24);
			for(int i=0;i<=23;i++) {
				OutputDayAndHourFlowDO a1 = new OutputDayAndHourFlowDO();
				if(i<10) {
					a1.setUSED_DATE("201709100"+String.valueOf(i));
					a1.setFLOW(24);
				}
				else {
					a1.setUSED_DATE("20170910"+String.valueOf(i));
					a1.setFLOW(50);
				}
				outPutList.add(a1);
			}
			
		}
		else {
			outPutList=null;
		}
		output.setAPP_FLOW_LIST(outPutList);
		return ResultGenerator.genSuccessResult(output);
    }
	
	@PostMapping("/QueryTotalFlowTest")
	public Result queryTotalFlowTest(@RequestBody InputTotalFlowDO req) throws Exception{
		Thread.sleep(5000);
		OutputTotalFlowDO outPut = new OutputTotalFlowDO();
		outPut.setALL_FLOW(4096);
		outPut.setFREE_FLOW(1024);
		outPut.setPAY_FLOW(0);
		outPut.setUSED_FLOW(1024);
		return ResultGenerator.genSuccessResult(outPut);
	}
	
	@PostMapping("/QueryAllMonthToDayTest")
    public Result queryAllMonthToDayTest(@RequestBody InputAppDayFlowDO req) throws Exception{
		Thread.sleep(5000);
		OutputDayFlowListDO outPut = new OutputDayFlowListDO();
		outPut.setAMOUNT(11);
		outPut.setFLOW_TOTAL(1024);
		outPut.setFREE_FLOW(1024);
		outPut.setPAY_FLOW(0);
		List<OutputDayFlowDO> flowDayList = new ArrayList<OutputDayFlowDO>(); 
		if(req.getQUERY_DATE().length()==6) {
			for(int i=1;i<=30;i++) {
				OutputDayFlowDO a1 = new OutputDayFlowDO();
				if(i<10) {
					a1.setDAY("2017090"+String.valueOf(i));
					a1.setFLOW_DAY(50);
				}
				else if(i<=11){
					a1.setDAY("201709"+String.valueOf(i));
					a1.setFLOW_DAY(100);
				}else {
					a1.setDAY("201709"+String.valueOf(i));
					a1.setFLOW_DAY(null);
				}
				flowDayList.add(a1);
			}			
		}
		outPut.setFLOW_DAY_LIST(flowDayList);
		
    		return ResultGenerator.genSuccessResult(outPut);
    }
	
	public static List<String> tempAppList = new ArrayList<String>(Arrays.asList("1-5","5-6","7-10","1-9","7-13","9-11","15-170","15-6","15-70","9-3"));  
	public static List<String> tempAppNameList = new ArrayList<String>(Arrays.asList("QQ","腾讯视频","360手机助手","微信","百度手机助手","工商银行","今日头条","京东","美团","支付宝"));
	public static List<Integer> tempAppFlowList= new ArrayList<Integer>(Arrays.asList(2048,2000,1800,1600,1400,1200,1024,896,800,512));
 

	@PostMapping("/QueryTopAppTest")
    public Result queryTopAppTest(@RequestBody InputAppDayFlowDO req) throws Exception{
		Thread.sleep(5000);
		OutputNewDayFlowListDO outPut = new OutputNewDayFlowListDO();
		List<OutputNewDayFlowDO> outPutList = new ArrayList<OutputNewDayFlowDO>();    
		if(req.getQUERY_DATE().length()==6||req.getQUERY_DATE().length()==8||req.getQUERY_DATE().length()==10) {//月排行
			for(int i =0;i<10;i++) {
				OutputNewDayFlowDO item= new OutputNewDayFlowDO();
				item.setAPP_CODE(tempAppList.get(i));
				item.setAPP_NAME(tempAppNameList.get(i));
				item.setAPP_FLOW(tempAppFlowList.get(i));
				outPutList.add(item);
		    }
			outPut.setAPP_FLOW_LIST(outPutList);
		}
			
    		return ResultGenerator.genSuccessResult(outPut);
    }

}
