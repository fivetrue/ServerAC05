
<%@page import="com.fivetrue.db.annotation.DisplayName"%>
<%@page import="java.lang.reflect.Field"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="AdminHeader.jsp"%>
<body>
	<%
		adminUser = (UserInfo) session.getAttribute("adminUser");
		UserDBManager.getInstance().create();
		ArrayList<UserInfo> users = UserDBManager.getInstance().getSelectQueryData(null, null);
		%>
		<div class="container" align="center">
		<h2>정보 이미지</h2>
		<table border="1" bordercolor="gray">
			<tr>
			<%
			for(Field f : UserInfo.class.getDeclaredFields()){
 				f.setAccessible(true);
				DisplayName name = f.getAnnotation(DisplayName.class); 
				if(name != null){
					out.print(String.format("<td align=\"center\">%s</td>", name.value()));
				}
			}
			%>
			</tr>
			<%
			for(UserInfo user : users){
				%>
				<tr>
					<%
					for(Field f : UserInfo.class.getDeclaredFields()){
						f.setAccessible(true);
						DisplayName name = f.getAnnotation(DisplayName.class); 
						if(name != null){
							Object obj = f.get(user);
							if(obj instanceof String && ((String)obj).startsWith("http")){
								out.print(String.format("<td align=\"center\"><img src=\"%s\"></td>", obj));
							}else{
								out.print(String.format("<td align=\"center\">%s</td>", obj));
							}
						}
						
					}
					%>
				</tr>
				<%
			}
			%>
		</table>
	</div>
		<%
		
		
	%>
	<%@include file="AdminFooter.jsp"%></body>
</body>
</html>