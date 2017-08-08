# 总体说明
1、采用spring boot搭建web服务，提供restful的接口。<br>
2、数据库驱动采用的oracle jdbc。<br>
3、后台缓存使用redis。<br>
4、持久化使用jpa，减少dao层代码。<br>
5、AOP实现logAdvice，自定义输出日志。<br>
6、错误代码，异常信息等进行了统一处理。<br>
7、使用maven进行构建。<br>

ps.一些测试用的test可忽略<br>

# 数据库连接配置
使用oracle数据库，版权问题maven库不包含，需要自行安装。<br>
1、oracle 驱动引入<br>
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar -Dfile=ojdbc6.jar<br>
-- 指定坐标、打包格式、打包文件<br>

2、applicatio.properties配置<br>
spring.datasource.url=jdbc:oracle:thin:@20.26.19.93:1521:CSHP93<br>
spring.datasource.username=scrm<br>
spring.datasource.password=scrm<br>
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver<br>


# JPA持久化
1、pom.xml配置<br>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

2、application.properties配置 <br>

spring.jpa.properties.hibernate.hbm2ddl.auto=update<br>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.ORACLEDialect<br>
spring.jpa.show-sql= none<br>

其中，hibernate.hbm2ddl.auto参数的作用主要用于：自动创建|更新|验证数据库表结构,有四个值：<br>
create： 每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。<br>
create-drop ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。<br>
validate ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。<br>
dialect 主要是指定生成表名的存储引擎为oracleDialect <br>
show-sql 是否打印出自动生产的SQL，方便调试的时候查看<br>

3、添加实体类，使用Entity注解，并实现implements Serializable <br>
Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列<br>

4、JPA查询的写法<br>
（1）spring data jpa 默认预先生成了一些基本的CURD的方法，例如：增、删、改等等<br>
 继承JpaRepository<br>
public interface UserRepository extends JpaRepository<User, Long> {
}
（2）使用默认方法，比如<br>
@Test<br>
public void testBaseQuery() throws Exception {<br>
	User user=new User();<br>
	userRepository.findAll();<br>
	userRepository.findOne(1l);<br>
	userRepository.save(user);<br>
	userRepository.delete(user);<br>
	userRepository.count();<br>
	userRepository.exists(1l);<br>
	// ...
}
（3）自定义简单查询<br>
自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：<br>
User findByUserName(String userName);<br>
也使用一些加一些关键字And、 Or<br>
User findByUserNameOrEmail(String username, String email);<br>
修改、删除、统计也是类似语法<br>
Long deleteById(Long id);<br>
Long countByUserName(String userName)<br>
基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy。<br>
List<User> findByEmailLike(String email);<br>
User findByUserNameIgnoreCase(String userName);    <br>
List<User> findByUserNameOrderByEmailDesc(String email);<br>


# 使用AOP，自定义日志输出

1、pom.xml配置依赖：<br>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-aop</artifactId>
</dependency>

2、application.properties配置<br>
AOP的默认配置属性，其中spring.aop.auto属性默认是开启的，也就是说只要引入了AOP依赖后，默认已经增加了@EnableAspectJAutoProxy。<br>
spring.aop.auto=true <br>
spring.aop.proxy-target-class=false <br>

3、具体使用AOP实现的日志代码参看LogAdivce.java<br>

# Redis
需提前安装redis<br>
1、引入 spring-boot-starter-redis<br>
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-redis</artifactId>  
</dependency>  
2、添加application.properties配置，配置redis的参数<br>

3、实现RedisConfig<br>

# 使用MAVEN构建
需安装maven。<br>
1、pom.xml配置<br>
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

2、构建方法有两种<br>
（1）在 Eclipse 中运行 Maven 构建：<br>
要在 Eclipse 中运行 Maven 构建，请右键单击 POM 文件并选择 Run As > Maven Build。在 Goals 文本字段中，输入 clean 和 package，然后单击 Run 按钮。<br>
（2） 从命令行运行 Maven 构建<br>
要从命令行运行 Maven 构建，请打开 Mac 终端窗口或 Windows 命令提示，导航到项目所在目录，然后执行以下命令：<br>
mvn clean package<br>


# 启动：
1、要运行刚创建的可执行 JAR，请打开 Mac 终端窗口或 Windows 命令提示，导航到项目文件夹，然后执行：<br>
java -jar target/demo-1.0-SNAPSHOT.jar<br>

2、在eclipse中找到主程序application.java,右键run as applications。<br>

SpringApplication类通过main()方法直接启动。大多数情况下，我们可以把项目启动这个任务直接委托给SpringApplication.run方法：<br>
public static void main(String[] args) {<br>
    SpringApplication.run(MySpringConfiguration.class, args);<br>
}<br>






