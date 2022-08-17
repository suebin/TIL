package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Qualifier("dto2")
	@Autowired
	MemberDTO dto;

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
