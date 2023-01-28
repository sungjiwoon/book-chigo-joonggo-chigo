<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 신청하기.</title>
</head>
<style>
.btn1{
    width: 200px;
    /* height: 29px; */
    border: 1px solid #DDDDDD;
    font-size: 14px;
    /* padding: 9px; */
    /* display: block; */
    margin-right: auto;
    margin-left: auto;
    
    /* margin-top: 20px; */
    padding: 10px 18px 10px 18px;
    background-color: gray;
    color: white;
    display: inline-block;    
	cursor : pointer;
}

#price_box{
    width: 400px; 
    height: 25px;
    border: 1px solid #DDDDDD;
    font-size: 17px;
    padding: 10px;
    display: block;
    /* margin-right: auto; */
    /* margin-left: auto; */
    margin-top: 20px;
    margin-left: 0px;
}


</style>
<body>
<div align="center">
<table><tr><td>
    <form  method="POST" action="<c:url value='/auction/apply.do' />">
     <!--  <img src="../images/book1.jpg" alt="최근책" class="book_img"> -->
      	<input id="price_box" type="number" min = "${startprice}" placeholder="입찰가격" name = "bidprice" required>
       	<input type="hidden" name="au_itemId" value="${item_id }"/>
      	<br>
     
      	<input class="btn1" type="submit" value = "입찰하기"> &nbsp;
	 	<input class="btn1" type="button" value = "취소" onclick="location.href='<c:url value='/auction/item.do'><c:param name="item_id" value="${itemId}"/></c:url>'">
      </form>
</td></tr></table>
</div>
</body>
</html>
<%@ include file="../main/IncludeBottom.jsp"%>
