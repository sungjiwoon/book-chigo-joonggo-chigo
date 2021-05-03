<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div>
	<form action="<c:url value='sell_list.jsp' />" align="right">
		<input class="btn_slist" style="width: 120px;" type="button" value="즐겨찾기 조회" onclick="location.href='<c:url value='sell_wishlist.jsp'/>'" />
		<input class="btn_slist" style="width: 120px;" type="button" value="주문 완료 조회" onclick="location.href='<c:url value='sell_finish.jsp'/>'" />
		<input class="btn_slist" type="button" value="판매글 조회" onclick="location.href='<c:url value='sell_history.jsp'/>'" />
		<input class="btn_slist" style="margin-right:100px;" type="button" value="판매 등록" onclick="location.href='<c:url value='sell_upload.jsp'/>'" />
		<br><br>
		<input id="sell_search_box" type="text">
		<input class="btn_slist" style="margin-right:100px;" type="submit" value="검색" />
		<br><br><br><br><br>
	<table class="slist" align="center">
		<tr bgcolor="ffffff">
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_seller.jsp' ><img border="0" src="../images/cat1.jpg" /></a></td>	
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_publisher.jsp'><img border="0" src="../images/cat2.jpg" /></a></td>
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_publisher.jsp'><img border="0" src="../images/dog1.jpg" /></a></td>
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_publisher.jsp'><img border="0" src="../images/dog2.jpg" /></a></td>
		</tr>
		<tr bgcolor="ffffff">
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">고양이 사전</td>
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">고양이 사전2</td>
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">강아지 사전</td>
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">강아지 사전2</td>
		</tr>
		<tr bgcolor="ffffff">
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
		</tr>
		<tr bgcolor="ffffff">
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_publisher.jsp'><img border="0" src="../images/cat1.jpg" /></a></td>	
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_publisher.jsp'><img border="0" src="../images/cat2.jpg" /></a></td>
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_publisher.jsp'><img border="0" src="../images/dog1.jpg" /></a></td>
			<td style="border-right:1px solid #E6E6E6; border-top:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">
				<a href='sell_publisher.jsp'><img border="0" src="../images/dog2.jpg" /></a></td>
		</tr>
		<tr bgcolor="ffffff">
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">고양이 사전</td>
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">고양이 사전2</td>
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">강아지 사전</td>
			<td style="border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-collapse: collapse;">강아지 사전2</td>
		</tr>
		<tr bgcolor="ffffff">
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
			<td style="color:#E02020; border-right:1px solid #E6E6E6; border-left:1px solid #E6E6E6; border-bottom:1px solid #E6E6E6; border-collapse: collapse;">10000원</td>
		</tr>
	</table>
	</form>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>
