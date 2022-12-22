<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>

<div class="container mt-3">
	<h3>${principal.user.nickname}님의 회원 정보</h3>
	<form action="/update/${user.userid }">
	<c:choose>
	<c:when test="${user.doctor.approval == null}">
		<button type="button" class="btn btn-info btn"
			onclick="location.href='/docupdate/${user.userid }';"
			id="btnDocUpdate">전문가 정보 입력하기</button>
	</c:when>
	<c:when test="${user.doctor.approval == 0}">
		<button type="button" class="btn btn-warning btn"
			onclick="location.href='/docview/${user.userid }';"
			>승인 대기중입니다.</button>
	</c:when>
	<c:when test="${user.doctor.approval == 1}">
		<button type="button" class="btn btn-success btn"
		onclick="location.href='/docview/${user.userid }';"
		>전문가 정보 확인하기</button>
	</c:when>
		<c:when test="${user.doctor.approval == 2}">
		<button type="button" class="btn btn-danger btn"
		onclick="/" id="btnDocView">승인 거절되었습니다. 관리자에게 문의하세요.</button>
	</c:when>
		<c:when test="${user.doctor.approval == 3}">
		<button type="button" class="btn btn-danger"
		onclick="/" id="btnDocView">이용 정지중입니다. 관리자에게 문의하세요.</button>
	</c:when>
	</c:choose>
		<div class="form-group">
			<input type="hidden" class="form-control" id="userid" name="userid"
				value="${user.userid }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="username">이메일:</label> <input type="email"
				class="form-control" id="username" name="username"
				value="${principal.user.username }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="password"
				class="form-control" id="password" name="password">
		</div>
		<div class="form-group">
			<label for="pass_check">비밀번호 확인:</label> <input type="password"
				class="form-control" id="pass_check" placeholder="패스워드를 한번 더 입력하세요."
				name="pass_check">
		</div>
		<div class="form-group">
			<label for="nickname">닉네임:</label> <input type="text"
				class="form-control" id="nickname" name="nickname"
				value="${user.nickname }">
		</div>
		<div class="form-group">
			<label for="tel">휴대폰번호:</label> <input type="tel"
				class="form-control" id="tel" name="tel" value="${user.tel }">
		</div>

		<button type="button" class="btn btn-primary " id="btnUpdate">수정하기</button>

	</form>
</div>

<script>
	$("#btnUpdate").click(function() {
		if ($("#password").val() == "") {
			alert("패스워드를 입력하세요.")
			$("#password").focus();
			return false;
		}
		if($("#password").val() != $("#pass_check").val()){
			alert("패스워드가 일치하지 않습니다.")
			$("#pass_check").focus();
			return false;
		}
		if ($("#nickname").val() == "") {
			alert("닉네임을 입력하세요.")
			$("#nickname").focus();
			return false;
		}
		if ($("#tel").val() == "") {
			alert("휴대폰번호를 입력하세요.")
			$("#tel").focus();
			return false;
		}
		var dataParam = {
			"userid" : $("#userid").val(),
			"username" : $("#username").val(),
			"password" : $("#password").val(),
			"nickname" : $("#nickname").val(),
			"tel" : $("#tel").val(),
		}
		$.ajax({
			type : 'put',
			url : '/update/',
			data : JSON.stringify(dataParam),
			contentType : 'application/json;charset=utf-8'
		}).done(function() {
			alert("회원 정보가 수정되었습니다. 다시 로그인 해 주세요.")
			location.href = "/login"
		}).fail(function() {
			alert("회원 정보 수정에 실패했습니다.")
		})
	})
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>