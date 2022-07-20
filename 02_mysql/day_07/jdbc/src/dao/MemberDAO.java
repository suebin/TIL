package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;
// Data Access Object
// 키보드 입력/웹브라우저 입력/명령행 매개변수 입력 : DTO 형태 전달받아서 DB에 저장!

// Member 테이블에 대한 CRUD 메소드 구현하는 클래스
// SQL  : INSERT, SELECT, UPDATE, DELETE
// CRUD : CREATE, READ, UPDATE, DELETE (ex) 회원관리 프로그램) 
public class MemberDAO {

	public int insertMember(MemberDTO dto) {
		Connection con = null;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String sql = "insert into member values(?,?,?,?,?, now())";
			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, dto.getId());
			pt.setInt(2, dto.getPassword());
			pt.setString(3, dto.getName());
			pt.setString(4, dto.getPhone());
			pt.setString(5, dto.getEmail());

			result = pt.executeUpdate(); // 한 개가 저장되었으면 1을 리턴하도록!
			System.out.println("(insertMember내부)삽입행의 갯수=" + result); // 오류 확인용 출력

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return result;

	} // insertMember

	public int updateMember(MemberDTO dto) {
		Connection con = null;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String colName = "";
			String colValue = "";
			if (dto.getPassword() != 0) {
				colName = "password";
				colValue = String.valueOf(dto.getPassword());
			} else if (dto.getName() != null) {
				colName = "name";
				colValue = dto.getName();
			} else if (dto.getPhone() != null) {
				colName = "phone";
				colValue = dto.getPhone();
			} else if (dto.getEmail() != null) {
				colName = "email";
				colValue = dto.getEmail();
			}

			String sql = "update member set " + colName + "=? where id=?";

			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, colValue);
			pt.setString(2, dto.getId());

			result = pt.executeUpdate();

			System.out.println("(UpdateMember내부)삽입행의 갯수=" + result); // 오류 확인용 출력

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return result;
	} // updateMember

	public int deleteMember(String id, String password) {
		Connection con = null;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			// 아이디 조회
			String sql1 = "select password from member where id=?";
			PreparedStatement pt1 = con.prepareStatement(sql1);
			pt1.setString(1, id);
			ResultSet rs = pt1.executeQuery();
			// 비밀번호 확인 후 delete
			boolean isPW = false;
			while (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					String sql2 = "delete from member where id=? and password=?";
					PreparedStatement pt2 = con.prepareStatement(sql2);
					pt2.setString(1, id);
					pt2.setString(2, password);
					result = pt2.executeUpdate();
					isPW = true;
				}
			} // while end

			if (isPW == false) {
				return 0;
			}

			System.out.println("(insertMember내부)삽입행의 갯수=" + result); // 오류 확인용 출력

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return result;

	} // deleteMember

	public MemberDTO selectOneMember(String id, String password) {
		MemberDTO dto = new MemberDTO();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String sql = "select * from member where id=?";

			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, id);

			ResultSet rs = pt.executeQuery();

			/*
			 * 현재상태 id 중복 가능 db
			 * 
			 * while(rs.next()) {
			 * 
			 * }
			 */
			// 테스트용 입력 id, pw 중복되지 않는 걸 간주
			if (rs.next()) { // 중복 id 여러개 있다면 첫번째 1개
				dto.setId(rs.getString("id"));
				if (Integer.parseInt(password) == rs.getInt("password")) {
					dto.setPassword(rs.getInt("password"));
					dto.setName(rs.getString("name"));
					dto.setPhone(rs.getString("phone"));
					dto.setEmail(rs.getString("email"));
					dto.setRegdate(rs.getString("regdate"));
				}
			}

			// dto.setPassword(0) 자동
			// dto.id :null 기본

			System.out.println("(insertMember내부)삽입행의 갯수=" + rs); // 오류 확인용 출력

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return dto;

	}

	public ArrayList<MemberDTO> selectAllMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String sql = "select * from member";

			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPassword(-1);
				list.add(dto);
			}
			// System.out.println("dao화면에서" + list.size()); // 확인용

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return list;

	}

	public ArrayList<MemberDTO> selectSerchMember(String search) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String sql = "select * from member where id like ? "
					+ "or name like ? or phone like ? or email like ?";

			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, "%"+search+"%");
			pt.setString(2, "%"+search+"%");
			pt.setString(3, "%"+search+"%");
			pt.setString(4, "%"+search+"%");
			
			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPassword(-1);
				list.add(dto);
			}
			
			// System.out.println("dao화면에서" + list.size()); // 확인용

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return list;

	}
	
	public int getTotalMember() {
		int result = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String sql = "select count(*) from member;";

			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			
			rs.next();
			result = rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return result;

	}

	public ArrayList<MemberDTO> selectPagingMember(int pagenum, int recordPerPage) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String sql = "select * from member order by regdate limit ?, ?;";

			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, (pagenum-1)*recordPerPage);
			pt.setInt(2, recordPerPage);
			
			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPassword(-1);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return list;

	}

	
	
}
