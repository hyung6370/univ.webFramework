<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="printGrade" class="hw2.GradeInfo" />
<jsp:setProperty name="printGrade" property="*" />
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print Page2</title>
</head>
<body>

	<%
		if (printGrade.totalScore() == true) {
			out.print("<html><body><h1>");
			out.println("성적을 취득하였습니다!!");
			out.print("</h1></body></html>");
		}
		else {
			out.print("<html><body><h1>");
			out.println("총점이 60점 미만입니다!!");
			out.print("</h1></body></html>");
		}
	%>
	<%
		int total = printGrade.getMexam() + printGrade.getFexam() + printGrade.getReport() + printGrade.getCheck();
	%>
	
	학번 : <jsp:getProperty property="id" name="printGrade"/> <br>
	이름 : <jsp:getProperty property="name" name="printGrade"/><br><br>
	중간시험 : <jsp:getProperty property="mexam" name="printGrade"/><br>
	기말시험 : <jsp:getProperty property="fexam" name="printGrade"/><br>
	리포트 : <jsp:getProperty property="report" name="printGrade"/><br>
	출석 : <jsp:getProperty property="check" name="printGrade"/><br><br>
	총점은 : <%= total %>점 입니다.


</body>
</html>