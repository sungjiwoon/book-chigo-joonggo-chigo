<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 완료</title>
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
</style>
<body>
<div align="center">
	<h3>게시글 삭제가 완료되었습니다.</h3>
	<button class = "btn1" onClick="location.href='<c:url value='/auction'/>'"  style="cursor:pointer;"> 경매 목록 가기 </button> <br> <br>
</div>
</body>
</html>
<%@ include file="../main/IncludeBottom.jsp"%>