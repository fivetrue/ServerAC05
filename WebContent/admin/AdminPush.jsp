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
<script type="text/javascript">
	function onClickSend(){
		var b = confirm("전송하겠습니까 ?");
		if(b == true){
			onReload();
		}
		return b;
	}
	
	function onReload(){
		location.reload(true);	
	}
</script>
<body>

	<%
		adminUser = (UserInfo) session.getAttribute("adminUser");
		String userName = adminUser != null ? adminUser.getDisplayName() : "";
	%>

	<div class="container" align="center">
		<h2>
			<%
				out.print(userName);
			%>님 환영합니다.
		</h2>
		<form action="/gimpo-ac05/push/send" method="POST">
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
			테스트 전송<br>
			<input type="checkbox" name="test"><br><br>
			<input type="submit" value="보내기" onclick="return confirm('메세지를 전달 하시겠습니까 ?');">
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
					String sql = NotificationDataDBManager.getInstance().getSelectQuery(null, null);
					sql += " ORDER BY createTime DESC";
					ArrayList<NotificationData> list = NotificationDataDBManager.getInstance().rawQuery(sql);
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
							%>
							<td align="center" width="200">
							<form action="/gimpo-ac05/admin/push/detail" method="post">
								<input type="hidden" name="id" value="<% out.print(data.getMulticast_id());%>">
								<input type="submit" value="자세히">
							</form>
							</td>
							</tr>
							
							<%
						}
					}
				%>
			
		</table>

	</div>
<%@include file="AdminFooter.jsp"%></body>
</html>