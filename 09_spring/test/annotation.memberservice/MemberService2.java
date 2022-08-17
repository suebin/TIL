package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 회원가입만 한다.
@Service("service2")
public class MemberService2 implements MemberService {
	@Autowired
	MemberDAO dao;
	
	@Override
	public void registerMember() {
		if(dao.selectMember() == false) {
			dao.insertMember();
		}
	}
}
