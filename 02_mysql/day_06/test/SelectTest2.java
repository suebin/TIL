import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {

	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");

		con = DriverManager.getConnection("jdbc:mysql://192.168.200.146:3306/empdb", 
				"emp2", "emp2");
		System.out.println("연결 성공");
		
		// employees 테이블에서 사번, 이름, 급여, 입사일 조회하되 사번이 100번대 (100 ~ 199)
		String query = "select employee_id, first_name, salary,hire_date "
				       + " from employees where employee_id between ? and ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, 100);
		st.setInt(2, 199);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			System.out.println
			(rs.getInt(1) + " : " + rs.getString(2) + " : " 
			+ rs.getDouble(3) + " : " + rs.getDate(4)	); 

		}
		
		rs.close();

		}catch(ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타 확인");
		}catch(SQLException e) {
			System.out.println("db연결 정보 잘못 확인");
			e.printStackTrace();
		}finally {

			try {
			con.close() ;
			System.out.println("연결 해제 성공");
			}catch(SQLException e) { }
		}

	}

}

