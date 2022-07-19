import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// set 할 필요가 없기 때문에 만들 수는 있지만 굳이 큰 차이가 없다.
public class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");

		con = DriverManager.getConnection("jdbc:mysql://192.168.200.146:3306/memberdb", 
				"emp2", "emp2");
		System.out.println("연결 성공");
		
		String query = "select id, "
				+ "insert(password, 1, length(password), repeat('*', length(password))) 암호, "
				+ "name, phone, email, "
				+" date_format(regdate, '%y/%m/%d %h시%i분%s초') 가입일 from member";
		
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {

			System.out.println
			(rs.getString(1) + " : " + " : " + rs.getString("암호") + " : " 
			+ rs.getString("name") +" : "
			 + rs.getString("phone") + ":" + rs.getString("email") + ":"
			 + rs.getString("가입일")		); 


		}
		
		rs.close();

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
