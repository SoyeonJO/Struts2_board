<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/thumnailvalidation.js"></script>
<style type="text/css">
	img{
		width : 200px;
		height: 200px;
	}
	#myCarousel{
		width : 200px;
		height: 200px;
	}
</style>
</head>
<body>
	<form action="" method="POST">
		<h4 class="box-heading">게시글 상세보기</h4>
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
			<label for="tb_content">첨부파일:</label>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
				</ol>
		
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox" style="height: 200px;">
					<c:forEach items="${tbiList }" var="tbiItems" varStatus="stat">
						<c:if test="${stat.first }">
							<div class="item active">
						</c:if>
						<c:if test="${stat.last }">
							<div class="item">		
						</c:if>
								<img src="/files/${tbiItems['TBI_SAVE_NAME'] }" alt="pic1" 
									onclick="javascript:location.href='${pageContext.request.contextPath}/user/thumbnailBoard/thumbnailDownload.do?tbi_seq=${tbiItems['TBI_SEQ'] }&tb_no=${param.tb_no }';" />
							</div>
					</c:forEach>
				</div>
				<!-- Left and right controls -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
		</div>
		<div class="form-group"> 
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-info" style="float: right">수정</button>
				<button type="reset" class="btn btn-danger" style="float: right">취소</button>
				<button id="delete" type="button" class="btn btn-danger" style="float: right">삭제</button>
				<button id="back" type="button" class="btn btn-primary" style="float: right" id="back">목록</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function(){
   		$('#tb_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
			}
    	});
   		
   		$('#tb_title').val('${tbInfo.tb_title}');
   		$('#tb_nickname').val('${tbInfo.tb_nickname}');
   		$('#tb_pwd').val('${tbInfo.tb_pwd}');
   		$('#tb_mail').val('${tbInfo.tb_mail}');
   		$('#tb_content').summernote('code', '${tbInfo.tb_content}');
   		$('form').append('<input type="hidden" id="tb_writer" name="tb_writer" value="${tbInfo.tb_writer}"/>');
   		
   		$('#delete').click(function(){
	   		if($('#tb_writer').val() == '${LOGIN_MEMBERINFO.mem_id}'){
			   	$(location).attr('href', '${pageContext.request.contextPath}/user/thumbnailBoard/deleteThumbnail.do?tb_no=${param.tb_no}');
	   		}else{
	   			BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '작성자만 삭제가 가능합니다.'
			 	});
	   			
	   			return false;
	   		}
   		});
   		
   		$('form').submit(function(){
			if($('#tb_writer').val() == '${LOGIN_MEMBERINFO.mem_id}'){
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
	   			
	   			$(this).attr('action', '${pageContext.request.contextPath}/user/thumbnailBoard/updateThumbnail.do?tb_no=${param.tb_no}');
	   			$(this).append('<input type="hidden" name="tb_ip" value="${pageContext.request.remoteAddr}"/>');
				$(this).append('<input type="hidden" name="tb_content" value="' + content + '"/>');
	   		}else{
	   			BootstrapDialog.show({
			 	    title: '알림',
			 	    message: '작성자만 수정이 가능합니다.'
			 	});
	   			
	   			return false;
	   		}
   		});
   		
   		$('#back').click(function(){
   			if(eval('${!empty param.currentPage}')){
   				$(location).attr('href', '${pageContext.request.contextPath}/user/thumbnailBoard/thumbnailBoardList.do?currentPage=${param.currentPage}&search_keyword=${param.search_keyword}&search_keycode=${param.search_keycode}');
   			}else{
   				$(location).attr('href', '${pageContext.request.contextPath}/user/thumbnailBoard/thumbnailBoardList.do?search_keyword=${param.search_keyword}&search_keycode=${param.search_keycode}');
   			}
   		});
	});
</script>
</html>