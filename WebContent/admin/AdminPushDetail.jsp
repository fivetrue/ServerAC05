<%@page import="com.fivetrue.gimpo.ac05.manager.NotificationDataCheckUserDBManager"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.NotificationDataCheckUser"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.fivetrue.gimpo.ac05.manager.NotificationDataDBManager"%>
<%@page import="com.fivetrue.db.annotation.DisplayName"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.NotificationData"%>
<%@page import="java.lang.reflect.Field"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="AdminHeader.jsp"%>
<body>
	<%
		UserInfo user = (UserInfo) session.getAttribute("admin");
		String userName = user != null ? user.getName() : "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String multicastId = request.getParameter("id");
		if(TextUtils.isEmpty(id)){
			
		}else{
			ArrayList<NotificationData> data = NotificationDataDBManager.getInstance().
					getSelectQueryData(null, "multicast_id='" + id + "'");
			
			if(data != null && data.size() > 0){
				NotificationData notification = data.get(0);
				if(notification != null){%>
	<div class="container" align="center">
		<h2>전달된 Push 정보</h2>
		<table border="1" bordercolor="gray">
			<tr>
			<td width="100" align="center"><b>Key</b></td> 
			<td width="150" align="center" ><b>Value</b></td> 
			</tr>
			<tr>
			<td width="100" align="center">Multicast Id</td> 
			<td width="150" align="center" ><%out.print(notification.getMulticast_id()); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">Push Id</td> 
			<td width="150" align="center" ><%out.print(notification.getId()); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">Title</td> 
			<td width="150" align="center" ><%out.print(notification.getTitle()); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">Message</td> 
			<td width="150" align="center" ><%out.print(notification.getMessage()); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">URL</td> 
			<td width="150" align="center" ><%out.print(notification.getUri()); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">imageURL</td> 
			<td width="150" align="center" ><%out.print(notification.getImageUrl()); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">createdTime</td> 
			<td width="150" align="center" ><%
			out.print(sdf.format(new Date(notification.getCreateTime()))); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">author</td> 
			<td width="150" align="center" ><%
			out.print(notification.getAuthorNickname()); %></td> 
			</tr>
			
			<tr>
			<td width="100" align="center">authorEmail</td> 
			<td width="150" align="center" ><%
			out.print(notification.getAuthorEmail()); %></td> 
			</tr>
		</table>
	
	<div class="container" align="center">
		<form action="/gimpo-ac05/push/delete" method="post" >
			<input type="hidden" name="id" value="<%out.print(notification.getMulticast_id()); %>">
			<input type="hidden" name="email" value="<%out.print(user.getEmail()); %>">
			<br>
			<input type="submit" value="삭제" onclick="return confirm('삭제된 데이터는 복구되지 않습니다. 삭제시겠습니까 ?');">
			<br>
		</form>
	</div>
	
		
	<div class="container" align="center">
		<h2>확인 유저 정보</h2>
		<%
		ArrayList<NotificationDataCheckUser> checkedUsers = NotificationDataCheckUserDBManager.getInstance()
			.getSelectQueryData(null, "notiMulticastId='" + id + "'");
		
		%>
		<table border="1" bordercolor="gray">
			<tr>
			<td align="center"><b>이메일</b></td>
			</tr>
			<%
			for(NotificationDataCheckUser u : checkedUsers){
				%>
			<tr>
			<td align="center"><%out.print(u.getUserEmail()); %></td>
			</tr>
				<%
			}
			%>
		</table>
	</div>
	<%
				}
				
			}
		}
	%>
	<%@include file="AdminFooter.jsp"%></body>
</body>
</html>