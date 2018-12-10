<%@page import="com.dev.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>회원 정보</title>
</head>
<body>

<%  ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list"); 
    if(!list.isEmpty()) {  %>
	   <table border="1">
	   		<tr><th>ID</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
			
			<%   for(int i=0; i<list.size(); i++){   
			       MemberVO member = list.get(i);   %>
			       
			        <tr><td><%=member.getId() %></td>
			            <td><%=member.getPasswd() %></td>
			            <td><%=member.getName() %></td>
			            <td><%=member.getMail() %></td>
			       </tr>
			       
			<%   }
       }else{
    	   out.print("<h3>등록된 회원 정보가 없습니다.</h3>");
       }
	%>
	  </table>

<%@ include file="home.jsp" %> 
</body>
</html>