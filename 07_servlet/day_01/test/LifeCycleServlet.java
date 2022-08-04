import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	// 서버 시작 후 현재 서블릿 최초 1번 호출 실행
	
	// LifeCycleServlet ser = new LifeCycleServlet(); 톰캣 서버 자동으로 !
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행(수정)");
		// Class.forName("mysql driver"); 처럼 최초의 한 번만 세팅하면 되는 것을 init 메서드가 하면 좋다.
	}

	// 서버 시작 후 현재 서블릿 메모리 삭제 시점 실행
	public void destroy() {
		System.out.println("destroy 실행");
	}
	
	// 서버 시작 후 현재 서블릿 여러번 호출시마다 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 실행"); // 서버 콘솔 출력
		response.getWriter().println("<h1>Life Cycle Servlet</h1>"); // 요청 브라우저 출력
	}

}

// doGet 메서드는 필수 !
// int, destroy 메서드는 필요할 때만 사용하고, 필수 X