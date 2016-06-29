<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link rel="stylesheet"
	href="bower_components/animate.css/animate.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="/gimpo-ac05/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<title>AC-05 Admin page</title>
</head>
<body>
	<div class="container" align="center">
		<h1>AC-05 관리자 로그인</h1>
		<form action="./push" method="post">
			<div class="row">
				<p>Email
				<p>
					<input type="text" name="email" />
			</div>
			<div class="row">
				<p>ID</p>
				<input type="text" name="id" />
			</div>
			<div class="row">
				<p>
					<input type="submit" value="로그인">
				</p>
		</form>
		<p>Support user</p>
		<p>fivetrue1101@gmail.com (이름없는마루)</p>
	</div>
</body>
</html>