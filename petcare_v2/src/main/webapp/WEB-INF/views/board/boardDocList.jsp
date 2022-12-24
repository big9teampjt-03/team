<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<div class="container mt-5">
<div id="doctorlistDIV">
	<h3>추천 수의사 목록</h3>
	<input type="hidden" class="form-control" id="doctorid" name="doctorid"
	value="${doctor.doctorid }" readonly="readonly">
	<table class="table table-hover" style="text-align: center;">
		<thead>
			<tr>
				<th>이름</th>
				<th>병원명</th>
				<th>병원주소</th>
				<th>인증여부</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${lists}" var="doc">
				<tr>
					<td><a href="/board/boardDocInfo/${doc.doctorid}">
					${doc.docname }</a></td>
					<td>${doc.dochospital }</td>
					<td>${doc.dochospitaladdr }</td>
					<c:choose>
					<c:when test="${doc.approval == 0 }">
					<td><button class="btn btn-warning btn-sm">인증 대기중</button></td>
					</c:when>
					<c:when test="${doc.approval == 1 }">
			 		 <td><button class="btn btn-success btn-sm">인증 완료</button></td>
			 		 </c:when>
			 		 </c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>

<%@include file="../includes/footer.jsp"%>