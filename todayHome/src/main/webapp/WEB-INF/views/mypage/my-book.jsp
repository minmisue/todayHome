<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
/* ----------------------- */
/* 스크랩북 */
/* ----------------------- */

.scrapBook {
  width: 1200px;
}

.scrapBook .scrapBook-user {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.scrapBook .scrapBook-user img {
  width: 86px;
  height: 86px;
}

.scrapBook .scrapBook-user span {
  font-size: 20px;
  font-weight: 600;
  margin-top: 8px;
}

.scrapBook .scrapBook-menu {
  text-align: center;
  padding: 0 16px;
  margin-bottom: 56px;
}

.scrapBook .scrapBook-menu .menu {
  display: inline-block;
  padding: 12px 6px;
  font-size: 16px;
  font-weight: 600;
  color: #35C5F0;
  box-sizing: border-box;
}

.scrapBook .scrapBook-content {
  display: flex;
  justify-content: center;
  align-items: flex-start;
  flex-wrap: wrap;
  padding: 0;
  margin: 0;
}

/* NOTE: 콘텐츠가 없을 때 CSS */
.scrapBook .scrapBook-content.show .no-content {
  display: none;
}

.scrapBook .scrapBook-content .no-content {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: 380px;
  font-size: 20px;
  text-align: center;
}

.scrapBook .scrapBook-content .no-content p:last-child {
  color: #999999;
  font-size: 14px;
}

/* NOTE: 콘텐츠가 있을 때 CSS */
.scrapBook .scrapBook-content.show {
  justify-content: flex-start;
}

.scrapBook .scrapBook-content.show .scrapBook {
  display: none;
}

.scrapBook .scrapBook-content li {
  width: calc(25% - 20px);
  margin: 0 10px 20px;
  list-style: none;
}

.scrapBook .scrapBook-content li .scrap-image {
  aspect-ratio: 1 / 1;
  border-radius: 5px;
  overflow: hidden;
}

.scrapBook .scrapBook-content li .scrap-image img {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.scrapBook .scrapBook-content li .scrap-content {
  display: flex;
  justify-content: center;
  align-items: flex-start;
  flex-direction: column;
  gap: 3px;
}

.scrapBook .scrapBook-content li .scrap-content .scrap-brand {
  font-size: 11px;
  color: #757575;
  word-break: break-all;
  line-height: 13px;
}

.scrapBook .scrapBook-content li .scrap-content .scrap-name {
  margin-top: 5px;
  word-break: break-all;
  font-size: 13px;
  font-weight: 600;
  line-height: 17px;
  color: #000000;
  overflow: hidden;
  text-overflow: ellipsis;
  word-wrap: break-word;
}

.scrapBook .scrapBook-content li .scrap-content .price-wrapper {
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.scrapBook .scrapBook-content li .scrap-content .price-wrapper .rate {
  color: #35c5f0;
  margin-right: 4px;
}

.scrapBook .scrapBook-content li .scrap-content .price-wrapper .price {
  color: #000;
  margin-right: 4px;
}

.scrapBook .scrapBook-content li .scrap-content .rating-wrapper {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  margin: 0;
  font-size: 13px;
  font-weight: 600;
}

.scrapBook .scrapBook-content li .scrap-content .rating-wrapper svg {
  color: #35c5f0;
  width: 1.1em;
  height: 1.1em;
  margin-right: 1px;
  vertical-align: -2px;
}

.scrapBook .scrapBook-content li .scrap-content .rating-wrapper strong {
  margin-right: 2px;
  color: #424242;
  font-weight: 600;
}
	</style>
</head>
<body>
<script>
    $(function () {
    	// 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
		// 두번째 파라미터에 null 입력시 메뉴바 숨김
        selectCurrentMenu(0, null);

        // 마이페이지일때 메뉴
		// 메인메뉴, 서브메뉴 숫자 입력
		// 첫번째 파라미터에 0 입력시 숨김
		selectMyPage(1,4);
    });
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
		<section class="scrapBook">
		    <h2>스크랩북</h2>
		    <div class="scrapBook-user">
		      <img src="${pageContext.request.contextPath}/resources/picture/member/default-profile.png" alt="user-image">
		      <span>${member.nickName}</span>
		    </div>
		
		    <div class="scrapBook-menu">
		      <strong class="menu menu-1">모두(0)</strong>
		      <strong class="menu menu-2">상품(0)</strong>
		    </div>
		    
		    <ul class="scrapBook-content">
		      <!-- 콘텐츠가 없을 때 UI -->
		      <!-- <div class="no-content">
		        <p>아직 스크랩한<br/>콘텐츠가 없습니다.</p>
		        <p>마음에 드는 콘텐츠를 발견하면 스크랩해보세요.</p>
		      </div> -->
		
		      <!-- 콘텐츠가 있을 때 UI -->
		      <c:forEach var="productForList" items="${productForList}" varStatus="status">
		      <li class="scrapBook">
		        <div class="scrap-image">
		          <img src="${pageContext.request.contextPath}resources/picture/product/${productForList.saveName}" alt="scrap image">
		        </div>
		        <div class="scrap-content">
		          <span class="scrap-brand">${productForList.brandName}</span>
		          <strong class="scrap-name">${productForList.productName }</strong>
		          <div class="price-wrapper">
		            <span class="rate">55%</span>
		            <span class="price">${productForList.price}</span>
		          </div>
		          <p class="rating-wrapper">
		            <svg class="icon" width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path fill="currentColor" fill-rule="evenodd" d="M12 19.72l-5.677 2.405c-.76.322-1.318-.094-1.247-.906l.533-6.142-4.042-4.656c-.54-.624-.317-1.283.477-1.467l6.006-1.39L11.23 2.28c.426-.707 1.122-.699 1.542 0l3.179 5.282 6.006 1.391c.805.187 1.011.851.477 1.467l-4.042 4.656.533 6.142c.072.822-.497 1.224-1.247.906L12 19.72z"></path></svg>
		            <strong>4.6</strong>
		            리뷰 2,406
		          </p>
		        </div>
		      </li>
		      </c:forEach>
		    </ul>
		  </section>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
