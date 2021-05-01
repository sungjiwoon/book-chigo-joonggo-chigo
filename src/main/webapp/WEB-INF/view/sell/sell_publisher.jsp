<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align="center" style="margin-left: 100px; margin-right: 100px;">
	<table class="pbook">
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
			<td style="width:100px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">조태호</td>
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
	</table>
	<table class="publisher" align="right">
		<tr>
			<td style="padding: 10px;">
				<a href='sell_publisher.jsp'> <!-- 즐겨찾기 추가 버튼, 이미 즐겨찾기에 추가된 책이면 alert문 띄우기 -->
					<img border="0" src="../../images/heart.PNG" width="35px" />
				</a>
			</td>
			<td style="color:#787372; padding: 21px;">판매자 : </td>
			<td style="padding: 10px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">김도연</td>
			<td style="color:#787372; padding: 10px;">판매자 거래 횟수 : </td>
			<td style="padding: 10px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">3회</td>
			<td style="padding:20px;">
				<input class="btn_slist" type="button" value="채팅하기" onclick="location.href='<c:url value='sell_publisher.jsp'/>'">	
			</td>
		</tr>
	</table>
	<br><br><br><br><br>
	<table>
		<tr>
			<td style="color:#787372; padding:30px;">상품 정보</td>
		</tr>
		<tr>
			<td style="margin: 20px; font-size:14px; line-height: 160%; font-family: 'Nanum Gothic', sans-serif;">
				책 상태 좋습니다 <br>
				반값택배/편의점 택배 중 하나 선택하여 주세요! <br>
				
				반값택배 1500
				편의점택배 3000
			</td>
		</tr>
	</table>
</div>
<%@ include file="../main/IncludeBottom.jsp"%>