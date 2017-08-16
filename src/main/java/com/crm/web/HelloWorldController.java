package com.crm.web;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.comm.Const;
import com.crm.comm.config.CasheConfig;
import com.crm.comm.domain.SysParam;
import com.crm.comm.domain.User;
import com.crm.repository.SysParamRepository;
import com.crm.comm.log.LoggerManage;


@RestController
public class HelloWorldController {
		
	
	@RequestMapping("/hello")
    public String Hello() {
        return "Hello World Debug";
    }
	
	
	@RequestMapping("/getUser")
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
	private CasheConfig a;
	@RequestMapping("/getHashMap1")
	public String getSysParam1(){	
			return a.getValue("1", "1");
	}
	
	@RequestMapping("/getHashMap2")
	public String getSysParam2(){	
		HashMap<String,HashMap<String,String>> b =a.getHashMap();
		return b.get("1").toString();
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


}
