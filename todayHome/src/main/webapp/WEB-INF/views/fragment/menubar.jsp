<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menubar.css">

<style>


    .menubar-container {

    }

</style>

<header>
    <div class="menubar-container">
        <div class="menubar-item-bundle" style="gap: 30px">
            <img class="logo" src="${pageContext.request.contextPath}/resources/picture/logo.png" onclick="location.href='${pageContext.request.contextPath}/home'">
            <div class="menubar-item" onclick="location.href='${pageContext.request.contextPath}/home'">커뮤니티</div>
            <div class="menubar-item" onclick="location.href='${pageContext.request.contextPath}/shop/home'">쇼핑</div>
        </div>

        <div class="menubar-item-bundle" style="gap: 18px">

            <%-- 통합 검색바 --%>
            <div class="search-input-bundle">
                <input class="search-box" type="text" placeholder="통합검색">
                <i class="bi bi-search"></i>
            </div>

            <%-- 로그인 --%>
            <i class="bi bi-bookmark menubar-icon"></i>
            <i class="bi bi-bell menubar-icon" onclick="location.href='${pageContext.request.contextPath}/mypage/alert'"></i>
            <%--            --%>

            <div style="position: relative">
                <i class="bi bi-cart menubar-icon" onclick="location.href='${pageContext.request.contextPath}/cart/list'"></i>

                <%-- 장바구니에 상품 없을시 표시 X --%>
                <div class="cart-badge">
                    <span id="cart-cnt">1</span>
                </div>
            </div>

            <%-- 로그인 --%>

            <div class="btn-group" role="group">
                <img class="menubar-profile-img dropdown-toggle" src="${pageContext.request.contextPath}/resources/picture/default-profile.png" onclick="location.href='#'"
                     data-bs-toggle="dropdown"
                     aria-expanded="false">

                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/mypage/all">마이페이지</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/production-review/write">나의 쇼핑</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/event/list">이벤트</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/community/picture/write">판매자 신청</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/community/picture/write">고객센터</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/community/picture/write">로그아웃</a></li>
                </ul>
            </div>
            <%----%>

<%--            로그인 아닐시--%>
<%--            <div class="menubar-text">로그인</div>--%>
<%--            <div class="menubar-text">회원가입</div>--%>
<%--            <div class="menubar-text">고객센터</div>--%>
<%--            --%>

            <div class="btn-group" role="group">
                <button type="button" class="btn dropdown-toggle write-btn" data-bs-toggle="dropdown"
                        aria-expanded="false">글쓰기
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/community/picture/write">사진/동영상 올리기</a></li>
                    <li><a class="dropdown-item" href="#">집들이 글쓰기</a></li>
<%--                    <li><a class="dropdown-item" href="#">노하우 글쓰기</a></li>--%>
                    <li><a class="dropdown-item" href="#">상품 리뷰 쓰기</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="sub-menubar-container">
        <div class="sub-menubar">
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/home'">홈</div>
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/community/follow/feed'">팔로잉</div>
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/community/picture/list'">사진</div>
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/community/house-warming/list'">집들이</div>
<%--            <div class="sub-item">노하우</div>--%>
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/event/list'">이벤트</div>
        </div>
    </div>

    <div class="sub-menubar-container">
        <div class="sub-menubar">
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/shop/home'">쇼핑홈</div>
            <div class="sub-item">카테고리</div>
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/shop/ranks'">베스트</div>
            <div class="sub-item" onclick="location.href='${pageContext.request.contextPath}/shop/today-deals'">오늘의딜</div>
<%--            <div class="sub-item">리퍼마켓</div>--%>
<%--            <div class="sub-item">오!굿즈</div>--%>
<%--            <div class="sub-item">빠른배송</div>--%>
<%--            <div class="sub-item">오!쇼룸</div>--%>
<%--            <div class="sub-item">오!프리미엄</div>--%>
<%--            <div class="sub-item">오!기획전</div>--%>
        </div>
    </div>
</header>
