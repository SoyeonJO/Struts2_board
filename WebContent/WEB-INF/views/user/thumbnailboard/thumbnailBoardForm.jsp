,<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/thumnailvalidation.js"></script>
<script type="text/javascript">
	$(function(){
	    $('#tb_content').summernote({
	    		lang: 'ko-KR',
				height: 150,
				codemirror: {
				theme: 'monokai'
			}
	    });
	
		$('#back').click(function(){
			$(location).attr('href', '${pageContext.request.contextPath}/user/thumbnailBoard/thumbnailBoardList.do');
		});
		
		$('#ff').submit(function(){
			title = $('#tb_title').val();
			nick = $('#tb_nickname').val();
			pwd = $('#tb_pwd').val();
			mail = $('#tb_mail').val();
			content = $('#tb_content').summernote('code');
			
			if(title.trim().length <= 0){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '제목을 입력해주세요.'
			 	});
				
				return false;
			}
			if(!title.validationTITLE()){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '제목을 형식에 맞게 입력해주세요.'
			 	});
				
				return false;
			}
			
			if(nick.trim().length <= 0){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '대화명을 입력해주세요.'
			 	});
				
				return false;
			}
			if(!nick.validationNICKNAME()){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '대화명을 형식에 맞게 입력해주세요.'
			 	});
				
				return false;
			}
			
			if(pwd.trim().length <= 0){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '비밀번호을 입력해주세요.'
			 	});
				
				return false;		
			}
			if(!pwd.validationPWD()){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '비밀번호를 형식에 맞게 입력해주세요.'
			 	});
				
				return false;
			}
			
			if(mail.trim().length <= 0){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '메일을 입력해주세요.'
			 	});
				
				return false;
			}
			if(!mail.validationMAIL()){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '메일을 형식에 맞게 입력해주세요.'
			 	});
				
				return false;
			}
			
			if(content.trim().length <= 0){
				BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '내용을 입력해주세요.'
			 	});
				
				return false;
			}
			
			$(this).attr('action', '${pageContext.request.contextPath}/user/thumbnailBoard/insertThumbnail.do');
			$(this).append('<input type="hidden" name="tb_writer" value="${LOGIN_MEMBERINFO.mem_id}"/>');
			$(this).append('<input type="hidden" name="tb_ip" value="${pageContext.request.remoteAddr}"/>');
			$(this).append('<input type="hidden" name="tb_content" value="' + content + '"/>');
			
			var flag = true;
			$('input[type=file]').each(function(index, inputTag){
				if(!/\.(jpg|jpeg|gif|png)/.test($(intpuTage).val().toLowerCase())){
					BootstrapDialog.show({
				 	    title: '알림',
				 	    message: '이미지 파일만 업로드할수 있어요.'
				 	});
					
					flag =  false;
				}
			});
			return flag;
		});
	});
</script>
</head>
<body>
	<form id="ff" action="" method="POST" enctype="multipart/form-data">
		<h4 class="box-heading">게시글 등록</h4>
		<div class="form-group">
			<label class="control-label col-sm-2" for="tb_title">제목:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="tb_title" name="tb_title" placeholder="제목 입력...">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="tb_nickname">작성자 대화명:</label>
			<div class="col-sm-10"> 
				<input type="text" class="form-control" id="tb_nickname" name="tb_nickname" placeholder="대화명 입력...">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="tb_pwd">패스워드:</label>
			<div class="col-sm-10"> 
				<input type="password" class="form-control" id="tb_pwd" name="tb_pwd" placeholder="패스워드 입력...">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="tb_mail">메일:</label>
			<div class="col-sm-10"> 
				<input type="text" class="form-control" id="tb_mail" name="tb_mail" placeholder="메일주소 입력...">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="tb_content">내용:</label>
			<div class="col-sm-10"> 
				<div id="tb_content">내용을 입력해주세요...</div>
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
	</form>
</body>
</html>