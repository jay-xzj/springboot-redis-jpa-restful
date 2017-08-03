package com.crm.comm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class JdbcTests {
	
	@Test
	public void test() {
		
		Connection connection = getConnection();
		String a="";
	    if (connection != null) {  
	        a ="连接oracle数据库成功:" + connection;  
	    } else {  
	        a="连接oracle数据库失败!!!";  
	    }  
	   System.out.println(a);
	}
	
	//驱动，URL，用户名，密码  
    private static final String driver = "oracle.jdbc.driver.OracleDriver";  
    private static final String url = "jdbc:oracle:thin:@20.26.19.93:1521:CSHP93"; 
    private static final String username = "scrm";  
    private static final String password = "scrm";  
  
    public static Connection getConnection() {  
        Connection connection = null;  
        try {  
            // 加 载驱动  
            Class.forName(driver).newInstance();  
            // 通过驱动管理类获取数据库连接  
            connection = DriverManager.getConnection(url, username, password);  
            // 关闭连接  
            connection.close();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return connection;  
    }  
  
}
