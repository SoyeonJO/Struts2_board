<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
</head>
<script type = "text/javascript">
$(function(){
	
	  $('#notice_no').val('${noticeInfo.notice_no}');
	  $('#notice_title').val('${noticeInfo.notice_title}');
	  $('#notice_reg_date').val('${noticeInfo.notice_reg_date}');
	  $('#notice_mem_id').val('${noticeInfo.notice_mem_id}');
	  $('#notice_content').val('${noticeInfo.notice_content}');	


	//목록 
	$('#listbtn').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/admin/notice/noticeList.do');
	});
	
	//수정
	$('#noticeView').submit(function(){	 
		$(location).attr('href', '${pageContext.request.contextPath}/admin/notice/updateNoticeInfo.do');
	});
		
	//삭제
	$('#deletebtn').click(function(){
		var notice_no= $('#notice_no').val();
		$(location).attr('href', '${pageContext.request.contextPath}/admin/notice/deleteNoticeInfo.do?notice_no='+notice_no);
	  });

});


function alertPRT(msg){
	BootstrapDialog.show({
	    title: '경고',
	    message: msg
	});
}



/* function redirectFlag(){
	if('${freeboardInfo.bo_mem_id}' == '${LOGIN_MEMBERINFO.mem_id}'){
		if('${freeboardInfo.bo_pwd}' == $('#bo_pwd').val()){
			return true;
		}
	}
	return false;
}	 */
</script>
<body>

<form action="${pageContext.request.contextPath}/admin/notice/updateNoticeInfo.do"  id ="noticeView"  role="form" method="post"> 

<c:import url="../inc/header.jsp"></c:import>
<div class="wrap">
	<table width="1000" height="0" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
<%-- 			<td width="180"><jsp:include page="freeBoardMenu.jsp"></jsp:include></td> --%>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">공지사항</div>
					<table border="0" cellspacing="1" cellpadding="1">
				    <input id="notice_no" type="hidden" name="notice_no" class="form-control" value=""/>
						<tr>
						  <th>제목</th>
						  <td><input type="text" class="notice_title" id="notice_title" name ="notice_title"></td>
						</tr>
						<tr>
						  <th>작성일</th>
						  <td><input type="text" class="notice_reg_date"  id="notice_reg_date" name ="notice_reg_date" disabled="disabled"></td>
						  <td><input type="hidden" class="notice_reg_date"  id="notice_reg_date" name ="notice_reg_date" ></td>
						  
						</tr>

						<tr>
						  <th>내용</th>
						  <td><textarea rows="15" cols="110"  id ="notice_content" name="notice_content" class="notice_content"  style="overflow: auto;">${noticeInfo.notice_content}</textarea> </td>
						</tr>
						
						<tr>
						    <th>첨부파일</th>
						    <td>
						     <div class="form-group"> 
		
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
					
						<div class="col-sm-5"> 
						<!-- Indicators -->
						<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
						</ol>
							
						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox" style="width:300px; height:200px;">
							<c:forEach items="${noticeInfo.items }" var="fileitem" varStatus="stat">
									<c:if test="${stat.first }">
										<div class="item active">
									</c:if>
									<c:if test="${stat.last}">
										<div class="item">
									</c:if>
										<img src="/files/${fileitem.fi_not_save_name}" alt="pic1"         
											onclick="javascript:location.href='${pageContext.request.contextPath }/user/notice/noticeDownload.do?fi_not_seq=${fileitem.fi_not_seq }&notice_no=${param.notice_no }';" />
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
					</table>

				<div class="form-group"> 
					<div style="text-align:right">
						<input class="btn2" type="submit" value="수정"/>
						<button type="button" class="btn2" id="deletebtn">삭제</button>
						<button type="button" class="btn2" id="listbtn">목록</button>
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