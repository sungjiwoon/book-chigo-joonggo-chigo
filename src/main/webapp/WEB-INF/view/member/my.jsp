<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../main/IncludeTop.jsp"%>

<!DOCTYPE html>
<html lang="kr">
<head>
	<meta charset="UTF-8">
	<title>북치고 중고치고</title>
	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<style>
		@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
		* {
			margin-left: auto; margin-right: auto;
		}
		.bookimg {
			width:100px;
			height:150px;
		}
		table {
			line-height:22px;
			border-spacing:0 30px;"
		}
	</style>
</head>
®
<body>
<div align="center">

	<div class="post">
		<input type="button" value="회원 탈퇴" class="member_delete_btn" onclick="">
		<table>

			<tr>
				<th>정보</th>
				<th>내용</th>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${member.id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.name}</td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><${member.account}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${member.phone}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${member.address}</td>
			</tr>
			<tr>
				<td>거래횟수</td>
				<td>${member.tradeCount}</td>
			</tr>
		</table>
	</div>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>
<script>
    $(document).ready(function () {
        $('.member_delete_btn').click(function () {
            if (confirm('정말 탈퇴하시겠습니까?')) {
                location.href = 'delete.do';
            }
        });
    });

</script>
</body>
</html>
