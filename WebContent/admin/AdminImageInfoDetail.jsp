<%@page import="com.fivetrue.gimpo.ac05.vo.ImageInfo"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.ImageInfoDBManager"%>
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
		adminUser = (UserInfo) session.getAttribute("adminUser");
		String imageId = request.getParameter("id");
		if (TextUtils.isEmpty(id)) {

		} else {
			String where = "imageInfoId=" + id;
			ArrayList<ImageInfo> data = ImageInfoDBManager.getInstance().getSelectQueryData(null, where);
			if (data != null && data.size() > 0) {
				ImageInfo info = data.get(0);
				if (info != null) {
	%>
	<div class="container" align="center">
		<h2>전달된 Push 정보</h2>
		<form action="/gimpo-ac05/admin/info/image/update" method="post">
		<table border="1" bordercolor="gray">
			<%
				Field[] dataFs = info.getClass().getDeclaredFields();
							out.print("<tr>");
							for (Field f : dataFs) {
								f.setAccessible(true);
									out.print(String.format("<td align=\"center\">%s</td>" 
											+ "<td align=\"center\"><input type=\"text\" name=\"%s\" value=\"%s\" size=\"50\"></td></tr>",
											f.getName(), f.getName(),f.get(info)));
							}
							%>
		</table>
		<br>
		<input type="hidden" name="email" value="<%out.print(adminUser.getEmail()); %>">
		<input type="submit" value="Update" onclick="return confirm('정말로 업데이트 하시겠습니까?')">
		</form>
		<br>
		<form action="/gimpo-ac05/admin/info/image/delete" method="post">
			<input type="hidden" name="id" value="<%out.print(info.getImageInfoId());%>">
			<input type="hidden" name="email" value="<%out.print(adminUser.getEmail()); %>">
			<input type="submit" value="Delete" onclick="return confirm('삭제된 데이터는 복구 할 수 없습니다. 삭제 하시겠습니까?')">
		</form>
		<br>
		<img src="<%out.print(info.getImageUrl()); %>">
	</div>
	<%
				}
			}
		}
	%>
	<%@include file="AdminFooter.jsp"%>
</body>
</html>