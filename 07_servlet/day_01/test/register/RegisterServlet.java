import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/servlettest/register 뒤에 "?id=servlet" 붙여주면 바로 id가 보인다.
// 따라서 입력한 id에 따라 id 값이 달라진다!
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청을 받아오기
		// HttpServletRequest : http 요청 정보 객체
		
		// 하나의 값 : request.getParameter
		String name = request.getParameter("name");
		
		// 여러 개의 값 (배열) : request.getParameterValues
		String subject[] = request.getParameterValues("subject"); // 대표적인 예 : select의 multiple, input의 type=checkbox 일 때
		
		if (name == null || name.equals("")) { 
			name = "입력되지 않은 사용자"; 
		}
		if (subject == null || subject.length == 0) { 
			subject[0] = "열리지 않은"; 
		}
		
		
		// 2. 처리 결과 : 자바 구현 (ex) 파일 입출력, JDBC)
		
		// 3. 결과 응답 : 서버 출력 (클라이언트 입력)
		response.setContentType("text/html;charset=utf-8"); // 브라우저 인코딩 - 서블릿 인코딩
		PrintWriter out = response.getWriter();
		out.println("<h1>" + name.toUpperCase() +" 회원님! ");
		// 반복문
		for (int i=0; i < subject.length; i++) {
			out.println(subject[i]+", ");
		}
		out.println(" 과정을 선택하셨습니다. </h1>");
		
	}

}
