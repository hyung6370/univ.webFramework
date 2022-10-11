package ch03.ex01;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        memberDAO = new MemberDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		
		
		if (action == null || action.equals("/listMembers.do")) {
			ArrayList<MemberVO> memberList = memberDAO.listMembers();
			request.setAttribute("memberList", memberList);
			nextPage = "/mvc/listMembers.jsp";
		}
		else if (action.equals("/insertReq.do")) {
			nextPage = "/insert.jsp";
		}
		else if (action.equals("/insert.do")) {
			String id = request.getParameter("id");
//			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String regdate = request.getParameter("regdate");
			MemberVO memberVO = new MemberVO(id, email, password, name, regdate);
			memberDAO.addMember(memberVO);
			
			nextPage = "/member/listMember.do";
		}
		else {
			ArrayList<MemberVO> memberList = memberDAO.listMembers();
			request.setAttribute("memberList", memberList);
			
			nextPage = "/listMembers.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
