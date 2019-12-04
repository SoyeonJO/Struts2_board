<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 보기</title>
</head>
<script type = "text/javascript">
$(function(){
	
	  $('#bo_no').val('${freeboardInfo.bo_no}')
	  $('#bo_title').val('${freeboardInfo.bo_title}');
	  $('#bo_mem_id').val('${freeboardInfo.bo_mem_id}');	
	  $('#bo_nickname').val('${freeboardInfo.bo_nickname}');	
	  $('#bo_pwd').val('${freeboardInfo.bo_pwd}');
	  $('#bo_mail').val('${freeboardInfo.bo_mail}');
	  $('#bo_content').val('${freeboardInfo.bo_content}');	
	  $('#bo_group').val('${freeboardInfo.bo_group}');	


	//목록 
	$('#listbtn').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/admin/freeboard/freeboardList.do');
	});
	
	//수정
	$('#freeboardView').submit(function(){	 
		
		$(location).attr('href', '${pageContext.request.contextPath}/admin/freeboard/updatefreeboardInfo.do');
	});
		
	
	
	
	
	//삭제
	$('#deletebtn').click(function(){
	
		 var bo_no= $('#bo_no').val();
		 var bo_group= $('#bo_group').val();
		$(location).attr('href', '${pageContext.request.contextPath}/admin/freeboard/deletefreeboardInfo.do?bo_no='+bo_no+'&bo_group='+bo_group);
		
	  });


	
	
	

	//답글
     $('#replybtn').click(function(){
		 var bo_title =$('#bo_title').val();
		 var url = '${pageContext.request.contextPath}/admin/freeboard/replyInfo.do';
		 $(location).attr('href', url + '?rnum=${freeboardInfo.rnum}&bo_title=' + bo_title + '&bo_group=${freeboardInfo.bo_group}&bo_seq=${freeboardInfo.bo_seq}&bo_depth=${freeboardInfo.bo_depth}');
	});
});


function alertPRT(msg){
	BootstrapDialog.show({
	    title: '경고',
	    message: msg
	});
}



function redirectFlag(){
	if('${freeboardInfo.bo_mem_id}' == '${LOGIN_MEMBERINFO.mem_id}'){
		if('${freeboardInfo.bo_pwd}' == $('#bo_pwd').val()){
			return true;
		}
	}
	return false;
}	
</script>
<body>

<form action="${pageContext.request.contextPath}/admin/freeboard/updatefreeboard.do"  id ="freeboardView"  role="form" method="post"> 

<c:import url="../inc/header.jsp"></c:import>
<div class="wrap">
	<table width="1000" height="0" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="freeBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자유게시판</div>
					<table border="0" cellspacing="1" cellpadding="1">
					
					
						<input id="bo_no" type="hidden" name="bo_no" class="form-control"/>
					    <input type="hidden" id="bo_group" name ="bo_group" />	
						<tr>
						  <th>제목</th>
						  <td><input type="text" class="bo_title" id="bo_title" name ="bo_title"></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><input type="text" class="bo_mem_id"  id="bo_mem_id" name ="bo_mem_id" ></td>
						  
						</tr>
						
						<tr>
						    <th>첨부파일</th>
						    <td>
						     <div class="form-group"> 
			 			  <label class="control-label " for="file01"></label>
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
					
						<div class="col-sm-6"> 
						<!-- Indicators -->
						<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
						</ol>
							
						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox" style="width:320px; height:200px;">
							<c:forEach items="${freeboardInfo.items}" var="fileitem" varStatus="stat">
									<c:if test="${stat.first }">
										<div class="item active">
									</c:if>
									<c:if test="${stat.last}">
										<div class="item">
									</c:if>
										<img src="/files/${fileitem.file_save_name}" alt="pic1" style=" width: 350px; height:200px;"          
											onclick="javascript:location.href='${pageContext.request.contextPath}/admin/freeboard/downlaodfree.do?file_seq=${fileitem.file_seq }&bo_no=${param.file_bo_no}';">
														  <!-- FreeboardFileAction에 bo_no와 file_bo_no를 보낸다. -->
						</div>
								</c:forEach>
					 </div>
					</div>
						<!-- Left and right controls -->
						<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
						<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
				 </td>
						
						
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="15" cols="110"  id ="bo_content" name="bo_content" class="bo_content"  style="overflow: auto;">${freeboardInfo.bo_content}</textarea> </td>
						</tr>
					</table>

				<div class="form-group"> 
					<div style="text-align:right">
						<input class="btn2" type="submit" value="수정"/>
						<button type="button" class="btn2" id="deletebtn">삭제</button>
						<button type="button" class="btn2" id="listbtn">목록</button>
						<button type="button" class="btn2" id="replybtn">답글</button>
					</div>
				</div>	
				</div>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>