package memberservice;
// 1개의 기능 : 최초 구현 이후에 변경 가능
public class MemberService2 implements MemberService {
	MemberDAO dao;
	
	// setter injection
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void registerMember() {
		if(dao.selectMember() == false) {
			dao.insertMember();
		}
	}
}
