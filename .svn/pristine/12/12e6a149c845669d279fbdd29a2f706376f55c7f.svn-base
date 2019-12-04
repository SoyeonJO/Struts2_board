<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons.js"></script>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판 리스트</title>

<script type="text/javascript">
 $(function(){
	 
$('#boardSelect tr').click(function(){ 
	 var bo_no = $(this).find('td:eq(0) input').val();
		var url = '${pageContext.request.contextPath}/admin/freeboard/freeboardView.do';
		 $(location).attr('href', url + '?bo_no=' + bo_no ); 
 });

});

</script>
</head>

<body>
<%-- <jsp:include page="../inc/header.jsp"></jsp:include> --%>
<c:import url="../inc/header.jsp"></c:import>
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="freeBoardMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">자유게시판</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<thead>
							<tr>
							  <th width="5%">번호</th>
							  <th width="60%">제목</th>
							  <th>작성자</th>
							  <th>작성일</th>
							  <th>조회수</th>
							</tr>
						</thead>
						<tbody id ="boardSelect">
					<c:if test="${empty freeboardList }">
						<tr align="center">
							<td colspan="5"> <font color="red">등록된 게시글이 없습니다.</font> </td>
						</tr>
					</c:if>
				<c:if test="${!empty freeboardList }">
			   <c:forEach items="${freeboardList}" var="boardlist">
			   
			      <c:if test="${boardlist.bo_status=='n'}">
			         <tr align="center">
			            <td><input type="hidden" id="bo_no" value="${boardlist.bo_no}"/>${boardlist.rnum}</td>
			            <td  onclick='event.cancelBubble=true;' colspan="5"><font color="red"> <input type="hidden" id="bo_title" value="${boardlist.bo_title}" />삭제된 게시물 입니다. </font></td>
			         </tr>
			      </c:if>
			      
			      
			      <c:if test="${boardlist.bo_status=='y'}">
				      <tr>
				         <td><input type="hidden" id="bo_no" value="${boardlist.bo_no}" />${boardlist.rnum}</td>
				         <td align="left"><c:forEach begin="1" end="${boardlist.bo_depth }" varStatus="stat"> &nbsp;&nbsp;&nbsp;
				                 <c:if test="${stat.last }">
				                  <i class="fa fa-angle-right"></i>
				                 </c:if>
				            </c:forEach> ${boardlist.bo_title }</td>
				         <td>${boardlist.bo_mem_id}</td>
				         <td>${boardlist.bo_reg_date}</td>
				         <td>${boardlist.bo_hit}</td>
	    			  </tr>
	   		   	</c:if>
							</c:forEach>
					   </c:if>
					</tbody>
				</table>
				
				${paginationContent}	
					
				
	<form action="${pageContext.request.contextPath}/admin/freeboard/freeboardList.do" method="post" class="form-inline pull-right">
			<input id="search_keyword" name ="search_keyword"  type="text" placeholder="검색어 입력..." class="form-control"/> 
			<select class="form-control" name="search_keycode">
				<option>검색조건</option>
				<option value="TOTAL">전체</option>
				<option value="TITLE">제목</option>
				<option value="CONTENT">내용</option>
				
			</select>
			
		    <input class="btn1" type="submit" value="검색"/>
		</form>

				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>