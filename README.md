# springboot-redis-jpa-restful
一、pom.xml配置


	<groupId>com.example</groupId>
	<artifactId>demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>demo</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.4.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
		<dependency>
        		<groupId>org.springframework.boot</groupId>
        		<artifactId>spring-boot-starter-web</artifactId>
        </dependency>    
        
        <!-- 自动编译加载 -->
        <dependency>
        		<groupId>org.springframework.boot</groupId>
        		<artifactId>spring-boot-devtools</artifactId>
        		<optional>true</optional>
        </dependency> 
        
        <!-- oracle驱动，maven 未提供，需外部引入 -->         
         <dependency>
         	<groupId>com.oracle</groupId>
    			<artifactId>ojdbc6</artifactId>
    			<version>11.2.0</version>
		</dependency>
        
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        
       <!-- redis依赖 --> 
        <dependency>  
    			<groupId>org.springframework.boot</groupId>  
    			<artifactId>spring-boot-starter-redis</artifactId>
    			<version>1.3.1.RELEASE</version>    			  
		</dependency> 
		
		<!-- jpa依赖 -->
		<dependency>
        		<groupId>org.springframework.boot</groupId>
        		<artifactId>spring-boot-starter-data-jpa</artifactId>
   		</dependency>
   		
   		<!-- aop依赖 -->
   		<dependency>
        		<groupId>org.springframework.boot</groupId>
        		<artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        
        <dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-lang3</artifactId>
		    <version>3.4</version>
		</dependency>
		
		<dependency>
    			<groupId>org.springframework.session</groupId>
    			<artifactId>spring-session-data-redis</artifactId>
		</dependency>
                       
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
                		<fork>true</fork>
            		</configuration>
			</plugin>
		</plugins>
	</build>


</project>

二、aop说明，日志输出使用
1、配置依赖：
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-aop</artifactId>
</dependency>

可以看下面关于AOP的默认配置属性，其中spring.aop.auto属性默认是开启的，也就是说只要引入了AOP依赖后，默认已经增加了@EnableAspectJAutoProxy。
# AOP
spring.aop.auto=true 
spring.aop.proxy-target-class=false 

三、数据库连接配置
使用oracle数据库
1、oracle 驱动引入
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar -Dfile=ojdbc6.jar
-- 指定坐标、打包格式、打包文件

2、applicatio.properties配置
spring.datasource.url=jdbc:oracle:thin:@20.26.19.93:1521:CSHP93
spring.datasource.username=scrm
spring.datasource.password=scrm
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

四、JPA持久化
1、引用jar包
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

2、application.properties配置 spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.ORACLEDialect
spring.jpa.show-sql= true

其中，hibernate.hbm2ddl.auto参数的作用主要用于：自动创建|更新|验证数据库表结构,有四个值：
create： 每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
create-drop ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。

validate ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。

dialect 主要是指定生成表名的存储引擎为oracleDialect 
show-sql 是否打印出自动生产的SQL，方便调试的时候查看

3、添加实体类，使用Entity注解，并实现implements Serializable 
Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列

4、JPA查询写法
基本查询
基本查询也分为两种，一种是spring data默认已经实现，一种是根据查询的方法来自动解析成SQL。

五、Redis

1、引入 spring-boot-starter-redis
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-redis</artifactId>  
</dependency>  
2、添加application.properties配置文件

3、实现RedisConfig



六、使用MAVEN构建：
1、在 Eclipse 中运行 Maven 构建：
要在 Eclipse 中运行 Maven 构建，请右键单击 POM 文件并选择 Run As > Maven Build。在 Goals 文本字段中，输入 clean 和 package，然后单击 Run 按钮。
2、 从命令行运行 Maven 构建
要从命令行运行 Maven 构建，请打开 Mac 终端窗口或 Windows 命令提示，导航到 HelloSpringBoot 项目目录，然后执行以下命令：
mvn clean package

七、启动：
1、要运行刚创建的可执行 JAR，请打开 Mac 终端窗口或 Windows 命令提示，导航到 HelloSpringBoot 项目文件夹，然后执行：
java -jar target/HelloSpringBoot-1.0-SNAPSHOT.jar

2、在eclipse中找到主程序application.java,右键run as applications。

SpringApplication类通过main()方法直接启动。大多数情况下，我们可以把项目启动这个任务直接委托给SpringApplication.run方法：
public static void main(String[] args) {
    SpringApplication.run(MySpringConfiguration.class, args);
}






