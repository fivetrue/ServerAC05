<%@page import="com.fivetrue.api.Result"%>
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
	UserInfo user = (UserInfo) session.getAttribute("adminUser");
	PushNotificationApiHandler manager = new PushNotificationApiHandler(getServletContext(), request, response);
	if(user == null){
		manager.deletePush();
	}else{
		Result result = manager.deletePushResult();
		if(result.getErrorCode() == Result.ERROR_CODE_OK){
			response.sendRedirect("/gimpo-ac05/admin/push");
		}else{
			%>
			<script type="text/javascript">
					alert(<%out.print(result.getMessage()); %>);
					history.back();
				</script>
			<%
		}
	}
%>
