<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>

    table {
      border-collapse: collapse;
      width: 100%;
    }

    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

</style>

<div class="body-container">
    <div class="body-title">
		<h2><i class="menu--icon  fa-fw fa-solid fa-truck-fast"></i> 주문 조회 </h2>
    </div>
    
    <div class="body-main">
  <form id="orderForm">
    <label for="orderNumber">주문 번호:</label>
    <input type="text" id="orderNumber" name="orderNumber">
    <button type="submit">주문 조회</button>
  </form>
	<div id="orderResult"></div>
</div>
</div>

<script>
    const orderForm = document.getElementById('orderForm');
    const orderResult = document.getElementById('orderResult');

    orderForm.addEventListener('submit', (e) => {
      e.preventDefault();
       
      const orderItemId = document.getElementById('orderItemId').value;

      const order = {
    	orderItemId: '123456',
        orderDate: '2023-07-02',
        orderStatus: '배송 중'
      };

      orderResult.innerHTML = `
        <h2>주문 정보</h2>
        <table>
          <tr>
            <th>주문 번호</th>
            <th>주문 일자</th>
            <th>주문 상태</th>
          </tr>
          <tr>
            <td>${order.orderItemId}</td>
            <td>${order.orderDate}</td>
            <td>${order.orderStatus}</td>
          </tr>
        </table>
      `;
    });
  </script>
