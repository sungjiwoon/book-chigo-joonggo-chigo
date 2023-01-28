<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <style>
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
* {
   margin-left: auto; margin-right: auto;
}


.btn1{
    width: 100px;
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

.post {
    margin:0 auto; width:750px;
    height : 380px;
    padding: 40px 18px 10px 18px;

}

table.ap {
    border-spacing: 7px;
}

td.aptd {
    width : 180px;
    border: 1px solid #DDDDDD;
    text-align: center;
    padding: 6px 10px 6px 10px;
    
}
.name {
    color : black;
    
    font-family: "Nanum Gothic", sans-serif;
    font-weight: 600;

}
.price {
    color : #E02020;
    
    font-family: "Nanum Gothic", sans-serif;
    font-weight: 500;
}

.bid {
    color : #03ffc0;
    
    font-family: "Nanum Gothic", sans-serif;
    font-weight: 800;
}


  </style>
<body>
<div align="center">
<div class="apply">
        <table class="ap">
            <c:set var="i" value="0"/> <!-- 줄바꿈을 위한 장치 1 -->
            <c:forEach var="item" items="${list}">
            <c:if test= "${i % 4 == 0 }" > <!-- 줄바꿈을 위한 장치2  -->
            <tr> </c:if>
                <td class="aptd" onClick="location.href='<c:url value='/auction/item.do'><c:param name="item_id" value="${item.au_itemId}"/></c:url>'" style="cursor:pointer;">
                	<text class="name">${item.au_bidId}</text><br>
                	<text class="price">${item.bidprice }원</text><br>
                	<c:if test="${item.bidstatus == 0 }"> 
                	<text class="name">입찰 중</text><br>
                	</c:if>
                	<c:if test="${item.bidstatus == 1 }"> 
                	<text class="bid">낙찰 상태</text><br>
                	</c:if>
                	<c:if test="${item.bidstatus == 5 }"> 
                	<text class="name">경매 마감</text><br>
                	</c:if>
                </td>
            
            <c:if test= "${i % 4 == 3 }" > <!-- 줄바꿈을 위한 장치3  -->
            </tr> </c:if>       
        	
        	<c:set var ="i" value="${i+1 }" />
            </c:forEach>
            
<!--        <tr> <td > 현재 입찰 건이 없습니다. </td> </tr>  -->
       </table>
    </div>

  </div>
</body>
</html>