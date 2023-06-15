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
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/4.avif">
				</div>

				<div class="preview-img-container">
					<img style="width: 100%; height: 100%"
						 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/5.webp">
				</div>
			</div>

			<div style="flex: 1">
				<img class="product-img"
					 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/1.jpg">
			</div>
		</div>

		<%-- 상품 옵션 및 버튼 --%>
		<div class="flex-col" style="margin-left: 35px">
			<div class="brand-name">영가구</div>
			<div class="product-name">[리뷰 23,000개] 베가 폴라 투명 접이식의자 17colors</div>
			<div class="rating">
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
				<i class="bi bi-star-fill"></i>
			</div>

			<div class="flex-col" style="margin-top: 8px">
				<div class="sale-percent">41%</div>
				<div class="flex-row" style="align-items: center; line-height: 30px">
					<div class="price">25,600</div>
					<div style="font-size: 24px">원</div>
				</div>
			</div>

			<div class="flex-row" style="padding: 20px 0; font-size: 14px">
				<div style="width: 42px; color: #828c94">배송</div>
				<div class="flex-col" style="flex: 1; gap: 5px">
					<div style="font-weight: 750;">무료배송</div>
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

			<div class="flex-row brand-home">
				<div><i class="bi bi-shop"></i> <span class="brand-home-name">테팔</span></div>
				<div class="brand-home-btn">브랜드 홈 <i class="bi bi-chevron-right"></i></div>
			</div>

			<select class="form-control" style="border: 1px solid #DBDBDB; border-radius: 5px; height: 40px; margin-top: 15px; margin-bottom: 30px; padding: 0 20px">
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

			<div class="flex-row" style="justify-content: space-between">
				<div style="margin-bottom: 20px; font-weight: 600">주문금액</div>
				<div style="font-size: 20px; line-height: 28px; font-weight: 700">0원</div>
			</div>

			<div class="flex-row" style="justify-content: space-between">
				<button class="cart-btn">장바구니</button>
				<button class="direct-purchase-btn">바로구매</button>
			</div>
		</div>
	</div>

	<div class="sub-menubar-container" style="margin-top: 50px; margin-bottom: 30px; display: block; background-color: #FAFAFA; position: sticky; top: 0">
		<div class="sub-menubar">
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
			<div class="flex-col" style="width: 100%; position: sticky; top: 80px; justify-content: space-between; height: 90vh;">
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
						<button class="cart-btn">장바구니</button>
						<button class="direct-purchase-btn">바로구매</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

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
