<%@page import="com.fivetrue.gimpo.ac05.api.NaverAPIManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <%
 	NaverAPIManager manager = new NaverAPIManager(getServletContext(), request, response);
 	manager.requestLogin();
 
 %>