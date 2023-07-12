<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
    }
    
    h2 {
      color: #333;
      padding: 40px;
    }
    
    .onboarding-progress {
      margin-bottom: 20px;
    }
    
    .onboarding-progress ul {
      list-style: none;
      padding: 0;
      display: flex;
    }
    
    .onboarding-progress li {
      margin-right: 10px;
      padding: 5px 10px;
      background-color: #eee;
      border-radius: 4px;
      color: #333;
    }
    
    .dashboard-card {
    display: flex;
    	width:40%;
      margin-bottom: 20px;
      padding: 20px;
      background-color: #f5f5f5;
      border-radius: 4px;
    }
    
    .product-registration-title {
      font-size: 20px;
      font-weight: bold;
    }
    
    .product-registration-description {
      color: #666;
      padding: 10px;
    }
    
    .product-registration-controls button {
      margin-right: 10px;
      padding: 10px 20px;
      background-color: #35C5F0;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    
    .seller-card strong {
      font-size: 20px;
      font-weight: bold;
    }
    
    .seller-card p {
      margin-bottom: 10px;
	padding: 10px;      
    }
    
    .seller-card em {
      margin-top: 10px;
      display: inline-block;
      position: relative;
    }
    
    .seller-card em span {
      display: none;
      position: absolute;
      background-color: #f5f5f5;
      border: 1px solid #ccc;
      padding: 10px;
      border-radius: 4px;
      bottom: -5px;
      left: 50%;
      transform: translateX(-50%);
      width: 250px;
    }
    
    .seller-card em:hover span {
      display: block;
    }
    
    .seller-card em span button {
      float: right;
      background-color: transparent;
      border: none;
      color: #333;
      cursor: pointer;
    }
    
    .seller-card button {
      padding: 10px 20px;
      background-color: #35C5F0;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
  </style>
  <div class="body-container">
    <div class="body-main">
      <h2>오늘의집 판매자 가입을 축하합니다!</h2>
<div style="display: flex;">
      <div class="dashboard-card" style="margin: 20px;">
        <div class="seller-card product-entry">
          <div class="product-registration-contents">
            <p class="product-registration-title">상품을 등록해 주세요.</p>
            <p class="product-registration-description">지금 바로, 판매 상품을 등록해 보세요.</p>
          </div>
          <div class="product-registration-controls">
            <button type="button" title="상품등록 하기" onclick="location.href='${pageContext.request.contextPath}/seller/product'">상품등록 하기</button>
          </div>
        </div>
      </div>
      
      <div class="dashboard-card" style="margin: 20px;">
        <div class="seller-card product-entry">
          <div class="product-registration-contents">
            <p class="product-registration-title">지금 바로 정산 받으세요.</p>
            <p class="product-registration-description">언제든지 정산을 받을 수 있습니다.</p>
          </div>
          <div class="product-registration-controls">
            <button type="button" title="정산 받기" onclick="location.href='${pageContext.request.contextPath}/seller/adjustment/money''">정산 받기</button>
          </div>
        </div>
      </div>
   </div> 
   <div style="display: flex;">
      <div class="dashboard-card" style="margin: 20px;">
        <div class="seller-card product-entry">
          <div class="product-registration-contents">
            <p class="product-registration-title">주문을 관리하세요.</p>
            <p class="product-registration-description">주문 리스트를 보고 주문 관리를 시작해 보세요.</p>
          </div>
          <div class="product-registration-controls">
            <button type="button" title="주문 관리" onclick="location.href='${pageContext.request.contextPath}/seller/delivery/ordermanage'">주문 관리하기</button>
          </div>
        </div>
      </div>
      
      <div class="dashboard-card" style="margin: 20px;">
        <div class="seller-card product-entry">
          <div class="product-registration-contents">
            <p class="product-registration-title">리뷰를 관리하세요.</p>
            <p class="product-registration-description">구매자들의 리뷰를 확인해 보세요.</p>
          </div>
          <div class="product-registration-controls">
            <button type="button" title="리뷰 관리" onclick="location.href='${pageContext.request.contextPath}/seller/review/reviewList'">리뷰 관리</button>
          </div>
        </div>
      </div>
   </div>  
    </div>
  </div>