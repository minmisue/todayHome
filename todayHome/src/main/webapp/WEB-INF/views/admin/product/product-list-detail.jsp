<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
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
  background: 	#F5F5F5;
  flex-direction: column;
      width: 100%; 
    padding: 20px; 
    box-sizing: border-box; 
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
  padding: 9px;
  text-align: center;
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
.page-navigation {
	clear: both;
	padding: 20px 0;
	text-align: center;
}
.paginate {
	clear: both;
	text-align: center;
	white-space: nowrap;
	font-size: 14px;	
}
.paginate a {
	border: 1px solid #ccc;
	color: #000;
	font-weight: 600;
	text-decoration: none;
	padding: 3px 7px;
	margin-left: 3px;
	vertical-align: middle;
}
.paginate a:hover, .paginate a:active {
	color: #6771ff;
}
.paginate span {
	border: 1px solid #e28d8d;
	color: #cb3536;
	font-weight: 600;
	padding: 3px 7px;
	margin-left: 3px;
	vertical-align: middle;
}
.paginate :first-child {
	margin-left: 0;
}
</style>
</head>
<body>
<script>
  function submitForm() {
		const f = document.searchForm;
		f.submit();
  }
</script>

<div class="body-container">
  <div class="body-title">
    <h2><i class="menu--icon fa-fw fa-solid fa-basket-shopping"></i> 상품상세 리스트 </h2>
  </div>
  <table class="delivery-table">
    <thead>
      <tr>
        <th>상품 아이디</th>
        <th>카테고리 아이디</th>
        <th>상품 이름</th>
        <th>내용</th>
        <th>등록날짜</th>
        <th>가격</th>
        <th>할인율</th>
        <th>배달비</th>
        <th>적립 포인트 퍼센트</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${product.productId}</td>
        <td>${product.productCategoryId}</td>
        <td>${product.productName}</td>
        <td>${product.content}</td>
        <td>${product.regDate}</td>
        <td>${product.price}</td>
        <td>${product.discountPercent}</td>
        <td>${product.deliveryCost}</td>
        <td>${product.reservingPointPercent}</td>
      </tr>
    </tbody>
  </table>
</div>
