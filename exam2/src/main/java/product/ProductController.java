package product;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        dao = new ProductDAO();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		// 여기에 코드 작성
		ProductVO product = new ProductVO();
		
		if (action == null || action.equals("/list.do")) {
			List<ProductVO> productList = dao.listProducts();
			request.setAttribute("productList", productList);
			forwardReq(request, response, "/news/newslist.jsp");
		}
		else if (action.equals("/insert.do") && request.getMethod().equalsIgnoreCase("POST")) {
			product.setWriter(request.getParameter("writer"));
			product.setTitle(request.getParameter("title"));
			product.setBody(request.getParameter("body"));
			dao.insert(product);
			response.sendRedirect("list.do");
		}
		else if (action.equals("/insertReq.do") && request.getMethod().equalsIgnoreCase("GET")) {
			forwardReq(request, response, "/news/insert.jsp");
		}
		else if (action.equals("/read.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ProductVO productVO = dao.getProductById(id);
			dao.updateReadCnt(id);
			request.setAttribute("productVO", productVO);
			forwardReq(request, response, "/news/read.jsp");
		}
		else if (action.equals("/update.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ProductVO productVO = dao.getProductById(id);
			request.setAttribute("productVO", productVO);
			forwardReq(request, response, "/news/update.jsp");
		}
		else if (action.equals("/updateReq.do") && request.getMethod().equalsIgnoreCase("POST")) {
			product.setWriter(request.getParameter("writer"));
			product.setTitle(request.getParameter("title"));
			product.setBody(request.getParameter("body"));
			product.setId(Integer.parseInt(request.getParameter("id")));
			dao.update(product);
			response.sendRedirect("list.do");
		}
		else if (action.equals("/backUpdate.do")) {
			response.sendRedirect("list.do");
		}
		
	}
	
	private void forwardReq(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException  {
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
