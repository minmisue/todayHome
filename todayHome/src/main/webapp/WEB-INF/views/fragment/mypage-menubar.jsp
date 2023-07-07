<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.menubar-profile-img {
	width: 40px;
	height: 40px;
	border-radius: 50%;
}

.menubar-profile-img:hover {
	cursor: pointer;
	border: 1px solid #35C5F0;;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage-menubar.css">

<header>
	<div class="menubar-container">
		<div class="menubar-item-bundle" style="gap: 30px">
			<img class="logo"
				src="${pageContext.request.contextPath}/resources/picture/logo.png"
				onclick="location.href='${pageContext.request.contextPath}/home'">
			<div class="menubar-item"
				onclick="location.href='${pageContext.request.contextPath}/home'">커뮤니티</div>
			<div class="menubar-item"
				onclick="location.href='${pageContext.request.contextPath}/shop/home'">쇼핑</div>
		</div>

		<div class="menubar-item-bundle" style="gap: 18px">
			<div class="search-input-bundle">
				<input class="search-box" type="text" placeholder="통합검색"> <i
					class="bi bi-search"></i>
			</div>

			<%-- 로그인 --%>
			<i class="bi bi-bookmark menubar-icon"></i> <i
				class="bi bi-bell menubar-icon"></i>
			<%--            --%>
			<div style="position: relative">
				 <i class="bi bi-bell menubar-icon"></i>
				<c:if
					test="${sessionScope.notificationCount != 0 && not empty sessionScope.sessionInfo}">
					<div class="cart-badge">
						<span id="cart-cnt">${sessionScope.notificationCount}</span>
					</div>
				</c:if>

			</div>
			<div style="position: relative">
				<i class="bi bi-cart menubar-icon"></i>
				<c:if
					test="${sessionScope.dataCartCount != 0 && not empty sessionScope.sessionInfo}">
					<div class="cart-badge">
						<span id="cart-cnt">${sessionScope.dataCartCount}</span>
					</div>
				</c:if>

			</div>

			<%-- 로그인 --%>
			<img class="menubar-profile-img"
				src="${pageContext.request.contextPath}/resources/picture/default-profile.png"
				onclick="location.href='#'">
			<%----%>

			<%--            로그인 아닐시--%>
			<%--            <div class="menubar-text">로그인</div>--%>
			<%--            <div class="menubar-text">회원가입</div>--%>
			<%--            <div class="menubar-text">고객센터</div>--%>
			<%--            --%>

			<div class="btn-group" role="group">
				<button type="button" class="btn dropdown-toggle write-btn"
					data-bs-toggle="dropdown" aria-expanded="false">글쓰기</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">사진/동영상 올리기</a></li>
					<li><a class="dropdown-item" href="#">집들이 글쓰기</a></li>
					<li><a class="dropdown-item" href="#">노하우 글쓰기</a></li>
					<li><a class="dropdown-item" href="#">상품 리뷰 쓰기</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="sub-menubar-container">
		<div class="sub-menubar">
			<div class="sub-item"
				onclick="location.href='${pageContext.request.contextPath}/'">리뷰쓰기</div>
			<div class="sub-item"
				onclick="location.href='${pageContext.request.contextPath}/'">내가작성한리뷰</div>
		</div>
	</div>


</header>

<script>
	// $(function () {
	//     console.log()
	//     let currentMenu = $('.menubar-item-bundle').children()[2]
	//     currentMenu.addClass('selected-item');
	// });
</script>