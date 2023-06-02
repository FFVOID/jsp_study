<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	request.setCharacterEncoding("UTF-8"); //한글깨짐방지
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String loginChk = request.getParameter("loginChk");
	
	//기존의 사용자 id,pw(db에서 가져왔다고 가정한다)
	String dbId = "user", dbPw = "1234";
	
	if(dbId.equals(id)) {
		if(dbPw.equals(pw)) {
			//로그인 작업 -> 세션값 생성
			session.setAttribute("id", id);
			
			//사용자가 아이디 저장체크여부
			if(loginChk != null){ //아이디 저장을 체크한경우
				Cookie c = new Cookie("loginChk","Y"); //쿠키생성 (key,value)
				c.setMaxAge(60 * 50); //50분 동안 쿠키에 값 저장
				c.setPath("/"); //쿠키의 적용 경로 "/" 이후부터 전부 쿠키를적용
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("loginChk","N"); //쿠키생성 (key,value)
				c.setMaxAge(60 * 50); //50분 동안 쿠키에 값 저장
				c.setPath("/"); //쿠키의 적용 경로
				response.addCookie(c);
			}
	%>
	<script>
		alert("인증되었습니다.");
		location.href = "main.jsp";
	</script>		
			
	<%
		} else {
	%>
	<script>
		alert("비밀번호가 다릅니다.");
		location.href = "index.jsp";
	</script>	
	<%		
		}
	} else {
	%>
	<script>
		alert("아이디가 다릅니다.");
		location.href = "index.jsp";
	</script>		
	<%
	}
%>
</body>
</html>