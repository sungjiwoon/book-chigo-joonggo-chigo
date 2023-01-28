<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>북치고 중고치고</title>
<link rel='stylesheet'
	href='https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link href="<c:url value="/style/member/login.css" />" rel="stylesheet">
<script type="text/javascript">
	var message = ${isLoginFail};
	if (message === true) {
		alert("로그인 정보가 올바르지 않습니다.");
	}
</script>

</head>
<body>
	<!-- partial:index.partial.html -->
	<div class="wrapper">
		<form class="form-signin" action="login.do" method="post">
			<h2 class="form-signin-heading">북치고 중고치고</h2>
			<input type="text" class="form-control" name="username"
				placeholder="아이디" required="" autofocus="" /> <input
				type="password" class="form-control" name="password"
				placeholder="비밀번호" required="" />

			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
			<button class="btn btn-lg btn-success btn-block" type="submit" onclick="location.href='register'">Join</button>
		</form>
	</div>
	<!-- partial -->

</body>
</html>
