// 2. web.xml로 url 매핑하기

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// http://localhost:8080/servlettest/ThirdServlet : 404 error
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().println("<h1>third Servlet</h1>");
	}

}


/*
 
  web.xml의 <web-app></web-app> 안에 아래와 같이 작성한다.

  <servlet>
  	<servlet-name>t</servlet-name>
  	<servlet-class>third.ThirdServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>t</servlet-name>
  	<url-pattern>/third</url-pattern>
  </servlet-mapping>

*/