<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align = "center">
	<h2>주문 완료 조회</h2><br><br>
	<table class="shistory">
		<tr style="background-color: #DDDDDD; height:30px;">
			<th>번호</th>
			<th>사진</th>
			<th>제목</th>
			<th>가격</th>
		</tr>
		<tr>
			<td>1</td>
			<td><a href='sell_publisher.jsp'><img border="0" src="../../images/book_example.jpg" width="100px" /></a></td>
			<td>모두의 딥러닝</td>
			<td>10,000원</td>
		</tr>
		<tr>
			<td>2</td>
			<td><a href='sell_publisher.jsp'><img border="0" src="../../images/book_example.jpg" width="100px" /></a></td>
			<td>모두의 딥러닝</td>
			<td>10,000원</td>
		</tr>
	</table>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>