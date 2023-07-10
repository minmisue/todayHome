<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/5.4.2/echarts.min.js"></script>

<script type="text/javascript">
$(function(){
	let url = "${pageContext.request.contextPath}/admin/chart";
	
	$.getJSON(url, function(data){
		// console.log(data);
		chartsDay(data);	
		chartsDayOfWeek(data);
		chartsMonth(data);	
	});
	
	function chartsDay(data) {
		let chartData = [];
		
		for(let item of data.days) {
			let s = parseInt(item.ORDERDATE.substring(5, 7))+'월 ';
			s += parseInt(item.ORDERDATE.substring(8))+'일';

			let obj = {value:item.TOTALMONEY, name:s};
			chartData.push(obj);
		}
		
		const chartDom = document.querySelector(".charts-day");
		let myChart = echarts.init(chartDom);
		let option;
		
		option = {
		  tooltip: {
		    trigger: 'item'
		  },
		  legend: {
		    top: '5%',
		    left: 'center'
		  },
		  series: [
		    {
		      name: '일별 판매현황',
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
		          fontSize: '40',
		          fontWeight: 'bold'
		        }
		      },
		      labelLine: {
		        show: false
		      },
		      data: chartData
		    }
		  ]
		};		
		
		option && myChart.setOption(option);
	}
	
	function chartsDayOfWeek(data) {
		let chartData = [];
		
		let m = new Date().getMonth()+1;
		let m2 = data.dayOfWeek.month.substring(4);

		let title = m !== 1 && m > m2 ? "전월 요일별 판매건수" : "이번달 요일별 판매건수"
		
		document.querySelector(".charts-dayOfWeek-title").innerHTML = title;
		
		chartData.push(data.dayOfWeek.SUN);
		chartData.push(data.dayOfWeek.MON);
		chartData.push(data.dayOfWeek.TUE);
		chartData.push(data.dayOfWeek.WED);
		chartData.push(data.dayOfWeek.THU);
		chartData.push(data.dayOfWeek.FRI);
		chartData.push(data.dayOfWeek.SAT);
		
		const chartDom = document.querySelector(".charts-dayOfWeek");
		let myChart = echarts.init(chartDom);
		let option;
		
		option = {
		  tooltip: {
		    trigger: 'item'
		  },
		  xAxis: {
		    type: 'category',
		    data: ['일', '월', '화', '수', '목', '금', '토']
		  },
		  yAxis: {
		    type: 'value'
		  },
		  series: [
		    {
		      data: chartData,
		      type: 'bar'
		    }
		  ]
		};
		
		option && myChart.setOption(option);
	}
	
	function chartsMonth(data) {
		let chartData = [];
		
		for(let item of data.months) {
			let s = parseInt(item.ORDERDATE.substring(4))+'월';
			let obj = {value:item.TOTALMONEY, name:s};
			chartData.push(obj);
		}
		
		const chartDom = document.querySelector(".charts-month");
		let myChart = echarts.init(chartDom);
		let option;
		
		option = {
		  tooltip: {
		    trigger: 'item'
		  },
		  legend: {
		    top: '5%',
		    left: 'center'
		  },
		  series: [
		    {
		      name: '월별 판매현황',
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
		          fontSize: '40',
		          fontWeight: 'bold'
		        }
		      },
		      labelLine: {
		        show: false
		      },
		      data: chartData
		    }
		  ]
		};
		
		option && myChart.setOption(option);
	}
	
});
</script>

<div class="container body-container">
    <div class="inner-page">
    
    	<div class="row g-1 mt-4 p-1">
			<div class="col p-2">
				<div class="fs-6 fw-semibold mb-2"><i class="bi bi-chevron-right"></i> 오늘 판매 현황</div>
				<div class="border rounded p-5 text-center">
					<div class="fs-5 mb-2">총 판매 건수 : 
						<span class="product-totalAmount fw-semibold text-primary">${today.COUNT}</span>
					</div>
					<div class="fs-5">총 판매 금액 : 
						<span class="product-totalAmount fw-semibold text-danger"><fmt:formatNumber value="${today.TOTAL}"/></span>원
					</div>
				</div>
			</div>
			
			<div class="col p-2">
				<div class="fs-6 fw-semibold mb-2"><i class="bi bi-chevron-right"></i> 이번달 판매 현황</div>
				<div class="border rounded p-5 text-center">
					<div class="fs-5 mb-2">총 판매 건수 : 
						<span class="product-totalAmount fw-semibold text-primary">${thisMonth.COUNT}</span>
					</div>
					<div class="fs-5">총 판매 금액 : 
						<span class="product-totalAmount fw-semibold text-danger"><fmt:formatNumber value="${thisMonth.TOTAL}"/></span>원
					</div>
				</div>
			</div>
    	
			<div class="col p-2">
				<div class="fs-6 fw-semibold mb-2"><i class="bi bi-chevron-right"></i> 전월 판매 현황</div>
				<div class="border rounded p-5 text-center">
					<div class="fs-5 mb-2">총 판매 건수 : 
						<span class="product-totalAmount fw-semibold text-primary">${previousMonth.COUNT}</span>
					</div>
					<div class="fs-5">총 판매 금액 : 
						<span class="product-totalAmount fw-semibold text-danger"><fmt:formatNumber value="${previousMonth.TOTAL}"/></span>원
					</div>
				</div>
			</div>
    	</div>
    
		<div class="row g-1 mt-4 p-1">
			<div class="col p-2">
				<div class="fs-6 fw-semibold mb-2"><i class="bi bi-chevron-right"></i> 최근 1주일 판매 현황</div>
				<div class="charts-day border rounded" style="height: 500px;"></div>
			</div>
			<div class="col p-2">
				<div class="fs-6 fw-semibold mb-2 "><i class="bi bi-chevron-right"></i> <label class="charts-dayOfWeek-title">전월 요일별 판매건수</label></div>
				<div class="charts-dayOfWeek border rounded" style="height: 500px;"></div>
			</div>
			<div class="col p-2">
				<div class="fs-6 fw-semibold mb-2"><i class="bi bi-chevron-right"></i> 최근 6개월 판매 현황</div>
				<div class="charts-month border rounded" style="height: 500px;"></div>
			</div>
		</div>		


    </div>
</div>