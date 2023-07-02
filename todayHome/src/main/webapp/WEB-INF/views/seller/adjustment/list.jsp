<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    type: method,
    url: url,
    data: query,
    dataType: dataType,
    success: function(data) {
      fn(data);
    },
    beforeSend: function(jqXHR) {
      jqXHR.setRequestHeader("AJAX", true);
    },
    error: function(jqXHR) {
      if (jqXHR.status === 403) {
        location.href = "${pageContext.request.contextPath}/seller/login";
        return false;
      } else if (jqXHR.status === 400) {
        alert("요청 처리가 실패했습니다.");
        return false;
      }
      console.log(jqXHR.responseText);
    }
  });
}
function search() {
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    var table = document.getElementById("resultTable");
    var rows = table.getElementsByTagName("tr");

    var totalAmount = 0; 

    for (var i = 1; i < rows.length - 1; i++) { 
      var row = rows[i];
      var adjustmentDate = row.cells[0].innerHTML;
      var amount = parseInt(row.cells[1].innerHTML.replace(/[^0-9]+/g, ''));
      
      if ((!startDate || !endDate) || (adjustmentDate >= startDate && adjustmentDate <= endDate)) {
        row.style.display = ""; 
        totalAmount += amount; 
      } else {
        row.style.display = "none"; 
      }
    }

    var totalAmountCell = document.getElementById("totalAmountCell");
    totalAmountCell.innerHTML = totalAmount.toLocaleString() + "원";
  }

  window.onload = search;
</script>

<div class="body-container">
  <div class="body-title">
    <h1>정산 현황</h1>
  </div>
  
  <div class="search-container">
    <h2>검색조건</h2>
    <label for="date">날짜</label>
    <div>
      <p>
        <input type="date" id="startDate">
        ~
        <input type="date" id="endDate">
        
        <button type="button" id="search" onclick="search()">검색</button>
      </p>
    </div>
  </div>
  
  <div class="result-container">
    <h2>검색결과</h2>
    <table id="resultTable">
      <tr>
        <th>정산일</th>
        <th>최종지급액</th>
      </tr>
      <c:forEach var="sellerAdjustment" items="${sellerAdjustmentList}">
        <tr>
          <td>${sellerAdjustment.adjustmentDate}</td>
          <td>${sellerAdjustment.amount}원</td> 
        </tr>
      </c:forEach>
      <c:if test="${empty sellerAdjustmentList}">
        <tr>
          <td colspan="2">정보가 없습니다.</td>
        </tr>
        <tr id="totalAmountRow">
          <th>총 최종 지급액</th>
          <th id="totalAmountCell">0원</th>
        </tr>
      </c:if>
      <c:if test="${not empty sellerAdjustmentList}">
        <tr id="totalAmountRow">
          <th>총 최종 지급액</th>
          <th id="totalAmountCell"></th>
        </tr>
      </c:if>
    </table>
  </div>
</div>


