<%@page import="com.fivetrue.gimpo.ac05.api.DataGetterApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DataGetterApiHandler handler = new DataGetterApiHandler(getServletContext(), request, response);
	handler.getPageDatas();
%>