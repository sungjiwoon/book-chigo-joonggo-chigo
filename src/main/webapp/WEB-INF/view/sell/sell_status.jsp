<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align="center">
	<br>
	<!-- write Form  -->
	<form name="form" method="POST"
		action="<c:url value='sell_seller.jsp' />">
		<h3>거래 상태 수정</h3>
		거래 중, 거래 완료 옆 입력 창에 구매자 아이디 입력
		<br><br><br><br>
		<table>
			<tr>
				<td style="padding-left: 10; padding-right: 10;">
					<label style="font-family: 'Nanum Gothic', sans-serif;"><input type="radio" name="deal_method" value="sale">판매 중</label><br><br>
					<label style="font-family: 'Nanum Gothic', sans-serif;"><input type="radio" name="deal_method" value="trading">거래 중</label>
					&nbsp;<input id="sell_search_box" type="text"><br><br>
					<label style="font-family: 'Nanum Gothic', sans-serif;"><input type="radio" name="deal_method" value="completed">거래 완료</label>
					&nbsp;<input id="sell_search_box" type="text">
				</td>
			</tr>
		</table>
		<br>
		<br>
		<br> <input class="btn_slist" type="submit" value="수정"> &nbsp;
		<input class="btn_slist" type="button" value="취소"
			onclick="location.href='<c:url value='sell_seller.jsp'/>'">
	</form>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>