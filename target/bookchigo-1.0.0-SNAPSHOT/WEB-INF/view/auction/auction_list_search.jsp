<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id = "toDay" class = "java.util.Date"/>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 검색 결과</title>
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
	cursor : pointer;
}

.div1 {
/*   font-family: "Nanum Gothic", sans-serif; */
  font-weight: 690; 
  font-size : 20px;
  padding: 10px 18px 10px 10px;
   
}

.book_td {
  padding: 30px 30px 30px 30px;
}

.book_img {
  width : 120px;
  height : 170px;
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
<body>
<div align="center">
<p class="div1" >"${key}" 검색 결과 입니다.</p>
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
		<td class="list" onClick="location.href='<c:url value='/auction/item.do'><c:param name="item_id" value="${item.au_itemId}"/></c:url>'" style="cursor:pointer;">
		<img class="book_img" src="<c:url value="/images/" />${item.imageurl}" /> 
		
		<br> <p>
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
            <text style="font-size:17px; align: center; font-family: 'Jeju Myeongjo', sans-serif; font-weight:700;">${item.itemname }</text><br>
            <text style="font-size:15px; text-align: center;">${item.author } | ${item.publisher}</text><br>
            <text style="font-size:17px; text-align: center; color:#E02020;">${item.startprice } 원</text> </p>
        </td>
        
        <c:if test= "${i % 5 == 4 }" > <!-- 줄바꿈을 위한 장치3  -->
		</tr> 
		</c:if>
		<c:set var ="i" value="${i+1 }" /> <!-- 줄바꿈을 위한 장치 4 -->
		
		</c:forEach>
    </table>
    <button class = "btn1" onClick="location.href='<c:url value='/auction'/>'"  style="cursor:pointer;"> 경매 목록 가기 </button> <br> <br>
  </div>
</body>
</html>