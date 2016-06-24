<%@page import="com.fivetrue.gimpo.ac05.vo.Admin"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.AdminUserDBManager"%>
<%@page import="com.fivetrue.utils.TextUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fivetrue.gimpo.ac05.manager.UserDBManager"%>
<%@page import="com.fivetrue.gimpo.ac05.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AC-05 Admin page</title>

<%

	String email = request.getParameter("email");
	String id = request.getParameter("id");
	
	if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(id)){
		ArrayList<UserInfo> admins = UserDBManager.getInstance().getSelectQueryData(null, "userinfo.email='"+ email +"' AND userinfo.id='" +id + "'");
		if(admins != null && admins.size() > 0){
			UserInfo adminUser = admins.get(0);
			AdminUserDBManager.getInstance().create();
			Admin admin = AdminUserDBManager.getInstance().getAdmin(adminUser.getEmail());
			if(admin != null){
				session.setAttribute("admin", adminUser);
			}else{
				response.sendRedirect("./error");
			}
		}else{
			response.sendRedirect("./error");	
		}
	}else{
		response.sendRedirect("./error");
	}
%>
</head>
