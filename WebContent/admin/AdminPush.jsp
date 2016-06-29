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
	%>

	<div class="container" align="center">
		<h2>
			<%
				out.print(userName);
			%>님 환영합니다.
		</h2>
		<form action="../push/send" method="POST">
			<%
				Field[] fields = NotificationData.class.getDeclaredFields();
				for (Field f : fields) {
					f.setAccessible(true);
					DisplayName name = f.getAnnotation(DisplayName.class);
					String type = null;
					if (name != null) {
						out.print(name.value() + "<br>");
						if (name.value().equals("공지사항")) {
							type = "checkbox";
						} else {
							type = "text";
						}
			%>
			<input type=<%out.print(type);%> name="<%out.print(f.getName());%>">
			<br>
			<%
				}
				}
			%>
			<input type="submit" value="보내기">
		</form>
	</div>

	<div class="container" align="center">
		<h2>전달된 Push 정보</h2>
		<table border="1" bordercolor="gray">
			<tr>
				<%
					for (Field f : fields) {
						f.setAccessible(true);
						DisplayName name = f.getAnnotation(DisplayName.class);
						if (name != null) {
							%>
							<td align="center"  width="200"><b><%out.print(name.value()); %> </b></td>
							<%
						}
					}
				%>

				<%
					ArrayList<NotificationData> list = NotificationDataDBManager.getInstance().getSelectQueryData(null, null);
					if (list != null) {
						for (NotificationData data : list) {
							Field[] dataFs = data.getClass().getDeclaredFields();
							out.print("<tr>");
							for (Field f : dataFs) {
								f.setAccessible(true);
								DisplayName name = f.getAnnotation(DisplayName.class);
								if (name != null) {
									out.print(String.format("<td align=\"center\">%s</td>", f.get(data)));
								}
							}
							out.print(String.format("<td align=\"center\"  width=\"200\"><a href=\"%s\">자세히</a></td>"
									, "/gimpo-ac05/admin/push/detail?id=" + data.getMulticast_id()));
							out.print("</tr>");
						}
					}
				%>
			
		</table>

	</div>


</body>
</html>