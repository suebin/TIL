import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	/*
	GET방식, POST방식 모두 처리하고 싶다면
	GET/POST 방식을 따로 구별하지 않는	service() 메서드를 사용해도 된다.
	하지만, doGet(), doPost() 따로 만들어주자!
	 */

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 방식에서는 한글이 깨지기 때문에 인코딩을 꼭 해야한다.
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답하기 위한 세팅 과정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 웹 브라우저에 출력
		
		System.out.println(request.getMethod()); // " 요청 방식 "을 console에 출력
		System.out.println(request.getRemoteAddr()); // " 요청 클라이언트 IP "를 console에 출력
		
		
		String user = request.getParameter("user");
		System.out.println(user);  // " user(요청자 이름) "를 console에 출력
		
		// 클라이언트 요청 받기
		String su1_str = request.getParameter("su1");
		String su2_str = request.getParameter("su2");
		
		
		/*
		
		교재 211p 실습 예제1 : 유효성 검사
		
		if, else를 이용해서
		su1과 su2의 값이 null이거나 공백인 경우 다시 입력하라는 링크를 띄우고, 
		아닌 경우 그대로 잘 실행시킨다. 
		
		*/
		
		if(su1_str == null || su1_str.equals("") || su2_str == null || su2_str.equals("")) {
			// 웹 브라우저에 출력
			out.println("<h1><a href='calc.html'>다시 입력하기</a></h1>");
		}
		else {

		int su1 = Integer.parseInt(su1_str);
		int su2 = Integer.parseInt(su2_str);
	
		// 클라이언트 요청 받기
		String op = request.getParameter("op");
		
		// 비즈니스 로직 처리
		String result="";
		
		if (op.equals("+")) {
			result = su1 + op + su2 + "=" + (su1+su2);
		}
		else if (op.equals("-")) {
			result = su1 + op + su2 + "=" + (su1-su2);
		}
		else if (op.equals("*")) {
			result = su1 + op + su2 + "=" + (su1*su2);
		}
		else if (op.equals("/")) {
			result = su1 + op + su2 + "=" + (su1/su2);
		}
		else if (op.equals("%")){
			result = su1 + op + su2 + "=" + (su1%su2);
		}
		else {
			result = "지원하지 않는 연산자입니다.";
		}
		
		// 웹 브라우저에 출력
		out.println("<h1>" + result + "</h1>");
		
		}
	}
}