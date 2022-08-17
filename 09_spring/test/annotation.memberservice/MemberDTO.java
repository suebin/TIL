package annotation.memberservice;

import org.springframework.stereotype.Component;

@Component("dto") // 객체는 생성되지만 value값을 전달하기 위해 xml 파일에 작성하는 것도 필요하다.
public class MemberDTO {
	String id, name, phone, email, regdate;
	int password;
	
	// 기본 생성자
	public MemberDTO() {
		System.out.println("MemberDTO 생성자 호출");
	}
	// 사용자 정의 생성자
	public MemberDTO(String id, int password) {
		this.id = id; 
		this.password = password;
		System.out.println("MemberDTO 생성자 호출 : " + id + ":" + password);
	}
	
	// getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	
}