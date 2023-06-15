<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
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

        .btn-best {
            width: 171px;
            height: 44px;
            border: 1px solid #DBDDE0;
            background-color: white;
        }

        .btn-best-selected {
            background-color: #65C2EC;
            color: white;
            border: none;
        }

        .btn-best:hover {
            border-color: #DBDDE0;
            background-color: #F8F9FA;
        }

        .btn-best-selected:hover {
            background-color: #469DCA;
            color: white;
        }


        .btn-left {
            border-radius: 5px 0 0 5px;
            margin-right: -3px;
        }

        .btn-right {
            border-radius: 0 5px 5px 0;
            margin-left: -3px;
        }

        .best-sub-menubar-container {
            padding: 0 92px;
            border-bottom: 1px solid #EBEDEF;
            margin-top: 30px;
            margin-bottom: 30px;
            display: block;
        }

        .best-sub-menubar {
            display: flex;
            flex-direction: row;
            /*margin: 0 92px;*/
            gap: 10px;
            margin: 0 auto;
            max-width: 1256px;
            padding: 0 60px;
            height: 50px;
            align-items: center;
            font-size: 16px;
            line-height: 20px;
            font-weight: 500;
        }
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(2, 3)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container" style="margin-top: 200px">
	<div class="content" style="text-align: center; margin-top: 50px">
		<div class="btn-bundle">
			<button type="button" class="btn-left btn-best"
					onclick="location.href='${pageContext.request.contextPath}/shop/ranks?type=recent'">실시간 베스트
			</button>
			<button type="button" class="btn-right btn-best btn-best-selected"
					onclick="location.href='${pageContext.request.contextPath}/shop/ranks?type=best'">역대 베스트
			</button>
		</div>
	</div>


	<div class="best-sub-menubar-container">
		<div class="best-sub-menubar">
			<div class="sub-item selected-sub-item">전체</div>
			<div class="sub-item">가구</div>
			<div class="sub-item">패브릭</div>
			<div class="sub-item">가전·디지털</div>
			<div class="sub-item">주방용품</div>
			<div class="sub-item">식품</div>
			<div class="sub-item">데코·식물</div>
			<div class="sub-item">조명</div>
			<div class="sub-item">수납·정리</div>
			<div class="sub-item">생활용품</div>
			<div class="sub-item">생필품</div>
			<div class="sub-item">유아·아동</div>
			<div class="sub-item">반려동물</div>
		</div>
	</div>


		<div class="content" style="margin-top: 50px">
			<%-- 베스트 상품들 --%>
			<div class="grid-col-4 grid-row">

				<c:forEach begin="1" end="16" step="1" varStatus="status">
					<div class="flex-col today-deal-product-container">
						<div class="today-deal-img-container">
							<img class="today-deal-product-img"
								 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/166131669433751075.jpeg?gif=1&w=1280&h=1280&c=c&webp=1">

							<div style="position: absolute; left: 10px; top: 0; width: 28px">
								<i class="bi bi-bookmark-fill" style="font-size: 28px; color: rgba(28,183,250,0.77)"></i>
								<div style="position: absolute; left: 0; top: 3px; font-size: 12px; color: white; font-weight: 700; width: 100%; text-align: center">${status.index}</div>
							</div>
						</div>
						<div class="flex-col today-deal-info-container">
							<div class="today-deal-brand-name">마틸라</div>
							<div class="today-deal-product-name">[원데이특가]시원쾌적 시어서커X항균소취 스무디 양면 여름 차렵이불세트 5colors</div>
							<div><span class="today-deal-sale-percent">55%</span><span
									class="today-deal-price">38,900</span>
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
