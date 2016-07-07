<%@page import="com.fivetrue.gimpo.ac05.api.DistrictApiHandler"%>
<%@page import="com.fivetrue.api.Result"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Admin admin = (Admin) session.getAttribute("admin");
	DistrictApiHandler handler = new DistrictApiHandler(getServletContext(), request, response);
	if (admin != null) {
		Result result = handler.updateDistrictResult();
		if (result.getErrorCode() == Result.ERROR_CODE_OK) {
			response.sendRedirect("/gimpo-ac05/admin/info/district");
		} else {
%>
			<script type="text/javascript">
					alert(<%out.print(result.getResult().toString()); %>);
					history.back();
				</script>
			<%
		}
	}else{
		handler.updateDistrict();
	}
 	
 %>