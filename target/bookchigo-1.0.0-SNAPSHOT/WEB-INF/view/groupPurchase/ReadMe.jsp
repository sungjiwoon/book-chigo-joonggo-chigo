<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 이용 시 주의사항</title>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
@charset "UTF-8";
* {
   font-family: 'Jeju Myeongjo', sans-serif;
   margin-left: auto; margin-right: auto;
}
</style>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
</head>
<body>
<div align="center">
<h2> * 북치고 장구치고 공동구매 주의사항 * </h2>
공동구매 게시판을 사용하기 전 꼭 읽어주세요! <br><br>
이 글을 읽지 않아 생기는 불이익은 본인의 책임입니다. <br><br><br>

<h3>1. 공동구매 게시글 작성/삭제/수정 </h3>
공동구매 게시글을 작성하여 상단의 '모집하기' 버튼을 누르시면 등록이 완료됩니다.<br><br>
공동구매 수정과 삭제는 모집자가 0명일 경우만 가능합니다.
이미 신청한 참여자가 있을 경우는 수정 및 삭제가 불가합니다. <br><br>
또한, 수정 시에는 책 정보는 수정할 수 없으며 공동구매 정보란에 있는 내용들만 수정이 가능합니다.<br><br>
수정과 삭제가 했음에도 불구하고 제대로 반영이 되지 않는다고 판단할 경우, 공동구매 전체목록보기 버튼을 누르시고 다시 한번 확인해주시길 바랍니다. <br><br><br>

<h3> 2. 공동구매 신청과 취소 </h3>
공동구매는 모집기한과 제한 인원 수에 따라 신청이 가능합니다. <br><br>
모집기한의 마지막날 00:00:00 전까지 신청하실 수 있습니다. <br><br>
이 시간 이후로는 공구 모집이 마감되며 신청하실 수 없습니다. <br><br>
모집기한 내에 제한인원이 모두 모집될 경우, 기한과 상관없이 공구 모집이 마감됩니다. <br><br> 
취소는 마감이 되지 않았을 경우만 가능하며, 공구모집이 완료되어 마감되었을 시에는 취소가 불가합니다. <br><br><br>

위의 사항들을 잘 숙지하여 공동구매 게시판을 즐겁게 이용하시길 바랍니다. <br><br><br>

북치고 장구치고 공동구매 게시판 담당자 드림 <br><br>
(자세한 문의사항은 9493-9123) <br><br><br>

<h2><a href="<c:url value="/groupPurchase/list.do" />"> 공동구매하러가기 </a></h2>

</div>
<%@ include file="../main/IncludeBottom.jsp"%> 