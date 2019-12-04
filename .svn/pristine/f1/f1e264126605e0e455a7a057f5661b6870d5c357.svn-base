<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/thumnailvalidation.js"></script>
</head>
<body>
<c:import url="../inc/header.jsp"></c:import>
	<form action="" method="POST" enctype="multipart/form-data">
		<div class="panel panel-green">
			<div class="panel-heading">게시글 쓰기</div>
			<div class="panel-body pan">
				<div class="form-body pal">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="tb_title" class="control-label"> 제목:</label>
								<div class="input-icon right">
									<i class="fa fa-user"></i> <input type="text"
										id="tb_title" name="tb_title" placeholder="제목 입력..."
										class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="tb_nickname" class="control-label"> 작성자 대화명:</label>
								<div class="input-icon right">
									<i class="fa fa-envelope"></i> <input type="text" id="tb_nickname" name="tb_nickname"
										placeholder="대화명 입력..." class="form-control" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="tb_pwd" class="control-label"> 패스워드:</label>
								<div class="input-icon right">
									<i class="fa fa-user"></i> <input type="password"
										id="tb_pwd" name="tb_pwd" placeholder="패스워드 입력..."
										class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="tb_mail" class="control-label"> 메일:</label>
								<div class="input-icon right">
									<i class="fa fa-envelope"></i> <input type="text" id="tb_mail" name="tb_mail"
										placeholder="메일주소 입력..." class="form-control" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="tb_content" class="control-label"> 내용:</label>
						<textarea rows="5" class="form-control" id="tb_content"
							name="tb_content"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="file01">첨부파일1:</label>
					<div class="col-sm-10">
						 <input type="file" class="filestyle" id="file01" name="files" data-buttonName="btn-primary">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="file02">첨부파일2:</label>
					<div class="col-sm-10">
						 <input type="file" class="filestyle" id="file02" name="files" data-buttonName="btn-primary">
					</div>
				</div>
				<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-info" style="float: right">등록</button>
						<button type="reset" class="btn btn-danger" style="float: right">취소</button>
						<button type="button" class="btn btn-primary" style="float: right" id="back">목록</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function(){
	
		$('#back').click(function(){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/thumbnailBoard/thumbnailBoardList.do');
		});
		
		$('form').submit(function(){
			title = $('#tb_title').val();
			nick = $('#tb_nickname').val();
			pwd = $('#tb_pwd').val();
			mail = $('#tb_mail').val();
			content = $('#tb_content').val();
			
			if(title.trim().length <= 0){
				alert('제목을 입력해주세요.');
				
				return false;
			}
			if(!title.validationTITLE()){
				alert('제목을 형식에 맞게 입력해주세요.');
				
				return false;
			}
			
			if(nick.trim().length <= 0){
				alert('대화명을 입력해주세요.');
				
				return false;
			}
			if(!nick.validationNICKNAME()){
				alert('대화명을 형식에 맞게 입력해주세요.');
				
				return false;
			}
			
			if(pwd.trim().length <= 0){
				alert('비밀번호을 입력해주세요.');
				
				return false;		
			}
			if(!pwd.validationPWD()){
				alert('비밀번호를 형식에 맞게 입력해주세요.');
				
				return false;
			}
			
			if(mail.trim().length <= 0){
				alert('메일을 입력해주세요.');
				
				return false;
			}
			if(!mail.validationMAIL()){
				alert('메일을 형식에 맞게 입력해주세요.');
				
				return false;
			}
			
			if(content.trim().length <= 0){
				alert('내용을 입력해주세요.');
				
				return false;
			}
			
			$(this).attr('action', '${pageContext.request.contextPath}/admin/thumbnailBoard/insertThumbnail.do');
			$(this).append('<input type="hidden" name="tb_writer" value="${LOGIN_MEMBERINFO.mem_id}"/>');
			$(this).append('<input type="hidden" name="tb_ip" value="${pageContext.request.remoteAddr}"/>');
			
			var flag = true;
			$('input[type=file]').each(function(index, inputTag){
				if(!/\.(jpg|jpeg|gif|png)/.test($(intpuTage).val().toLowerCase())){
					alert('이미지 파일만 업로드할수 있어요.');
					
					flag =  false;
				}
			});
			return flag;
		});
	});
</script>
</html>