<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
	<h3>${user.nickname}님의 회원 정보</h3>
	<form action="/admin/userdetail/${user.userid }">
		<div class="form-group">
			<label for="userid">번호:</label> <input type="text" class="form-control"
				id="userid" name="userid" value="${user.userid }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="username">아이디(이메일주소):</label> <input type="text"
				class="form-control" id="username" name=username
				value="${user.username }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="nickname">닉네임:</label> <input type="text"
				class="form-control" id="nickname" name="nickname" value="${user.nickname }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="tel">휴대폰번호:</label> <input type="text"
			class="form-control" id="tel" name="tel" value="${user.tel }"
			readonly="readonly">
		</div>
		<div class="form-group">
			<label for="doctorid">전문가 회원 번호:</label> <input type="text"
			class="form-control" id="doctorid" name="doctorid" value="${user.doctor.doctorid }"
			readonly="readonly">
		</div>
		
		<button type="button" class="btn btn-danger" onclick="funDelete(${user.userid})">삭제</button>
	
	</form>
</div>
<script>
function funDelete(userid){
	if(!confirm("정말 삭제할까요?"))return false;
	$.ajax({
		type:"delete",
		url: "/delete/"+userid,
	})
	.done(function(resp){
		alert(resp+"번 회원 삭제 성공")
		location.href = "/admin/userlist"
	})
	.fail(function(){
		alert("실패")
	})
}
</script>
<%@ include file="../includes/footer.jsp"%>
