<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/commons.js"></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/js/memberViewAdminvalidation.js'> </script>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원상세정보</title>
<script type="text/javascript">
	$(function() {
		var sido = getSido();
		$('select[name=mem_sido]').empty().html(sido);
		$('select[name=mem_sido] option').each(function() {
			if($(this).val() == '${fn:substring(fn:trim(memberInfo.mem_addr1), 0, 2) }') {
				$(this).attr('selected','selected');
			}
		});
		
		var selectSido = $('select[name=mem_sido]').val(); 
		var gugun = getGugun(selectSido);
		var segu = "";
		for(var i =1; i < gugun.length; i++) {
			segu += '<option value="' + gugun[i] + '">' + gugun[i] + '</option>';
		}
		$('select[name=mem_gugun]').empty().html(segu);
		
		$('select[name=mem_gugun] option').each(function() {
			if($(this).val() == '${fn:split(memberInfo.mem_addr1, " ")[1] }') {
				$(this).attr('selected', 'selected');
			}
		});
		
		var hp = settingDisernNum();
		$('select[name=mem_hp1]').empty().html(hp);
		$('select[name=mem_hp1] option').each(function() {
			if($(this).val() == '${fn:split(memberInfo.mem_tel, "-")[0] }') {
				$(this).attr('selected', 'selected');
			}
		});
		
		var time = new Date();
		var year = getYearsOptions(time);
		$('select[name=mem_year]').empty().html(year);
		$('select[name=mem_year] option').each(function() {
			if($(this).val() == '${fn:split(memberInfo.mem_birth, "-")[0] }') {
				$(this).attr('selected', 'selected');
			}
		});
		
		var month = getMonthOptions();
		$('select[name=mem_month]').empty().html(month);
		$('select[name=mem_month] option').each(function() {
			if($(this).val() == '${fn:split(memberInfo.mem_birth, "-")[1] }') {
				$(this).attr('selected', 'selected');
			}
		});
		
		var day = new Date($('select[name=mem_month] option:selected').val());
		var date = getLastDate(day);
		var op = "";
		for(var i = 1; i <= date; i++) {
			op += "<option value='" + i + "'>" + i + "</option>";
		}
		$('select[name=mem_day]').empty().html(op);
		$('select[name=mem_day] option').each(function() {
			if($(this).val() == '${fn:split(fn:substringBefore(memberInfo.mem_birth, " "), "-")[2] }') {
				$(this).prop('selected', true);
			}
		});
		
		$('select[name=mem_month]').change(function() {
			var day = new Date($('select[name=mem_month] option:selected').val());
			var date = getLastDate(day);
			var op = "";
			for(var i = 1; i <= date; i++) {
				op += "<option value='" + i + "'>" + i + "일</option>";
			}
			$('select[name=mem_day]').empty().html(op);
		});
		
		$('select[name=mem_sido]').change(function() {
			var selectSido = $('select[name=mem_sido]').val(); 
			var gugun = getGugun(selectSido);
			var segu = "";
			for(var i =1; i < gugun.length; i++) {
				segu += '<option value="' + gugun[i] + '">' + gugun[i] + '</option>';
			}
			$('select[name=mem_gugun]').empty().html(segu);
		});
		
		$('form[name=updateMemberForm]').submit(function() {
			var mem_hp1 = $('select[name=mem_hp1] option:selected').val();
			var mem_hp2 = $('input[name=mem_hp2]').val();
			var mem_hp3 = $('input[name=mem_hp3]').val();
			var mem_hp = mem_hp1 + '-' + mem_hp2 + '-' + mem_hp3;
			$('#mem_tel').val(mem_hp);
			
			var mem_year = $('select[name=mem_year] option:selected').val();
			var mem_month = $('select[name=mem_month] option:selected').val();
			var mem_day = $('select[name=mem_day] option:selected').val();
			var mem_birth = mem_year + '-' + mem_month + '-' + mem_day;
			$('#mem_birth').val(mem_birth);
			
			var add1 = $('select[name=mem_sido] option:selected').val();
			var add2 = $('select[name=mem_gugun] option:selected').val();
			var mem_addr = add1 + " " + add2;
			$('#mem_addr1').val(mem_addr);
			
			var mem_m1 = $('input[name=mem_mail1]').val();
			var mem_m2 = $('input[name=mem_mail2]').val();
			var mem_mail = mem_m1 + "@" + mem_m2;
			$('#mem_mail').val(mem_mail);
			
			if(!memberForm()) {
				return false;
			}
		});
		
		$('#listBack').click(function() {
			var url = '${pageContext.request.contextPath}/admin/member/memberList.do';
			var add = '?currentPage=${currentPage}&search_base_keyword=${search_base_keyword}&search_base=${search_base}';
			var add2 = '&search_sido=${search_sido}&search_gugun=${search_gugun}&search_hp=${search_hp}&search_birth=${search_birth}';
			
			 $(location).attr('href', url + add + add2);
		});
		
		$('#deleteMember').click(function() {
			if($('#mem_pass').val() != $('#mem_pass_confirm').val()) {
				alert('비밀번호가 일치하지 않습니다.');
				return false;
			}
			var mem_id = $('label[class=mem_id]').text();
			var url = '${pageContext.request.contextPath}/admin/member/deleteMember.do';
			var add = '?mem_id=' + mem_id;			
			 $(location).attr('href', url + add);
			
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
					<div class="title">회원정보</div>
					<form method="post" name="updateMemberForm" action="${pageContext.request.contextPath }/admin/member/updateMember.do">
						<table border="0" cellspacing="1" cellpadding="1">
							<tr>
								<th><span class="r">*</span>이름</th>
								<td>
									<label class="mem_name">${memberInfo.mem_name }</label>
								</td>
							</tr>
							<tr>
								<th><span class="r">*</span>아이디</th>
								<td>
									<label class="mem_id">${memberInfo.mem_id }</label>
									<input name="mem_id" type="hidden" value="${memberInfo.mem_id }"/>
								</td>
							</tr>
							<tr>
								<th><span class="r">*</span>아이디</th>
								<td><input name="mem_nick" type="text" id="mem_nick" value="${memberInfo.mem_nick }"/></td>
							</tr>
							<tr>
								<th><span class="r">*</span>비밀번호</th>
								<td><input name="mem_pass" type="text" id="mem_pass" size="20" value="${memberInfo.mem_pass }"/></td>
							</tr>
							<tr>
								<th><span class="r">*</span>비밀번호 확인</th>
								<td><input name="mem_pass_confirm" type="text" id="mem_pass_confirm" size="20" /></td>
							</tr>
							<tr>
								<th>이메일 주소</th>
								<td>
									<input name="mem_mail1" type="text" id="mem_mail1" size="20" value="${fn:substringBefore(memberInfo.mem_mail, '@' )}" />@
									<input name="mem_mail2" type="text" id="mem_mail2" size="20" value="${fn:substringAfter(memberInfo.mem_mail, '@' )}"/> 
									<input name="mem_mail" type="hidden" id="mem_mail" value="" size="20"/> 
								</td>
							</tr>
							<tr>
								<th>거주지</th>
								<td>
									<select style="width: 130px; margin-right: 10px;" name="mem_sido">
											<option selected="selected">선택하세요</option>
									</select>
									
									<select style="width: 130px;" name="mem_gugun">
										<option selected="selected">선택하세요</option>
									</select>
									<input type="hidden" name="mem_addr1" id="mem_addr1"/>
								</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td><select style="width: 100px;" name="mem_hp1">
										<option selected="selected">선택하세요</option>
									</select> - 
									<input name="mem_hp2" type="text" id="mem_hp2" size="20" value="${fn:split(memberInfo.mem_tel, '-')[1] }"/> - 
									<input name="mem_hp3" type="text" id="mem_hp3" size="20" value="${fn:split(memberInfo.mem_tel, '-')[2] }"/>
									<input name="mem_tel" type="hidden" id="mem_tel" size="20"/>
								</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td>
									<input type="radio" name="mem_calendar" value="solar" checked="checked"/>양력
									<input type="radio" name="mem_calendar" value="lunar" />음력 
									<input name="mem_birth" type="hidden" id="mem_birth" size="20"/>
									<select style="width: 130px; margin-left: 10px;" name="mem_year">
										<option selected="selected">선택하세요</option>
									</select> 
									<select style="width: 130px;" name="mem_month">
										<option selected="selected">선택하세요</option>
									</select> 
									<select style="width: 130px;" name="mem_day">
										<option selected="selected">선택하세요</option>
									</select>
								</td>
							</tr>
						</table>
						<div style="float: right;">
							<input class="btn2" type="submit" value="변경내용 저장" id="updateMember"/>
							<input class="btn2" type="button" value="목록" id="listBack"/>
							<input class="btn2" type="reset" value="취소" />
							<input class="btn2" type="button" value="탈퇴" id="deleteMember"/>
						</div>
					</form>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>