<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		
		
		$('#rView').submit(function(){
			
			title = $('#ref_title').val().trim();
			content = $('#ref_content').val().trim();
			
			if(title.length <= 0){
				alert('제목을 입력해주세요.');
				return false;
			}	
			
			if(content.length <= 0){
				alert('내용을 입력해주세요.');
				return false;
			}
			
			
			$(this).append('<input type="hidden" name="ref_mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
// 			$(this).append('<input type="hidden" name="ref_nickname" value="${LOGIN_MEMBERINFO.mem_name}"></input>');
		});
		
		$('#list').click(function(){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/reference/refList.do');
		});
	});
</script>
</head>
<body>
<c:import url="../inc/header.jsp"></c:import>
<div class="panel panel-green" style="background:#fff;">
   <div class="panel-heading">자료실 작성</div>
        <div class="panel-body pan">
             <form action="${pageContext.request.contextPath}/admin/reference/insertRef.do" method="post" id="rView" enctype="multipart/form-data">		
            <div class="form-body pal">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                        <input id="ref_no" name="ref_no" type="hidden" placeholder="" class="form-control"/>
        				<label for="inputSubject" class="control-label">제목</label>

                            <div class="input-icon right">
						<input id="ref_title" name="ref_title" type="text" placeholder="" class="form-control" value="${refInfo.ref_title }" />
                        </div>
                        </div> 
                        </div> 
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="ref_nickname" class="control-label">작성자</label>
                            <div class="input-icon right">
                                <input readonly id="ref_nickname" name="ref_nickname" type="text" placeholder="" class="form-control"  value="${LOGIN_MEMBERINFO.mem_name}"/>
                                </div>
                        </div>
                    </div>
                 </div>
                     
                <div class="form-group">
                   <label for="ref_content" class="control-label"> 내용</label>
            
                        <textarea id="ref_content" name="ref_content" rows="5" class="form-control" value="${refInfo.ref_content }"></textarea>
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
					
            <div class="form-actions text-right pal">
                <button type="submit" class="btn btn-success">등록</button>
				<button type="reset" class="btn btn-danger" id="deletebtn">취소</button>
				<button type="button" class="btn btn-info" id="list">목록</button>
            </div>
            </form>
        </div>
</div>
</body>
</html>