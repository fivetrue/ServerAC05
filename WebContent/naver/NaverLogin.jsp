<%@page import="com.fivetrue.gimpo.ac05.api.NaverAPIManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <%
 	NaverAPIManager manager = new NaverAPIManager(getServletContext(), request, response);
 	manager.requestLogin();
 %>
 
 <!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <body>
 	<h1>로그인 중</h2>
 </body>
 </html>