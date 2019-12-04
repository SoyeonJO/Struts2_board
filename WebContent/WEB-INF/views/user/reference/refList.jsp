<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자료실 목록</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript'>
		$(function() {
			$('tbody tr').click(function() {
				var ref_no = $(this).find('td:eq(0) input').val();
				var rnum = $(this).find('td:eq(0)').text();
				var url = '${pageContext.request.contextPath}/user/reference/refView.do';
				$(location).attr('href', url + '?ref_no=' + ref_no + '&rnum=' + rnum + '&currentPage=${param.currentPage}&search_keyword=${search_keyword}&search_keycode=${search_keycode}');
			});
			
			$('#insertBtn').click(function(){
				if(eval('${!empty LOGIN_MEMBERINFO}')){
					$(location).attr('href', '${pageContext.request.contextPath }/user/reference/refForm.do');
				}else{
					alert('로그인을 해주세요.');
					return false;
				}
				});
		});
</script>
</head>
<body>
<div id="freeboardList_content">-
	<div class="panel panel-blue">
    	<div class="panel-heading">자료실 목록</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
					<th scope="col" width="10%">조회수</th>
				</tr>
			</thead>
			<tbody>
					<c:if test="${empty refList }">
						<tr align="center">
							<td colspan="5"> <font color="red">등록된 게시글이 없습니다.</font> </td>
						</tr>
					</c:if>
					 <c:if test="${!empty refList }">
							<c:forEach items="${refList}" var="refInfo">
							
								<c:choose>
									<c:when test="${refInfo.ref_status == 'n' }">
									<tr align="center">
										 <td colspan="5" onclick="event.cancelBubble=true">삭제된 게시글입니다.</td>
									</tr>	 
									</c:when>
									<c:otherwise>
										<tr>
											<td><input type="hidden" id="no" value="${refInfo.ref_no}"/>${refInfo.rnum}</td>
											<td align="left">
											<c:forEach begin="1" end="${refInfo.ref_depth }" varStatus="stat">
											&nbsp;&nbsp;&nbsp;
											<c:if test="${stat.last }">
												<i class="fa fa-angle-right"></i>
											</c:if>
										</c:forEach>
										${refInfo.ref_title }
									</td>
									<td>${refInfo.ref_mem_id}</td>
									<td>${refInfo.ref_reg_date}</td>
									<td>${refInfo.ref_hit}</td>
								</tr>
							</c:otherwise>
						</c:choose>								
					</c:forEach>
					</c:if>
					</tbody>
					
<!-- 			<tbody> -->
<%-- 				<c:forEach items="${refList }" var="refInfo"> --%>
<!-- 				<tr> -->
<%-- 					<td><input type="hidden" value="${refInfo.ref_no}"/>${refInfo.rnum}</td> --%>
<%-- 					<td>${refInfo.ref_title }</td> --%>
<%-- 					<td>${refInfo.ref_mem_id }</td> --%>
<%-- 					<td>${refInfo.ref_reg_date }</td> --%>
<%-- 					<td>${refInfo.ref_hit }</td> --%>
<!-- 				</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</tbody> -->
		
		</table>
		${paginationContent }
	</div>
</div>
<div >
<form action="${pageContext.request.contextPath }/user/reference/refList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="NICKNAME">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control" id="insertBtn">게시글 등록</button>
</form>
</div>	
</body>
</html>