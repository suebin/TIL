import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	// Member 테이블 CRUD

	// DataSource
	public ArrayList<MemberDTO> selectAllMember() {
		Connection conn = null;
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();

		try {
			// 1.context.xml 파일에 정의한 내용을 읽어오기
			Context initContext = new InitialContext();

			// 2. <Resource> 태그의 설정을 읽어오기
			Context envContext = (Context) initContext.lookup("java:/comp/env");// java - component - environment파일

			// 3. jdbc/mydb 설정 태그만 읽어와서 connection pooling 클래스 객체를 생성하기
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
			
			// 4.
			conn = ds.getConnection();

			String sql = "select * from member";
			PreparedStatement pt = conn.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				// dto.setPassword(rs.getInt("password"));//insert(password, 0, repeat('*', 10)
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));// date_format(regdate, '%Y%m%d")
				dto.getRegdate().substring(0, 10);
				memberlist.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();// connectionpool로 반납(null..)
			} catch (SQLException e) {
			}
		}
		return memberlist;
	}// SELECTALLMEMBER

	// DataSource
	public int selectMember(String id, String userpassword) {
		Connection conn = null;
		int condition = 0;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
			conn = ds.getConnection();
			
			System.out.println(conn);
			
			String sql = "select id, password from member where id=?";// member 테이블 id 컬럼 pk
			
			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			ResultSet rs = pt.executeQuery();
			// sql 실행 결과 여러개 레코드 검색되거나 1개 검색 --> 1번째 레코드 조회
			// sql 실행 결과 0개 검색

			String dbid = null, dbpassword = null;
			if (rs.next()) {
				condition = 1; // id 존재한다
				dbid = rs.getString("id");
				dbpassword = rs.getString("password");
				// id 존재하고 pw 동일하다
				if (dbpassword.equals(userpassword)) {
					condition = 2;
				}
			} else {
				// id 존재하지 않는다
				condition = 3;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();// 메모리정리시간.
			} catch (SQLException e) {
			}
		}
		return condition;
	}

	// 기존 DB 연결 방법
	public int insertMember(MemberDTO dto) {
		Connection conn = null;
		int condition = 0;// insert한 행의 갯수
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
			String sql = "insert into member values(?,?,?,?,?,now())";
			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, dto.getId());
			pt.setInt(2, dto.getPassword());
			pt.setString(3, dto.getName());
			pt.setString(4, dto.getPhone());
			pt.setString(5, dto.getEmail());
			condition = pt.executeUpdate();
			/*
			 * dto 값 getter , regdate컬럼입력값 - now() insert into member
			 * values(?,?,?,?,?,now())
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return condition;
	} // insertMember end
	
	// DataSource
	public int deleteMember(String id, String pw) {
		Connection conn = null;
		int condition = 0;// delete한 행의 갯수
		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
			conn = ds.getConnection();

			String sql = "delete from member where id=? and password=?";
			
			PreparedStatement pt = conn.prepareStatement(sql);
			
			pt.setString(1, id);
			pt.setInt(2, Integer.parseInt(pw));
			
			condition = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return condition;
	} // deleteMember end
	
	// DataSource
	public MemberDTO updateMember(MemberDTO dto) {
		
		Connection conn = null;
		
		int condition = 0; // update한 행의 개수
		
		MemberDTO return_dto = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
			conn = ds.getConnection();
			
			String sql = "update member set name=?, phone=?, email=? where id=? and password=?";
			
			PreparedStatement pt = conn.prepareStatement(sql);

			pt.setString(1, dto.getName());
			pt.setString(2, dto.getPhone());
			pt.setString(3, dto.getEmail());
			pt.setString(4, dto.getId());
			pt.setInt(5, dto.getPassword());
			
			condition = pt.executeUpdate();
			
			if (condition >= 1) {
				String sql2 = "select id, password, name, phone, email, date_format(regdate, '%Y년도%m월%d일') from member";
				
				// 패스워드 가리기 : replace(password, password, '****') as password
				
				pt = conn.prepareStatement(sql2);
				ResultSet rs = pt.executeQuery();
				
				while(rs.next()) { // 실습 중이기 때문에 편의를 위해서 여러개 있으면 최종적으로 반복한 레코드만 저장한다.
					return_dto = new MemberDTO();
					
					return_dto.setId(rs.getString("id"));
					return_dto.setPassword(rs.getInt("password"));
					return_dto.setName(rs.getString("name"));
					return_dto.setPhone(rs.getString("phone"));
					return_dto.setEmail(rs.getString("email"));
					return_dto.setRegdate(rs.getString("regdate"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return return_dto;
	} // updateMember end

	
	/*
	// updateMember() 메서드 정상 작동하는지 테스트 (기존 DB 연결 방법으로 해야 한다.)
	public static void main(String args[]) { // main() 메서드는 java application에서 실행 / DataSource는 톰캣에서 실행하는 것이기 때문에 java application가 아닌 run on server에서 사용 가능 
		MemberDTO dto = new MemberDTO("xxx", 1111, "이름", "01011112222", "이메일@gmail.com", null);
		MemberDTO dto2 = new MemberDAO().updateMember(dto);
		System.out.println(dto2);
	}
	*/
	
}