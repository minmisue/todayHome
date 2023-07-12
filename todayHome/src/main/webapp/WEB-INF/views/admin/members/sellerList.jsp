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
<body >
<script>
  function submitForm() {
		const f = document.searchForm;
		f.submit();
  }
  
</script>

<div class="body-container">
  <div class="body-title">
    <h2><i class="menu--icon  fa-fw fa-solid fa-user-group"></i> 판매자 리스트 </h2>
  </div>
 
    
  <form id="searchForm" name="searchForm" action="${pageContext.request.contextPath}/admin/members/sellerList" method="post">
    <div class="filters">
  <div>
  <label for="list">회원 상태:&nbsp;&nbsp;&nbsp;</label>
    <label for="">대기</label>
	<input type="checkbox" name="list" value="0" ${fn:contains(list, '0') ? 'checked' : ''} >&nbsp;&nbsp;
    <label for="">승인</label>
	<input type="checkbox" name="list" value="1" ${fn:contains(list, '1') ? 'checked' : ''} >&nbsp;&nbsp;
    <label for="">거절</label>
	<input type="checkbox" name="list" value="2" ${fn:contains(list, '2') ? 'checked' : ''}>&nbsp;&nbsp;
    <label for="">정지</label>
	<input type="checkbox" name="list" value="3" ${fn:contains(list, '3') ? 'checked' : ''}>
  </div>
      <hr>
      <div class="search" style="padding: 20px;">
        <label for="search-input">검색어:</label>
        <select id="search-option" name="condition">
          <option value="sellerName" ${condition == "sellerName" ? 'selected="selected"' : ''}>판매자 이름</option>
          <option value="brandName" ${condition == "brandName" ? 'selected="selected"' : ''}>브랜드 이름</option>
          <option value="businessNumber" ${condition == "businessNumber" ? 'selected="selected"' : ''}>사업자 번호</option>
          <option value="representativeName" ${condition == "representativeName" ? 'selected="selected"' : ''}>회사 이름</option>       
        </select>
        <input type="text" id="search-input" name="keyword" value="${keyword}">
      <hr>
      </div>
      <div class="search" style="padding: 20px;">
      <label for="search-input">정렬:</label>
		<select id="search-option" name="orderBy">
		  <option value="amount_DESC" ${orderBy == 'amount_DESC' ? 'selected="selected"' : ''}>정산금액 높은순</option>
		  <option value="amount_ASC" ${orderBy == 'amount_ASC' ? 'selected="selected"' : ''}>정산금액 낮은순</option>
		  <option value="regDate_DESC" ${orderBy == 'regDate_DESC' ? 'selected="selected"' : ''}>가입일 최신순</option>
		  <option value="regDATE_ASC" ${orderBy == 'regDATE_ASC' ? 'selected="selected"' : ''}>가입일 오래된순</option>
		</select>
        </div>
    <hr>
    <table class="delivery-table" style="background: white; padding: 20px;">
      <thead>
        <tr>
		  <th>판매자 번호</th>
          <th>회사 이름</th>
          <th>판매자 이름</th>
          <th>브랜드 이름</th>
          <th>사업자 번호</th>
          <th>가입 날짜</th>
          <th>전화번호</th>
          <th>이메일</th>
          <th>정산가능 금액</th>
          <th>상태</th>
        </tr>
      </thead>
      <c:forEach var="seller" items="${adminSellerList}" varStatus="status">
        <tr>
          <td>${seller.sellerId}</td>
          <td>${seller.representativeName}</td>
          <td>${seller.sellerName}</td>
          <td>${seller.brandName}</td>
          <td>${seller.businessNumber}</td>
          <td>${seller.regDate}</td>
          <td>${seller.tel}</td>
          <td>${seller.email}</td>
          <td>${seller.accumulatedAmount}</td>
          <td><a style=" text-decoration: none; color: black;" href="${pageContext.request.contextPath}/admin/members/sellerDetail/${seller.sellerId}">${seller.status == 0 ? '대기' : seller.status == 1 ? '승인' : seller.status == 2 ? '거절' : seller.status == 3 ? '정지' : ''}</a></td>
        </tr>
      </c:forEach>
    </table>
        <div class="button-container" style="display: flex; justify-content: center;">
          <button id="reset-button" class="styled-button" type="button" onclick="location.href='${pageContext.request.contextPath}/admin/members/sellerList';">초기화</button>
          <button id="search-button" class="styled-button" type="button" onclick="submitForm()">검색</button>
        </div>
    <div class="page-navigation">   
       ${paging}
    </div>
  </div>
  </form>
</div>
