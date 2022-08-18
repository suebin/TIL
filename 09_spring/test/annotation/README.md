annotation을 사용하면 훨씬 코드가 간결해진다.

<br>

>
>`springmvc 패키지`와 `annotation.springmvc` 패키지는 동일한 기능을 한다. <br>
>다만, `springmvc` 패키지는 annotation을 사용하지 않았고, `annotation.springmvc 패키지`는 annotation을 사용하였다. 
>
>jsp파일은 동일하다.
>
<br>

1. 톰캣 서버 실행하고 `http://localhost:8080/test/login`을 들어가면, 로그인 입력 창이 뜬다(loginform.jsp) 
2. 입력하고, 로그인 버튼을 누르면 입력값이 POST방식으로 loginresult.jsp로 전달되어 출력된다.

<br>


#### 1. springmvc
- annotation을 사용하지 않고, `servlet-context.xml`에 아래 내용을 추가하여 작성
```xml
<!-- spring mvc HandlerMapping hello-HelloController() 객체 생성) -->

<beans:bean id="hello" class="springmvc.HelloController"/>
<beans:bean id="list" class="springmvc.ListController"/>
<beans:bean id="form" class="springmvc.LoginFormController"/>
<beans:bean id="result" class="springmvc.LoginResultController"/>

<beans:bean id="urlMapping" class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
	<beans:property name="mappings">
		<beans:props>
			<beans:prop key="/hello">hello</beans:prop>
			<beans:prop key="/list">list</beans:prop>
			<beans:prop key="/loginform">form</beans:prop>
			<beans:prop key="/loginresult">result</beans:prop>
		</beans:props>
	</beans:property>
</beans:bean>
```

#### 2. annotation.springmvc
- `servlet-context.xml`에 아래 내용을 추가 후, annotation을 사용하여 작성
```xml
<context:component-scan base-package="annotation.springmvc" />
```

