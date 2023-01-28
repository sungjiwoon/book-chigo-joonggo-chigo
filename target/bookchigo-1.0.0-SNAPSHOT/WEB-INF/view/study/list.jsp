<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>스터디원 모집 </title>
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

<body>
    <div align="center">
        <div class="post">
			<input type="button" value="스터디 등록" class = "btn1" onclick="location.href='study/register'">
            <table>
				<c:forEach var="study" items="${list}">
				<tr>
					<td><img class="bookimg" src="<c:url value="/images/"/>${study.bookImageUrl}"></td>
					<td style="padding-left:35px; width:350px">
						<a href="chat/room?stid=${study.studyId}"><h3>${study.studyName}</h3></a>
						<i class="fa fa-user"></i> ${study.currentMemberCnt}/${study.maxMemberCnt}</h3>
						<br>토론일정: ${study.discussionDate}
						<br>도서정보: ${study.bookName} (글쓴이 : ${study.bookAuthor})
						<br>${study.introduction}</td>
				</tr>
				</c:forEach>
            </table>
        </div>
    </div>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>
</body>