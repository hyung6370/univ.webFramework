package ch03.jstl;

import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InitMember implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		ArrayList<Member> mlist = new ArrayList<Member>();

		for(int i = 0; i < 8; i++) {	 // JSTL 예제를 위해 샘플 데이터 생성
			Member data = new Member("홍길동"+i, "test"+i+"@test.net");
			mlist.add(data);
		}

		// email 이 빠진 2개 샘플 데이터 추가
		mlist.add(new Member("김철수", null));	
		mlist.add(new Member("이영희", null));

		// application scope 에 members 및 member 객체 저장
		context.setAttribute("members", mlist);
		context.setAttribute("member", new Member());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
