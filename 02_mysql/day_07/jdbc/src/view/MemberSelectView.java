package view;

import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberSelectView implements View {

	// MemberSelectView - input()
	// 아이디 : xxx
	// 암호 : xxx
	// 입력 id와 암호는 중복되지 않는 걸로 확인

	// MemberDAO - MemberDTO selectOneMember(String id, String password)
	// 1. member 테이블에서 id, password 같은 레코드 조회 ResultSet결과를 MemberDTO로 저장
	// 출력
	// 2. id가 c_member 존재하지 않으면 "회원가입부터 하세요." 출력
	// id 존재, 암호가 다르면 "다시 입력하세요." 출력
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		// 1. 입력
		System.out.print("조회 아이디 : ");
		String id = sc.next();
		System.out.print("조회 암호 : ");
		String password = sc.next();

		// 2. DTO 객체 (6개 변수 저장되어 있음) 생성 - 생략 가능

		// 3. DAO 객체 생성 메소드 호출 (전달값)
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectOneMember(id, password);

		if (dto.getId() != null) {
			if (dto.getPassword() != 0) {
				System.out.println(dto/* .toString()자동호출결과 */);
			} else {
				System.out.println("암호가 다릅니다. 다시 입력하세요.");
			}
		}
		else {
			System.out.println("해당 아이디가 존재하지 않습니다. 회원 가입부터 하세요");
		}

	}

}
