package com.crm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行，加载配置问题
 */
@Component
@Order(value=1)
public class StartUp implements CommandLineRunner {
	
    @Override
    public void run(String... args) throws Exception {
        System.out.println("IndexStartupRunner >>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 <<<<<<<<<<<<<");
       
        
    }
    

}
