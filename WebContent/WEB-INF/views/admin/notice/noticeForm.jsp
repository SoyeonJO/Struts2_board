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
<script type="text/javascript" src='${pageContext.request.contextPath }/js/noticevalidation.js'></script>
<script type = "text/javascript">
$(function(){
	$('#notice_mem_id').val('${LOGIN_MEMBERINFO.mem_id}');
	$('#notice_mem_name').val('${LOGIN_MEMBERINFO.mem_name}');
 
 
	// 목록버튼
	$('#list').click(function(){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/notice/noticeList.do');
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
<body>

<form id="noticeForm" action="${pageContext.request.contextPath}/admin/notice/insertNoticeInfo.do"  role="form" method="post" enctype="multipart/form-data"> 

<c:import url="../inc/header.jsp"></c:import>
<div class="wrap">
	<table width="1000" height="0" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
<%-- 			<td width="180"><jsp:include page="freeBoardMenu.jsp"></jsp:include></td> --%>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자유게시판</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<input type="hidden" id="notice_mem_id" name="notice_mem_id">
						<input type="hidden" id="notice_mem_name" name="notice_mem_name">
					
						<tr>
						  <th>제목</th>
						  <td><input class="notice_title" id="notice_title" name ="notice_title"></td>
						</tr>
						<tr>
						  <th>내용</th>
						  <td><textarea rows="15" cols="110"  id ="notice_content" name="notice_content" class="notice_content"  style="overflow: auto;"></textarea> </td>
						</tr>
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
					</table>

				<div class="form-group"> 
					<div style="text-align:right">
						<button type="submit" class="btn btn-success" id="rebtn">등록</button>
						<button type="reset" class="btn btn-danger" id="deletebtn">삭제</button>
						<button type="button" class="btn btn-info" id="list">목록</button>
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