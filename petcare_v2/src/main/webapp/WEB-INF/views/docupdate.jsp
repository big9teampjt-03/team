<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<title>전문가 정보 수정하기</title>
</head>
<body>
<div class="container mt-3">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<div class="form-group">
			<input type="hidden" class="form-control" id="doctorid" name="doctorid"
				value="${doctor.doctorid }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="docname">이름(실명):</label> <input type="text"
				class="form-control" id="docname" value=${doctor.docname }
				name="docname">
		</div>

		<div class="form-group">
			<label for="doclicensenum">의사 면허 번호:</label> <input type="text"
				class="form-control" id="doclicensenum"
				 value=${doctor.doclicensenum } name="doclicensenum">
		</div>

		<div class="form-group">
			<label for="dochospital">병원 이름:</label> <input type="text"
				class="form-control" id="dochospital"  value=${doctor.dochospital }
				name="dochospital">
		</div>

		<div class="form-group">
			<label for="dochospitaltel">병원 전화번호:</label> <input type="text"
				class="form-control" id="dochospitaltel"
				 value=${doctor.dochospitaltel } name="dochospitaltel">
		</div>

		<div class="form-group">
			<label for="dochospitaladdr">병원 주소:</label> <input type="text"
				class="form-control" id="dochospitaladdr"
				 value=${doctor.dochospitaladdr } name="dochospitaladdr">
		</div>

		<div class="form-group">
			<label for="dochospitalpostal">병원 우편번호:</label> <input type="text"
				class="form-control" id="dochospitalpostal"
				 value=${doctor.dochospitalpostal } name="dochospitalpostal">
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

		<button class="btn btn-info" id="btnDocApproval">승인 요청하기</button>
</div>

<script>
	$("#btnDocApproval").click(function() {
		var dataParam = {
			"doctorid":$("#doctorid").val(),
			"docname" : $("#docname").val(),
			"doclicensenum" : $("#doclicensenum").val(),
			"dochospital" : $("#dochospital").val(),
			"dochospitaltel" : $("#dochospitaltel").val(),
			"dochospitaladdr" : $("#dochospitaladdr").val(),
			"dochospitalpostal" : $("#dochospitalpostal").val(),
		}
		$.ajax({
			type : "PUT",
			url : "/docupdate/",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(dataParam)
		}).done(function(resp) {
			if (resp == "success") {
				alert("승인 요청되었습니다.")
				self.close();
			}
		}) //done
		.fail(function() {
			alert("오류")
		})
	})
</script>
</body>
</html>