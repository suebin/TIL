package memberservice;

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
