<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            margin: 0 3px;
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
	</style>
</head>
<body>
<script>
    $(function () {
        selectCurrentMenu(2, 0)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container">

	<div class="content flex-row">
		<%-- 상품 사진 --%>
		<div class="product-img-container flex-row">
			<%-- 미리보기 --%>
			<div class="flex-col preview-img-container-bundle">
				<div class="preview-img-container selected-preview-img">
					<img style="width: 100%; height: 100%"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/1.jpg">
				</div>

				<div class="preview-img-container">
					<img style="width: 100%; height: 100%"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/2.webp">
				</div>

				<div class="preview-img-container">
					<img style="width: 100%; height: 100%"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/3.webp">
				</div>

				<div class="preview-img-container">
					<img style="width: 100%; height: 100%"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/5.webp">
				</div>
			</div>
			<div style="flex: 1;">
				<div style="aspect-ratio: 1/1">
					<img class="product-img"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/1.jpg">
				</div>
			</div>

		</div>

		<%-- 상품 옵션 및 버튼 --%>
		<div class="flex-col" style="margin-left: 35px; flex: 1">
			<div class="brand-name">영가구</div>
			<div class="product-name">${product.productName}</div>
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
					<div class="price">${product.price}</div>
					<div style="font-size: 24px">원</div>
				</div>
			</div>

			<div class="flex-row" style="padding: 20px 0; font-size: 14px">
				<div style="width: 42px; color: #828c94">배송</div>
				<div class="flex-col" style="flex: 1; gap: 5px">
					<div style="font-weight: 750;">${product.deliveryCost} 원</div>
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
				<div><i class="bi bi-shop"></i> <span class="brand-home-name">테팔</span></div>
				<div class="brand-home-btn">브랜드 홈 <i class="bi bi-chevron-right"></i></div>
			</div>


			<c:forEach var="mainOption" items="${mainOptionList}" >
				<select class="form-control select-option" style="border: 1px solid #DBDBDB; border-radius: 5px; height: 40px; padding: 0 20px; margin-top: 10px">
					<option selected="" value="" disabled="">${mainOption.optionName}</option>
					<c:forEach var="subOption" items="${mainOption.subOptions}">
						<option value="${subOption.subOptionId}">${subOption.subOptionName}</option>
					</c:forEach>
				</select>
			</c:forEach>

			<div class="flex-col selected-option-container"></div>

			<div class="flex-row" style="justify-content: space-between; margin-top: 30px; ">
				<div style="margin-bottom: 20px; font-weight: 600">주문금액</div>
				<div style="font-size: 20px; line-height: 28px; font-weight: 700">0원</div>
			</div>

			<div class="flex-row" style="justify-content: space-between">
				<button class="cart-btn" id="addCartBtn">장바구니</button>
				<button class="direct-purchase-btn" onclick="getSelectedOption()">바로구매</button>
			</div>
		</div>
	</div>

<%--	<c:forEach var="stock" items="${mainOptionList}">--%>
<%--		<p>${stock}</p>--%>
<%--	</c:forEach>--%>


	<div class="sub-menubar-container" style="margin: 50px 0px 30px 0px; display: block; background-color: #FAFAFA; position: sticky; top: 130px">
		<div class="sub-menubar" style="padding: 0 55px">
			<div class="sub-item selected-sub-item" style="width: 130px; text-align: center">상품정보</div>
			<div class="sub-item" style="width: 130px; text-align: center">리뷰 <span class="count">23,222</span></div>
			<div class="sub-item" style="width: 130px; text-align: center">문의 <span class="count">4,402</span></div>
			<div class="sub-item" style="width: 130px; text-align: center">배송/환불</div>
		</div>
	</div>

	<div class="content flex-row">
		<div class="flex-col product-content">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/1.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/5.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/6.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/7.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/8.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/9.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/10.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/11.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/12.jpg">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/13.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/14.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/15.avif">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/16.webp">
			<img src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/17.webp">
		</div>

		<div style="flex: 1; padding: 0 40px;">
			<div class="flex-col" style="width: 100%; position: sticky; top: 205px; justify-content: space-between; height: 74vh;">
				<select class="form-control" style="border: 1px solid #DBDBDB; border-radius: 5px; height: 40px; padding: 0 20px">
					<option selected="" value="" disabled="">색상</option>

					<option value="0">투명 (PET) (25,600원)</option>
					<option value="1">**라탄/투명(PC) (48,900원)</option>
					<option value="2">**라탄/틴트브라운(PC) (48,900원)</option>
					<option value="3">크림 (PET) (25,600원)</option>
					<option value="4">투명민트 (PET) (25,600원)</option>
					<option value="5">다크블루 (PET) (25,600원)</option>
					<option value="6">투명브라운 (PET) (25,600원)</option>
					<option value="7">다크브라운 (PET) (25,600원)</option>
					<option value="8">투명핑크 (PET) (25,600원)</option>
				</select>

				<div class="flex-col">
					<div class="flex-row" style="justify-content: space-between">
						<div style="margin-bottom: 20px; font-weight: 600">주문금액</div>
						<div style="font-size: 20px; line-height: 28px; font-weight: 700">0원</div>
					</div>

					<div class="flex-row">
						<div class="bookmark-icon"><i class="bi bi-bookmark"></i></div>
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
	<%--let stockList = ${stockList};--%>
    <c:set var="productStocks" value="${stockList}" />

    let stockList = [
        <c:forEach items="${productStocks}" var="productStock" varStatus="status">{
            stockId: ${productStock.stockId},
            optionPrice: ${productStock.optionPrice},
            quantity: ${productStock.quantity},
            mainOptionId1: ${productStock.mainOptionId1},
            mainOptionId2: ${productStock.mainOptionId2},
            subOptionId1: ${productStock.subOptionId1},
            subOptionId2: ${productStock.subOptionId2},
            subOptionName1: '${productStock.subOptionName1}',
            subOptionName2: '${productStock.subOptionName2}',
            mainOptionName1: '${productStock.mainOptionName1}',
            mainOptionName2: '${productStock.mainOptionName2}',
            productId: ${productStock.productId}
        }<c:if test="${not status.last}">,</c:if>
        </c:forEach>
    ];



    // 처음 시작시 첫번째 옵션을 제외하고 하위옵션 선택 불가
    $(function () {
        disableExceptFirstOption();
    });

    function disableExceptFirstOption() {
        let notFirst = selectOptions.not(':first');
        for (const x of notFirst) {
            $(x).children().hide()
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
    }

    // 각 옵션 선택 리스너
    for (let i = 0; i < mainOptionCnt; i++) {
        selectOptions[i].addEventListener('change', function () {

            // 마지막 옵션을 선택한 경우
            if (i === mainOptionCnt-1) {
                console.log('옵션 모두 선택 완료!')

				let selectedOption = getSelectedOption();

                console.log(selectedOption)

                console.log('[0][0]' + selectedOption[0][0] + ' [1][0]' + selectedOption[1][0])

				let selectOptionInfo

				if (mainOptionCnt === 0) {
                    selectOptionInfo = stockList[0];
                } else if (mainOptionCnt === 1) {
                    stockList.find(function (item) {
                        selectOptionInfo = parseInt(item.subOptionId1) === parseInt(selectedOption[0][0]);
                    })
				} else if (mainOptionCnt === 2) {
                    selectOptionInfo = stockList.find(function (item) {
                        return parseInt(item.subOptionId1) === parseInt(selectedOption[0][0]) && parseInt(item.subOptionId2) === parseInt(selectedOption[1][0])
                    })
				}

                console.log(selectOptionInfo)
                addSelectedOption(selectOptionInfo)

                clearOptions();
				return
			}
			// 다음 메인옵션이 있는 경우

			let currentSubOptionId = $(this).val();

            let nextSubOptions = stockList.filter(function (stock) {
                return parseInt(stock.subOptionId1) === parseInt(currentSubOptionId) && parseInt(stock.quantity) !== 0
            });

            console.log('nextSubOptions : ' + nextSubOptions)

			let optionTag = `<option selected="" value="" disabled="">` + nextSubOptions[0].mainOptionName2 + `</option>`

            for (const nextSubOption of nextSubOptions) {
                optionTag +=
					`
						<option value="` + nextSubOption.subOptionId2 + `">` + nextSubOption.subOptionName2 + ` (` + nextSubOption.optionPrice + `원) </option>
					`
            }

            // $(selectOptions[i + 1]).children().show();
            $(selectOptions[i + 1]).html(optionTag).show()
        });
    }

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
						<div class="option-price-container"><span class="option-price">` + stock.optionPrice + `</span> 원</div>
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
            // console.log('stockId = ' + stockId + ' quantity = ' + quantity);
        }

        return result
    }



	// 장바구니
    $("#addCartBtn").click(function () {
        if (${empty sessionScope.sessionInfo}) {
            if (confirm("로그인이 필요한 서비스 입니다.\n로그인 페이지로 이동하시겠습니까?")) {
                $(location).attr('href', '${pageContext.request.contextPath}/login')
                return;
            } else {
                return;
            }
        }

        let msg = "상품을 장바구니에 저장합니다."

        if (!confirm(msg)) {
            return false;
        }

        let selectedOptions = getAllSelectedOptions();

        let productId = "${product.productId}";

        let data = {
            productId: productId,
			selectedOptions: selectedOptions
        }

        $.ajax({
            url: "${pageContext.request.contextPath}/seller/product/cart",
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
            }
        });

    });


</script>

<script>
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
</script>
</body>
</html>
