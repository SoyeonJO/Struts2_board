<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 목록</title>
</head>
<body>
<div class="panel panel-green" id="noticeList_content">
	<div class="panel-heading">공지사항</div>
        <div class="panel-body">
            <table class="table table-hover-color">
                <thead>
                <tr>
                    <th>NO</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
                </thead>
			<tbody id="noticeSelect">
			  
			  <c:if test="${empty noticeList }">
						<tr align="center">
							<td colspan="5"> <font color="red">등록된 게시글이 없습니다.</font> </td>
						</tr>
					</c:if>
					  <c:if test="${!empty noticeList }">
							<c:forEach items="${noticeList}" var="noticeList">
								<c:choose>
									<c:when test="${noticeList.notice_status == 'n' }">
									<tr align="center">
										 <td colspan="5" onclick="event.cancelBubble=true">삭제된 게시글입니다.</td>
									</tr>	 
									</c:when>
									<c:otherwise>
								
								<tr> 
								                       <!-- bo_no를 !rnum처리! -->
									<td><input type="hidden" id="no" value="${noticeList.notice_no}"/>${noticeList.rnum}</td>
									<td align="left">
										${noticeList.notice_title }
									</td>
									<td>${noticeList.notice_reg_date}</td>
									<td>${noticeList.notice_hit}</td>
								</tr>
								</c:otherwise>
						</c:choose>	
							</c:forEach>
					   </c:if>
			  
			
			
			</tbody>
		</table>
	</div>

</div>	
		${paginationContent}
<div >
<form action="${pageContext.request.contextPath }/user/notice/noticeList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" id="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	 
</form> 
</div>	
</body>
<script type="text/javascript">
$(function(){
	
	$('#noticeSelect tr').click(function(){ 
		 var notice_no = $(this).find('td:eq(0) input').val();
			var url = '${pageContext.request.contextPath}/user/notice/noticeView.do';
			 $(location).attr('href', url + '?notice_no=' + notice_no ); 
	 });
	
	$('#btn1').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/user/notice/noticeForm.do');
	}); 
	
});
</script>
</html>