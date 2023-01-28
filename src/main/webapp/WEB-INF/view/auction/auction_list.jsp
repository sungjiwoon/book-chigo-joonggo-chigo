<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id = "toDay" class = "java.util.Date"/>
<%@ include file="../main/IncludeTop.jsp"%>


<html>
  <head>
    <meta charset="utf-8">
	<title> 경매 글 읽기 및 작성 </title>
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
  <style>
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
* {
   margin-left: auto; margin-right: auto;
}

#search_box {
   width: 500px;
    height: 30px;
    border: 1px solid #DDDDDD;
    font-size: 17px;
    padding: 10px;
    display: block;
    margin-right: auto;
    margin-left: auto;
    margin-top: 20px;
}

.btn1{
    width: 150px;
    /* height: 29px; */
    border: 1px solid #DDDDDD;
    font-size: 14px;
    /* padding: 9px; */
    /* display: block; */
    margin-right: auto;
    margin-left: auto;
    font-family: "Nanum Gothic", sans-serif;
    font-weight: 600; 
    /* margin-top: 20px; */
    padding: 10px 18px 10px 18px;
    background-color: #DDDDDD;
    color: #424242;
    display: inline-block;    
    border-radius : 1px;
	cursor : pointer;
}

.btn2 {
    width: 80px;
    height : 30px;
    /* height: 29px; */
    border: 1px solid #DDDDDD;
    font-size: 14px;
    /* padding: 9px; */
    /* display: block; */
    margin-right: auto;
    margin-left: auto;
    font-weight: 500; 
    /* margin-top: 20px; */
/*     padding: 10px 18px 10px 18px; */
/*     background-color: #DDDDDD; */
	font-family: "Nanum Gothic", sans-serif;
    color: #424242;
    display: inline-block;    
    border-radius : 8px;
    cursor : pointer;

}

.div1 {
  font-family: "Nanum Gothic", sans-serif;
  font-weight: 690; 
  font-size : 20px;
  padding: 10px 18px 10px 10px;
   
}

.book_td {
  padding: 30px 30px 30px 30px;
}

.book_img {
  width : 148px;
  height : 210px;
}

.book_title {
  font-size:18px;
  text-align:center;
}

.book_author {
  font-size:15px;
  text-align:center;
}

table.list {
	border-spacing : 20px;
}

  </style>
</head>
<div align="center">
 <div class="search">
 <form  method="POST" action="<c:url value='/auction/search.do' />" >
 	  <input id="search_box" type="text" name = "key" placeholder="도서 이름이, 작가 이름만 검색 가능합니다." > <br>
 	  <input type = "radio" name="type_search" value="itemname" checked>
 	  <label for="author">도서 이름</label>
 	  <input type = "radio" name="type_search" value="author">
 	  <label for="author">작가 이름</label>
      <input type="submit" value="경매 검색" class = "btn2">
      <br> <br>
      <input type="button" value="경매 게시글 작성" class = "btn1" onclick="location.href='<c:url value='/auction/upload'/>'" >
      <c:if test="${islogin == 1 }">
      <input type="button" value="올린 경매 조회" class = "btn1" onclick="location.href='<c:url value='/auction/auctioneer.do'/>'" >
      <input type="button" value="입찰 내역 조회" class = "btn1" onclick="location.href='<c:url value='/auction/bidder.do'/>'" >
      </c:if>
    </div>

</form>
  <div class="list">
    <p class="div1" >최근 경매 목록</p>
    <fmt:parseNumber value="${toDay.time/(1000*60*60*24)}" integerOnly="true" var="nowDate"/>    
	<table class="list">
		<c:set var="i" value="0"/> <!-- 줄바꿈을 위한 장치 1 -->
		<c:forEach var="item" items="${list}">
		
		<%-- <fmt:parseDate value = "${item.deadline}" var="deadDate" pattern="EEE MM dd kk:mm:ss z yyyy"/>  --%>
		<fmt:parseNumber value="${item.deadline.time / (1000*60*60*24)}" integerOnly="true" var="strDate"/>
		
		<c:if test= "${i % 5 == 0 }" > <!-- 줄바꿈을 위한 장치2  -->
		<tr> 
		</c:if>
		
		<!-- td에 링크 걸기. -->
		<td class="list_img" onClick="location.href='<c:url value='/auction/item.do'><c:param name="item_id" value="${item.au_itemId}"/></c:url>'" style="cursor:pointer;">
		<img class="book_img" src="<c:url value="/images/" />${item.imageurl}" /> <br> <p>
		
		<c:choose> 
			<c:when test = "${strDate-nowDate < 0 or item.dealstatus == 1}">
			<text style="font-size:12px; text-align: center; color:#E02020;"> 경매 마감 </text>
			</c:when>
			<c:when test = "${strDate-nowDate > 0}">
            <text style="font-size:12px; text-align: center; color:#E02020;"> D - ${strDate-nowDate } </text>
            </c:when>
            <c:when test = "${strDate-nowDate == 0}">
            <text style="font-size:12px; text-align: center; color:#E02020; font-weight:700;"> 오늘 마감 </text>
            </c:when>
         </c:choose>
         
            <br>
            <text style="font-size:15px; align: center; font-family: 'Jeju Myeongjo', sans-serif; font-weight:700;">${item.itemname }</text><br>
            <text style="font-size:12px; text-align: center;">${item.author } | ${item.publisher}</text><br>
            <text style="font-size:15px; text-align: center; color:#E02020;">${item.startprice } 원</text> </p>
        </td>
        
        <c:if test= "${i % 5 == 4 }" > <!-- 줄바꿈을 위한 장치3  -->
		</tr> 
		</c:if>
		<c:set var ="i" value="${i+1 }" /> <!-- 줄바꿈을 위한 장치 4 -->
		
		</c:forEach>
    </table>
  </div>
</div>
<%@ include file="../main/IncludeBottom.jsp"%>