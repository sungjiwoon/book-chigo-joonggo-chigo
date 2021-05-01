<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align="center" style="margin-left: 100px; margin-right: 100px;">
	<table>
		<tr>
			<td style="width:400px; padding-right:50px;" rowspan="7">
				<img border="0" src="../../images/book_example.jpg" width="400px" />
			</td>
			<td style="width:100px; font-size:25px; font-weight: bold;" colspan="2">모두의 딥러닝</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" style="color:#E02020; font-size:25px; font-weight: bold;">10,000원</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" style="color:#9b9b9b;"><hr></td>
			<td></td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;">저자</td>
			<td style="width:100px; font-size:14px; font-family:'Nanum Gothic', sans-serif;">조태호</td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;" >출판사</td>
			<td style="width:100px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">길벗</td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;" >거래 방식</td>
			<td style="width:200px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">편택/반택, 계좌 입금</td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;" >거래 상태</td>
			<td style="width:100px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">판매 중</td>
		</tr>
	</table><br><br>
	<form name="form">
		<table class="publisher" align="right">
			<tr>
				<td style="padding: 10px;">
					<input class="btn_slist" style="width: 150px;" type="button" value="거래 상태 수정" onclick="location.href='<c:url value='sell_status.jsp'/>'">
				</td>
				<td style="padding: 10px;">
					<input class="btn_slist" type="button" value="게시글 수정" onclick="location.href='<c:url value='sell_update.jsp'/>'">
				</td>
				<td style="padding:10px; margin-right:100px;">
					<input class="btn_slist" type="button" value="게시글 삭제" onclick="remove_click()">	
				</td>
			</tr>
		</table>
	</form>
	<br><br><br><br><br>
	<table>
		<tr>
			<td style="color:#787372; padding:30px;">상품 정보</td>
		</tr>
		<tr>
			<td style="margin: 20px; line-height: 160%; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">
				책 상태 좋습니다 <br>
				반값택배/편의점 택배 중 하나 선택하여 주세요! <br>
				
				반값택배 1500
				편의점택배 3000
			</td>
		</tr>
	</table>
</div>
<script>
	function remove_click() {
		var ok = confirm("게시글을 삭제하시겠습니까?");
		if (ok == true) {
			form.action = "<c:url value='sell_list.jsp' />";
			form.submit();
		}
	}
</script>

<%@ include file="../main/IncludeBottom.jsp"%>