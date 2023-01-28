<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>채팅방 목록 </title>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="<c:url value="/style/chat/list.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
	<h3 class=" text-center">채팅방 목록</h3>
	<div class="messaging">
		<div class="inbox_msg">
			<div class="inbox_people">
				<div class="inbox_chat">
					<c:forEach var="chat" items="${list}">
						<c:if test="${chat.sell_itemId ne 0}">
							<a href="chat/room?seid=${chat.sell_itemId}">
						</c:if>
						<c:if test="${chat.studyId ne 0}">
							<a href="chat/room?stid=${chat.studyId}">
						</c:if>
						<div class="chat_list">
							<c:if test="${chat.sell_itemId ne 0}">
								<div class="chat_people">
									<div class="chat_img"> <img src="<c:url value="/images/"/>${chat.sell_image}"> </div>
									<div class="chat_ib">
										<h5>[개인채팅] 판매 도서 이름 : ${chat.sell_itemName}<span class="chat_date">${chat.registrationDate}</span></h5>
										<p>${chat.message}</p>
									</div>
								</div>
							</c:if>
							<c:if test="${chat.studyId ne 0}">
								<div class="chat_people">
									<div class="chat_img"> <img src="<c:url value="/images/"/>${chat.bookImageUrl}"> </div>
									<div class="chat_ib">
										<h5>[그룹채팅] 스터디방 이름 : ${chat.studyName}<span class="chat_date">${chat.registrationDate}</span></h5>
										<p>${chat.message}</p>
									</div>
								</div>
							</c:if>
						</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>