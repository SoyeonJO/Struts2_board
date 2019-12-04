<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/commons.js"></script>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원리스트</title>
<script type="text/javascript">
	$(function() {
		
		var sido = "<option value='' selected='selected'>선택하세요</option>";
		sido += getSido();
		$('select[name=search_sido]').empty().html(sido);
		
		$('select[name=search_sido]').change(function() {
			var selectSido = $('select[name=search_sido]').val(); 
			var gugun = getGugun(selectSido);
			var segu = "<option value='' selected='selected'>선택하세요</option>";
			for(var i =1; i < gugun.length; i++) {
				segu += '<option value="' + gugun[i] + '">' + gugun[i] + '</option>';
			}
			$('select[name=search_gugun]').empty().html(segu);
		});
		
		var hp = "<option value='' selected='selected'>선택하세요</option>";
		hp += settingDisernNum();
		$('select[name=search_hp1]').empty().html(hp);
		
		var time = new Date();
		var year = "<option value='' selected='selected'>선택하세요</option>";
		year += getYearsOptions(time);
		$('select[name=search_year]').empty().html(year);
		
		var month = "<option value='' selected='selected'>선택하세요</option>";
		month += getMonthOptions();
		$('select[name=search_month]').empty().html(month);
		
		$('select[name=search_month]').change(function() {
			var day = new Date($('select[name=search_month] option:selected').val());
			var date = getLastDate(day);
			var op = "<option value=''>선택하세요</option>";
			for(var i = 1; i <= date; i++) {
				op += "<option value='" + i + "'>" + i + "</option>";
			}
			$('select[name=search_day]').empty().html(op);
		});
		
		$('input:checkbox[name=selectTotal]').change(function() {
			if($(this).prop('checked')) {
				$('input:checkbox[name=selectOne]').prop("checked", true);
			}else {
				$('input:checkbox[name=selectOne]').prop("checked", false);
			}
		});
		
		
		$('#search_count').change(function() {
			var blockCount = $('#search_count option:selected').val();
			$.ajax({ 
				 url : '${pageContext.request.contextPath}/admin/member/memberListAjax.do' 	
				,type : 'post'
				,dataType : 'json'
				,data : { 'blockCount':blockCount}
				,error : function(xhr) {
					alert(xhr.status);
				}
				,success : function(res) {
					var htmls = "";
					$.each(res.memberList, function(i, v) {
						htmls += '<tr>' +
									'<th width="10%">' +
				   				  	'<input type="checkbox" name="selectTotal" class="checkbox_align"/>' +
									'</th>' + 
									'<th width="20%">' + v.mem_id + '</th>' +
									'<th>' + v.mem_name + '</th>' +
									'<th>' + v.mem_birth.substr(0,12) + '</th>' +
									'<th>' + v.mem_mail + '</th>' +
								'</tr>';
					});
					$('tbody[class=memberList]').empty().html(htmls);
					$('span[class=pagingHtml]').empty();
					$('span[class=pagingHtml]').html(res.paginationContent);
				}
			});
		});	 

		$('form[name=search_form]').submit(function() {
			var search_hp1 = $('select[name=search_hp1] option:selected').val();
			var search_hp2 = $('input[name=search_hp2]').val();
			var search_hp3 = $('input[name=search_hp3]').val();
			var search_hp = search_hp1 + search_hp2 + search_hp3;
			$('#search_hp').val(search_hp);
			
			
			var search_year = $('select[name=search_year] option:selected').val();
			var search_month = $('select[name=search_month] option:selected').val();
			var search_day = $('select[name=search_day] option:selected').val();
			var search_birth = search_year + search_month + search_day;
			$('#search_birth').val(search_birth);
		});
		
		$('#memberTable tr:gt(0)').click(function() {
			var mem_id = $(this).find('th:eq(1)').text();
			var add = '&currentPage=${currentPage}&search_base_keyword=${search_base_keyword}&search_base=${search_base}';
			var add2 = '&search_sido=${search_sido}&search_gugun=${search_gugun}&search_hp=${search_hp}&search_birth=${search_birth}';
			$(location).attr('href', '${pageContext.request.contextPath}/admin/member/memberDetail.do?mem_id=' + mem_id + add + add2);
		});
	});
</script>
</head>
<body>
<c:import url="../inc/header.jsp"></c:import>
<div class="wrap">	
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><c:import url="memberMenu.jsp"></c:import></td>
			<td width="30">&nbsp;</td>
			<td width="790">
				<div id="container">
					<div class="title">회원관리</div>
					<form name="search_form" action="${pageContext.request.contextPath}/admin/member/memberList.do" method="get">
						<table border="0" cellspacing="1" cellpadding="1">
							<tr>
								<th width="120">기본검색</th>
								<td>
									<select style="width: 130px;" name="search_base">
											<option value="">선택하세요</option>
											<option value="search_name">이름</option>
											<option value="search_id">아이디</option>
									</select>
								<input name="search_base_keyword" type="text" size="20" /></td>
							</tr>
							<tr>
								<th>거주지</th>
								<td>
									<select style="width: 130px;" name="search_sido">
											<option value="">선택하세요</option>
									</select> 
									<select style="width: 130px;" name="search_gugun">
										<option value="">선택하세요</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>
									<select style="width: 100px;" name="search_hp1">
										<option value="">선택하세요</option>
									</select> - 
									<input name="search_hp2" type="text" id="search_hp2" size="20" value=""/> - 
									<input name="search_hp3" type="text" id="search_hp3" size="20" value=""/>
									<input name="search_hp" type="hidden" id="search_hp" size="20" value=""/>
								</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td><input type="radio" name="search_calendar" value="solar" checked="checked"/>양력
									<input type="radio" name="search_calendar" value="lunar" />음력 
									<input name="search_birth" type="hidden" id="search_birth" size="20" />
									<select style="width: 130px;" name="search_year">
										<option value="">선택하세요</option>
									</select> 
									<select style="width: 130px;" name="search_month">
										<option value="">선택하세요</option>
									</select> 
									<select style="width: 130px;" name="search_day">
										<option value="">선택하세요</option>
									</select>
								</td>
							</tr>
						</table>
						<div style="padding-top: 5px; text-align: right;">
							<input class="btn1" type="reset" value="초기화"/>
							<input class="btn1" type="submit" value="검색하기" id="search_member"/>
						</div>
					</form>
					<div style="padding-top: 5px;" id="search_totalMembers">
						<label class="totalmembers"></label>
						<select style="width: 50px; float: right;" name="search_count" id="search_count">
							<option selected="selected" value="10">10</option>
							<option value="25">25</option>
							<option value="50">50</option>
						</select>
					</div>
					<div style="height: 15px;"></div>
					<table border="0" cellspacing="1" cellpadding="1" id="memberTable">
						<thead>
							<tr>
								<th width="10%">
								    <input type="checkbox" name="selectTotal" class="checkbox_align"/>&nbsp;선택
								</th>
								<th width="20%">아이디</th>
								<th>이름</th>
								<th>생일</th>
								<th>메일</th>
							</tr>
						</thead>
						<tbody class="memberList">
							<c:forEach items="${memberlist }" var="memberInfo">
								<tr>
									<th width="10%" onclick="event.cancelBubble = true;">
									    <input type="checkbox" name="selectOne" class="checkbox_align"/>
									</th>
									<th width="20%">${memberInfo.mem_id }</th>
									<th>${memberInfo.mem_name }</th>
									<th>${fn:substringBefore(memberInfo.mem_birth, ' ') }</th>
									<th>${memberInfo.mem_mail }</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div align="center">
						<span class="pagingHtml">${paginationContent }</span>
						<input class="publishingCoupon" type="submit" value="선택회원 메일발송" style="float: left;"/>
						<input class="btn2" type="button" value="Excel작성" style="float: right;"/>
						<input class="btn2" type="button" value="PDF작성" style="float: right; margin-right: 5px;"/>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>