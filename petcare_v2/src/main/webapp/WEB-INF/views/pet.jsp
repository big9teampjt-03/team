<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="container">
	<h3>애완동물 등록</h3>
	
	<div class="form-group">
		<label for="imagepet">사진:</label> <input type="file"
			 id="imagepet"name="imagepet">
	</div>
	
	
	<div class="form-group">
		<label for="petname">이름:</label> <input type="text"
			class="form-control" id="petname" placeholder="Enter Name"
			name="petname">
	</div>
	
	<div class="form-group">
		<label for="petbirth">생년월일:</label> <input type="date"
			 id="petbirth" name="petbirth">
	</div>
	
	<div class="form-group">
	 <label for="petgender">성별:</label> 
      남<input type="radio" name="gender"  id="petgender" value="남" checked >
  		여<input type="radio" name="gender"  id="petgender" value="여" ><br>
	</div>
	
	<div class="form-group">
			<label for="petweight">몸무게:</label> <input type="text"
				class="form-control" id="petweight" placeholder="Enter weight"
				name="petweight">
		</div>
	
	<div class="form-group">
		<label for="petbreed">품종:</label> <input type="text"
			 id="petbreed" placeholder="품종을 입력하세요."
			name="petbreed">
	</div>
	
	
	<button type="button" class="btn btn-secondary" id="btnPet">등록</button>

		<script>
		
		$("#btnPet").click(function() {
			
			var dataParam = {
				"petname" : $("#petname").val(),
				"petbirth" : $("#petbirth").val(),
				"petgender" : $("input[name='gender']:checked").val(),
				"petweight" : $("#petweight").val(),
				"petbreed" : $("#petbreed").val(),
				"imagepet" : $("#imagepet").val()
			}
			
			$.ajax({
				
				type : "POST",
				url : "/pet",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(dataParam)
			}).done(function(resp) {
				if (resp == "success") {
					alert("등록이 정상적으로 처리되었습니다.")
					location.href="/pet"
				} else if (resp == "fail") {
					alert(".")
					$("#username").val("")
				}
			}) //done
			.fail(function() {
				alert("등록에 실패했습니다.")
			})
		})
		
	</script>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>