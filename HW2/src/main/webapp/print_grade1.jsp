<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print Page1</title>
</head>
<body>
	<% 
		int middleExam = Integer.parseInt(request.getParameter("mexam"));
		int finalExam = Integer.parseInt(request.getParameter("fexam"));
		int reportScore = Integer.parseInt(request.getParameter("report"));
		int checkScore = Integer.parseInt(request.getParameter("check"));
		int total = middleExam + finalExam + reportScore + checkScore;
		String pageURL = null;
		
		if (total >= 60) {
			pageURL = "/success.jsp";
		}
		else {
			pageURL = "/fail.jsp";
		}
	%>
	
	<jsp:forward page = "<%=pageURL %>" />
	

</body>
</html>