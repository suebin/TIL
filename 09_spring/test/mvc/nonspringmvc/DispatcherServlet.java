package nonspringmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Front Controller
@WebServlet("/") // 뒤에 어떤 것이 와도 가능하다는 뜻이다.
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 서버 진입 대문
		String uri = request.getRequestURI();
		String uri_array[] = uri.split("/");
		String result = uri_array[uri_array.length-1];
		
		HandlerMapping mappings = new HandlerMapping(); // put("hello", ...)
		Controller con = mappings.getController(result);
		String viewname = con.handleAndRequest(request, response); // hello.jsp를 리턴한다.
		
		// 포워딩
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);
	}

}
