<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            grid-auto-rows: 408px;
        }

        .today-deal-main-label {
			font-size: 32px;
			line-height: 42px;
            font-weight: 700;
			color: rgb(47, 52, 56);
			margin: 40px 0 10px;
        }

        .today-deal-sub-label {
			color: rgb(130, 140, 148);
			margin-bottom: 30px;
			line-height: 20px;
        }
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(2, 4)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container" style="margin-top: 200px">
	<div class="content" style="margin-top: 50px">

		<div class="today-deal-main-label">오늘의딜</div>
		<div class="today-deal-sub-label">매일 자정, 새로운 특가상품</div>

		<%-- 오늘의 딜 상품들 --%>
		<div class="grid-col-4 grid-row">
			<c:forEach items="${productList}" var="product" varStatus="status">
				<div class="flex-col today-deal-product-container" onclick="location.href='${pageContext.request.contextPath}/product/${product.productId}'">
					<div class="today-deal-img-container">
						<img class="today-deal-product-img"
							 src="${pageContext.request.contextPath}/resources/picture/shop/product/product/${product.saveName}">

						<div style="position: absolute; left: 12px; top: 12px; background-color: #EE7F7B; width: 95px; line-height: 24px; font-size: 12px; color: white; font-weight: 700; text-align: center; padding: 0px 6px; border-radius: 5px">
							<span class="remain-time">06:54:45</span> 남음
								<%--							<i class="bi bi-bookmark-fill" style="font-size: 28px; color: rgba(28,183,250,0.77)"></i>--%>
								<%--							<div style="position: absolute; left: 0; top: 3px; font-size: 12px; color: white; font-weight: 700; width: 100%; text-align: center">${status.index}</div>--%>
						</div>
					</div>
					<div class="flex-col today-deal-info-container">
						<div class="today-deal-brand-name">${product.brandName}</div>
						<div class="today-deal-product-name">${product.productName}</div>
						<div>
							<c:if test="${product.discountPercent != 0}">
								<span class="today-deal-sale-percent">
									${product.discountPercent}%
								</span>
							</c:if>

							<span class="today-deal-price">
								<fmt:formatNumber value="${product.price * (1 - product.discountPercent/100)}" pattern="#,###" />
								${formatNumber}
							</span>
						</div>
						<div class="today-deal-item-info">
							<span class="today-deal-star"><i class="fa-solid fa-star"></i></span>
							<span class="today-deal-rating">${product.rating}</span>
							<span class="today-deal-review-count">리뷰 ${product.reviewCnt}</span>
						</div>
					</div>
				</div>


<%--				<div class="flex-col today-deal-product-container">--%>
<%--					<div class="today-deal-img-container">--%>
<%--						<img class="today-deal-product-img"--%>
<%--							 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/1.jpg">--%>

<%--						<div style="position: absolute; left: 12px; top: 12px; background-color: #EE7F7B; width: 95px; line-height: 24px; font-size: 12px; color: white; font-weight: 700; text-align: center; padding: 0px 6px; border-radius: 5px">--%>
<%--							<span class="remain-time">06:54:45</span> 남음--%>
<%--&lt;%&ndash;							<i class="bi bi-bookmark-fill" style="font-size: 28px; color: rgba(28,183,250,0.77)"></i>&ndash;%&gt;--%>
<%--&lt;%&ndash;							<div style="position: absolute; left: 0; top: 3px; font-size: 12px; color: white; font-weight: 700; width: 100%; text-align: center">${status.index}</div>&ndash;%&gt;--%>
<%--						</div>--%>
<%--					</div>--%>

<%--					<div class="flex-col today-deal-info-container">--%>
<%--						<div class="today-deal-brand-name">마틸라</div>--%>
<%--						<div class="today-deal-product-name">[원데이특가]시원쾌적 시어서커X항균소취 스무디 양면 여름 차렵이불세트 5colors</div>--%>
<%--						<div><span class="today-deal-sale-percent">55%</span><span class="today-deal-price">38,900</span>--%>
<%--						</div>--%>
<%--						<div class="today-deal-item-info"><span class="today-deal-star"><i--%>
<%--								class="fa-solid fa-star"></i></span><span class="today-deal-rating">4.7</span><span--%>
<%--								class="today-deal-review-count">리뷰 144</span></div>--%>
<%--					</div>--%>
<%--				</div>--%>
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

<script>
    $(function () {
        updateRemainingTime()
    });

    function getRemainingTimeInSeconds() {
        const now = new Date(); // 현재 시간
        const endOfDay = new Date();
        endOfDay.setHours(23, 59, 59, 999); // 오늘의 끝나는 시간 (23시 59분 59초 999밀리초)

         // 남은 시간 계산 (밀리초를 초로 변환)
        return convertSecondsToTime(Math.floor((endOfDay - now) / 1000));
    }

    function updateRemainingTime() {
        const remainingTime = getRemainingTimeInSeconds();

        let $remain = $('.remain-time');
        for (const remain of $remain) {
			$(remain).text(remainingTime)
        }

        // 1초마다 함수를 호출하여 시간을 갱신
        setTimeout(updateRemainingTime, 1000);
    }

    function convertSecondsToTime(seconds) {
        const hours = Math.floor(seconds / 3600);
        const minutes = Math.floor((seconds % 3600) / 60);
        const remainingSeconds = seconds % 60;

        const formattedHours = hours < 10 ? '0' + hours : hours;
        const formattedMinutes = minutes < 10 ? '0' + minutes : minutes;
        const formattedSeconds = remainingSeconds < 10 ? '0' + remainingSeconds : remainingSeconds;

        return formattedHours + ':' + formattedMinutes + ':' + formattedSeconds;
    }

</script>
</body>
</html>
