<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="calc" class="ch07.com.dao.GuGuDan"></jsp:useBean>
    <jsp:setProperty property ="*" name="calc"></jsp:setProperty>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>구구단 출력하기</h4>
	<% for (int i =1;i<=9;i++){ %>
		<%="5 * " + i + "=" + calc.process(i)%>
		<br>
	<%}%>
	
</body>
</html>