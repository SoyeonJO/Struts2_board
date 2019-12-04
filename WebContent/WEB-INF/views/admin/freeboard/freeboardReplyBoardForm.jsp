<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 댓글등록</title>
<script type="text/javascript" src='${pageContext.request.contextPath}/js/freevalidation.js'></script>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type = "text/javascript">
$(function(){

	
	
	$('form').submit(function(){

		if(!$('#bo_nickname').val().validationNAME()){
			alert('이름을 바르게 입력해주세요.');
			return false;
		}
		if(!$('#bo_pwd').val().validationPASSWORD()){
			alert('비밀번호를 숫자 4자리로 입력해주세요.');
			return false;
		}
		if(!$('#bo_mail').val().validationEMAIL()){
			alert('이메일 주소를 바르게 입력해주세요.');
			return false;
		}

	
	});
  
	$('#replyForm').submit(function(){
		// 입력값 검증 - 과제
		$(this).attr('action', '${pageContext.request.contextPath}/admin/freeboard/insertReplyInfo.do');
		$(this).append('<input type="hidden" name="bo_mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
		$(this).append('<input type="hidden" name="bo_nickname" value="${param.bo_nickname}"></input>');
		$(this).append('<input type="hidden" name="bo_content" value="${param.bo_content}"></input>');
		$(this).append('<input type="hidden" name="bo_group" value="${param.bo_group}"></input>');
		$(this).append('<input type="hidden" name="bo_seq" value="${param.bo_seq}"></input>');
		$(this).append('<input type="hidden" name="bo_depth" value="${param.bo_depth}"></input>');
		
		return true;		
	});
	

    //목록
   
	$('#btn1').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/admin/freeboard/freeboardList.do');
	});
	
    
});
</script>
</head>
<body>

<h2>&nbsp;답글</h2>
<form id="replyForm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/admin/freeboard/insertReplyInfo.do" method="post">
	<div class="form-group">
		<label class="control-label col-sm-1" for="bo_title">제목:</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="bo_title" name="bo_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1" for="bo_nickname">작성자 대화명:</label>
		<div class="col-sm-7"> 
			<input type="text" class="form-control" id="bo_nickname" name="bo_nickname" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1" for="bo_pwd">패스워드:</label>
		<div class="col-sm-7"> 
			<input type="password" class="form-control" id="bo_pwd" name="bo_pwd" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1" for="bo_mail">메일:</label>
		<div class="col-sm-7"> 
			<input type="text" class="form-control" id="bo_mail" name="bo_mail" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-1" for="bo_content">내용:</label>
		<div class="col-sm-7"> 
		<textarea rows="15" cols="50"  id ="bo_content" name="bo_content" class="bo_content"  style="overflow: auto;">${freeboardInfo.bo_content}</textarea> </td>
		
			<div id="bo_content"><p></p></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-1 col-sm-5">
			<button type="submit" class="btn btn-success">답글등록</button>
			<button type="reset" class="btn btn-danger">취소</button>
			<button type="button" class="btn btn-info" id="btn1">목록</button>
		</div>
	</div>
</form>
</body>
</html>