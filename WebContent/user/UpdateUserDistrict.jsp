<%@page import="com.fivetrue.gimpo.ac05.api.UserApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	UserApiHandler handler = new  UserApiHandler(getServletContext(), request, response);
	handler.updateUserDistrict();
 %>