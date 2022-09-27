<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fail Page</title>
</head>
<body>
	<%
	
		int schoolId = Integer.parseInt(request.getParameter("id"));
		String studentName = request.getParameter("name");
		int middleExam = Integer.parseInt(request.getParameter("mexam"));
		int finalExam = Integer.parseInt(request.getParameter("fexam"));
		int reportScore = Integer.parseInt(request.getParameter("report"));
		int checkScore = Integer.parseInt(request.getParameter("check"));
		int total = middleExam + finalExam + reportScore + checkScore;
	
	%>

	<h1>총점이 60점 미만입니다!!</h1>
	
	<tr>
		<td>학번: </td>
		<td><%= schoolId %><br></td>
	</tr>
	<tr>
		<td>이름: </td>
		<td><%= studentName %><br><br></td>
	</tr>
	<tr>
		<td>중간시험: </td>
		<td><%= middleExam %><br></td>
	</tr>
	<tr>
		<td>기말시험: </td>
		<td><%= finalExam %><br></td>
	</tr>
	<tr>
		<td>리포트: </td>
		<td><%= reportScore %><br></td>
	</tr>
	<tr>
		<td>출석: </td>
		<td><%= checkScore %><br><br></td>
	</tr>
	<tr>
		<td>총점은 <%= total %>점 입니다.</td>
	</tr>
	
</body>
</html>