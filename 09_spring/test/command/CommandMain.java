package command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("command/command.xml");
		
		// BoardCommand 타입을 지정해주는 것이다. 
		Command c1 = factory.getBean(BoardCommand.class, "board"); // Command c1 = (Command)factory.getBean("board");
		Command c2 = factory.getBean(MemberCommand.class, "member");
		Command c3 = factory.getBean(ProductCommand.class, "product");

		c1.run();
		c2.run();
		c3.run();
		
	}
}
