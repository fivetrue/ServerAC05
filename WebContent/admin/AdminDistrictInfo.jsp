<%@page import="com.fivetrue.db.annotation.PrimaryKey"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.District"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.DistrictDBManager"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.AppConfigDBManager"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.ImageInfo"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.ImageInfoDBManager"%>
<%@page import="java.lang.reflect.Field"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="AdminHeader.jsp"%>
<%
	DistrictDBManager.getInstance().create();
	ArrayList<District> districts = DistrictDBManager.getInstance().getSelectQueryData(null, null);
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
		<h2>District Setting</h2>
		<table border="1" bordercolor="gray">
			<tr>
			<%
					for (Field f : District.class.getDeclaredFields()) {
						f.setAccessible(true);
						out.print(String.format("<td align=\"center\">%s </td>",f.getName()));
					}
					%>
			</tr>
			<%
				for(District district : districts){
					%>
				<tr>
					<form action="/gimpo-ac05/api/district/update" method="post">
					<%
					for (Field f : District.class.getDeclaredFields()) {
						f.setAccessible(true);
						if(f.getAnnotation(PrimaryKey.class) != null){
							out.print(String.format("<td align=\"center\">%s<input type=\"hidden\" name=\"%s\" value=\"%s\"></td>", f.get(district), f.getName(), f.get(district)));
						}else{
							out.print(String.format("<td align=\"center\"><input type=\"text\" name=\"%s\" value=\"%s\"></td>", f.getName(), f.get(district)));
						}
					}
					%>
					<td align="center">
					<input type="hidden" name="email"
						value="<%out.print(admin.getAdminEmail()); %>">
					<input type="submit" value="수정">
					</td>
					</form>
				</tr>
				<%
				}
				%>
				<tr>
				<form action="/gimpo-ac05/api/district/add" method="post">
				<%
					for (Field f : District.class.getDeclaredFields()) {
						f.setAccessible(true);
						out.print(String.format("<td align=\"center\"><input type=\"text\" name=\"%s\"></td>", f.getName()));
					}
					%>
					<td align="center">
					<input type="hidden" name="email"
						value="<%out.print(admin.getAdminEmail()); %>">
					<input type="submit" value="추가">
					</td>
				</tr>
		</table>
	</div>
	<%@include file="AdminFooter.jsp"%>
</body>
<%
		
	}
%>
</html>