<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<form id="noticeForm" action="${pageContext.request.contextPath}/user/notice/insertNoticeInfo.do" enctype="multipart/form-data" method="post">
	<div class="panel panel-black">
		<div class="panel-heading">공지사항</div>
		<div class="panel-body pan">
		
		<input type="hidden" id="notice_mem_id" name="notice_mem_id">
		<input type="hidden" id="notice_mem_name" name="notice_mem_name">
			
				<div class="form-group">
						<label for="inputSubject" class="control-label"> 제목</label>
						<div class="input-icon right">
							<i class="fa fa-tag"></i> <input id="notice_title" name="notice_title" type="text" placeholder="" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputMessage" class="control-label"> 내용</label>
						<textarea rows="5" class="form-control" id="notice_content" name="notice_content"></textarea>
						
		
			    <div class="col-md-6">
						<label class="control-label col-sm-2" for="file01">첨부파일1:</label>
						<div class="col-sm-10">
							<input type="file" class="filestyle" id="file01" name="files" data-buttonName="btn-primary">
						</div>
					</div>
					<div class="col-md-6">
						<label class="control-label col-sm-2" for="file02">첨부파일2:</label>
						<div class="col-sm-10">
							<input type="file" class="filestyle" id="file02" name="files" data-buttonName="btn-primary">
						</div>
					</div>
				
						<br/>
						<br/>
						<br/>
				
			<div class="form-group"> 
				<div class="col-sm-offset-1 col-sm-10">
					<button type="submit" class="btn btn-success" id="rebtn">등록</button>
					<button type="reset" class="btn btn-danger" id="deletebtn">삭제</button>
					<button type="button" class="btn btn-info" id="list">목록</button>

				</div>
			</div>
						</div>
					</div>

			
	</div>
</form>
</body>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/noticevalidation.js'></script>
<script type = "text/javascript">
$(function(){
	$('#notice_mem_id').val('${LOGIN_MEMBERINFO.mem_id}');
	$('#notice_mem_name').val('${LOGIN_MEMBERINFO.mem_name}');
 
 
	// 목록버튼
	$('#list').click(function(){
			$(location).attr('href', '${pageContext.request.contextPath}/user/notice/noticeList.do');
		}); 


    	$('#noticeForm').submit(function(){
    		
    		
   		if(!$('#notice_title').val().validationTITLE()){
   			alert('제목을 입력해주세요.');
   			return false;
   		}
   		if(!$('#notice_content').val().validationCONTENT()){
   			alert('내용을 입력해주세요.');
   			return false;
   		}
   		
   	}); 
   	
   	


   	
   	
});

</script>

</html>