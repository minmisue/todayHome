<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
</style>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tabs.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" type="text/css">
<script>
function submitAdjustment() {
	  var inputAmount = parseInt(document.getElementById("amountInput").value);
	  var accumulatedAmount = parseInt(document.getElementById("seller").textContent);
	  
	  if (inputAmount > accumulatedAmount || inputAmount === 0) {
	    alert("정산받을 금액을 다시 확인해주세요.");
	    return;
	  }
	  
	  document.getElementById("inputAmount").value = inputAmount;
	  document.getElementById("adjustmentForm").submit();
	}
</script>

<div class="body-container">
  <div class="body-title">
    <h2><i class="menu--icon  fa-fw fa-solid fa-won-sign"></i> 정산 받기</h2>
  </div>
  <div class="body-main">
    <div>
      <label>정산 예정 금액:</label>
      <span id="seller">${seller.accumulatedAmount}</span>
    </div>

    <div>
      <label>금액 입력:</label>
      <form id="adjustmentForm"  method="post">
        <input type="number" id="amountInput" name="inputAmount" step="10000" min="0" required>
        <button type="button" onclick="submitAdjustment()">정산하기</button>
        <input type="hidden" name="inputAmount" id="inputAmount" value="">
      </form> 
    </div>
  </div>
</div>