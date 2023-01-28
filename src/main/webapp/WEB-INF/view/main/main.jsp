<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTopMain.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북치고 중고치고</title>
</head>
<style>
table {
    border-spacing: 7px;
}

td {
    width : 400px;
    height : 45px;
    border: 1px solid #DDDDDD;
    text-align: center;
    padding: 6px 10px 6px 10px;
    
}

a {
 cursor :pointer;
}
a:link , a:visited{
  color : black;
  text-decoration: none;
}
a:hover {
  color : black;
  style : bold;
  cursor :pointer;
}
a:active {
  color : black;
  style : bold;
  cursor :pointer;
}
</style>
<body>
<div align="center">
	<c:if test="${ses == 1 }"> 
	<p style="font-size:16px;"> <text style="font-weight:600;">${username }님  / </text> <a href="<c:url value='/notice/list.do'/>">알림</a> </p>
	
	</c:if>
	<c:if test="${ses == 0}"> 
	<a href="<c:url value="/member/login" />">로그인</a> / <a href="<c:url value="/member/register" />">회원가입</a>
	</c:if>
	<br><br>
	<table>
	<c:if test="${ses == 1 }"> 
	<tr><td onClick="location.href='<c:url value='/member/my'/>'" style="cursor:pointer;">회원 정보 조회하기</td></tr>
	<tr><td onClick="location.href='<c:url value='/chat'/>'" style="cursor:pointer;">채팅방 입장</td></tr> </c:if>
	<tr><td onClick="location.href='<c:url value='/sell/list.do'/>'" style="cursor:pointer;">중고책 사러가기!</td></tr>
	<tr><td onClick="location.href='<c:url value='/study'/>'" style="cursor:pointer;">스터디그룹이 필요하면..</td></tr>
	<tr><td onClick="location.href='<c:url value='/auction'/>'" style="cursor:pointer;">중고책 경매는 어때?</td></tr>
	<tr><td onClick="location.href='<c:url value='/groupPurchase/list.do'/>'" style="cursor:pointer;">도서 공.동.구.매</td></tr>
	<c:if test="${ses == 1 }"> 
	<tr><td onClick="location.href='<c:url value='/member/logout.do'/>'" style="cursor:pointer; background-color : #DDDDDD;">로그아웃</td></tr> </c:if>
<%-- 	<tr><td onClick="location.href='<c:url value='/naver/list.do'/>'" style="cursor:pointer;">실제 도서 구매는 여기로</td></tr> --%>
	</table>

</div>
</body>
</html>