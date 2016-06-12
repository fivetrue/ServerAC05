<%@page import="com.google.gson.Gson"%>
<%@page import="com.fivetrue.api.Result"%>
<%@page import="com.fivetrue.gimpo.ac05.api.NaverAPIManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		NaverAPIManager manager = new NaverAPIManager(getServletContext(), request, response);
		Result result = manager.receiveServiceCallback();
		String resultJson = new Gson().toJson(result);
	%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">

	var windowWidth = window.screen.width < window.outerWidth ?
    	    window.screen.width : window.outerWidth;
	var mobile = windowWidth < 500;
	var response =  '<%out.print(resultJson);%>';
	if(mobile){
		window.Android.onCallback(response);
	}else{
		alert("response : " + response);
	}
	
</script>
<title>Callback page</title>
</head>
<body>

</body>
