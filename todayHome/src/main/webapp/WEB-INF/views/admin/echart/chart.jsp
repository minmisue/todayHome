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
	let url = "${pageContext.request.contextPath}/admin/echart/line1";
	
	$.getJSON(url, function(data){
		// console.log(data);
		
		var chartDom = document.getElementById('lineContainer1');
		var myChart = echarts.init(chartDom);
		var option;

		option = {
		  title: {
			text:'서울 월별 평균 기온'  
		  },
		  xAxis: {
		    type: 'category',
		    data: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
		  },
		  yAxis: {
		    type: 'value'
		  },
		  
		  // series: data.series
		  series: [
    		{
      			data: data.list,
      			type: 'line'
    		}
  		  ]		  
		};

		option && myChart.setOption(option);
		
	});
	
});

$(function(){
	let url = "${pageContext.request.contextPath}/admin/echart/line2";
	
	$.getJSON(url, function(data){
		// console.log(data);
		
		var chartDom = document.getElementById('lineContainer2');
		var myChart = echarts.init(chartDom);
		var option;

		option = {
		  title: {
			text: data.year + '년 월별 평균 기온'  
		  },
		  legend: {
			data: data.legend
		  },
		  tooltip: {
			trigger: 'axis'  
		  },
		  xAxis: {
		    type: 'category',
		    data: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
		  },
		  yAxis: {
		    type: 'value'
		  },
		  
		  series: data.series
		};

		option && myChart.setOption(option);
		
	});
	
});

$(function(){
	let url = "${pageContext.request.contextPath}/admin/echart/bar";

	$.getJSON(url, function(data){
		// console.log(data);
		
		var chartDom = document.getElementById('barContainer');
		var myChart = echarts.init(chartDom);
		var option;

		option = {
		  title: {
			text: data.year + '년 월별 평균 기온'  
		  },
		  legend: {
			data: data.legend
		  },
		  tooltip: {
			trigger: 'axis'  
		  },
		  xAxis: {
		    type: 'category',
		    data: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
		  },
		  yAxis: {
		    type: 'value'
		  },
		  
		  series: data.series
		};

		option && myChart.setOption(option);
		
	});
	
});

$(function(){
	let url = "${pageContext.request.contextPath}/admin/echart/pie";
	
	$.getJSON(url, function(data){
		// console.log(data);
		
		var chartDom = document.getElementById('pieContainer');
		var myChart = echarts.init(chartDom);
		var option;

		option = {
		  title: {
			  text: '접속자 수'
		  },
		  tooltip: {
		    trigger: 'item'
		  },
		  legend: {
		    top: '5%',
		    left: 'center'
		  },
		  series: [
		    {
		      name: '인원수',
		      type: 'pie',
		      radius: ['40%', '70%'],
		      avoidLabelOverlap: false,
		      itemStyle: {
		        borderRadius: 10,
		        borderColor: '#fff',
		        borderWidth: 2
		      },
		      label: {
		        show: false,
		        position: 'center'
		      },
		      emphasis: {
		        label: {
		          show: true,
		          fontSize: 40,
		          fontWeight: 'bold'
		        }
		      },
		      labelLine: {
		        show: false
		      },
		      data: data
		    }
		  ]
		};

		option && myChart.setOption(option);
		
	});
	
});

$(function(){
	let date = "2023-06-12"; // 매주 월요일만 가능
	let url = "${pageContext.request.contextPath}/admin/echart/covid?date="+date;
	
	$.getJSON(url, function(data){
		var chartDom = document.getElementById('covidContainer');
		var myChart = echarts.init(chartDom);
		var option;
		
		var arr = [];
		for(let item of data.list) {
			let obj = {value: item.incDec, name: item.gubun};
			arr.push(obj);
		}
		
		console.log(data);
		
		option = {
		  title: {
				text: data.stdDay + ' 전일 대비 확진자 증가수'
		  },
		  legend: {
		    top: 'bottom'
		  },
		  toolbox: {
		    show: true,
		    feature: {
		      mark: { show: true },
		      dataView: { show: true, readOnly: false },
		      restore: { show: true },
		      saveAsImage: { show: true }
		    }
		  },
		  series: [
		    {
		      name: 'Nightingale Chart',
		      type: 'pie',
		      radius: [50, 250],
		      center: ['50%', '50%'],
		      roseType: 'area',
		      itemStyle: {
		        borderRadius: 8
		      },
		      data: arr
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
	    <div id="lineContainer2" class="box"></div>
	</div>
	
	<div class="box-container">
	    <div id="barContainer" class="box"></div>
	    <div id="pieContainer" class="box"></div>
	</div>
	
	<div class="box-container">
	    <div id="covidContainer" class="box" style="height: 700px;"></div>
	</div>
	
</div>

</body>
</html>