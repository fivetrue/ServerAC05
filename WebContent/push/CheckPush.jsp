<%@page import="com.fivetrue.gimpo.ac05.manager.GcmResultDBManager"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.GCMResult"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.NotificationDataDBManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.UserDBManager"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.UserInfo"%>
<%@page import="com.fivetrue.utils.TextUtils"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.NotificationData"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.PushMessage"%>
<%@page import="com.fivetrue.gimpo.ac05.api.PushNotificationApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PushNotificationApiHandler manager = new PushNotificationApiHandler(getServletContext(), request, response);
	manager.checkPush();
	/* NotificationData data = manager.getNotificationDataFromParameter();
	String redirect = data.getUri();
	String pushUrl = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() 
	+ request.getContextPath() + "push/check?redirect=" + redirect;
	data.setUri(pushUrl);
	UserInfo adminUser = (UserInfo) session.getAttribute("admin"); */
%>
