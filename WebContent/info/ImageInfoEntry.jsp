<%@page import="com.fivetrue.gimpo.ac05.api.ImageInfoApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ImageInfoApiHandler handler = new ImageInfoApiHandler(getServletContext(), request, response);
	handler.getImageInfoEntry();
%>