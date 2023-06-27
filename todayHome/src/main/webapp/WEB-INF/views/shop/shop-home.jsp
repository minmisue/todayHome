<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
        .shop-banner {
            height: 380px;
        }
		
		.shop-banner:hover {
            cursor: pointer;
        }

        .shop-banner img {
            height: 100%;
            width: 100%;
            object-fit: cover;
        }

        .main-icon-container {
            display: grid;
            grid-template-columns: repeat(10, 1fr);
        }

        .icon-img, .icon-text:hover {
            cursor: pointer;
        }

        .icon-img {
            margin: 0 auto;
            width: 65px;
            height: 65px;
            object-fit: cover;
            border-radius: 30%;
        }

        .icon-text {
            margin-top: 8px;
        }

        .shop-main-label {
            font-size: 20px;
            font-weight: 700;
            margin-bottom: 20px;
        }

        .grid-col-4 {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 15px;
        }

        .today-deal-brand-name {
            margin-top: 10px;
            font-size: 13px;
            color: #848C93;
        }

        .today-deal-product-name {
            margin-top: 5px;
            font-size: 13px;
            font-weight: 400;
            line-height: 17px;
            max-height: 34px;
            color: #424242;
        }

        .today-deal-sale-percent {
            font-size: 17px;
            line-height: 23px;
            font-weight: 700;
            color: #65C2EC;
        }

        .today-deal-price {
            margin-left: 5px;
            font-size: 17px;
            line-height: 23px;
            font-weight: 700;
        }

        .today-deal-rating {
            color: #424242;
        }

        .today-deal-review-count {
            margin-left: 5px;
        }

        .today-deal-star {
            color: #65C2EC;
        }

        .today-deal-item-info {
            margin-top: 5px;
            font-size: 12px;
            color: #9e9e9e;
            line-height: 16px;
            font-weight: 700;
        }

        .today-deal-product-img {
            width: 100%;
            border-radius: 5px;
			transition: 0.2s;
        }

        .today-deal-product-img:hover {
            transform: scale(1.05);
            cursor: pointer;
        }


        .today-deal-info-container {
            padding: 0 10px;
        }

        .today-deal-img-container {
            width: 100%;
            aspect-ratio: 1/1;
            overflow: hidden;
            position: relative;
        }

        .today-deal-product-container:hover {
            cursor: pointer;
        }

		.today-deal-product-container:hover .today-deal-product-name {
            color: #A0A0A0;
        }

        .grid-row {
			grid-auto-rows: 458px;
        }

        .more-view-btn {
			color: #f77;
            font-weight: 700;
            margin-right: 7px;
			font-size: 15px;
            transition: opacity .1s;
        }
		
		.more-view-btn:hover {
            color: #F6BFBD;
            cursor: pointer;
        }



	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(2, 1)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container" style="margin-top: 130px">

	<div class="shop-banner">
		<img src="${pageContext.request.contextPath}/resources/picture/shop/home/banner/1.avif">
	</div>

	<div class="content main-icon-container" style="margin-top: 50px;">
		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/1.avif">
			<div class="icon-text">오!세일</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/ranks'">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/2.webp">
			<div class="icon-text">BEST</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/today-deals'">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/3.webp">
			<div class="icon-text">오늘의딜</div>
		</div>

		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/4.avif">
			<div class="icon-text">가구세일</div>
		</div>

		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/5.avif">
			<div class="icon-text">선착순특가</div>
		</div>

		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/6.avif">
			<div class="icon-text">프리미엄</div>
		</div>

		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/7.avif">
			<div class="icon-text">시즌인기템</div>
		</div>

		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/8.avif">
			<div class="icon-text">키친특가</div>
		</div>

		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/9.webp">
			<div class="icon-text">오!쇼룸</div>
		</div>

		<div class="main-icon-item flex-col">
			<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/10.webp">
			<div class="icon-text">기획전</div>
		</div>
	</div>

	<div class="content" style="margin-top: 50px">
		<div class="flex-row" style="justify-content: space-between; align-items: center">
			<div class="shop-main-label">오늘의딜</div>

			<%-- 클릭시 오늘의딜 탭으로 이동 --%>
			<div class="more-view-btn">더보기</div>
		</div>

		<%-- 오늘의 딜 상품 4개 --%>
		<div class="grid-col-4">
			<div class="flex-col today-deal-product-container" onclick="location.href='${pageContext.request.contextPath}/product/268'">
				<div class="today-deal-img-container">
					<img class="today-deal-product-img"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/1.jpg">
				</div>
				<div class="flex-col today-deal-info-container">
					<div class="today-deal-brand-name">영가구</div>
					<div class="today-deal-product-name">[리뷰 23,000개] 베가 폴라 투명 접이식의자 17colors</div>
					<div><span class="today-deal-sale-percent">55%</span><span class="today-deal-price">25,600</span>
					</div>
					<div class="today-deal-item-info"><span class="today-deal-star"><i
							class="fa-solid fa-star"></i></span><span class="today-deal-rating">4.7</span><span
							class="today-deal-review-count">리뷰 23,823</span></div>
				</div>
			</div>

			<div class="flex-col today-deal-product-container">
				<div class="today-deal-img-container">
					<img class="today-deal-product-img"
						 src="https://bucketplace-v2-development.s3.amazonaws.com/uploads/productions/168256978840040031.jpg">
				</div>
				<div class="flex-col today-deal-info-container">
					<div class="today-deal-brand-name">마틸라</div>
					<div class="today-deal-product-name">[원데이특가]시원쾌적 시어서커X항균소취 스무디 양면 여름 차렵이불세트 5colors</div>
					<div><span class="today-deal-sale-percent">55%</span><span class="today-deal-price">38,900</span>
					</div>
					<div class="today-deal-item-info"><span class="today-deal-star"><i
							class="fa-solid fa-star"></i></span><span class="today-deal-rating">4.7</span><span
							class="today-deal-review-count">리뷰 144</span></div>
				</div>
			</div>

			<div class="flex-col today-deal-product-container">
				<div class="today-deal-img-container">
					<img class="today-deal-product-img"
						 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/165959279812235613.jpg?gif=1&w=1280&h=1280&c=c&webp=1">
				</div>
				<div class="flex-col today-deal-info-container">
					<div class="today-deal-brand-name">마틸라</div>
					<div class="today-deal-product-name">[원데이특가]시원쾌적 시어서커X항균소취 스무디 양면 여름 차렵이불세트 5colors</div>
					<div><span class="today-deal-sale-percent">55%</span><span class="today-deal-price">38,900</span>
					</div>
					<div class="today-deal-item-info"><span class="today-deal-star"><i
							class="fa-solid fa-star"></i></span><span class="today-deal-rating">4.7</span><span
							class="today-deal-review-count">리뷰 144</span></div>
				</div>
			</div>

			<div class="flex-col today-deal-product-container">
				<div class="today-deal-img-container">
					<img class="today-deal-product-img"
						 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/167168822852557476.jpg?gif=1&w=1280&h=1280&c=c&webp=1">
				</div>
				<div class="flex-col today-deal-info-container">
					<div class="today-deal-brand-name">마틸라</div>
					<div class="today-deal-product-name">[원데이특가]시원쾌적 시어서커X항균소취 스무디 양면 여름 차렵이불세트 5colors</div>
					<div><span class="today-deal-sale-percent">55%</span><span class="today-deal-price">38,900</span>
					</div>
					<div class="today-deal-item-info"><span class="today-deal-star"><i
							class="fa-solid fa-star"></i></span><span class="today-deal-rating">4.7</span><span
							class="today-deal-review-count">리뷰 144</span></div>
				</div>
			</div>

		</div>
	</div>


	<div class="content" style="margin-top: 50px;">
		<div class="shop-main-label">카테고리</div>
		<jsp:include page="/WEB-INF/views/fragment/category.jsp"/>
	</div>

	<div class="content" style="margin-top: 50px">
		<div class="shop-main-label">인기 상품</div>

		<%-- 오늘의 딜 상품 4개 --%>
		<div class="grid-col-4 grid-row">

			<c:forEach begin="0" end="15" step="1">
				<div class="flex-col today-deal-product-container">
					<div class="today-deal-img-container">
						<img class="today-deal-product-img"
							 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/1.jpg">
					</div>
					<div class="flex-col today-deal-info-container">
						<div class="today-deal-brand-name">마틸라</div>
						<div class="today-deal-product-name">[원데이특가]시원쾌적 시어서커X항균소취 스무디 양면 여름 차렵이불세트 5colors</div>
						<div><span class="today-deal-sale-percent">55%</span><span class="today-deal-price">38,900</span>
						</div>
						<div class="today-deal-item-info"><span class="today-deal-star"><i
								class="fa-solid fa-star"></i></span><span class="today-deal-rating">4.7</span><span
								class="today-deal-review-count">리뷰 144</span></div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>



</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
