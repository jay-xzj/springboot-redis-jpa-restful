package com.crm.flowdetail.web;

import java.rmi.RemoteException;
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
import com.crm.comm.domain.User;
import com.crm.comm.repository.UserRepository;
import com.crm.comm.service.UserService;
import com.crm.flowdetail.model.InputAppDayFlowDO;
import com.crm.flowdetail.model.InputQueryFlowDetailDO;
import com.crm.flowdetail.service.impl.QueryFlowDetailSVImpl;


@RestController
@RequestMapping("/FlowDetail")
public class FlowDetailController {
	
	@Autowired
	QueryFlowDetailSVImpl queryFlowDetailSVImpl;
		
	@PostMapping("/getTopApp")
    public Result getTopApp(@RequestBody InputAppDayFlowDO req) throws Exception{
    		Result result = queryFlowDetailSVImpl.queryAppFlow(req);
    		return result;
    }
	  

}
