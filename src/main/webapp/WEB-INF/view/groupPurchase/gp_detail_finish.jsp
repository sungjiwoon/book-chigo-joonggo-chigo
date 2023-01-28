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
<title>게시글 자세히 보기</title>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
@charset "UTF-8";
* {
   font-family: 'Jeju Myeongjo', sans-serif;
   margin-left: auto; margin-right: auto;
}
		table, th, tr {
			border: 3px solid white;
         	border-collapse: collapse;
			table-layout:fixed;
			margin-left : auto;
			margin-right : auto;
			font-family: "Nanum Gothic", sans-serif;		
			text-align : center;	
		}
		
		.table{
			font-family: "Nanum Gothic", sans-serif;
			width: 90%;
		}
		
		#hint {
			background-color : #DDDDDD;
			width:150px;
		}
		
		#box {
			background-color : white;
			margin: 40px 00px 40px 0px;
			width:500px;
			height:300px;
			border-radius : 50px 50px 50px 50px;
			align:right;
			
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
    		/* height: 29px; */
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
   		
   		.book_img {
  			width : 200px;
  			height : 250px;
  			float: left;
  			display:inline-block;
  			padding: 10px 18px 10px 18px;
  		}
   		
</style>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
</head>
<body>
<div align="center">
<h2>게시글 보기</h2>
이미 마감된 공동구매입니다.<br><br>
	<table id="box">
		<tr align="left">
			<th rowspan="7"><img class="book_img" src="<c:url value="/images/"/>${Thisbook.book_photo}"></th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">ISBN : ${Thisbook.book_id}</th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">제목 : ${Thisbook.book_name}</th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">저자 : ${Thisbook.book_writer}</th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">출판사 : ${Thisbook.book_publisher}</th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">가격 : ${Thisbook.book_price}</th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">책 줄거리 : ${Thisbook.book_summary}</th>
		</tr>		
	</table>
	<br><br><br><br><br><br><br>
	<table style="width:900px; height:45px" >
		<tr>
			<th id="hint">신청한 사람</th>
 			<th>이 공동구매의 리더만 볼 수 있습니다.</th> 
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px" >
		<tr>
			<th id="hint">게시글 고유번호</th>
			<th >${gpDetail.gp_postId}</th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px" >
		<tr>
			<th id="hint">게시글 제목</th>
			<th>${gpDetail.post_title}</th>	
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px" >
		<tr>
			<th id="hint">모집자</th>
			<th>${gpDetail.readerId}</th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">모집기한</th>
			<th><fmt:formatDate value="${gpDetail.gp_date}" pattern="yyyy-MM-dd"/> 까지</th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">현재상황</th>
			<th>${gpDetail.now} / ${gpDetail.limit}</th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">공구가</th>
			<th>${gpDetail.dis_price}</th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:100px">
		<tr>
			<th id="hint">내용</th>
			<th >${gpDetail.post_contents}</th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">입금계좌</th>
			<th >${gpDetail.account}</th>
		</tr>
	</table>
</div>
<%@ include file="../main/IncludeBottom.jsp"%> 