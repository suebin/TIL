import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. 설치한 mysql driver 호출
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1. db연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
				"emp2", "emp2");//emp2 계정은 모든 db 사용 권한
		System.out.println("연결 성공");
		//member , c_member, c_memo, member_copy
		//c_member 테이블에 데이터 삽입
		// id_jdbc2 2222 김강산 010-4321-4321 kang@tech.com now()
		String sql = "insert into c_member values(?,?,?,?,?, now())";
		PreparedStatement pt = con.prepareStatement(sql);
		//5개 sql 입력파라미터
		pt.setString(1, "id_jdbc2");// jdbc driver - setString 데이터 '' 자동 
		pt.setInt(2, 2222);
		pt.setString(3,  "김강산");
		pt.setString(4,  "010-4321-4322");
		pt.setString(5, "kang@tech.com");
		int rows = pt.executeUpdate();
		System.out.println("삽입행의 갯수=" + rows);
		
		}catch(ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타 확인");
		}catch(SQLException e) {
			System.out.println("db연결 정보 잘못 확인");
			e.printStackTrace();
		}finally {
			//4. db연결해제
			try {
			con.close() ;// mysql 외부 연결 허용 최대치 - 100여개
			System.out.println("연결 해제 성공");
			}catch(SQLException e) { }
		}

	}

}