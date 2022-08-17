package nonspringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public String handleAndRequest(HttpServletRequest request, HttpServletResponse response) {
		// model 생성
		HelloDTO dto = new HelloDTO();
		
		// model 값 저장
		dto.setMessage("Cotroller가 jsp로 전달하는 model입니다.");
		
		request.setAttribute("model", dto);
		
		// view name
		return "hello.jsp";
	}

}
