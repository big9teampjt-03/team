<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
	<h3>${doctor.docname}님 전문가 등록 정보</h3>
	<form action="/admin/docdetail/${doctor.doctorid }">
		<div class="form-group">
			<label for="doctorid">번호:</label> <input type="text"
				class="form-control" id="doctorid" name="doctorid"
				value="${doctor.doctorid }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="docname">이름(실명):</label> <input type="text"
				class="form-control" id="docname" name=docname
				value="${doctor.docname }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="doclicensenum">의사 면허 번호:</label> <input type="text"
				class="form-control" id="doclicensenum" name="doclicensenum"
				value="${doctor.doclicensenum }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="dochospital">병원 이름:</label> <input type="text"
				class="form-control" id="dochospital" name="dochospital"
				value="${doctor.dochospital }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="dochospitaltel">병원 전화번호:</label> <input type="text"
				class="form-control" id="dochospitaltel" name="dochospitaltel"
				value="${doctor.dochospitaltel }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="dochospitaladdr">병원 주소:</label> <input type="text"
				class="form-control" id="dochospitaladdr" name="dochospitaladdr"
				value="${doctor.dochospitaladdr }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="dochospitalpostal">병원 우편번호:</label> <input type="text"
				class="form-control" id="dochospitalpostal" name="dochospitalpostal"
				value="${doctor.dochospitalpostal }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="approval">승인 상태 (0:승인대기중, 1:승인, 2:거절, 3:추방):</label> <input type="text"
				class="form-control" id="approval" name="approval"
				value="${doctor.approval }" readonly="readonly">
		</div>
		<div class="form-group">
		<c:choose>
			<c:when test="${doctor.approval == 0}">
				<button type="button" class="btn btn-primary btn-sm" id="btnAppr">승인</button>
				<button type="button" class="btn btn-danger btn-sm" id="btnDeny">거절</button>
			</c:when>
			<c:when test="${doctor.approval == 1}">
				<button type="button" class="btn btn-secondary" id="btnDrop">정지</button>
			</c:when>
			<c:when test="${doctor.approval == 3}">
				<button type="button" class="btn btn-danger">정지 회원</button>
			</c:when>
			<c:when test="${doctor.approval == 2}">
				<button type="button" class="btn btn-danger">승인 거절</button>
			</c:when>
		</c:choose>
		</div>
	</form>
</div>
<script>
	$("#btnAppr").click(function() {
		var data = {
			"doctorid" : $("#doctorid").val(),
			"approval" : $("#approval").val(),
		}
		$.ajax({
			type : "put",
			url : "/admin/successappr",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
		}).done(function() {
			alert("승인 완료")
			location.href = "/admin/doctorlist";
		}).fail(function() {
			alert("오류");
		})
	})
	
	$("#btnDeny").click(function() {
		var data = {
			"doctorid" : $("#doctorid").val(),
			"approval" : $("#approval").val(),
		}
		$.ajax({
			type : "put",
			url : "/admin/failappr",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
		}).done(function() {
			alert("거절 완료")
			location.href = "/admin/doctorlist";
		}).fail(function() {
			alert("오류");
		})
	})
	
	$("#btnDrop").click(function() {
		var data = {
			"doctorid" : $("#doctorid").val(),
			"approval" : $("#approval").val(),
		}
		$.ajax({
			type : "put",
			url : "/admin/drop",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data),
		}).done(function() {
			alert("정지 완료")
			location.href = "/admin/doctorlist";
		}).fail(function() {
			alert("오류");
		})
	})

	// function funDelete(userid){
	// 	$.ajax({
	// 		type:"delete",
	// 		url: "/delete/"+userid,
	// 	})
	// 	.done(function(resp){
	// 		alert(resp+"번 삭제 성공")
	// 		location.href = "/list"
	// 	})
	// 	.fail(function(){
	// 		alert("삭제 실패")
	// 	})
	// }
</script>
<%@ include file="../includes/footer.jsp"%>
