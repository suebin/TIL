// servlet file

package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forward1")
public class ForwardTest1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		id = id.toUpperCase();
		
		//forward 전 출력문장 "무시"
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print("forward1에서 호출 ==> " + id + "회원님 반갑습니다.");
		
		// dispatch를 이용한 포워딩 !
		request.setAttribute("upperid", id);
		request.setAttribute("DTO", dto객체);
		
		RequestDispatcher rd = request.getRequestDispatcher("forward2");
		
		rd.forward(request, response); // print 삭제 후, forward 동작
		
		// rd.include(request, response); // jsp
		
		// forward 이후 콘솔 출력 o
		System.out.println("이건 출력되나요?");
	
	}

}