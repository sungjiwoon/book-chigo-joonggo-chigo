<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>북치고 중고치고</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value="/style/member/join.css" />" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="signup-form">
		<form action="register.do" method="post">
			<h2>회원가입</h2>
			<p>아래 정보들을 입력해주세요!</p>
			<hr>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <span class="fa fa-user"></span>
						</span>
					</div>
					<input type="text" class="form-control" name="id"
						placeholder="아이디" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i
							class="fa fa-paper-plane"></i>
						</span>
					</div>
					<input type="email" class="form-control" name="email"
						placeholder="이메일" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-lock"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="password"
						placeholder="비밀번호" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-lock"></i>
							<i class="fa fa-check"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="confirm_password"
						placeholder="비밀번호 확인" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i
							class="fa fa-address-book"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="name"
						placeholder="이름" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i
							class="fa fa-address-book"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="address"
						placeholder="주소" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i
							class="fa fa-location-arrow"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="phone"
						placeholder="전화번호를 입력해주세요." required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i
							class="fa fa-location-arrow"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="account"
						placeholder="계좌 번호를 입력해주세요." required="required">
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg">회원가입</button>
			</div>
		</form>
		<div class="text-center">
			<span style="color: #222;">이미 가입하셨나요? <a style="color:#222;" href="login">로그인하기</a></span>
		</div>
	</div>

</body>

</html>
