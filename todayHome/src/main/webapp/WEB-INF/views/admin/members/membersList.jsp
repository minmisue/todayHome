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
 
    
  <form id="searchForm" name="searchForm" action="${pageContext.request.contextPath}/admin/members/membersList" method="post">
      <div class="filters">
  <div>
  <label for="memberRoleIdList">회원 상태:&nbsp;&nbsp;&nbsp;</label>
    <label for="">비회원</label>
	<input type="checkbox" name="memberRoleIdList" value="0" ${fn:contains(memberRoleIdList, '0') ? 'checked' : ''} >&nbsp;&nbsp;
    <label for="">회원</label>
	<input type="checkbox" name="memberRoleIdList" value="1" ${fn:contains(memberRoleIdList, '1') ? 'checked' : ''} >&nbsp;&nbsp;
    <label for="">관리자</label>
	<input type="checkbox" name="memberRoleIdList" value="2" ${fn:contains(memberRoleIdList, '2') ? 'checked' : ''}>&nbsp;&nbsp;
  </div>
      <hr>
      <div class="search" style="padding: 20px;">
        <label for="search-input">검색어:</label>
        <select id="search-option" name="condition">
          <option value="nickName" ${condition == "nickName" ? 'selected="selected"' : ''}>닉네임</option>
          <option value="email" ${condition == "email" ? 'selected="selected"' : ''}>이메일</option>       
        </select>
        <input type="text" id="search-input" name="keyword" value="${keyword}">
      
      </div>
      <div class="search" style="padding: 20px;">
      <label for="search-input">정렬:</label>
		<select id="search-option" name="sort">
		  <option value="desc" ${sort == 'DESC' ? 'selected="selected"' : ''}>가입일 최신순</option>
		  <option value="asc" ${sort == 'ASC' ? 'selected="selected"' : ''}>가입일 오래된순</option>
		</select>
        </div>
    <hr>
    <table class="delivery-table" style="background: white; padding: 20px;">
      <thead>
        <tr>
		  <th>회원 번호</th>
          <th>역할</th>
          <th>이메일</th>
          <th>이름</th>
          <th>전화번호</th>
          <th>우편번호</th>
          <th>주소</th>
          <th>상세주소</th>
          <th>닉네임</th>
          <th>비밀번호</th>
          <th>가입일짜</th>
        </tr>
      </thead>
      <c:forEach var="member" items="${adminMemberList}" varStatus="status">
        <tr>
          <td>${member.memberId}</td>
          <td>
	        <c:choose>
	          <c:when test="${member.memberRoleId == 0}">비회원</c:when>
	          <c:when test="${member.memberRoleId == 1}">회원</c:when>
	          <c:when test="${member.memberRoleId == 2}">관리자</c:when>
	        </c:choose>
	      </td>
          <td>${member.email}</td>
          <td>${member.name}</td>
          <td>${member.tel}</td>
          <td>${member.postNum}</td>
          <td>${member.address1}</td>
          <td>${member.address2}</td>
          <td>${member.nickName}</td>
          <td>${member.password}</td>
          <td>${member.regDate}</td>                      
          <td><a style=" text-decoration: none; color: black;" href="${pageContext.request.contextPath}/admin/members/sellerDetail/${seller.sellerId}">${seller.status == 0 ? '대기' : seller.status == 1 ? '승인' : seller.status == 2 ? '거절' : seller.status == 3 ? '정지' : ''}</a></td>
        </tr>
      </c:forEach>
    </table>
        <div class="button-container" style="display: flex; justify-content: center;">
          <button id="reset-button" class="styled-button" type="button" onclick="location.href='${pageContext.request.contextPath}/admin/members/membersList';">초기화</button>
          <button id="search-button" class="styled-button" type="button" onclick="submitForm()">검색</button>
        </div>
    <div class="page-navigation">   
       ${paging}
    </div>
  </div>
  </form>
</div>
