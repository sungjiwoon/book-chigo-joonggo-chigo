<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 등록하기</title>
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
		
		.table {
			width: 90%;
			font-family: "Nanum Gothic", sans-serif;
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
 
		#text {
			border:none;
		}
		
		.img_box {
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
<h2>공동구매 모집하기</h2>
<form name="form" method="POST" action="<c:url value='/groupPurchase/upload.do' />" enctype="multipart/form-data">
<input type="submit" value="모집 시작하기" class="btn0" required>
	<table id="box">
		<tr align="left">
			<th rowspan="7" align="left"> 
			<input type="file" class="img_box" name="img_file" placeholder="파일첨부" required> </th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">ISBN : 
			<input type="text" name="book_id" required> </th>
		</tr>
		<tr align="left">
			<th align="left" id="hint"> 제목 :  
			<input type="text" name="book_name" required> 
			</th>
		</tr>
		<tr align="left">
			<th align="left" id="hint"> 저자 : 
			<input type="text" name="book_writer" required> </th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">출판사 : 
			<input type="text" name="book_publisher" required> </th>
			</tr>
		<tr align="left">
			<th align="left" id="hint">가격 : 
			<input type="text" name="book_price" required> </th>
		</tr>
		<tr align="left">
			<th align="left" id="hint">책 줄거리 :
			<input type="text" name="book_summary" required> </th>
		</tr>			
	</table>
<br><br><br><br><br><br><br>
	
	<table style="width:900px; height:45px" >
		<tr>
			<th id="hint">게시글 고유번호</th>
			<th><input readonly value='고유번호 미정, 게시글 등록완료시 고유번호가 부여됩니다.' 
			style="border:none; text-align:center; width:800px" type="text" required >
			</th>
		</tr>
	</table>
	<br><br>	
	<table style="width:900px; height:45px">	
		<tr>
			<th id="hint">제목</th>
			<th><input value="&lt;책제목&gt;을 포함해주세요" name="post_title" 
			style="border:none; width:800px; text-align:center" type="text" required  >
			</th>
		</tr>
	</table>
	<br><br>	
	<table style="width:900px; height:45px" >
		<tr>
			<th id="hint">모집자</th>
			<th><input readonly name="readerId" value='${gpForm.readerId}' 
			style="border:none; width:800px; text-align:center" type="text"  >
			<input type="hidden" name="readerMemberId" value='${gpForm.readerMemberId}' 
			style="border:none; width:800px; text-align:center">
			</th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">모집기한</th>
			<th><input name="gp_date" style="border:none; 
			text-align:center; width:800px" type="date" required></th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">제한인원</th>
			<th><input name="limit" style="border:none; text-align:center; width:800px" type="text" required></th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">공구가</th>
			<th><input name="dis_price"
			style="border:none; text-align:center; width:800px" type="text" required></th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:100px">
		<tr>
			<th id="hint" >내용</th>
			<th><input name="post_contents"
			style="border:none; text-align:center; width:800px" type="text" required></th>
		</tr>
	</table>
	<br><br>
	<table style="width:900px; height:45px">
		<tr>
			<th id="hint">입금계좌</th>
			<th><input name="account" readonly value="${gpForm.account}"
			style="border:none; text-align:center; width:800px" type="text" ></th>
		</tr>
	</table>
</form>
</div>
<%@ include file="../main/IncludeBottom.jsp"%> 