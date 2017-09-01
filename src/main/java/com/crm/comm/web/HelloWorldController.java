package com.crm.comm.web;

/*import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import com.crm.cfgdata.base.cache.CfgWsClientCacheService;
import com.crm.cfgdata.base.cache.StaticDataCacheService;
import com.crm.cfgdata.base.domain.BsStaticData;
import com.crm.cfgdata.base.domain.CfgWsClient;
import com.crm.cfgdata.base.repository.BsStaticDataRepository;
import com.crm.comm.Const;
import com.crm.comm.config.CacheConfig;
import com.crm.comm.domain.SysParam;
import com.crm.comm.domain.User;
import com.crm.comm.log.LoggerManage;
import com.crm.comm.repository.SysParamRepository;
import com.crm.esb.invoke.WsClient;
import com.crm.esb.invoke.XStreamUtil;*/


@RestController
public class HelloWorldController {
		
	
	@RequestMapping("/hello")
    public String Hello() {
        return "Hello World Debug";
    }
	
	
	/*@RequestMapping("/getUser")
    public User getUser() {
    		User user=new User();
    		user.setUsername("小明");
    		user.setPassword("xxxx");
        return user;
    }
	
	@Value("${com.demo.title}")
	private String title;
	@Value("${com.demo.description}")
	private String description;
	
	@RequestMapping("/getUserProperties")
    public User getUserProperties() {	
		User  demoProperties = new User();
		demoProperties.setPassword(description);
		demoProperties.setUsername(title);
		return demoProperties;
    }
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/getJdbcTest")
    public String getJdbcTest() {		
	    String sql = "select count(1) from aiscrm_collect_busi";
	    Integer ret =jdbcTemplate.queryForObject(sql, Integer.class);
	    return ret.toString();
    }
	
	@RequestMapping("/getUserKey")
	@Cacheable(value="user-key",keyGenerator = "keyGenerator")
	public String getUserKey() {
		String user = getJdbcTest();
	    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	    return user;
	}
	
	
	@RequestMapping("/getConst")
	public String getConst() {		
	    return Const.BASE_PATH;
    }
	@Autowired
	private SysParamRepository sys;
	@RequestMapping("/getSysParam")
	public List<SysParam> getSysParam(){		
		return sys.findByParamCodeAndParamKey("b1","a1");
	}
	
	@Autowired
	private StaticDataCacheService a;
	@RequestMapping("/getHashMap1")
	public List<BsStaticData> getSysParam1(){	
		return a.getList("CM_ACCOUNT_PAY_METHOD");	
	}
	
	@RequestMapping("/getHashMap2")
	public BsStaticData getSysParam2(){	
		return a.getObj("CM_ACCOUNT_PAY_METHOD", "1");
	}
	
	@RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
	@Autowired
	private  BsStaticDataRepository bsStaticDataRepository;;
	@RequestMapping("/testFindAll")
	public List<BsStaticData> testFindAll(){	
		return bsStaticDataRepository.findAll();
	}
	
	
	@Autowired
	private  CfgWsClientCacheService cfgWsClientCacheService;
	@RequestMapping("/getCache")
	public CfgWsClient getCache(){	
		return cfgWsClientCacheService.getObj("ESB_CS_QRY_MULTI_MULTIQRY_001");
	}
   
	@RequestMapping("/getEsb")	
	public String getEsb(){
		com.crm.esb.invoke.xbeans.BUSI_INFO busiInfo = new com.crm.esb.invoke.xbeans.BUSI_INFO();
		busiInfo.setBILL_ID("13566369050");
		String returnValue="";
		try{
			CfgWsClient cfgWsClient = new CfgWsClient();
			cfgWsClient =cfgWsClientCacheService.getObj("ESB_CS_QRY_MULTI_MULTIQRY_001");
			WsClient client = new WsClient(cfgWsClient);
			String reqXml = null;
		    //TODO LOG相关，时间戳
			//Timestamp startTime = ServiceManager.getIdGenerator().getSysDate();
			//long beginTime = System.currentTimeMillis();
			try {
				reqXml = XStreamUtil.getEsbReqXml(busiInfo);
				returnValue = (String)client.invoke(new Object[] {reqXml});
			} catch (Exception e) {
				returnValue=e.getMessage();
				throw new Exception(e);
			}
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		System.out.print(returnValue);
		return returnValue;
	}*/

}
