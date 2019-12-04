<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원리스트</title>
<script type="text/javascript">
	$(function() {
	});
	
	google.charts.load("current", {packages:["corechart"]});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
	
      var data = google.visualization.arrayToDataTable([
	     ['Task', 'Hours per Day'],
	     
    	 ['1월' , '${date1}'*1], 
    	 ['2월' , '${date2}'*1], 
    	 ['3월' , '${date3}'*1], 
    	 ['4월' , '${date4}'*1], 
    	 ['5월' , '${date5}'*1], 
    	 ['6월' , '${date6}'*1], 
    	 ['7월' , '${date7}'*1], 
    	 ['8월' , '${date8}'*1], 
    	 ['9월' , '${date9}'*1], 
    	 ['10월' , '${date10}'*1], 
    	 ['11월' , '${date11}'*1], 
    	 ['12월' , '${date12}'*1], 
	  ]);
     
      
	  var options = {
	    title: '회원가입 월 통계',
	    is3D: true,
	  };
	
	  var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
	  chart.draw(data, options);
	}
</script>
</head>
<body>
<c:import url="../inc/header.jsp"></c:import>
<div class="wrap">	
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><c:import url="statisticsMenu.jsp"></c:import></td>
			<td width="30">&nbsp;</td>
			<td width="790">
				<div id="container">
					<div class="title">회원가입 월 통계</div>
					<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>