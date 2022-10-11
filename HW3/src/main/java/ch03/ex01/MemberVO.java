package ch03.ex01;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	
	public MemberVO(String id, String email, String password, String name, String regdate) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
	}
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	String id;
	String email;
	String password;
	String name;
	String regdate;
}
