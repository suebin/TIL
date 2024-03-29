package dao;

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
	// MEMBER테이블 CRUD
	
	// DataSource로 DB 연결
	public ArrayList<MemberDTO> selectAllMember() {
		Connection conn = null;
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();

		try {
			// DataSource
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");// java - component - environment파일
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");

			conn = ds.getConnection();

			String sql = "select * from member";
			PreparedStatement pt = conn.prepareStatement(sql);

			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				// dto.setPassword(rs.getInt("password"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				memberlist.add(dto);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // connection pool 로 반납
			} catch (SQLException e) {
			}
		}
		return memberlist;
	} // selectAllMember end

	public int selectMember(String id, String userpassword) {
		Connection conn = null;
		int condition = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

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
				conn.close();
			} catch (SQLException e) {
			}
		}
		return condition;
	}

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
	}// insertMember end
	
	// DataSource로 DB 연결
	public int deleteMember(String id, String pw) {
		Connection conn = null;
		int condition = 0;// insert한 행의 갯수
		try {
			// DataSource
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");// java - component - environment파일
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
	}// deleteMember end

}// class
