<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div class="container">
	<form action="/login" method="post">
		<div class="form-group">
			<label for="email">이메일:</label> <input type="email" id="email"
				name="email" class="form-control" placeholder="이메일을 입력하세요." />
		</div>
		<div class="form-group">
			<label for="passowrd">비밀번호:</label> <input type="password"
				class="form-control" id="password" placeholder="비밀번호를 입력하세요."
				name="password">
		</div>
		<button class="btn btn-primary" id="btnLogin">로그인</button>
	</form>
	<script>
	$("#btnLogin").click(function(){
		if($("#email").val()==""){
			alert("이메일을 입력하세요.")
			$("#email").focus();
			return false;
		}
		if($("#password").val()==""){
			alert("비밀번호를 입력하세요.")
			$("#password").focus();
			return false;
		}
		var dataParam = {
				"email" : $("#email").val(),
				"password" : $("#password").val()
		}
		
	})
	</script>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>