package com.crm.flowdetail.web;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

}
