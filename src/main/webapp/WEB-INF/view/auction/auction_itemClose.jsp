<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 마감</title>
</head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
* {
   margin-left: auto; margin-right: auto;
}

.btn1{
    width: 300px;
    /* height: 29px; */
    border: 1px solid #DDDDDD;
    /* font-size: 12px; */
    /* padding: 9px; */
    /* display: block; */
    margin-top: 0px;
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 0px;
    text-align: center;
    /* margin-top: 20px; */
    
    padding: 9px 10px 9px 10px;
    background-color: #DDDDDD;
    color: #424242;
    display: inline-block;      
}
td.bid_td {
	width : 150px;
	height : 50px;
	font-weight : 700;
	background-color : #DDDDDD;
	text-align : center;
	
}
td.bid_td2 {
	width : 300px;
	height : 50px;
	font-weight : 500;
	text-align : center;
	
}
table.bid {
	border-spacing: 7px;
}
</style>
<body>
<div align = "center">
	<h2> "${ ai.itemname}" 경매가 마감되었습니다.</h2>
	<h4>입찰자 정보</h4>
	<c:if test="${bid_ok ==1}" >
	<table class="bid">
	<tr>
		<td class="bid_td">낙찰 id</td>
		<td class="bid_td2">${ab.au_bidId}</td>
	</tr> <tr>
		<td class="bid_td">낙찰자 성함</td>
		<td class="bid_td2">${bid_member.name } </td> </tr> 
	<tr>	
		<td class="bid_td">경매 아이템</td>
		<td class="bid_td2">${ai.itemname } </td>
	</tr>
	<tr>
		<td class="bid_td">낙찰 가격</td>
		<td class="bid_td2">${ab.bidprice } </td>
	</tr>
	</table>
	</c:if>
	<c:if test="${bid_ok==0 }" >
	<h3>입찰자가 아무도 없습니다.</h3>
	</c:if>

</div>
<%@ include file="../main/IncludeBottom.jsp"%>