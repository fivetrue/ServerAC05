<%@page import="com.fivetrue.gimpo.ac05.api.ImageInfoApiHandler"%>
<%@page import="com.fivetrue.api.Result"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.UserInfo"%>
<%@page import="com.fivetrue.utils.TextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserInfo user = (UserInfo) session.getAttribute("adminUser");
	ImageInfoApiHandler manager = new ImageInfoApiHandler(getServletContext(), request, response);
	if(user == null){
		manager.deleteImageInfo();
	}else{
		Result result = manager.deleteImageInfoResult();
		if(result.getErrorCode() == Result.ERROR_CODE_OK){
			response.sendRedirect("/gimpo-ac05/admin/info/image");
		}else{
			%>
			<script type="text/javascript">
					alert(<%out.print(result.getResult().toString()); %>);
					history.back();
				</script>
			<%
		}
	}
%>
