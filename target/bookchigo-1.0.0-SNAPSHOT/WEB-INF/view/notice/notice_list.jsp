<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림창</title>
</head>
<style>
      #notice_table,#notice_th, #notice_td_1{
         border: 1px solid #DDDDDD;
         border-collapse: collapse;
         
      }
      #notice_td_1 {
         height:40px;
         text-align : center;
         cursor:pointer;
      }
      #notice_th {
         background-color : black;
         color : #FFFFFF;
         height : 30px;
         text-style:bold;
      }
      
      #notice_td_0 {
         background-color : #DDDDDD;
         height:40px;
         text-align : center;
         cursor:pointer;
      }
      
      #notice_table {
         width: 97%;
         border-spacing: 7px;
      }
   

	#btn1{
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
      #post_title {
         border : 0px;
         background-color : white;
         color:black;
         font-size : 14px;
         
      }
      
   </style>
<body>
<div align="center">
	<h2>알림창</h2>
	
   <br>
   <table align="center" id="notice_table">
      	 <tr id="notice_tr">
            <th id="notice_th">제목</th>
            <th style="width:200px;" id="notice_th">확인 여부</th>
            <th style="width:200px;" id="notice_th">전송 날짜</th>
         </tr>
         <tr>
         <c:forEach var="post" items="${list}">
         <c:choose>
         	<c:when test="${post.count == 1}">
         	<tr onClick="location.href='<c:url value='/notice/item.do'><c:param name="noticeId" value="${post.noticeId}"/></c:url>'">       
            <td style="width:300px;" id="notice_td_1">${post.title }</td>
            <td style="width:200px;" id="notice_td_1"> 알림 확인 했음 </td>
            <td style="width:200px;" id="notice_td_1"> <fmt:formatDate value="${post.notice_date}" pattern="yyyy년 MM월 dd일"/> </td>
         	</tr>
         	</c:when>
         	<c:when test="${post.count == 0}">
         	<tr onClick="location.href='<c:url value='/notice/item.do'><c:param name="noticeId" value="${post.noticeId}"/></c:url>'">       
            <td style="width:300px;" id="notice_td_0">  ${post.title }</td>
            <td style="width:200px;" id="notice_td_0"> 알림 확인 필요 </td>
            <td style="width:200px;" id="notice_td_0"> <fmt:formatDate value="${post.notice_date}" pattern="yyyy년 MM월 dd일"/> </td>
         	</tr>
         	</c:when>
         </c:choose>
         </c:forEach>
   </table>
    <br> <%-- <input type="button" value = "메인페이지" id="btn1" onClick="location.href='<c:url value='/main' />'"> --%>
</form>
</div>
</body>
</html>