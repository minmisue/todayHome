<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<style type="text/css">

p{
	font-weight: bold;
}


.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  text-align: center;
}

.status-box {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.status-item {
  width: 100%;
  height: 100px;
  padding: 10px 15px;
  border: 1px solid lightgray;
  border-radius: 5px;
  margin-right: 5px;
  cursor: pointer;
}

.status-item:hover {
  border-color: blue;
}
.status-item-content{
 font-weight: bold;
}
.filters {
  border: 1px solid lightgray;
  border-radius: 5px;
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  background: gainsboro;
  flex-direction: column;
      width: 100%; /* 크기 조정 */
    padding: 20px; /* 크기 조정 */
    box-sizing: border-box; /* 크기 조정 */
}

.date-range {
	padding:20px;
  display: flex;
  align-items: center;
  border-radius: 5px;
}

.date-range label {
  margin-right: 5px;
  border-radius: 5px;
}

.status-filter label {
  margin-right: 5px;
  border-radius: 5px;
}

.search input[type="text"],
.search button {
  margin-left: 5px;
}
input[type="checkbox"] {
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  width: 16px;
  height: 16px;
  border: 1px solid #000;
  border-radius: 50%;
  outline: none;
  cursor: pointer;
  background-color: #fff;
}

input[type="checkbox"]:checked {
  background-color: #778899;
  }
  
  .delivery-table {
  background: white;
  padding: 20px;
  border-collapse: collapse;
  width: 100%;
}



.delivery-table th,
.delivery-table td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid lightgray;
}

.delivery-table th {
  font-weight: bold;
}

.delivery-table tbody tr:last-child td {
  border-bottom: none;
}

.button-container  button{
    width: 10%;
    padding: 10px;
    border-radius: 5px;
    margin: 20px;
}


.styled-button button{
  margin: 0 10px;
  padding: 10px 20px;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}

.styled-button:hover {
  border: 2px solid blue;
  color: blue;
}
</style>
</head>
<body>

<div class="body-container">
    <div class="body-title">
		<h2><i class="menu--icon  fa-fw fa-solid fa-truck-fast"></i> 배송 관리 </h2>
    </div>
    
    <p>배송처리를 진행 해주세요</p>
    <div class="body-main">
    	    <div class="status-box">
      <div class="status-item active">결제 완료
      	<div class="status-item-content"> 0 </div>
     	</div>
      <div class="status-item">상품 준비 중
      	<div class="status-item-content"> 0 </div>
     	</div>
      <div class="status-item">배송 지시
      	<div class="status-item-content"> 0 </div>    
      </div>
      <div class="status-item">배송 중
        <div class="status-item-content"> 0 </div>
     	</div>
      <div class="status-item">배송 완료
      	<div class="status-item-content"> 0 </div>
      	</div>
      </div>
    </div>

<div class="filters">
  <div class="date-range">
    <label for="start-date">기간:</label>
    <input style="width: 20%;" type="date" id="start-date">
    <label for="end-date">-</label>
    <input style="width: 20%;"  type="date" id="end-date">
  </div>
  <hr>
<div class="status-filter" style="padding:20px;">
  <label for="status">배송 상태:</label>
  <div>
    <input type="checkbox" id="payment" value="all">
    <label for="all">전체</label>
    <input type="checkbox" id="payment" value="payment">
    <label for="payment">결제 완료</label>
    <input type="checkbox" id="preparation" value="preparation">
    <label for="preparation">상품 준비 중</label>
    <input type="checkbox" id="dispatch" value="dispatch">
    <label for="dispatch">배송 지시</label>
    <input type="checkbox" id="shipping" value="shipping">
    <label for="shipping">배송 중</label>
    <input type="checkbox" id="delivered" value="delivered">
    <label for="delivered">배송 완료</label>
  </div>
</div>
  <hr>
  <div class="search" style="padding: 20px;">
    <label for="search-input">주문자명:</label>
    <input type="text" id="search-input">
  </div>
  <hr>
    <table class="delivery-table" style="background: white; padding: 20px;">
      <thead>
        <tr>
          <th>주문자명</th>
          <th>주문일자</th>
          <th>상품명</th>
          <th>배송 상태</th>
        </tr>
      </thead>
      <tbody style="padding: 20px; text-align: center;">
        <tr>
          <td>홍길동</td>
          <td>2023-06-29</td>
          <td>상품 A</td>
          <td>결제 완료</td>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>2023-06-29</td>
          <td>상품 A</td>
          <td>결제 완료</td>
        </tr>
      </tbody>
    </table>
<div class="button-container" style="display: flex; justify-content: center;">
  <button id="reset-button" class="styled-button" >초기화</button>
  <button id="search-button" class="styled-button">검색</button>
</div>
  </div>  
  </div>
  </body>
  </html>