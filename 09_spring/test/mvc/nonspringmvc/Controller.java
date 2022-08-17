package nonspringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트 요청을 분석해서 처리하고, DispatcherServlet에게 전달한다.
public interface Controller {
	public String handleAndRequest(HttpServletRequest request, HttpServletResponse response);	
}
