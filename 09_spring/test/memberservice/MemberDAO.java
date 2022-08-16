package memberservice;

public class MemberDAO {
	MemberDTO dto; // 회원 정보 저장 객체
	
	public void setDto(MemberDTO dto) { // 외부로부터 dto 객체를 전달받기 위한 용도
		this.dto = dto;
	}

	public boolean selectMember() {
		if(dto.getId().equals("spring") && dto.getPassword() == 1111) {
			return true; // 정상적으로 로그인을 한다.
		}
		else {
			return false; // 회원가입을 한다.
		}
	}
	
	public void insertMember() {
		System.out.println(dto.getId() + " 회원님 정상적으로 회원가입이 되었습니다.");
	}
	
	public void insertEmployee() {
		System.out.println(dto.getId() + " 신입사원으로 입사하셨습니다.");
	}
}
