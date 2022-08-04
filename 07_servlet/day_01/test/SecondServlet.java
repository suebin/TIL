// 1. webServlet 어노테이션으로 url 매핑하기

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second") // 서블릿 url 호출 이름 (url 매핑)
public class SecondServlet extends HttpServlet { // 서블릿 클래스 이름

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("<h1>second Servlet</h1>");
	}

}