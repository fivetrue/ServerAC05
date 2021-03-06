<%@page import="com.fivetrue.gimpo.ac05.manager.DistrictDBManager"%>
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
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="apple-touch-icon" href="apple-touch-icon.png"> -->
    <!-- <link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32" /> -->
    <link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16" />
    <link rel="stylesheet" href="/gimpo-ac05/css/normalize.min.css">
    <link rel="stylesheet" href="/gimpo-ac05/css/bootstrap.min.css">
    <link rel="stylesheet" href="/gimpo-ac05/css/jquery.fancybox.css">
    <link rel="stylesheet" href="/gimpo-ac05/css/flexslider.css">
    <link rel="stylesheet" href="/gimpo-ac05/css/styles.css">
    <link rel="stylesheet" href="/gimpo-ac05/css/queries.css">
    <link rel="stylesheet" href="/gimpo-ac05/css/etline-font.css">
    <link rel="stylesheet" href="bower_components/animate.css/animate.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <script src="/gimpo-ac05/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<title>AC-05 Admin page</title>

<%

	String email = request.getParameter("email");
	String id = request.getParameter("id");
	UserInfo adminUser = null;
	Admin admin = null;
	if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(id)){
		DistrictDBManager.getInstance().create();
		UserDBManager.getInstance().create();
		ArrayList<UserInfo> admins = UserDBManager.getInstance().getSelectQueryData(null, "userinfo.email='"+ email +"' AND userinfo.id='" +id + "'");
		if(admins != null && admins.size() > 0){
			adminUser = admins.get(0);
			AdminUserDBManager.getInstance().create();
			admin = AdminUserDBManager.getInstance().getAdmin(adminUser.getEmail());
			if(adminUser != null && admin != null){
				session.setAttribute("admin", admin);
				session.setAttribute("adminUser", adminUser);
			}else{
				response.sendRedirect("/gimpo-ac05/admin/login");
				return;
			}
		}else{
			response.sendRedirect("/gimpo-ac05/admin/login");
			return;
		}
	}else{
		adminUser = (UserInfo) session.getAttribute("adminUser");
		admin = (Admin) session.getAttribute("admin");
		if(admin != null && adminUser != null){
			
		}else{
			response.sendRedirect("/gimpo-ac05/admin/login");
			return;
		}
	}
%>
</head>

<body>

<header>
<div class="header-content" bgcolor="#000000">
	<div class="header-nav">
		<nav>
		<ul class="primary-nav">
			<li><a href="/gimpo-ac05/admin/push">푸쉬</a></li>
			<li><a href="/gimpo-ac05/admin/info/image">정보 이미지</a></li>
			<%
			if(admin != null && admin.getAdminType() >= 3){
				%>
				<li><a href="/gimpo-ac05/admin/info/app">앱 설정</a></li>
				<li><a href="/gimpo-ac05/admin/info/district">구역 설정</a></li>
				<%
			}
			
			if(admin != null && admin.getAdminType() >=2){
				%>
				<li><a href="/gimpo-ac05/admin/info/users">회원정보</a></li>
				<%
			}
			%>
		</ul>
		</nav>
	</div>
	<div class="navicon">
		<a class="nav-toggle" href="#"><span></span></a>
	</div>
</div>
</header>
</body>
