<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
	<title> 경매 게시글 등록 </title>
  <style>
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
* {
   margin-left: auto; margin-right: auto;
}


.btn1{
    width: 200px;
    /* height: 29px; */
    border: 1px solid #DDDDDD;
    font-size: 16px;
    /* padding: 9px; */
    /* display: block; */
    margin-right: auto;
    margin-left: auto;
    
    /* margin-top: 20px; */
    padding: 10px 18px 10px 18px;
    background-color: gray;
    color: white;
    display: inline-block;    
    cursor:pointer;

}

.btn2{
    width: 180px;
    /* height: 29px; */
    border: 1px solid #DDDDDD;
    font-size: 16px;
    /* padding: 9px; */
    /* display: block; */
    margin-right: auto;
    margin-left: auto;
    
    /* margin-top: 20px; */
    padding: 10px 18px 10px 18px;
    background-color: #DDDDDD;
    color: white;
    display: inline-block;    
	cursor:pointer;
}

.book_img {
  width : 250px;
  float: left;
  display:inline-block;
  padding: 10px 18px 10px 18px;
 

}

#title_box, #author_box, #date_box, #price_box, #condition_box , #img_box{
    width: 400px; 
    height: 40px;
    border: 1px solid #DDDDDD;
    font-size: 17px;
    padding: 10px;
    display: block;
    /* margin-right: auto; */
    /* margin-left: auto; */
    margin-top: 20px;
    margin-left: 0px;
}

#img_box {
    width: 400px; 
    height: 40px;
    border: 1px solid #DDDDDD;
    font-size: 14px;
    padding: 10px;
    display: block;
    /* margin-right: auto; */
    /* margin-left: auto; */
    margin-top: 20px;
    margin-left: 0px;
}


.post {
    margin:0 auto; 
    width:750px;
    padding: 40px 18px 10px 18px;
}

td {
	height : 42px;
	text-align : center;
}


  </style>
</head>
<body>
<div align="center">
<!-- 	<div class="post" >  -->
<form  method="POST" action="<c:url value='/auction/update.do' />" enctype="multipart/form-data"> 
	<table> <tr>  <td> ▼ 이미지 첨부 ▼	  
     <!--  <img src="../images/book1.jpg" alt="최근책" class="book_img"> -->	
      	<input id = "img_box" type = "file" id="img_box" name = "img_file" placeholder="파일첨부" value="${ai.imageurl}" required>   
      	<input id="title_box" type="text" placeholder="책 제목" name = "itemname" value="${ai.itemname}" required>
      	<input id="author_box" type="text" placeholder="출판사"  name = "publisher" value="${ai.publisher}" required>
      	<input id="author_box" type="text" placeholder="지은이" name = "author" value="${ai.author}" required>
      	<input id="date_box" type="date" placeholder="마감날짜" name = "deadline" value="${ai.deadline}" required>
      	<input id="condition_box" type="text" placeholder="상태" name = "condition" value="${ai.condition}" required>
      	<input id="price_box" type="number" min = "1" placeholder="시작 가격" name = "startprice" value="${ai.startprice}" required>
      	<br>
     	<input type="hidden" name="itemId" value="${ai.au_itemId}">
      	<input class="btn1" type="submit" value = "경매 수정하기"> &nbsp;
	 	<input class="btn2" type="button" value = "취소" onclick="location.href='<c:url value='/auction/list.do'/>'">
      
     </td></tr></table> 
     </form>

</div>
<%@ include file="../main/IncludeBottom.jsp"%>