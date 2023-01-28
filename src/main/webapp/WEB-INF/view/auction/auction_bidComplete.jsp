<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 입찰 완료</title>
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
    cursor : pointer;
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
<div align="center">
	<h2>입찰이 완료되었습니다.</h2>
	<h4>입찰자 정보</h4>
	
	<table class="bid">
	<tr class="bid_tr">
		<td class="bid_td">입찰 id</td>
		<td class="bid_td2">${ab.au_bidId}</td></tr> 
	<tr class="bid_tr">
		<td class="bid_td">입찰자 성함</td>
		<td class="bid_td2">${host_name } </td> </tr> 
	<tr class="bid_tr">	
		<td class="bid_td">경매 고유 id</td>
		<td class="bid_td2">${ab.au_itemId } </td>
	</tr>
	<tr class="bid_tr">	
		<td class="bid_td">경매 아이템</td>
		<td class="bid_td2">${item_name } </td>
	</tr>
	<tr class="bid_tr">
		<td class="bid_td">입찰 가격</td>
		<td class="bid_td2">${ab.bidprice } </td>
	</tr>
	</table>
	
	<button class = "btn1" onClick="location.href='<c:url value='/auction/item.do'><c:param name="item_id" value="${ab.au_itemId}"/></c:url>'" > 해당 경매로 이동 </button> <br> <br>
</div>
</body>
</html>
<%@ include file="../main/IncludeBottom.jsp"%>