<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!-- 
  클라이언트 단 파일업로드 : <form enctype=mutipart/form-data >
                              ajax({})
  파일 업로드 환경
  1. http://commons.apache.org
 
 
  2. WEB-INF/lib import
 
 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
 $(function(){
	 
	  $('form').submit (function(){
		  var flag = true;
		  $('input[type=file]').each(function(index, inputTag){
			  
			  if(!/\(jpg|jpeg|gif|png)$/.test($(inputTag).val().toLowerCase)){
				  alert('이미지파일만 업로드 할수 있어요');
				  flag = false;
			  }
		  })
		  return flag;
	  })
	 
 })

</script>
</head>
<body>
<!-- 
   form태그  enctype = "application/x-www-form-urlencoded" 일반서브밋요청(쿼리스트링값은 문자열)
             enctype = "multipart/form-data" 일반서브밋요청(쿼리스트링값은 바이너리 스트리밍)
   for태그 파일 서브밋 요청시: method = "POST"


 -->
<%-- form[action='${pageContext.request.contextPath }/14/result.jsp' method=POST enctype=multipart/form-data]  --%>  <!-- method와 enctype설정이 되어야 업로드가가능 -->
<form action="${pageContext.request.contextPath}/file/fileUpload.do" method="POST" enctype="multipart/form-data">
<table>
	<tr>
			<td>아이디</td>
			<td><input type="text" name="mem_id"/></td>
	</tr>
	<tr>
			<td>비밀번호</td>
			<td><input type="text" name="mem_pass"/></td>
	</tr>
	<tr>
			<td>성명</td>
			<td><input type="text" name="mem_name"/></td>
	</tr>
	<tr>
			<td>파일1</td>
			<td><input type="file" name="files" /></td>
	</tr>
	<tr>
			<td>파일2</td>
			<td><input type="file" name="files" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="파일전송"/>
		</td>
	</tr>
</table>
</form>
<!-- 파일 업로드 다운로드 -->
<img src="/files/${param.fileName}" alt="" width="200px" height="250px"
     onclick="javascript: location.href ='${pageContext.request.contextPath}/file/fileDownload.do?fileName=${param.fileName}';"/>
</body>
</html>