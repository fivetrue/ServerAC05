<%@page import="com.fivetrue.gimpo.ac05.manager.AppConfigDBManager"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.AppConfig"%>
<%@page import="com.fivetrue.db.annotation.AutoIncrement"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.ImageInfo"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.ImageInfoDBManager"%>
<%@page
	import="com.fivetrue.gimpo.ac05.manager.NotificationDataCheckUserDBManager"%>
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
<%
	AppConfigDBManager.getInstance().create();
	ArrayList<AppConfig> appConfigs = AppConfigDBManager.getInstance().getSelectQueryData(null, null);
	
	if(admin.getAdminType() < 3){
		%>
<script type="text/javascript">
			alert('개발자 메뉴입니다.');
		</script>
<%
	}else{
		%>
<body>
	<div class="container" align="center">
		<h2>App Setting</h2>
		<table border="1" bordercolor="gray">
			<%
				for(AppConfig appConfig : appConfigs){
					%>
				<form action="" method="post">
					<%
					for (Field f : AppConfig.class.getDeclaredFields()) {
						f.setAccessible(true);
						out.print("<tr>");
						out.print(String.format("<td align=\"center\">%s </td>",f.getName()));
						out.print(String.format("<td align=\"center\"><input type=\"text\" name=\"%s\" value=\"%s\"></td>", f.getName(), f.get(appConfig)));
						out.print("</tr>");
					}
					%>
				<tr><td align="center"><input type="submit" value="수정"></td></tr>
				</form>
			<%
				}
				%>
		</table>
	</div>
	<%@include file="AdminFooter.jsp"%>
</body>
<%
		
	}
%>
</html>