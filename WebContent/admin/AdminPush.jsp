<%@page import="com.fivetrue.db.annotation.DisplayName"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.NotificationData"%>
<%@page import="java.lang.reflect.Field"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@include file="AdminHeader.jsp" %>
<body>

<%
	UserInfo user = (UserInfo) session.getAttribute("admin");
	String userName = user != null ? user.getName() : "";
%>

<h1> <%out.print(userName); %>님 환영합니다.</h1>
<form action="../push/send" method="POST">
	<% 
		Field[] fields = NotificationData.class.getDeclaredFields();
		for(Field f : fields){
			f.setAccessible(true);
			DisplayName name = f.getAnnotation(DisplayName.class);
			String type = null;
			if(name != null){
				out.print(name.value() + " : ");
				if(name.value().equals("공지사항")){
					type = "checkbox";
				}else{
					type = "text";
				}
				
				%>
				 <input type=<%out.print(type); %> name="<%out.print(f.getName());%>"> <br> 
				<%
			}
		}
	%>	
	<input type="submit">
</form>
</body>
</html>