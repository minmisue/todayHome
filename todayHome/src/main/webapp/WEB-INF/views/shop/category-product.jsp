<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
        .shop-banner {
            height: 380px;
        }

		.shop-banner img {

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
            grid-template-columns: repeat(3, 1fr);

            gap: 25px;

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
            margin-right: 5px;
        }

        .today-deal-price {
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
            /*padding: 0 5px;*/
        }

        .today-deal-img-container {
            width: 100%;
            aspect-ratio: 1/1;
            overflow: hidden;
            position: relative;
            border-radius: 5px;
        }

        .today-deal-product-container:hover {
            cursor: pointer;
        }

        .today-deal-product-container:hover .today-deal-product-name {
            color: #A0A0A0;
        }

        .grid-row {
            grid-auto-rows: 360px;
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

        .add-btn, .remove-btn, .edit-btn{
            /*font-size: 18px;*/
        }

        .add-btn {
            color: #6D90E0
        }

        .remove-btn {
            color: indianred;
        }

        .add-btn:hover, .remove-btn:hover, .edit-btn:hover{
            filter: brightness(80%);
            cursor: pointer;
        }

        .category {
            /*border: 1px solid black;*/
            padding: 5px 8px;
        }

        .category-name {
			font-size: 13px;
        }

		a {
			color: black;
			text-decoration: none;
		}

        .main-category {
			display: block;
            font-weight: 700;
            padding: 5px 15px;
            font-size: 23px;
        }
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(2, 2)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container" style="margin-top: 130px">

	<div class="flex-row content" style="margin-bottom: 100px;">
		<div class="side-bar" style="width: 500px">
			<div id="selectContainer" style="padding: 40px 30px">
				<a class="main-category" style="margin-bottom: 5px;" href="${pageContext.request.contextPath}/shop/category/${topLevelCategory.productCategoryId}">${topLevelCategory.categoryName}</a>

				<c:forEach items="${allCategories}" var="category">
					<div class="flex-row category" style="align-content: center; align-items: center">
						<c:forEach begin="1" step="1" end="${category.categoryLevel}">
							&nbsp;&nbsp;
						</c:forEach>
						<a style="display: block" class="category-name" href="${pageContext.request.contextPath}/shop/category/${category.productCategoryId}">${category.categoryName}</a>
<%--						<i class="bi bi-plus-square-fill add-btn" onclick="addCategory(this, 'add')"></i>--%>
<%--						<i class="bi bi-dash-square-fill remove-btn" onclick="addCategory(this, 'delete')"></i>--%>
<%--						<i class="bi bi-pencil-square edit-btn" onclick="addCategory(this, 'edit')"></i>--%>
						<input type="hidden" class="product-category-id" value="${category.productCategoryId}"/>
						<input type="hidden" class="category-level" value="${category.categoryLevel}"/>
					</div>
				</c:forEach>

				<hr>

				<c:forEach items="${categories}" var="category">
					<c:if test="${category.productCategoryId != topLevelCategory.productCategoryId}">
						<a class="main-category" href="${pageContext.request.contextPath}/shop/category/${category.productCategoryId}">${category.categoryName}</a>
					</c:if>
				</c:forEach>
			</div>

		</div>

		<div class="product-content">
			<div class="shop-banner">
				<img src="${pageContext.request.contextPath}/resources/picture/shop/home/banner/1.avif">
			</div>


			<div class="content" style="margin-top: 50px;">
				<div class="shop-main-label">상품</div>

				<c:if test="${productList.size() == 0}">
					<div class="flex- col" style="width: 100%; justify-content: center; text-align: center; gap: 10px; padding :70px 0">
						<img style="margin-top: 40px;" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/assets/163703569663018673.png" alt="장바구니가 비었습니다.">
						<div style="margin-top: 15px;">등록된 상품이 없습니다.</div>
					</div>
				</c:if>
				<div class="grid-col-4 grid-row">
					<c:forEach items="${productList}" var="product">
						<div class="flex-col today-deal-product-container"
							 onclick="location.href='${pageContext.request.contextPath}/product/${product.productId}'">
							<div class="today-deal-img-container">
								<img class="today-deal-product-img"
									 src="${pageContext.request.contextPath}/resources/picture/shop/product/product/${product.saveName}">
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
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>


<script>
	function addCategory(obj, type) {
		let selectedValue = $(obj).parent().find('.product-category-id').val();
		let categoryLevel = $(obj).parent().find('.category-level').val();
		let selectedName = $(obj).parent().find('.category-name').text();


		console.log(selectedValue)

		if (selectedValue === '' || selectedValue === null || typeof selectedValue === 'undefined') {
			selectedValue = null
			selectedName = '최상위 카테고리'
		} else {
			if (categoryLevel >= 4 && type === 'add') {
				alert('하위 카테고리의 깊이는 4 이하만 가능합니다.')
				return
			}
		}

		$('#parentCategoryName').text(selectedName)
		$('#parentCategoryId').val(selectedValue)
		$('#type').val(type)

		// 삭제라면 모달창 생략
		if (type === 'delete') {
			if (confirm('하위카테고리가 있거나 이 카테고리에 등록된 상품이 있다면 삭제할 수 없습니다.\n삭제를 진행하시겠습니까?')) {
				addCategoryAjax()
			}
			return;
		} else if (type === 'edit') {
			$('#modalLabel').text('카테고리 수정')
		}

		// alert(selectedValue + " " + selectedName)

		let inputModal = $('#categoryInputModal');

		let modal = new bootstrap.Modal(inputModal);
		modal.toggle()
	}

	function addCategoryAjax() {

		let categoryName = $('#categoryName').val();
		let parentCategoryId = $('#parentCategoryId').val();
		let type = $('#type').val();

		let query = 'categoryName=' + categoryName + '&parentCategoryId=' + parentCategoryId

		if (type === 'add') {
			if (parentCategoryId === null || parentCategoryId === '' || typeof parentCategoryId === 'undefined') {
				query = 'categoryName=' + categoryName
			}
		}

		$.ajax({
			url: "${pageContext.request.contextPath}/category/" + type,
			type: 'POST',
			data: query,
			dataType: 'text',
			success: function(response) {
				if (response === 'true') {
					alert('요청이 완료되었습니다.')
					location.reload();
				} else {
					alert('요청이 실패하였습니다.')
				}

			},
			error: function(xhr, status, error) {
				alert('요청이 실패하였습니다.')
			}
		});

	}

</script>
</body>
</html>
