<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
	<title> 경매 확인 </title>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
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

.book_img {
  width : 220px;
  height : 312px;
  float: left;
  display:inline-block;
  padding: 10px 18px 10px 18px;
 

}


#title_box{
    width: 450px; 
    height: 70px;
    border: 0px solid #DDDDDD;
    font-size: 50px;
    padding: 15px 8px 20px 10px;
    display: block;
    /* margin-right: auto; */
    /* margin-left: auto; */
    margin-top: 20px;
    margin-left: 0px;
    font-family: 'Jeju Myeongjo', sans-serif;
    font-weight: 700; 
}

#author_box, #date_box, #price_box, #condition_box {
    width: 400px; 
    height: 15px;
    border: 0px solid #DDDDDD;
    font-size: 18px;
    padding: 15px 10px 10px 10px;
    display: block;
    /* margin-right: auto; */
    /* margin-left: auto; */
    margin-top: 5px;
    margin-left: 0px;
    font-family: "Nanum Gothic", sans-serif;
    font-weight: 500; 
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


  </style>
</head>
<body>
  <div align="center">
   
    <div class="post">
      <img class="book_img" src="<c:url value="/images/"/>${ai.imageurl}">
      <!-- <text id="title_box" value="해리포터 한정판" > -->
      <input id="title_box" type="text" value="${ai.itemname }" readonly>
      <input id="author_box" type="text" value="${ai.author } |  ${ai.publisher}" readonly >
      <hr style = "width : 470px; border-top : 1px solid #DDDDDD">
<%--       <fmt:formatDate value = "${item.deadline}" type="both" var="deadDate" pattern="yyyy년 MM월 dd일 hh시 mm분"/> --%> 
  <%--     <fmt:formatDate value="${item.deadline}" type="both" pattern="yyyy-MM-dd [E] a hh:mm:ss"/> --%>
      <input id="date_box" type="text" value="마감 날짜 : <fmt:formatDate value="${ai.deadline}" pattern="yyyy년 MM월 dd일"/>" readonly >
      <input id="condition_box" type="text" value="도서 상태 : ${ai.condition }" readonly >
      <input id="price_box" type="text" value="가격 시작 : ${ai.startprice }원" readonly >
      <br>
      
      <div align = "left" >    
      <c:if test="${ai.memberId == memberId}"> 
      	<c:if test="${ai.dealstatus == 0 }"> 
      	<input type="button" value="경매 마감" class = "btn1" onClick="location.href='<c:url value='/auction/close.do'><c:param name="itemId" value="${ai.au_itemId}"/></c:url>'">
      	<input type="button" value="게시글 수정" class = "btn1" onClick="location.href='<c:url value='/auction/update'><c:param name="itemId" value="${ai.au_itemId}"/></c:url>'">
      	<br><br></c:if>
      
      <input type="button" value="경매 목록" class = "btn1" onClick="location.href='<c:url value='/auction'/>'"> 
      <input type="button" value="경매 삭제" class = "btn1" onClick="location.href='<c:url value='/auction/delete.do'><c:param name="itemId" value="${ai.au_itemId}"/></c:url>'">
      	<c:if test="${ai.dealstatus == 1 }">
      	<br><p align = "left">&nbsp;&nbsp;<text style="color:red;">경매 마감</text> | 최종 낙찰 가격 : <text style="color:red;"> ${ai.finalprice }원</text></p>
      	</c:if>
      </c:if>      
      
      
      <c:if test="${ai.memberId != memberId}">  
      <input type="button" value="경매 목록" class = "btn1" onClick="location.href='<c:url value='/auction'/>'">
      	<c:if test="${ai.dealstatus == 0 }">
      	<input type="button" value="경매 신청" class = "btn1"  onClick="location.href='<c:url value='/auction/apply'><c:param name="startprice" value="${ai.startprice}"/><c:param name="itemId" value="${ai.au_itemId}"/></c:url>'">
      	</c:if>
      	<c:if test="${ai.dealstatus == 1 }">
      	<br><p align = "left">&nbsp;&nbsp;<text style="color:red;">경매 마감</text> | 
      		<c:if test="${ai.finalprice != -1 }">최종 낙찰 가격 : <text style="color:red;"> ${ai.finalprice }원</text></c:if>
      		<c:if test="${ai.finalprice == -1 }">낙찰자가 없습니다.</c:if>
      		</p></c:if>
      </c:if>
  	</div>  
    
    </div>

    <div class="apply">
        <table class="ap">
        <c:if test="${haveBid == 1 }">
            <c:set var="i" value="0"/> <!-- 줄바꿈을 위한 장치 1 -->
            <c:forEach var="item" items="${bidList}">
            <c:if test= "${i % 6 == 0 }" > <!-- 줄바꿈을 위한 장치2  -->
            <tr> </c:if>
                <td class="aptd"><text class="name">${item.au_bidId} 님</text><br><text class="price">${item.bidprice }원</text></td>
            
            <c:if test= "${i % 6 == 5 }" > <!-- 줄바꿈을 위한 장치3  -->
            </tr> </c:if>       
        	
        	<c:set var ="i" value="${i+1 }" />
            </c:forEach>
            
       </c:if>
       <c:if test="${haveBid == 0 }">
       <tr> <td > 현재 입찰 건이 없습니다. </td> </tr> </c:if> 
       </table>
    </div>

  </div>
</div>
<%@ include file="../main/IncludeBottom.jsp"%>