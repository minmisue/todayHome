<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Home</title>

<style>
.main-container.review-home {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.select-btn {
	width: 100px;
    margin-right: 3px;
    display: inline-block;
    box-sizing: border-box;
    font-weight: 700;
    text-align: center;
    padding: 4px 0;
    cursor: pointer;
    border-radius: 4px;
	font-size: 15px;

    color: #dbdbdb;
    background-color: #ffffff;
    border: 1px solid #dbdbdb;
}

.selected {
    color: #35c5f0;
    background-color: #ffffff;
    border: 1px solid #3fc5f0;
}

.product-text-container {
	display: flex;
	flex-direction: column;
	gap: 5px;
}

.product-text {
	font-weight: 400;
	color: #333;
}

.subject {
	font-size: 15px;
	font-weight: bold;
}

.name {
	font-size: 12px;
}

.star-rating i {
	color: #35c5f0;
}

.date {
	font-size: 12px;
	color: #dbdbdb;
    margin-left: 10px;
}

.review {
	font-size: 12px;
}

.flex-row{
	margin-bottom: 20px;
}
</style>
<script>

</script>

</head>
<body>
	<script>
		$(function() {
			  // 여기에서 메뉴 선택
	        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
	        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
			// 두번째 파라미터에 null 입력시 메뉴바 숨김
	        selectCurrentMenu(0, null);

	        // 마이페이지일때 메뉴
			// 메인메뉴, 서브메뉴 숫자 입력
			// 첫번째 파라미터에 0 입력시 숨김
			selectMyPage(3,2);
		});
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content review-home">
			<div class="review-home-search">
				<button class="select-btn selected" onclick="bestPage(this)"> 베스트순</button>
				<button class="select-btn" onclick="recentPage(this)"> 최신순</button>
					<div class="flex-col" style="margin-top: 30px; gap: 10px">
						<c:forEach items="${productList}" var="product">
							<div class="product-container flex-row"
								style="justify-content: space-between; width: 100%">
								<div class="flex-row" style="gap: 15px; align-items: center;">
									<div class="product-text-container">
										<div class="product-text subject">${product.productName}</div>
										<div class="product-text name">${product.stockString}</div>

										<div class="star-rating">
											<c:set var="rating" value="${product.rating}"/>
											<c:set var="first" value="${fn:substringBefore(rating, '.')}"/>
											<c:set var="second" value="${fn:substringAfter(rating, '.')}"/>

											<!-- 3.4라면 1~3자리까지 꽉찬 별로 채움 -->
											<c:if test="${!first.equals('0')}">
												<c:forEach begin="1" end="${first}">
													<i class="fa-solid fa-star"></i>
												</c:forEach>
											</c:if>

											<c:if test="${!first.equals('5')}">
												<!-- 소숫점 숫자가 0이 아니라면 반별 -->
												<c:if test="${!second.equals('0')}">
													<i class="fa-solid fa-star-half-stroke"></i>
												</c:if>
												<!-- 0이라면 빈별 -->
												<c:if test="${second.equals('0')}">
													<i class="fa-regular fa-star"></i>
												</c:if>

												<!-- 5 - (앞자리+1) -->
												<c:if test="${!first.equals('4')}">
													<c:forEach begin="1" end="${4-first}">
														<i class="fa-regular fa-star"></i>
													</c:forEach>
												</c:if>
											</c:if>
											<span class="date"> ${product.regDate} | 오늘의집 리뷰</span>
										</div>

										<div class="product-text review">${product.content}</div>
									</div>
								</div>

								<div class="flex-col"
									style="padding-right: 5px; gap: 5px; justify-content: center; text-align: center">
									<div style="font-size: 14px">수정</div>
								</div>
							</div>
						</c:forEach>
					</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
<script>
	let selectBtn = $('.select-btn');

    function selectBtnClass(obj) {
        for (const x of selectBtn) {
            if (x === obj) {
                $(x).addClass('selected')
            } else {
                $(x).removeClass('selected')
            }
        }
    }

    function recentPage(obj) {
        selectBtnClass(obj)
    }

    function bestPage(obj) {
        selectBtnClass(obj)
    }
</script>

</body>
</html>
