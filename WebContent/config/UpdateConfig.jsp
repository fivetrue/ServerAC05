<%@page import="com.fivetrue.api.Result"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.Admin"%>
<%@page import="com.fivetrue.gimpo.ac05.api.AppConfigApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Admin admin = (Admin) session.getAttribute("admin");
	AppConfigApiHandler handler = new AppConfigApiHandler(getServletContext(), request, response);
	if (admin != null) {
		Result result = handler.updateConfigResult();
		if (result.getErrorCode() == Result.ERROR_CODE_OK) {
			response.sendRedirect("/gimpo-ac05/admin/info/app");
		} else {
%>
			<script type="text/javascript">
					alert(<%out.print(result.getResult().toString()); %>);
					history.back();
				</script>
			<%
		}
	}else{
		handler.updateConfig();
	}
 	
 %>