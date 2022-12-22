<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<div class="container mt-3">
	<h3>일반 회원 리스트</h3>
	<div id="userDIV">
	<table class="table table-hover" style="text-align: center;">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>닉네임</th>
				<th>가입일</th>
				<th>권한1</th>
				<th>권한2</th>
				<th>관리</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${lists}" var="user">
				<tr>
					<td>${user.userid }</td>
					<td><a href="userdetail/${user.userid}"> ${user.username }</a></td>
					<td>${user.nickname }</td>
					<td>${user.regdate }</td>
					<td>${user.role }</td>
					<td>${user.doctor.role }</td>
					<td><button type="button" class="btnDel btn-danger btn-sm" 
					data-mid="${user.userid }">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>

<script>
var delfun = function() {
	if(!confirm("정말 삭제할까요?"))return false;
	$.ajax({
		type:'DELETE',
		url:'/admin/delete/'+$(this).data("mid")
	})
	.done(function(resp){
		alert(resp+"번 회원 삭제 성공");
		location.href="/admin/userlist"
	})
	.fail(function(){
		alert("실패")
	})
}
$("#userDIV").on("click",".btnDel",delfun);
</script>
<%@include file="../includes/footer.jsp"%>
