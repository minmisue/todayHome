<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <style>   
    h2 {
      color: #333;
      padding: 40px;
    }
    
    .dashboard-card {
      margin-bottom: 20px;
      padding: 20px;
      background-color: #f5f5f5;
      border-radius: 4px;
    }
    
    .dashboard-card-title {
      font-size: 20px;
      font-weight: bold;
    }
    
    .dashboard-card-description {
      color: #666;
    }
    
    .dashboard-card-link {
      display: block;
      margin-top: 10px;
      text-decoration: none;
      color: #007bff;
    }
  </style>
<div class="body-container">
    <div class="body-main">
  <div class="dashboard-card">
    <h3 class="dashboard-card-title">상품 관리</h3>
    <p class="dashboard-card-description">판매 중인 상품의 관리 및 카테고리를 수정하고 확인할 수 있습니다.</p>
    <a class="dashboard-card-link" href="${pageContext.request.contextPath}/admin/product/productList">상품 관리 페이지로 이동</a>
  </div>
  
  <div class="dashboard-card">
    <h3 class="dashboard-card-title">글 관리</h3>
    <p class="dashboard-card-description">이벤트 글 생성, 공지사항, 질문과 답변을 처리할 수 있습니다.</p>
    <a class="dashboard-card-link" href="${pageContext.request.contextPath}/admin/event/list">글 관리 페이지로 이동</a>
  </div>
  
  <div class="dashboard-card">
    <h3 class="dashboard-card-title">회원 관리</h3>
    <p class="dashboard-card-description">사용자 계정을 관리하고 회원 정보 및 판매자 정보를 확인할 수 있습니다.</p>
    <a class="dashboard-card-link" href="${pageContext.request.contextPath}/admin/members/membersList">회원 관리 페이지로 이동</a>
  </div>
    <div class="dashboard-card">
    <h3 class="dashboard-card-title">정산 관리</h3>
    <p class="dashboard-card-description">정산 기록을 확인할 수 있습니다.</p>
    <a class="dashboard-card-link" href="${pageContext.request.contextPath}/admin/adjustment/list">정산 관리 페이지로 이동</a>
  </div>
	</div>
</div>