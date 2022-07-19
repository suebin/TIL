import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		con = DriverManager.getConnection("jdbc:mysql://192.168.200.146:3306/memberdb", 
				"emp2", "emp2");
		System.out.println("연결 성공");

		Scanner sc = new Scanner(System.in);
		System.out.print("아이디는 : "); 
		String id = sc.next(); 
		System.out.print("수정할 이름은 : ");
		String name = sc.next();
		System.out.print("수정할 폰번호는 : "); // unique
		String phone = sc.next();
		System.out.print("수정할 이메일은 : ");// unique, @ 포함
		String email = sc.next();
		
		String query = "update c_MEMBER "
				+ " set NAME=?, PHONE=?, EMAIL=? "
				+ "	WHERE ID=?";
		/* 삭제는 ? : delete from 테이블명 where id=? and regdate=? */
		//2-2 sql 저장-전송
		PreparedStatement st = con.prepareStatement(query);
		
		st.setString(1, name);
		st.setString(2, phone);
		st.setString(3, email);
		st.setString(4, id);
		
		
		int rowcount = st.executeUpdate();
		System.out.println("수정행의 갯수=" + rowcount);
		
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