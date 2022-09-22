

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArithmeticCalc
 */
@WebServlet("/ex")
public class exchangeCalc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exchangeCalc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operations[] = request.getParameterValues("operation");
		double f_input = Double.parseDouble(request.getParameter("firstInput"));
//		double s_input = Double.parseDouble(request.getParameter("secondInput"));
		String operation = request.getParameter("operation");
		double result = 0;
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body><h1>");
		out.println("반환 결과: ");
//		out.println(f_input);
		
//		for (String i_operation:operations) {
//			out.print(i_operation + " ");
//		}
		
//		out.println(s_input + " = ");
		
		if (operation.contains("dollar")) {
			result = f_input * 0.00072;
			// result = f_input / 1394.5;
			out.println(String.format("%.4f", result) + " Dallar");
		}
		else if (operation.contains("yen")) {
			result = f_input * 0.10;
			out.println(result + " Yen");
		}
		else if (operation.contains("yuan")) {
			result = f_input * 0.0050;
			out.println(String.format("%.4f", result) + " Yuan");
		}
		else if (operation.contains("euro")){
			result = f_input * 0.00072;
			out.println(String.format("%.4f", result) + " Euro");
		}
		
		
		out.println("<br><br><a href='javascript:history.go(-1)'>다시 계산</a>");
		
		out.print("</h1></body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
