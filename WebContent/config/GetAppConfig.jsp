<%@page import="com.fivetrue.gimpo.ac05.api.AppConfigApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AppConfigApiHandler handler = new AppConfigApiHandler(getServletContext(), request, response);
	handler.getAppConfig();
 %>