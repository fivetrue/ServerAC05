<%@page import="com.fivetrue.gimpo.ac05.vo.ImageInfo"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.ImageInfoDBManager"%>
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
<%
	ArrayList<ImageInfo>datas = ImageInfoDBManager.getInstance().getSelectQueryData(null, null);
	Field[] fields = ImageInfo.class.getDeclaredFields();
%>
<body>
<div class="container" align="center">
		<h2>정보 이미지</h2>
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
					if (datas != null) {
						for (ImageInfo data : datas) {
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
							<form action="/gimpo-ac05/admin/info/image/detail" method="post">
								<input type="hidden" name="id" value="<% out.print(data.getImageInfoId());%>">
								<input type="submit" value="수정">
							</form>
							</td>
							</tr>
							<%
						}
					}
				%>
			
		</table>
		
		<form action=""></form>

	</div>
</body>
</html>