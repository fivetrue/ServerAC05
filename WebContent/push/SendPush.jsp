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
	NotificationData data = manager.getNotificationDataFromParameter();
	UserInfo adminUser = (UserInfo) session.getAttribute("admin");
	
	if(data == null || TextUtils.isEmpty(data.getMessage())
			|| TextUtils.isEmpty(data.getTitle()) || adminUser == null){
		
		//Error
		%>
			<script type="text/javascript">
			alert("입력된 데이터가 올바르지 않습니다.");
			history.back();
			</script>
		<%
		
	}else{
		PushMessage push = new PushMessage();
		push.setData(data);
		ArrayList<UserInfo> users =  UserDBManager.getInstance().getSelectQueryData(null, null);
		String result = "";
		if(users != null && users.size() > 0){
			for(UserInfo user : users){
				result += "Receiver = " + user.getEmail() + "<br>";
				push.getRegistration_ids().add(user.getGcmId());
			}
			result += "Receiver count = " + users.size() + "<br>"; 
			String pushResult = PushNotificationApiHandler.sendNotification(push);
			GCMResult gcmResult = new Gson().fromJson(pushResult, GCMResult.class);
			
			data.setMulticast_id(gcmResult.getMulticast_id());
			data.setCreateTime(System.currentTimeMillis());
			data.setAuthorEmail(adminUser.getEmail());
			data.setAuthorNickname(adminUser.getNickname());
			
			NotificationDataDBManager.getInstance().create();
			NotificationDataDBManager.getInstance().insertObject(data);
			
			GcmResultDBManager.getInstance().create();
			GcmResultDBManager.getInstance().insertObject(gcmResult);
			
			out.println(result + pushResult);
		}else{
			//Error
			%>
			<script type="text/javascript">
			alert("수신 받을 유저가 없습니다. ");
			history.back();
			</script>
			<%
			
		}
	}

%>
