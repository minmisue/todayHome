<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>상품 상세</title>

	<style>
        .preview-img-container {
            width: 62px;
            height: 62px;
            border-radius: 5px;
        }


        .preview-img-container img {
            object-fit: cover;
            transition: 1.1s;
        }

        .preview-img-container img:hover {
            cursor: pointer;
        }

        .selected-preview-img {
            border: 2px solid #64C2EB;
        }

        .product-img-container {
            width: 60%;
        }

        .preview-img-container-bundle {
            width: 62px;
            gap: 10px;
            margin-right: 10px;
        }

        .cart-btn {
            border: 1px solid #64C2EB;
            flex: 1;
            color: #64C2EB;
            margin: 0 3px;
            border-radius: 5px;
            background-color: white;
        }

        .direct-purchase-btn {
            flex: 1;
            background-color: #64C2EB;
            color: white;
            padding: 14px 10px;
            margin-left: 3px;
            border-radius: 5px;
            border: none;
        }

        .direct-purchase-btn:hover {
            background-color: #4EABD7;
        }

        .brand-name {
            margin-bottom: 4px;
            font-size: 14px;
            font-weight: 750;
			color: #676E74;
        }

        .product-name {
            font-size: 22px;
            font-weight: 400;
			flex: 1;
        }

        .sale-percent {
            /*line-height: 30px;*/
            color: #64C2EB;
            font-weight: 900;
            font-size: 30px;
        }

        .price {
            font-size: 32px;
            font-weight: 700;
            margin-right: 4px;
        }

        .rating {
            margin-top: 12px;
            color: #64C2EB;
        }

		.bi-bookmark-fill {
            color: #64C2EB;
		}
		
		.bookmark-btn:hover {
            cursor: pointer;
		}

        .product-content > img {
            width: 100%;
            object-fit: cover;
        }

        .product-content {
            width: 65%
        }

        .product-img {
            width: 100%;
            height: 100%;
			border-radius: 10px;
        }

        .brand-home {
            justify-content: space-between;
            padding: 14px 0;
        }

        .brand-home-btn {
            background-color: #F5F5F5;
            padding: 4px 12px;
            border-radius: 10px;
            font-size: 13px;
            font-weight: bold;
            color: #828c94;
        }

		.brand-home-btn:hover {
            cursor: pointer;
			background-color: #EAEBEF;
        }

        .brand-home-name {
            margin-left: 4px;
            font-size: 15px;
            font-weight: 600;
        }

        .count {
            margin-left: 4px;
            color: #9e9e9e;
            font-size: 15px;
        }

        .bookmark-icon {
			border: 1px solid #DBDBDB;
			border-radius: 5px;
			width: 55px;
			margin-right: 5px;
			padding: 16px;
			font-size: 22px;
        }
		
		.bookmark-icon:hover {
            cursor: pointer;
        }

        input[type="number"]::-webkit-outer-spin-button,
        input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        .btnChange {
			border: none;
			width: 18px;
			background-color: white;
			font-size: 19px;
			filter: ;
        }

		.btnChange:hover , .option-quantity:hover {
            cursor: pointer;
			color: #97999B;
        }

        .option-quantity {
			border: none;
			font-size: 14px;
        }

        .edit-quantity-container {
			border: 1px solid #DBDDE0;
			border-radius: 4px;
			padding: 7px 6px;
			background-color: white;
			text-align: center;
        }

		.option-price-container {
            font-weight: 600;
			line-height: 20px;
        }

        .toast-theme {
            background-color: #303438;
            padding: 5px 15px;
            color: white;
            transition: 0.5s;
        }

        .selected-review-btn {
			color: #65C2EC;
        }

        .star-rating i {
            color: #35c5f0;
        }

        .bookmark-cnt {
            margin-top: 2px;
            font-size: 11px;
            line-height: 14px;
            letter-spacing: -.3px;
            color: #424242;
        }

		a {
			color: black;
		}
	</style>
</head>
<body>
<script>
    $(function () {
        selectCurrentMenu(2, 0)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container" style="position: relative">

	<%-- 스크랩 토스트 --%>
	<div class="position-fixed bottom-0 start-50 translate-middle-x toast-container p-3" style="z-index: 11;">
		<div id="insertScrapToast" data-bs-delay="3000" class="toast hide toast-theme" role="alert" aria-live="assertive" aria-atomic="true">
			<div class="toast-body flex-row" style="justify-content: space-between">
				<div>
					스크랩했습니다
				</div>
				<a href="${pageContext.request.contextPath}/mypage/${sessionScope.sessionInfo.memberId}/book" style="text-decoration: none; color: #63BDE6; font-weight: 650;">스크랩북 보기</a>
			</div>
		</div>

		<div id="deleteScrapToast" style="transition: 0.5s" data-bs-delay="3000" class="toast hide toast-theme" role="alert" aria-live="assertive" aria-atomic="true">
			<div class="toast-body">
				스크랩북에서 삭제했습니다.
			</div>
		</div>
	</div>

	<div class="content flex-row">
		<%-- 상품 사진 --%>
		<div class="product-img-container flex-row">
			<%-- 미리보기 --%>
			<div class="flex-col preview-img-container-bundle">

				<c:forEach items="${product.productImgList}" var="productImg">
					<div class="preview-img-container">
						<img style="width: 100%; height: 100%"
							 src="${pageContext.request.contextPath}/resources/picture/shop/product/product/${productImg.saveName}">
					</div>
				</c:forEach>

<%--				<div class="preview-img-container">--%>
<%--					<img style="width: 100%; height: 100%"--%>
<%--						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/2.webp">--%>
<%--				</div>--%>

<%--				<div class="preview-img-container">--%>
<%--					<img style="width: 100%; height: 100%"--%>
<%--						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/3.webp">--%>
<%--				</div>--%>

<%--				<div class="preview-img-container">--%>
<%--					<img style="width: 100%; height: 100%"--%>
<%--						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/5.webp">--%>
<%--				</div>--%>
			</div>
			<div style="flex: 1;">
				<div style="aspect-ratio: 1/1">
					<img class="product-img"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product/product/${product.productImgList[0].saveName}">
				</div>
			</div>
		</div>

		<%-- 상품 옵션 및 버튼 --%>
		<div class="flex-col" style="margin-left: 35px; flex: 1">
			<div class="brand-name">${seller.brandName}</div>
			<div class="flex-row" style="">
				<div class="product-name">${product.productName}</div>
				<div class="flex-col" style="justify-content: center; align-items: center; padding: 5px 5px; margin-left: 15px">
					<div><i class="bi bi-bookmark bookmark-btn" style="font-size: 25px" onclick="scrapProduct()"></i></div>
					<div class="bookmark-cnt">${scrapCnt}</div>
				</div>
			</div>
			<div class="rating">
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
			</div>

			<div class="flex-col" style="margin-top: 8px">
				<div class="sale-percent">${product.discountPercent}%</div>
				<div class="flex-row" style="align-items: center; line-height: 30px">
					<div class="price">
						<fmt:formatNumber value="${product.price * (product.discountPercent/100)}" pattern="#,###" />
						${formatNumber}
					</div>
					<div style="font-size: 24px">원</div>
				</div>
			</div>

			<div class="flex-row" style="padding: 20px 0; font-size: 14px">
				<div style="width: 42px; color: #828c94">배송</div>
				<div class="flex-col" style="flex: 1; gap: 5px">
					<div style="font-weight: 750;"><fmt:formatNumber value="${product.deliveryCost}"/> 원</div>
					<div>일반택배</div>
					<div style="color: #757575"><i class="bi bi-check"></i>제주도/도서산간 지역 5,000원</div>
					<div style="background-color: #F7F8FA; height: 40px; margin-top: 10px; border-radius: 5px; align-items: center; padding: 10px 20px">
						<div style="margin: auto 0; font-size: 14px">
							<i class="bi bi-box-seam"></i>
							<span style="margin-left: 5px; color: #65C2EC; font-weight: 700;">6/9(금)</span>
							<span>도착 예정 </span>
							<span style="font-weight: bold;">96%</span>
						</div>
					</div>
				</div>
			</div>

			<hr>

			<div class="flex-row brand-home" >
				<div><i class="bi bi-shop"></i> <span class="brand-home-name">${seller.brandName}</span></div>
				<div class="brand-home-btn">브랜드 홈 <i class="bi bi-chevron-right"></i></div>
			</div>

			<c:forEach var="mainOption" items="${mainOptionList}" varStatus="status">
				<select class="form-control select-option" style="border: 1px solid #DBDBDB; border-radius: 5px; height: 40px; padding: 0 15px; font-size: 15px; margin-top: 10px; ">
					<option selected="" value="" disabled="">${mainOption.optionName}</option>
					<c:if test="${status.index == 0}">
						<c:forEach var="subOption" items="${mainOption.subOptions}">
							<option value="${subOption.subOptionId}">${subOption.subOptionName}</option>
						</c:forEach>
					</c:if>
				</select>
			</c:forEach>

			<div class="flex-col selected-option-container"></div>

			<div class="flex-row" style="justify-content: space-between; margin-top: 30px; ">
				<div style="margin-bottom: 20px; font-weight: 600">주문금액</div>
				<div style="font-size: 20px; line-height: 28px; font-weight: 700"><span class="total-price">0</span>원</div>
			</div>

			<div class="flex-row" style="justify-content: space-between">
				<button class="cart-btn">장바구니</button>
				<button class="direct-purchase-btn" >바로구매</button>
			</div>
		</div>
	</div>

<%--	<c:forEach var="stock" items="${mainOptionList}">--%>
<%--		<p>${stock}</p>--%>
<%--	</c:forEach>--%>

	<div id="product-content" style="margin-bottom: 120px"></div>
	<div class="sub-menubar-container" style="margin: 50px 0 30px 0; display: block; background-color: #FAFAFA; position: sticky; top: 130px">
		<div class="sub-menubar" style="padding: 0 55px; height: 48px">
			<a class="sub-item selected-sub-item" href="#product-content" style="text-decoration: none; width: 130px; text-align: center; margin-bottom: -1px;">상품정보</a>
			<a class="sub-item" href="#product-review-container" style="width: 130px; text-align: center; text-decoration: none;">리뷰 <span class="count">${reviewCount}</span></a>
<%--			<div class="sub-item" style="width: 130px; text-align: center">문의 <span class="count">4,402</span></div>--%>
<%--			<div class="sub-item" style="width: 130px; text-align: center">배송/환불</div>--%>
		</div>
	</div>

	<div class="content flex-row">
		<div class="flex-col product-content" >
			<div class="content-img-container flex-col" style="width: 100%;">
				<c:forEach items="${product.contentImgList}" var="productImg">
					<img style="width: 100%; height: 100%"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product/content/${productImg.saveName}">
				</c:forEach>
			</div>

			<div class="product-review-container flex-col" id="product-review-container">
				<div class="flex-row" style="font-weight: 700; font-size: 18px; gap: 10px; margin-top: 20px;">
					<div>리뷰</div>
					<div style="color: #65C2EC">541</div>
				</div>

				<div class="flex-row" style="justify-content: space-between; background-color: #F7F8FA; padding: 25px 60px; align-items: center; border-radius: 4px; margin-top: 15px">
					<div class="flex-row" style="font-size: 22px; align-items: center; color: #65C2EC">
						<div class="star-rating" style="margin-right: 8px">
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
						</div>
						<span style="margin-left: 12px; font-size: 34px; font-weight: 700; color: black">
							${rating}
						</span>
					</div>
					<div style="border-right: 1px solid #EDEDED; height: 100%"></div>
					<div class="flex-col" style="font-size: 12px; color: #9e9e9e; gap: 5px">
						<div class="flex-row" style="align-items: center">
							<div>5점</div><div style="width: 140px; height: 5px; background-color: #DBDCE0; margin: 0 10px; border-radius: 4px"></div><div>455</div>
						</div>
						<div class="flex-row" style="align-items: center">
							<div>4점</div><div style="width: 140px; height: 5px; background-color: #DBDCE0; margin: 0 10px; border-radius: 4px"></div><div>455</div>
						</div>
						<div class="flex-row" style="align-items: center">
							<div>3점</div><div style="width: 140px; height: 5px; background-color: #DBDCE0; margin: 0 10px; border-radius: 4px"></div><div>455</div>
						</div>
						<div class="flex-row" style="align-items: center">
							<div>2점</div><div style="width: 140px; height: 5px; background-color: #DBDCE0; margin: 0 10px; border-radius: 4px"></div><div>455</div>
						</div>
						<div class="flex-row" style="align-items: center">
							<div>1점</div><div style="width: 140px; height: 5px; background-color: #DBDCE0; margin: 0 10px; border-radius: 4px"></div><div>455</div>
						</div>
					</div>
				</div>
				<div class="flex-row" style="font-size: 13px; font-weight: 700; gap: 10px; padding: 20px 0; border-top: #EDEDED; border-bottom: #EDEDED; border-style: solid; border-left: none; border-right: none; margin-top: 20px">
					<div class="selected-review-btn">베스트순</div>
					<div>최신순</div>
				</div>

				<div class="review-container flex-col">
					<c:forEach items="${reviewList}" var="review">
						<div class="review flex-col" style="font-size: 13px; margin-top: 20px; padding-bottom: 50px; border: solid #EDEDED; border-width: 0 0 1px 0; margin-bottom: 20px;">
							<div class="profile flex-row" style="align-items: center">
								<div class="user-profile-img">
									<img style="width: 24px; height: 24px; object-fit: cover; border-radius: 12px" src="${pageContext.request.contextPath}/resources/picture/default-profile.png"/>
								</div>
								<div class="flex-col" style="margin-left: 10px;">
									<div>
										${review.nickName}
									</div>
									<div class="flex-row" style="gap: 5px">
										<div class="star-rating" style="margin-right: 8px">
											<c:set var="rating" value="${review.rating}"/>
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
										</div>
										<div>
											${review.regDate}
										</div>
										<div>
											∙
										</div>
										<div>
											오늘의집 구매
										</div>
									</div>
								</div>
							</div>
							<div class="review-product-info flex-col" style="border: solid #EDEDED; border-width: 0 0 0 3px; padding: 0 10px; font-size: 13px; margin-top: 15px;">
								<div style="font-weight: 600;">
									${review.productName}
								</div>
								<div>
									${review.stockString}
								</div>
							</div>
							<div class="review-img" style="margin-top: 20px;">
								<img style="width: 112px; height: 112px; object-fit: cover; border-radius: 4px" src="${pageContext.request.contextPath}/resources/picture/shop/product/review/${review.reviewImgName}"/>
							</div>
							<div class="review-content" style="margin-top: 30px; font-size: 15px">
								${review.content}
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<div style="flex: 1; padding: 0 40px; margin-left: 20px">
			<div class="flex-col" style="width: 100%; position: sticky; top: 205px; justify-content: space-between; height: 74vh;">
				<div></div>
				<div class="flex-col">
					<div class="flex-row" style="justify-content: space-between; padding: 0 3px; align-items: center; margin-bottom: 20px; ">
						<div style="font-weight: 600">주문금액</div>
						<div style="font-size: 20px; line-height: 28px; font-weight: 700;"><span class="total-price">0</span>원</div>
					</div>

					<div class="flex-row">
						<div class="bookmark-icon" onclick="scrapProduct()"><i class="bi bi-bookmark bookmark-btn"></i></div>
						<button class="cart-btn" onclick="getAllSelectedOptions()">장바구니</button>
						<button class="direct-purchase-btn">바로구매</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>


<script>
	let selectOptions = $('.select-option');
    let mainOptionCnt = ${mainOptionCnt};
    let scrapStatus = false;
    let isLogin = false;

	<%--let stockList = ${stockList};--%>
    <c:set var="productStocks" value="${stockList}" />


    let stockList = [
        <c:forEach items="${productStocks}" var="productStock" varStatus="status">{
            <c:set var="productStocks" value="${stockList}" />

			<c:set var="stockOptionPrice" value="${productStock.optionPrice * (product.discountPercent/100)}"/>

            stockId: ${productStock.stockId},
            optionPrice:  ${stockOptionPrice},
            quantity: ${productStock.quantity},
            <c:if test="${productStock.mainOptionId1 != null}">
            	mainOptionId1: ${productStock.mainOptionId1},
			</c:if>
			<c:if test="${productStock.mainOptionId2 != null}">
            	mainOptionId2: ${productStock.mainOptionId2},
            </c:if>
            <c:if test="${productStock.subOptionId1 != null}">
            	subOptionId1: ${productStock.subOptionId1},
			</c:if>
            <c:if test="${productStock.subOptionId2 != null}">
            	subOptionId2: ${productStock.subOptionId2},
			</c:if>
            <c:if test="${productStock.subOptionName1 != null}">
            	subOptionName1: '${productStock.subOptionName1}',
			</c:if>
            <c:if test="${productStock.subOptionName2 != null}">
            	subOptionName2: '${productStock.subOptionName2}',
			</c:if>
            <c:if test="${productStock.mainOptionName1 != null}">
            	mainOptionName1: '${productStock.mainOptionName1}',
			</c:if>
            <c:if test="${productStock.mainOptionName2 != null}">
            	mainOptionName2: '${productStock.mainOptionName2}',
			</c:if>
            productId: ${productStock.productId}
        }<c:if test="${not status.last}">,</c:if>
        </c:forEach>
    ];



    // 처음 시작시 첫번째 옵션을 제외하고 하위옵션 선택 불가
    $(function () {
        // disableExceptFirstOption();
		scrapStatus = ${isScrap};
		changeBookmarkBtn();
        isLogin = ${not empty sessionScope.sessionInfo}
    });

    // 첫번째 옵션 제외 옵션 삭제
    function disableExceptFirstOption() {
        let notFirst = selectOptions.not(':first');
        for (const x of notFirst) {
            $(x).children().not(':first').remove()
        }
    }

    function getSelectedOption() {
        // 선택된 옵션 아이디를 조회
		let selectedOptionList = [];

        for (const option of selectOptions) {
            let optionId = $(option).val();
            let optionName = $(option).find('option:selected').text();
            selectedOptionList.push([optionId, optionName]);
        }

        return selectedOptionList;
    }

    // 옵션 초기화
    function clearOptions() {
        for (const option of selectOptions) {
            $(option).html($(option).html())
        }

        disableExceptFirstOption()
    }

    // 각 옵션 선택 리스너
    for (let i = 0; i < mainOptionCnt; i++) {
        selectOptions[i].addEventListener('change', function () {

            // 마지막 옵션을 선택한 경우 : 옵션을 초기화하고 선택 컨테이너 생성
            if (i === mainOptionCnt-1) {
                console.log('옵션 모두 선택 완료!')

				let selectedOption = getSelectedOption();
				let selectOptionInfo

				if (mainOptionCnt === 0) {
                    selectOptionInfo = stockList[0];
                } else if (mainOptionCnt === 1) {
                    selectOptionInfo = stockList.find(function (item) {
                        return parseInt(item.subOptionId1) === parseInt(selectedOption[0][0]);
                    })
				} else if (mainOptionCnt === 2) {
                    selectOptionInfo = stockList.find(function (item) {
                        return parseInt(item.subOptionId1) === parseInt(selectedOption[0][0]) && parseInt(item.subOptionId2) === parseInt(selectedOption[1][0])
                    })
				}

                let stockId = selectOptionInfo.stockId;
                let allSelectedOptions = getAllSelectedOptions();

                for (const selectedOption of allSelectedOptions) {
                    if (parseInt(selectedOption[0]) === parseInt(stockId)) {
                        alert('이미 등록된 옵션입니다.')
                        clearOptions();
						return;
					}
                }

                addSelectedOption(selectOptionInfo)
                clearOptions();
                displayTotalPrice()
				return
			}

			// 다음 메인옵션이 있는 경우
			let currentSubOptionId = $(this).val();

            let nextSubOptions = stockList.filter(function (stock) {
                return parseInt(stock.subOptionId1) === parseInt(currentSubOptionId) && parseInt(stock.quantity) !== 0
            });

			let optionTag = `<option selected="" value="" disabled="">` + nextSubOptions[0].mainOptionName2 + `</option>`

            for (const nextSubOption of nextSubOptions) {
                optionTag +=
					`
						<option value="` + nextSubOption.subOptionId2 + `">` + nextSubOption.subOptionName2 + ` (` + nextSubOption.optionPrice.toLocaleString('ko-KR') + `원) </option>
					`
            }

            $(selectOptions[i + 1]).html(optionTag).show()
        });
    }

    // 옵션 선택 완료시 하단에 옵션 + 가격 + 수량 정보를 나타내는 컨테이너를 추가한다.
    function addSelectedOption(stock) {

        let optionNameBundle

        if (mainOptionCnt === 0) {
            return
		} else {
			optionNameBundle = stock.mainOptionName1 + ': ' + stock.subOptionName1
		}

        if (mainOptionCnt === 2) {
			optionNameBundle += ' / ' + stock.mainOptionName2 + ': ' + stock.subOptionName2
		}

        let obj =
			`
				<div class="selected-option" style="background-color: #F8F9FA; padding: 12px; margin-top: 10px; border-radius: 4px">
					<div style="font-size: 14px; line-height: 18px; padding: 0 24px 10px 0; rgb(47, 52, 56);">
			` +
				optionNameBundle
			+ `
				</div>
					<div class="flex-row" style="margin-top: 12px; align-items: end; justify-content: space-between">
						<input type="hidden" class="stock-id" value="`+ stock.stockId +`">
						<div class="edit-quantity-container" style="display: flex; flex-direction: row; align-items: center" id="quantityBundle">
							<i class="bi bi-dash-lg btnChange minus" onclick="$.clickChangeBtn(this, ` + stock.stockId + `)"></i>
							<div class="option-quantity" style="width: 40px; text-align: center" >1</div>
							<input id="optionQuantityInput" type="hidden" value="1">
							<i class="bi bi-plus-lg btnChange plus" onclick="$.clickChangeBtn(this, ` + stock.stockId + `)"></i>
						</div>
						<div class="option-price-container"><span class="option-price">` + stock.optionPrice.toLocaleString('ko-KR') + `</span> 원</div>
					</div>
				</div>
			`
		$('.selected-option-container').append(obj)
    }


    $.clickChangeBtn = function (obj, stockId) {
        let stock = stockList.find(function (name) {
            return name.stockId === stockId
        });

        let min = 1;
        let optionQuantityInput = $(obj).parent().find('input')
        let optionQuantityDisplay = $(obj).parent().find('.option-quantity')
        let remainQuantity = stock.quantity;
        let changeNum = optionQuantityInput.val();
        let price = stock.optionPrice;
        let optionPrice = $(obj).parent().next().find('.option-price')

        if ($(obj).hasClass('plus')) {
            console.log('plus')
            changeNum++;
        } else {
            console.log('minus')
            changeNum--;
        }

        console.log('changeNum = ' + changeNum);
        console.log('price = ' + price)
        console.log('remainQuantity = ' + remainQuantity)

        if (changeNum > remainQuantity) {
            alert('최대 수량보다 많이 담을 수 없습니다.')
        } else if (changeNum < min) {
            alert('1개보다 적게 담을 수 없습니다.')
        } else {
            optionQuantityInput.val(changeNum);
            optionQuantityDisplay.text(changeNum);
            optionPrice.text(changeNum * price)

            displayTotalPrice()
        }
    };

</script>


<script>
    function getAllSelectedOptions() {
        let selectedOptions = $('.selected-option-container').children();
        let result = []

        for (const option of selectedOptions) {
			let stockId = $(option).find('.stock-id').val();
            let quantity = $(option).find('.option-quantity').text();
			result.push([stockId, quantity])
        }

        return result
    }

    // 주문 금액 합산가격 표기
    function displayTotalPrice() {
        let selectedOptions = $('.selected-option-container').children();
        let totalPrice = 0

        for (const option of selectedOptions) {
            totalPrice += parseInt($(option).find('.option-price').text().replaceAll(',',''));
        }

        let totalPriceOut = $('.total-price');

        for (const totalPriceObj of totalPriceOut) {
			$(totalPriceObj).text(totalPrice.toLocaleString('ko-kr'))
        }
    }



	// 장바구니
    $(".cart-btn").click(function () {
        if (${empty sessionScope.sessionInfo}) {
            if (confirm("로그인이 필요한 서비스 입니다.\n로그인 페이지로 이동하시겠습니까?")) {
                $(location).attr('href', '${pageContext.request.contextPath}/login')
            }

            return;
        }

        let msg = "상품을 장바구니에 저장합니다."

        if (!confirm(msg)) {
            return;
        }

        let selectedOptions = getAllSelectedOptions();
        if (selectedOptions.length === 0) {
            alert("먼저 옵션을 선택해 주세요.");
            return;
        }

        let productId = "${product.productId}";

        let data = {
            productId: productId,
			selectedOptions: selectedOptions
        }

        $.ajax({
            url: "${pageContext.request.contextPath}/product/cart",
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(response) {
                let state = response.state;
                if (state === true) {
                    if (confirm("장바구니에 저장되었습니다.\n장바구니로 이동하시겠습니까?")) {
                        $(location).attr('href', '${pageContext.request.contextPath}/cart')
                    }
                }
            },
            error: function(xhr, status, error) {
                // 요청이 실패했을 때 실행되는 코드
				alert("장바구니 추가에 실패했습니다.")
            }
        });
    });

    // 바로 주문
    $(".direct-purchase-btn").click(function () {
        if (${empty sessionScope.sessionInfo}) {
            if (confirm("로그인이 필요한 서비스 입니다.\n로그인 페이지로 이동하시겠습니까?")) {
                $(location).attr('href', '${pageContext.request.contextPath}/login')
                return;
            } else {
                return;
            }
        }

        let form = document.createElement('form');
        form.setAttribute('method', 'POST');
        form.setAttribute('action', '${pageContext.request.contextPath}/payment/buy-now')

        let selectedOptions = getAllSelectedOptions();

        let productId = "${product.productId}";

        let data = {
            productId: productId,
            selectedOptions: selectedOptions
        }

        let orderData = JSON.stringify(data);

        console.log(orderData)

        let productIdInputTag = document.createElement('input');
        productIdInputTag.setAttribute('type', 'hidden');
        productIdInputTag.setAttribute('name', 'productId');
        productIdInputTag.setAttribute('value', productId);
        form.appendChild(productIdInputTag);

        for (let x of selectedOptions) {
            let stockIdTag = document.createElement('input');
            stockIdTag.setAttribute('type', 'hidden');
            stockIdTag.setAttribute('name', 'stockId');
            stockIdTag.setAttribute('value', x[0]);

            form.appendChild(stockIdTag);

            let quantityTag = document.createElement('input');
            quantityTag.setAttribute('type', 'hidden');
            quantityTag.setAttribute('name', 'quantity');
            quantityTag.setAttribute('value', x[1]);
            form.appendChild(quantityTag);
        }

        document.body.appendChild(form);
        form.submit();
    });
</script>



<script>
	// 미리보기 첫번째만 선택
    $(function () {

        $($('.preview-img-container')[0]).addClass('selected-preview-img')
    });

	// 미리보기 이미지 오버시 이미지 변경 스크립트
    $(function () {
        let $preview = $('.preview-img-container');

        $preview.mouseover(function () {
            resetPreview(this)

            $(this).addClass('selected-preview-img')
            let src = $(this).children().attr('src');

            $('.product-img').attr('src', src);
        });

        $preview.mouseout(function () {
            resetPreview(this)
        });

        function resetPreview(obj) {
            for (const x of $preview) {
                if (x !== obj)
                    $(x).removeClass('selected-preview-img')
            }
        }
    });

    function changeBookmarkBtn() {
        let bookMarkBtn = $('.bookmark-btn');
        if (scrapStatus) {
            for (const x of bookMarkBtn) {
                $(x).removeClass('bi-bookmark').addClass('bi-bookmark-fill');
            }
        } else {
            for (const x of bookMarkBtn) {
                $(x).removeClass('bi-bookmark-fill').addClass('bi-bookmark');
            }
		}
    }

    // 상품 스크랩
    function scrapProduct() {
        if (!isLogin) {
            alert("로그인이 필요한 서비스입니다.");
            return
		}

		let productId = '${product.productId}';

        scrapStatus = !scrapStatus;
        changeBookmarkBtn();

        $.ajax({
            url: "${pageContext.request.contextPath}/product/scrap",
            type: 'POST',
            data: 'productId=' + productId,
            dataType: 'json',
            success: function(response) {
                if (response.result === true) {
					$('.bookmark-cnt').text(response.scrapCnt)
                    showToast()
                } else {
                    alert("서버와의 연결이 불안정합니다.");
                }
            },
            error: function(xhr, status, error) {
                // 요청이 실패했을 때 실행되는 코드
                alert("서버와의 연결이 불안정합니다.");
            }
        });
    }
</script>

<script>
    function showToast() {
        let elementById

        if (!scrapStatus) {
            elementById = document.getElementById('deleteScrapToast');
        } else {
            elementById = document.getElementById('insertScrapToast');
        }
        let instance = bootstrap.Toast.getOrCreateInstance(elementById);
        instance.show()
    }
</script>

</body>
</html>
