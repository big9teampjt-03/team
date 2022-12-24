<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="container">
	<div class="form-group">
		<h3>${principal.user.nickname}님의 반려견 정보</h3>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"> <input type="hidden"
			class="form-control" id="petid" name="petid" value="${pet.petid }"
			readonly="readonly">

		<div class="form-group">
			<img src="/resources/img/${pet.imagepet }"width=300 height=300>
		</div>
		<div class="form-group">
			<label for="petname">이름:</label> <input type="text"
				class="form-control" id="petname" name="petname"
				value="${pet.petname }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="petbirth">생년월일:</label> <input type="text"
				class="form-control" id="petbirth" name="petbirth"
				value="${pet.petbirth }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="petbreeds">견종:</label> <input type="text"
				class="form-control" id="petbreeds" name="petbreeds"
				value="${pet.petbreeds }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="petgender">성별:</label> <input type="text"
				class="form-control" id="petgender" name="petgender"
				value="${pet.petgender }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="petneutering">중성화 여부:</label> <input type="text"
				class="form-control" id="petneutering" name="petneutering"
				value="${pet.petneutering }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="petvaccination">백신 접종 여부:</label> <input type="text"
				class="form-control" id="petvaccination" name="petvaccination"
				value="${pet.petvaccination }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="petweight">몸무게:</label> <input type="text"
				class="form-control" id="petweight" name="petweight"
				value="${pet.petweight }" readonly="readonly">
		</div>


<%-- 		<c:forEach items="${pet }" var="Pet"> --%>
<%--      ${Pet.petname}<br /> --%>
<%--      ${Pet.petbreed}<br /> --%>
<%--      ${Pet.petgender}<br /> --%>
<%-- 			<img src="/resources/img/${Pet.imagepet }" /> --%>

<%-- 		</c:forEach> --%>
	</div>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>