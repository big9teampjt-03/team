<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div class="container">
<div class="form-group">
<h3>${principal.user.nickname}님의 애완동물 정보</h3>
 <c:forEach items="${User.pets }" var="Pet">
     ${Pet.petname}<br/>
     ${Pet.petbreed}<br/>
     ${Pet.petgender}<br/> ${Pet.imagepet }
     <img  src="/resources/img/${Pet.imagepet }" />
     
     </c:forEach>
     </div>
     </div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>