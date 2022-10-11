package ch03.jstl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
	private String name;		// 회원 정보 멤버 변수
	private String email;

	public Member() {		// 기본 생성자인 경우 다음과 같이 신규 정보로 초기화
		name="홍길동";
		email="test@test.net";
	}
}
