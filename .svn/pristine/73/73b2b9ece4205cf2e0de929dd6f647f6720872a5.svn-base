<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 댓글등록</title>
<script>
$(function(){
	
	$('#ref_content').summernote({
		lang: 'ko-KR',
		height: 150,
		codemirror: {
		theme: 'monokai'
	}
});
	
	$('#replyForm').submit(function(){
		
		title = $('#ref_title').val().trim();
		content = $('#ref_content').summernote('code').trim();
		
		if(title.length <= 0){
			alert('제목을 입력해주세요.');
			return false;
		}	
				
		if(content.length <= 0){
			alert('내용을 입력해주세요.');
			return false;
		}
		
		// 입력값 검증 - 과제
// 		$(this).append('<input type="hidden" name="ref_nickname" value="${LOGIN_MEMBERINFO.mem_name}"></input>');
		$(this).append('<input type="hidden" name="ref_mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
		$(this).append('<input type="hidden" name="ref_content" value="' + $('#ref_content').summernote('code') + '"></input>');
		$(this).append('<input type="hidden" name="ref_group" value="${param.ref_group}"></input>');
		$(this).append('<input type="hidden" name="ref_seq" value="${param.ref_seq}"></input>');
		$(this).append('<input type="hidden" name="ref_depth" value="${param.ref_depth}"></input>');
		
		return true;		
	});
	
	$('#back').click(function(){
		if(eval('${!empty param.currentPage}')){
			$(location).attr('href', '${pageContext.request.contextPath}/user/reference/refList.do?currentPage=${param.currentPage}&search_keyword=${param.search_keyword}&search_keycode=${param.search_keycode}');
		}else{
			$(location).attr('href', '${pageContext.request.contextPath}/user/reference/refList.do?search_keyword=${param.search_keyword}&search_keycode=${param.search_keycode}');
		}
	});
});
</script>
</head>
<body>
<div class="row">
	 <%-- <div class="col-sm-3">
		 <label class="col-sm-2 control-label">No :</label>
  		 <p class="form-control-static">${param.rnum }</p>
	 </div> --%>
	 <div class="col-sm-8">
	 	<label class="col-sm-2 control-label">제목 :</label>
    	<p class="form-control-static">${param.ref_title }</p>
	 </div>
	 <div class="col-sm-1">
	 	<p class="text-right text-danger bg-danger">의 댓글</p>
	 </div>
</div>
<hr />
<form id="replyForm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/user/reference/insertRefReply.do" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="ref_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="ref_title" name="ref_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="ref_nickname">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input readonly type="text" class="form-control" id="ref_nickname" name="ref_nickname"value="${LOGIN_MEMBERINFO.mem_name}" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="ref_content">내용:${param.ref_content }</label>
		<div class="col-sm-10"> 
			<div id="ref_content"></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success" style="float: right;">답글등록</button>
			<button type="button" class="btn btn-danger">취소</button>
			<button type="button" class="btn btn-info" id="back">목록</button>
		</div>
	</div>
</form>
</body>
</html>