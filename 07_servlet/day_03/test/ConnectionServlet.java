// servlet file

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {		
			// DB연결 1000개
			
			/* 기존 DB 연결 : 16초 소요
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			long start = System.currentTimeMillis();
			
			for(int i=1; i<=1000; i++){
				Connection conn = DriverManager.getConnection
						("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
				System.out.println(i+"번째 mysql 연결 성공");
				conn.close();
			} 
			
			long stop = System.currentTimeMillis();
			System.out.println((stop-start)/1000 + "초 소요");
			*/
			
			
			
			// DataSource = connection pooling 클래스 톰캣 제공 사용 : 0초 소요 !
			
			// 1. context.xml 파일에서 정의한 내용을 읽어 올 준비
			Context initContext = new InitialContext();
			
			// 2. <Resource /> 이름 태그 설정 정보 읽기
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // java - component - environment 파일
			
			// 3. jdbc/mydb 태그만 읽어와서 connection pooling 클래스 객체 생성 (name만 다르면 얼마든지 <Resource /> 여러개 만들 수 o)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			
			// tomcat 시작할 때 미리 생성 : 배열 형태로 관리 (빌려주고 반납하는 것을 반복)
			long start = System.currentTimeMillis();
			
			for (int i=1; i<=1000; i++) {
			Connection conn = ds.getConnection(); // 미리 생성한 conn 빌려온다.
			System.out.println(i+"번째 mysql 연결 성공");
			conn.close(); // conn 반납
			}
			
			long stop = System.currentTimeMillis();
			System.out.println((stop-start)/1000 + "초 소요");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}