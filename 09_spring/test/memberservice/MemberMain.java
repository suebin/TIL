package memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String args[]) {
		// 스프링에게 bean 생성을 부탁한다. (member.xml)
		ApplicationContext factory = new ClassPathXmlApplicationContext("memberservice/member.xml");
		
		MemberService service = (MemberService)factory.getBean("service");
		service.registerMember();
		
	}
}
