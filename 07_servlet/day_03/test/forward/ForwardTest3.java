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

import dto.MemberDTO;

// 한 사람의 정보를 담은 MemberDTO 객체를 forward4로 전송

@WebServlet("/forward3")
public class ForwardTest3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 5개 입력
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		// MemberDTO 객체로 만들기
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(Integer.parseInt(pw));
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		dto.setRegdate("2022-08-08");
		
		// dispatch를 이용한 포워딩 
		request.setAttribute("dto", dto);
		RequestDispatcher rd = request.getRequestDispatcher("forward4"); // 다른 서블릿으로도 전송 가능
		rd.forward(request, response); 
	
	}

}
