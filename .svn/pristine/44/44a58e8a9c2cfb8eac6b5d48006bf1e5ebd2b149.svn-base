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
<style type="text/css">
	.viewImg{
		width : 200px;
		height: 200px;
	}
	#myCarousel{
		width : 200px;
		height: 200px;
	}
	textarea{
		width : %;
	}
	#file{
		margin-left: 50px;
	}
</style>
</head>
<body>
<c:import url="../inc/header.jsp"></c:import>
	<form action="" method="POST">
		<div class="panel panel-green">
			<div class="panel-heading">게시글 상세보기</div>
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
				<div id="file" class="form-group">
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
										<img class="viewImg" src="/files/${tbiItems['TBI_SAVE_NAME'] }" alt="pic1" 
											onclick="javascript:location.href='${pageContext.request.contextPath}/admin/thumbnailBoard/thumbnailDownload.do?tbi_seq=${tbiItems['TBI_SEQ'] }&tb_no=${param.tb_no }';" />
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
						<button id="delete" type="button" class="btn btn-danger"
							style="float: right">삭제</button>
						<button id="back" type="button" class="btn btn-primary"
							style="float: right" id="back">목록</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function(){
   		
   		$('#tb_title').val('${tbInfo.tb_title}');
   		$('#tb_nickname').val('${tbInfo.tb_nickname}');
   		$('#tb_pwd').val('${tbInfo.tb_pwd}');
   		$('#tb_mail').val('${tbInfo.tb_mail}');
   		$('#tb_content').val('${tbInfo.tb_content}');
   		$('form').append('<input type="hidden" id="tb_writer" name="tb_writer" value="${tbInfo.tb_writer}"/>');
   		
   		$('#delete').click(function(){
	   		if($('#tb_writer').val() == '${LOGIN_MEMBERINFO.mem_id}'){
			   	$(location).attr('href', '${pageContext.request.contextPath}/admin/thumbnailBoard/deleteThumbnail.do?tb_no=${param.tb_no}');
	   		}else{
	   			alert('작성자만 삭제가 가능합니다.');
	   			
	   			return false;
	   		}
   		});
   		
   		$('form').submit(function(){
			if($('#tb_writer').val() == '${LOGIN_MEMBERINFO.mem_id}'){
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
	   			
	   			$(this).attr('action', '${pageContext.request.contextPath}/admin/thumbnailBoard/updateThumbnail.do?tb_no=${param.tb_no}');
	   			$(this).append('<input type="hidden" name="tb_ip" value="${pageContext.request.remoteAddr}"/>');
	   		}else{
	   			alert('작성자만 수정이 가능합니다.');
	   			
	   			return false;
	   		}
   		});
   		
   		$('#back').click(function(){
   			if(eval('${!empty param.currentPage}')){
   				$(location).attr('href', '${pageContext.request.contextPath}/admin/thumbnailBoard/thumbnailBoardList.do?currentPage=${param.currentPage}&search_keyword=${param.search_keyword}&search_keycode=${param.search_keycode}');
   			}else{
   				$(location).attr('href', '${pageContext.request.contextPath}/admin/thumbnailBoard/thumbnailBoardList.do?search_keyword=${param.search_keyword}&search_keycode=${param.search_keycode}');
   			}
   		});
	});
</script>
</html>