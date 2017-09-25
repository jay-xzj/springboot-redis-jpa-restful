package com.crm.flowdetail.web;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.comm.Result;
import com.crm.comm.ResultGenerator;
import com.crm.comm.cfgdata.base.util.DateUtil;
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
	//4A登录认证
	@ResponseBody
	@PostMapping("/4ASignIn")
    public Result login4A(HttpServletRequest req) throws IOException {
        //Map<String, String> result = new HashMap<String, String>();
        Result result =new Result();
		result.setCode(200);
		result.setMessage("4A Authentication Success");
        //result.put("flag", "true");
        //HttpSession a = req.getSession();
        //result.put("login4aName", (String) req.getSession().getAttribute("user4aname"));
        return result;
    }
	
	@PostMapping("/QueryTotalFlow")
	public Result queryTotalFlow(@RequestBody InputTotalFlowDO req) throws Exception{
		Result result = queryFlowDetailSVImpl.queryTotalFlow(req);
		return result;
	}
	
	
	public static List<Integer> tempOneAppFlowList= new ArrayList<Integer>(Arrays.asList(300,200,460,454,223,34,324,356,767,23,123,345,124,124,235,32,454,24,234,35,123,23,88,97,79,88,23,124,123,35));
	public static List<Integer> tempOneAppHourFlowList= new ArrayList<Integer>(Arrays.asList(30,20,46,45,22,34,32,35,76,23,12,34,124,12,23,32,45,24,23,35,13,23,88,97));

	@PostMapping("/QueryAppFlowTest")
    public Result queryAppFlowTest(@RequestBody InputDayAndHourFlowDO req) throws Exception{
		//Thread.sleep(5000);
		OutputDayAndHourFlowListDO output = new OutputDayAndHourFlowListDO();
		List<OutputDayAndHourFlowDO> outPutList = new ArrayList<OutputDayAndHourFlowDO>();  	
		String nowStr = DateUtil.date2String(new Date(),"yyyyMMdd");
		int count = 0;
		if(Integer.valueOf(nowStr)>20170930){
			count=30;
		}else {
			count =Integer.valueOf(nowStr.substring(6,8))-1;
		}	
		int sum =0;
		if(req.getQUERY_DATE().length()==6) {
			output.setAMOUNT(count);
			for(int i=0;i<30;i++) {
				OutputDayAndHourFlowDO a1 = new OutputDayAndHourFlowDO();
				if(i+1<10) {
					a1.setUSED_DATE("2017090"+String.valueOf(i+1));
					a1.setFLOW(tempOneAppFlowList.get(i));
					sum=sum+tempOneAppFlowList.get(i);
				}
				else if(i+1<=count){
					a1.setUSED_DATE("201709"+String.valueOf(i+1));
					a1.setFLOW(tempOneAppFlowList.get(i));
					sum=sum+tempOneAppFlowList.get(i);
				}else {
					a1.setUSED_DATE("201709"+String.valueOf(i+1));
					a1.setFLOW(null);
				}
				outPutList.add(a1);
			}
			output.setFLOW_TOTAL(sum);

		}
		else if(req.getQUERY_DATE().length()==8) {
			output.setAMOUNT(24);
			for(int i=0;i<24;i++) {
				OutputDayAndHourFlowDO a1 = new OutputDayAndHourFlowDO();
				if(i<10) {
					a1.setUSED_DATE(req.getQUERY_DATE()+"0"+String.valueOf(i));
					a1.setFLOW(tempOneAppHourFlowList.get(i));
					sum=sum+tempOneAppHourFlowList.get(i);
				}
				else {
					a1.setUSED_DATE(req.getQUERY_DATE()+String.valueOf(i));
					a1.setFLOW(tempOneAppHourFlowList.get(i));
					sum=sum+tempOneAppHourFlowList.get(i);
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
		//Thread.sleep(5000);
		OutputTotalFlowDO outPut = new OutputTotalFlowDO();
		String nowStr = DateUtil.date2String(new Date(),"yyyyMMdd");
		int count = 0;
		if(Integer.valueOf(nowStr)>20170930){
			count=30;
		}else {
			count =Integer.valueOf(nowStr.substring(6,8))-1;
		}	
		int sum =0;
		for(int i=0;i<count;i++) {
			sum=sum+tempMonthFlowList.get(i);
		}
		outPut.setALL_FLOW(8192);
		outPut.setFREE_FLOW(sum);		
		outPut.setPAY_FLOW(0);
		outPut.setUSED_FLOW(sum);
		return ResultGenerator.genSuccessResult(outPut);
	}
	
	public static List<Integer> tempMonthFlowList= new ArrayList<Integer>(Arrays.asList(300,200,460,454,223,34,324,356,767,23,123,345,124,124,235,32,454,24,234,35,123,23,88,97,79,88,23,124,123,35));

	@PostMapping("/QueryAllMonthToDayTest")
    public Result queryAllMonthToDayTest(@RequestBody InputAppDayFlowDO req) throws Exception{
		//Thread.sleep(5000);
		OutputDayFlowListDO outPut = new OutputDayFlowListDO();
		String nowStr = DateUtil.date2String(new Date(),"yyyyMMdd");
		int count = 0;
		if(Integer.valueOf(nowStr)>20170930){
			count=30;
		}else {
			count =Integer.valueOf(nowStr.substring(6,8))-1;
		}	
		outPut.setAMOUNT(count);
		int sum = 0;
		
		List<OutputDayFlowDO> flowDayList = new ArrayList<OutputDayFlowDO>(); 
		if(req.getQUERY_DATE().length()==6) {
			for(int i=0;i<30;i++) {
				OutputDayFlowDO a1 = new OutputDayFlowDO();
				if(i+1<10) {
					a1.setDAY("2017090"+String.valueOf(i+1));
					a1.setFLOW_DAY(tempMonthFlowList.get(i));
					sum=sum+tempMonthFlowList.get(i);
				}
				else if(i+1<=count){
					a1.setDAY("201709"+String.valueOf(i+1));
					a1.setFLOW_DAY(tempMonthFlowList.get(i));
					sum=sum+tempMonthFlowList.get(i);
				}else {
					a1.setDAY("201709"+String.valueOf(i+1));
					a1.setFLOW_DAY(null);
				}				
				flowDayList.add(a1);				
			}			
		}
		outPut.setFLOW_DAY_LIST(flowDayList);
		outPut.setFLOW_TOTAL(sum);
		outPut.setFREE_FLOW(sum);
		outPut.setPAY_FLOW(0);
		
    		return ResultGenerator.genSuccessResult(outPut);
    }
	
	
	public static List<String> tempAppList = new ArrayList<String>(Arrays.asList("1-5","5-6","7-10","1-9","7-13","9-11","15-170","15-6","15-70","9-3"));  
	public static List<String> tempAppNameList = new ArrayList<String>(Arrays.asList("QQ","腾讯视频","360手机助手","微信","百度手机助手","工商银行","今日头条","京东","美团","支付宝"));
	public static List<Integer> tempAppFlowList1= new ArrayList<Integer>(Arrays.asList(2048,2000,1800,1600,1400,1200,1024,896,800,512));
	public static List<Integer> tempAppFlowList2= new ArrayList<Integer>(Arrays.asList(500,300,150,120,110,108,106,100,50,46));
	public static List<Integer> tempAppFlowList3= new ArrayList<Integer>(Arrays.asList(50,45,44,38,33,32,26,24,20,19));


	@PostMapping("/QueryTopAppTest")
    public Result queryTopAppTest(@RequestBody InputAppDayFlowDO req) throws Exception{
		//Thread.sleep(5000);
		int count = req.getTOP_AMOUNT();
		OutputNewDayFlowListDO outPut = new OutputNewDayFlowListDO();
		List<OutputNewDayFlowDO> outPutList = new ArrayList<OutputNewDayFlowDO>();    
		if(req.getQUERY_DATE().length()==6) {//月排行
			for(int i =0;i<count;i++) {
				OutputNewDayFlowDO item= new OutputNewDayFlowDO();
				item.setAPP_CODE(tempAppList.get(i));
				item.setAPP_NAME(tempAppNameList.get(i));
				item.setAPP_FLOW(tempAppFlowList1.get(i));
				outPutList.add(item);
		    }
			outPut.setAPP_FLOW_LIST(outPutList);
		}
		if(req.getQUERY_DATE().length()==8) {//日排行
			for(int i =0;i<count;i++) {
				OutputNewDayFlowDO item= new OutputNewDayFlowDO();
				item.setAPP_CODE(tempAppList.get(i));
				item.setAPP_NAME(tempAppNameList.get(i));
				item.setAPP_FLOW(tempAppFlowList2.get(i));
				outPutList.add(item);
		    }
			outPut.setAPP_FLOW_LIST(outPutList);
		}
		if(req.getQUERY_DATE().length()==10) {//时间排行
			for(int i =0;i<count;i++) {
				OutputNewDayFlowDO item= new OutputNewDayFlowDO();
				item.setAPP_CODE(tempAppList.get(i));
				item.setAPP_NAME(tempAppNameList.get(i));
				item.setAPP_FLOW(tempAppFlowList3.get(i));
				outPutList.add(item);
		    }
			outPut.setAPP_FLOW_LIST(outPutList);
		}
			
    		return ResultGenerator.genSuccessResult(outPut);
    }

}
