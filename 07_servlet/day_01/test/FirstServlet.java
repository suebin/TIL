import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/servlettest/first.FirstServlet 
@WebServlet("/f")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<h1>title</h1>");	
	}

}

// 1. 자바 서블릿 클래스 정의 규칙
// 2. 컴파일 : 이클립스가 자동으로 해준다!
// 3. 실행 : run as -> run on server -> 브라우저 실행 결과