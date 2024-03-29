# Spring MVC와 MyBatis 프로젝트

## xml 파일

### 0. pom.xml 설정
- mysql-connector-java.jar
- mybatis.jar
- spring-jdbc.jar
- mybatis-spring

```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.29</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis</artifactId>
	<version>3.5.6</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-jdbc</artifactId>
	<version>4.3.18.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis-spring</artifactId>
	<version>1.3.2</version>
</dependency>
```

---

### 1. Spring Bean Configuration File 설정 (spring-mybatis.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

<!-- 1. MyBatis Datasource를 Spring Datasource로 객체 변경 -->
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	<property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
	<property name="url" value="jdbc:mysql://127.0.0.1:3306/memberdb" />
	<property name="username" value="emp2" />
	<property name="password" value="emp2" />
</bean>

<!-- 2. MyBatis 연동 + SQL 매핑 xml (세션을 만들어주는 공장) -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	<property name="dataSource" ref="dataSource" />
	<property name="configLocation" value="classpath:spring/mybatis/mybatis-config.xml" />
	<property name="mapperLocations" value="classpath:spring/mybatis/sql-mapping.xml" />
</bean>

<!-- 3. MyBatise의 SqlSession = Spring의 SqlsessionTemplate (세션 만들기) -->
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
	<constructor-arg ref="sqlSessionFactory" />
</bean>


<!-- spring annotation 인식 패키지 설정 (Main에서 사용) -->
<context:component-scan base-package="spring.mybatis" />

</beans>
```

---

### 2. mybatis-config.xml
- Type Alias 설정

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">


<configuration>

<!-- DTO 객체 Alias 지정 -->
<typeAliases>
	<typeAlias type="spring.mybatis.MemberDTO" alias="memberdto"/>
</typeAliases>

</configuration>
```

---

### 3. web.xml
```xml
<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>
	/WEB-INF/spring/root-context.xml
	classpath:spring/mybatis/spring-mybatis.xml
	</param-value>
</context-param>

<!-- 한글 인코딩 처리 : filter 클래스 (utf-8로 필터링을 해준다.) : 서블릿, jsp, 컨트롤러 DispatcherServlet -->
<filter>
	<filter-name>encoding</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>utf-8</param-value>
	</init-param>
</filter>
<filter-mapping>
	<filter-name>encoding</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

---

### 4. servlet-context.xml

```xml
<!-- Spring MVC Annotation 사용 -->
<context:component-scan base-package="spring.mybatis" />
```
