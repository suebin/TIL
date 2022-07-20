package view;

import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberUpdateView implements View {

	@Override
	public void input() {

		System.out.println("=== 회원정보 수정을 시작합니다. ===");

		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.next();

		System.out.print("수정항목 입력(암호, 이름.폰번호, 이메일 중 한 개 입력) : ");
		String updateName = sc.next();
		System.out.print("수정값 입력 : ");
		String updateValue = sc.next();

		MemberDTO dto = new MemberDTO();

		dto.setId(id);
		if (updateName.equals("암호")) {
			dto.setPassword(Integer.parseInt(updateValue));
		}
		else if (updateName.equals("이름")) {
			dto.setName(updateValue);
		}
		else if (updateName.equals("폰번호")) {
			dto.setPhone(updateValue);
		}
		else if (updateName.equals("이메일")) {
			dto.setEmail(updateValue);
		}
		// id = 입력값, password = 입력값, name = 입력값

		MemberDAO dao = new MemberDAO();
		int result = dao.updateMember(dto);
		System.out.println(result + " 개의 행 변경");
	}

}
