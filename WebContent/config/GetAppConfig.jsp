<%@page import="com.fivetrue.gimpo.ac05.api.ConfigApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	ConfigApiHandler handler = new ConfigApiHandler(getServletContext(), request, response);
	handler.getAppConfig();
 %>