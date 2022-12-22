<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "/WEB-INF/views/includes/header.jsp"%>

<!-- <div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>Spring Board Write</h1>      
    
  </div>
</div> -->
<div class="container">
<br>
<h3>상담글쓰기</h3>
<br>
<form action ="boardCounselinsert" method="post"  enctype="multipart/form-data">
<div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" >
    </div>
    <div class="form-group">
      <label for="writer">글쓴이</label>
      <input type="text" class="form-control" id="username" placeholder="Enter writer" name="username"  value="${principal.user.nickname}"  readonly="readonly">
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea class="form-control" id="content" placeholder="Enter content" name="content" rows="4" cols="100"></textarea>
    </div>
    <div class="form-group">
      <label for="uploadcounsel">파일</label>
      <input type="file" class="form-control" id=uploadcounsel placeholder="Enter upload" name="uploadcounsel" >
    </div>
   <!--  <div class="form-check form-check-inline mt-3">
    <input class="form-check-input" type="checkbox" name="secret" id="secret">
    <label class="form-check-label">비밀글 설정</label>
</div> -->
 <%-- <c:if test="${board.secret == true}">
    <c:choose>
        <c:when test="${board.username eq member.vo.userid || member.authorities eq '[ROLE_ADMIN, ROLE_MEMBER]'}"> <!-- 작성자이거나 관리자일 때 -->
            <td><a href="get${pageMaker.cri.listLink}&counselID=${board.counselID}" class="text-secondary text-center"><i class="icofont-lock"></i><c:out value="${board.title}"/><span class="text-muted small"> [${board.replycnt}]</span></a></td>
        </c:when>
        <c:otherwise>
            <td class="text-secondary"><i class="icofont-lock"></i><c:out value="${board.title}"/><span class="text-muted small"> [${board.replycnt}]</span></td>
        </c:otherwise>
    </c:choose>                                            
</c:if> --%>
<br>
    <button type="submit" id="btnBoard" class="btn btn-primary">글쓰기</button>
    </form>
 </div>
 <script>

 $("#btnBoard").click(function(){
	if($("#title").val()==""){
		alert("제목을 작성하세요")
		return false;
	}
	if($("#content").val()==""){
		alert("내용을 작성하세요")
		return false;
	}
	var data={
			"title":$("#title").val(),
			"content":$("#content").val()
	}
	$.ajax({
		type:"POST",
		url:"/board/boardCounselinsert/"+$("#counselID").val(),
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(data)
	})
	.done(function(resp){
		alert("게시글 작성 실패")
	})
	.fail(function(){
	alert("게시글 작성 성공")
	
	})
})

 </script>
<%@ include file="../includes/footer.jsp"%>