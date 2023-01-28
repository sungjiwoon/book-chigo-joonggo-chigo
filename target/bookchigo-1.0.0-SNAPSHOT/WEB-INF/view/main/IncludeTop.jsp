<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>북 치고 중고 치고</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Cache-Control" content="max-age=0">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
  <meta http-equiv="Pragma" content="no-cache">
  <link rel="stylesheet" href="../style/bookstore.css" type="text/css" />
</head>

<body bgcolor="white">
<div align="center">
	<a href="<c:url value="/main" />"><img border="0" src="<c:url value='/images/logo.png' />" width = "60%" /></a>
	<table style="border-spacing: 7px;">	<tr>
	<td style="font-size:17px; align: center; font-family: 'Jeju Myeongjo', sans-serif; font-weight:500; cursor:pointer;" 
		onClick="location.href='<c:url value='/main/'/>'" > 홈 </td> <td id = "td_border"> | </td>
	<td style="font-size:17px; align: center; font-family: 'Jeju Myeongjo', sans-serif; font-weight:500; cursor:pointer;" 
		onClick="location.href='<c:url value='/sell/list.do'/>'" > 중고 거래 </td> <td id = "td_border"> | </td>
	<td style="font-size:17px; align: center; font-family: 'Jeju Myeongjo', sans-serif; font-weight:500; cursor:pointer;" 
		onClick="location.href='<c:url value='/auction'/>'" > 중고책 경매 </td> <td id = "td_border"> | </td>
	<td style="font-size:17px; align: center; font-family: 'Jeju Myeongjo', sans-serif; font-weight:500; cursor:pointer;" 
	 	onClick="location.href='<c:url value='/study'/>'" > 스터디 그룹 </td> <td id = "td_border"> | </td>
	<td style="font-size:17px; align: center; font-family: 'Jeju Myeongjo', sans-serif; font-weight:500; cursor:pointer;" 
		onClick="location.href='<c:url value='/groupPurchase/list.do'/>'"> 공동 구매 </td> 
	</tr> </table>
</div>
<br>
<br>
