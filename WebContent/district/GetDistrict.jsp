<%@page import="com.fivetrue.gimpo.ac05.api.DistrictApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DistrictApiHandler handler = new DistrictApiHandler(getServletContext(), request, response);
	handler.getDistricts();
 %>