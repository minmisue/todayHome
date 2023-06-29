<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
.body-main {
	max-width: 930px;
}
h1 {
  text-align: center;
}

.search-container {
  margin-bottom: 20px;
}

h2 {
  margin-bottom: 10px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="date"] {
  width: 20%;
  padding: 5px;
  font-size: 16px;
}

.result-container table {
  width: 100%;
  border-collapse: collapse;
}

.result-container th, .result-container td {
  padding: 10px;
  text-align: center;
  border-bottom: 1px solid #ccc;
}

.result-container th {
  background-color: #f5f5f5;
}
</style>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tabs.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" type="text/css">

<script type="text/javascript">
function ajaxFun(url, method, query, dataType, fn) {
	$.ajax({
		type:method,
		url:url,
		data:query,
		dataType:dataType,
		success:function(data){
			fn(data);
		},
		beforeSend : function(jqXHR) {
			jqXHR.setRequestHeader("AJAX", true);
		},
		error : function(jqXHR) {
			if (jqXHR.status === 403) {
				location.href="${pageContext.request.contextPath}/seller/login";
				return false;
			} else if(jqXHR.status === 400) {
				alert("요청 처리가 실패했습니다.");
				return false;
			}
			console.log(jqXHR.responseText);
		}
	});
}
function search() {
    // 검색 버튼 클릭 시 호출되는 함수

    // 선택한 날짜 값을 가져오기
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    // 검색 결과를 갱신하기 위해 AJAX 요청 등의 로직을 추가해주세요.
    
    // 이 예시에서는 단순히 테이블의 모든 행을 제거한 후, 새로운 검색 결과 행을 추가하는 방식으로 구현합니다.
    var table = document.getElementById("resultTable");
    var rowCount = table.rows.length;

    // 테이블의 기존 검색 결과 행 모두 제거
    for (var i = rowCount - 1; i > 0; i--) {
        table.deleteRow(i);
    }

    
}
</script>

	<div class="body-container">
		<div class="body-title">
		<h1>정산 현황</h1>
		<div>
  		정산 지급 예정일:
  		</div>
  	<div>
  		예상 금액:
  	</div>
  
  </div>
  
  <div class="search-container">
    <h2>검색조건</h2>
    <label for="date">날짜</label>
    <div>
      <p>
      	<input type="date" id="startdate">
       		~ 
       	<input type="date" id="enddate">
       	
       	<button type="button" id="search">검색</button>
       </p>
  	</div>
  </div>
  
  <div class="result-container">
    <h2>검색결과</h2>
    <table>
      <tr>
        <th>정산일</th>
        <th>구매확정기간</th>
        <th>지급상태</th>
        <th>최종지급액</th>
      </tr>
      <tr>
        <td>2023-06-01</td>
        <td>2023-05-01</td>
        <td>지급 완료</td>
        <td>100,000원</td>
      </tr>
     <tr>
		<th colspan="3">총 최종 지급액 </th>
		<th>10,000원</th>     
     </tr>
    </table>
  </div>
  </div>

