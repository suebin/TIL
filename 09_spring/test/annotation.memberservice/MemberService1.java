package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 회원가입을 하고, 신입사원 등록까지 한다.
@Service("service1")
public class MemberService1 implements MemberService {
	@Autowired
	MemberDAO dao;
	
	@Override
	public void registerMember() {
		if(dao.selectMember() == false) {
			dao.insertMember();
			dao.insertEmployee();
		}
	}
}
