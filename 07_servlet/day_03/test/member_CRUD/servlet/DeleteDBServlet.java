// servlet file

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/delete")
public class DeleteDBServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		int rows = dao.deleteMember(id, pw); // 1 이상 : 지워진 것 !
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		if (rows >= 1) {
			o.print("<h1> 탈퇴 처리 되었습니다.</h1>");
		}
	}

}
