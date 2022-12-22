<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="container mt-3">
	<h3>${principal.user.nickname}님의 전문가 정보 확인하기</h3>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<div class="form-group">
			<input type="hidden" class="form-control" id="userid" name="userid"
				value="${principal.user.userid }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="docname">이름(실명):</label> <input type="text"
				class="form-control" id="docname" name="docname"
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

<!-- 		<div class="form-group"> -->
<!-- 			<label for="imagedocprofile">프로필 사진:</label> <input type="file" -->
<!-- 				id="imagedocprofile" placeholder="사진을 등록해 주세요." -->
<!-- 				name="imagedocprofile"> -->
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label for="imagedoclicense">의사 면허증:</label> <input type="file" -->
<!-- 				id="imagedoclicense" placeholder="면허증을 등록해 주세요." -->
<!-- 				name="imagedoclicense"> -->
<!-- 		</div> -->

		<c:choose>
		<c:when test="${doctor.approval == 0}">
		<button class="btn btn-info">승인 대기중입니다. 잠시만 기다려 주세요.</button>
		</c:when>
		<c:when test="${doctor.approval == 1}">
		<button class="btn btn-info" onclick="location.href='/docupdate/${doctor.doctorid }';">
		전문가 정보 수정하기</button>
		</c:when>
		</c:choose>
		
</div>

<script>
// 	$("#btnDocApproval").click(function() {
// 		var dataParam = {
// 			"user_id":$("#userid").val(),
// 			"docname" : $("#docname").val(),
// 			"doclicensenum" : $("#doclicensenum").val(),
// 			"dochospital" : $("#dochospital").val(),
// 			"dochospitaltel" : $("#dochospitaltel").val(),
// 			"dochospitaladdr" : $("#dochospitaladdr").val(),
// 			"dochospitalpostal" : $("#dochospitalpostal").val(),
// 		}
// 		$.ajax({
// 			type : "POST",
// 			url : "/docupdate/"+$("#userid").val(),
// 			contentType : "application/json;charset=utf-8",
// 			data : JSON.stringify(dataParam)
// 		}).done(function(resp) {
// 			if (resp == "success") {
// 				alert("승인 요청되었습니다.")
// 				location.href = "update"
// 			}
// 		}) //done
// 		.fail(function() {
// 			alert("오류")
// 		})
// 	})
</script>
<%@ include file="includes/footer.jsp"%>