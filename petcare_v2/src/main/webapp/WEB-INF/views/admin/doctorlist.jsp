<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<div class="container mt-3">
<div id="doctorlistDIV">
	<h3>전문가 회원 리스트</h3>
	<input type="hidden" class="form-control" id="doctorid" name="doctorid"
	value="${doctor.doctorid }" readonly="readonly">
	<table class="table table-hover" style="text-align: center;">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>가입일</th>
				<th>승인상태</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${lists}" var="doc">
				<tr>
					<td>${doc.doctorid }</td>
					<td><a href="docdetail/${doc.doctorid}">${doc.user.username }</a></td>
					<td>${doc.docname }</td>
					<td>${doc.regdate }</td>
					<td>${doc.approval }</td>
<%-- 				<c:choose> --%>
<%-- 			  	<c:when test="${doc.approval == 0}"> --%>
<!-- 			  	<td> -->
<%-- 	                <button type="button" class="btnAppr" data-mid="${doctor.doctorid }">승인</button> --%>
<!-- 	                <button type="button" class="btn btn-danger btn-sm" id="btnDeny">거절</button> -->
<!--                 </td> -->
<%-- 			  	</c:when> --%>
<%-- 			  	<c:when test="${doc.approval == 1}"> --%>
<!-- 			  	<td> -->
<!-- 	                <button type="button" class="btn btn-danger btn-sm" id="btnDrop">정지</button> -->
<!--                 </td> -->
<%-- 			  	</c:when> --%>
<%-- 			  	<c:when test="${doc.approval == 3}"> --%>
<!-- 			  	 	<td>정지회원</td> -->
<%-- 			  	</c:when> --%>
<%-- 			  	<c:when test="${doc.approval == 2}"> --%>
<!-- 			  		<td>승인거절회원</td> -->
<%-- 			  	</c:when> --%>
<%-- 			  </c:choose> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>

<script>
//0 승인대기, 1 승인, 2 거절, 3 추방
// var appfun = function() {
// 	$.ajax({
// 	type:'PUT',
// 	url:'/admin/successapp/'+$(this).data("mid")
// 	})
// 	.done(function(resp){
// 		alert(resp+"번 승인 성공");
// 		location.href="/admin/doctorlist"
// 	})
// 	.fail(function(){
// 		alert("실패")
// 	})
// }
// $("#doctorlistDIV").on("click",".btnAppr",appfun);
// $("#btnApprove").click(function(){
// 	const successapp = $(this).data("doctorid");
// // 	$.ajax({
// // 		type : 'post',
// // 		url : '<c:url value="/admin/successapp" />',
// // 		data : {
// // 			id : successapp,
// // 		}
// // 		success : function(data) {
// // 			alert("success")
// // 		},error : function(status, error) {
// // 			alert("error");
// // 		}
// // 	});
// 	var data = {
// 			"doctorid":$("#doctorid").val(),
// 			// "approval":$("#approval").val(),
// 	}
// 	$.ajax({
// 		type : "post",
// 		url : "/admin/successapp/",
// 		contentType : "application/json;charset=utf-8",
// 		data : JSON.stringify(data),
// 		}).done(function() {
// 			alert("승인 완료")
// 			location.href="/admin/doctorlist";
// 		})
// 		.fail(function() {
// 		alert("승인 오류");
// 	})
// })

  $("btnDeny").click(function(){
	  data = {
				"doctorid":$("#doctorid").val(),
				"approval":$("#approval").val()
		}
		$.ajax({
			type : "put",
			url : "/admin/fail",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			success : function(resp) {
				alert("거절 완료")
				location.href="/admin/doctorlist";
			},
			error : function(e) {
			alert("오류" + e);
			}
		})
	})
  
  $("#btnDrop").click(function() {
	  data = {
				"doctorid":$("#doctorid").val(),
				"approval":$("#approval").val()
		}
		$.ajax({
			type : "put",
			url : "/admin/drop",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
			success : function(resp) {
				alert("정지 완료")
				location.href="/admin/doctorlist";
			},
			error : function(e) {
			alert("오류" + e);
			}
		})
	})
</script>
<%@include file="../includes/footer.jsp"%>
