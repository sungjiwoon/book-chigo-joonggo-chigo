<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 전체 목록</title>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
@charset "UTF-8";
* {
   font-family: 'Jeju Myeongjo', sans-serif;
   margin-left: auto; margin-right: auto;
}
		table, th, tr {
			border: 3px solid white;
         	border-collapse : collapse;
			table-layout : fixed;
			margin-left : auto;
			margin-right : auto;	
			font-family: "Nanum Gothic", sans-serif;
			text-align : center;
		}
					
		.table {
			width: 90%;
			font-family: "Nanum Gothic", sans-serif;
		}
		
		#hint {
			background-color : #DDDDDD;
			text-align : center;
			font-family: "Nanum Gothic", sans-serif;
			text-style:bold;
			height:25px;
		}
		
		#search_box { 
			width: 300px;
    		height: 40px;
    		border: 1px solid #DDDDDD;
    		font-size: 17px;
    		padding: 10px;
    		display: block;
    		margin-right: auto;
    		margin-left: auto;
    		margin-top: 20px;
    		display:inline-block;
    	}
    			
		.bookimg {
			width:100px;
			height:150px;
		}
		
    	.btn0 {
    		width: 130px;
    		/* height: 29px; */
    		border: 2px solid #DDDDDD;
   		 	font-size: 16px;
    		/* padding: 9px; */
    		/* display: block; */
    		margin-right: auto;
    		margin-left: auto;
    		font-family: "Nanum Gothic", sans-serif;
    		font-weight: 700; 
    		/* margin-top: 20px; */
    		padding: 10px 18px 10px 18px;
    		background-color: white;
    		color: #424242;
    		display: inline-block;    
    		border-radius : 50px 50px 50px 50px;
		}		
		
    	.btn1 {
    		width: 130px;
    		height: 40px;
    		border: 1px solid #DDDDDD;
   		 	font-size: 16px;
    		/* padding: 9px; */
    		/* display: block; */
    		margin-right: auto;
    		margin-left: auto;
    		font-family: "Nanum Gothic", sans-serif;
    		font-weight: 700; 
    		/* margin-top: 20px; */
    		padding: 10px 18px 10px 18px;
    		background-color: #DDDDDD;
    		color: #424242;
    		display: inline-block;    
    		border-radius : 1px;
		}
		
		.post {
   			margin:0 auto; width:750px;
    		height : 380px;
   			padding: 40px 18px 10px 18px;
   		}
   		
</style>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
</head>
<body>
<div align="center">
<h1>전체 목록</h1>
<input type="button" value="전체 목록보기" class="btn0" onclick="location.href='<c:url value='/groupPurchase/list.do'/>'"/>
<input type="button" value="모집하기" class="btn0" onclick="location.href='<c:url value='/groupPurchase/uploadForm.do'/>'"/>
<input type="button" value="나의 모집" class="btn0" onclick="location.href='<c:url value='/groupPurchase/ImReader/list.do'/>'"/>
<input type="button" value="나의 신청" class="btn0" onclick="location.href='<c:url value='/groupPurchase/ImApplier/list.do'/>'"/>
</div>
<br><br>
<div align="center" class="posts">
	<table class="table" style="width:1000px;">
		<tr style="height:45px"> 
			<th id="hint" style="width:10%;">고유번호</th>
			<th id="hint" style="width:16%;">책</th>
			<th id="hint" style="width:48%;">정보</th>
			<th id="hint" style="width:14%;">공구가</th>
			<th id="hint" style="width:11%;">공구원</th>
		</tr>			
		<c:forEach var="post" items="${PostList}">
		<tr onClick="location.href='<c:url value='/groupPurchase/detail.do'><c:param name="gp_postId" value="${post.gp_postId}"/></c:url>'" 
		style="cursor:pointer; height:170px;">
			<th style="width:10%;">${post.gp_postId}</th>	    
			<th style="width:16%;"><img class="bookimg" src="<c:url value="/images/"/>${post.book_photo}"></th>
			<th style="text-align:left; width:48%;">
				&nbsp;&nbsp;&nbsp;${post.post_title}<br><br>
				&nbsp;&nbsp;&nbsp;ISBN : ${post.book_id} <br><br>
				&nbsp;&nbsp;&nbsp;모집자 : ${post.readerId}<br><br>
				&nbsp;&nbsp;&nbsp;기한: <fmt:formatDate value="${post.gp_date}" pattern="yyyy-MM-dd"/>까지 </th>
			<th style="width:14%;">${post.dis_price}</th> <!-- 공구 리더, 총대 -->
			<th style="width:11%;">${post.now} / ${post.limit} </th>
		</tr>
	    </c:forEach>	 
	</table>
</div>
<br><br><br>
<div align="center">
	<form name="Search" method="POST" action="<c:url value='/groupPurchase/search.do'/>">
   		<input type="text" id="search_box" placeholder="검색어를 입력하세요" required="required" name="book_name">
   		<input type="submit" value="search" class="btn1">
 	</form>
</div>
<%@ include file="../main/IncludeBottom.jsp"%> 