package memberservice;

// 회원가입을 하고, 신입사원 등록까지 한다.
public class MemberService1 implements MemberService {
	MemberDAO dao;
	
	// setter injection
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void registerMember() {
		if(dao.selectMember() == false) {
			dao.insertMember();
			dao.insertEmployee();
		}
	}
}
