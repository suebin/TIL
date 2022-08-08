// servlet file

package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forward2")
public class ForwardTest2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//String id = (String)request.getAttribute("upperid"); // object 타입이라서 string으로 형 변환
		//id = id.toUpperCase();
	
		String id = (String)request.getAttribute("upperid");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print("forward2에서 호출 ==> " + id + "회원님 반갑습니다.");
		
		
	}

}

