<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">

<style type="text/css">
* { padding: 0; margin: 0; }
*, ::after, ::before { box-sizing: border-box; }

body {
	font-family:"Malgun Gothic", "맑은 고딕", NanumGothic, 나눔고딕, 돋움, sans-serif;
	font-size: 14px;
	color: #222;
}

a { color: #222; text-decoration: none; cursor: pointer; }
a:active, a:hover { color: #f28011; text-decoration: underline; }

.container { margin: 30px auto; width: 800px; }
.box-container .box {
	box-sizing: border-box;
	padding: 20px;
	width: 100%;
	height: 400px;
	border: 1px solid #ccc;
	margin: 10px;
	text-align: center;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/5.4.2/echarts.min.js"></script>

<script type="text/javascript">
// https://echarts.apache.org/en/index.html

$(function(){
	let url = "${pageContext.request.contextPath}/admin/echart/chart/line1";
	
	$.getJSON(url, function(data){
		// console.log(data);
		
		var chartDom = document.getElementById('lineContainer1');
		var myChart = echarts.init(chartDom);
		var option;

		option = {
		title: {
			text: data.year + '년 월별 회원 수'  
			},				
		  xAxis: {
		    type: 'category',
		    data: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
		  },
		  yAxis: {
		    type: 'value'
		  },
		  series: [
		    {
		      data: data.series,
		      type: 'bar'
		    }
		  ]
		};

		option && myChart.setOption(option);
	
});
});


</script>

</head>
<body>

<div class="container">
	<h2> chart 예제 </h2>
	
	<div class="box-container" style="margin-top: 15px;">
	    <div id="lineContainer1" class="box"></div>

	</div>

	
</div>

</body>
</html>