<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
<link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/jquery-ui-1.10.4.custom.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/animate.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/all.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/style-responsive.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/zabuto_calendar.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/pace.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/jquery.news-ticker.css">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.7.1/summernote.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" type="text/css">
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<title>회원관리 관리자</title>
</head>
<body>
	<div class="wrap">
		<div id="header">
			<div class="top_bn">
				<ul>
					<li><span style="color:red"><b>${LOGIN_MEMBERINFO.mem_nick }</b></span>&nbsp;<span>님 어서오세요</span></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_t.jpg" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_f.jpg" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath }/image/admin_homelink.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath }/admin/join/logout.do"><img src="${pageContext.request.contextPath }/image/admin_logout.jpg" /></a></li>
				</ul>
			</div>
			<div class="logo">
				<img src="${pageContext.request.contextPath }/image/logo.jpg" />
			</div>
			<div class="gnb">
				<ul>
					<li><a href="${pageContext.request.contextPath }/admin/member/memberList.do">회원관리</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/notice/noticeList.do">공지사항</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/freeboard/freeboardList.do">게시판</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/reference/refList.do">자료실</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/thumbnailBoard/thumbnailBoardList.do">썸네일게시판</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/statistics/insertDateStatus.do">통계 분석</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>