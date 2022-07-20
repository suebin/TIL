package dto;

// DTO : 데이터 중간 저장하고 DAO로 전달해준다.
// MemberVO (Value object)도 있음
// MemberDO (Data Objec)도 있음
public class MemberDTO { // member 테이블의 1개 레코드 표현 객체
	String id;
	int password;
	String name;
	String phone;
	String email;
	String regdate;
	
	// 다른 곳에서도 사용할 수 있도록 getter, setter 만든다.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "id = " + id + ", 암호 = " + password + ", 이름 = "+ name + ", 폰번호 = "
				+ phone + ", 이메일 = " + email + ", 회원가입일 = " + regdate ;
	}
	
	

	// toString, 생성자 ...
}
