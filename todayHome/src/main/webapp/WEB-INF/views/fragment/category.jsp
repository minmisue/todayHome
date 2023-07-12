<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .main-category-icon-container {
        display: flex;
        flex-direction: row;
		transition: 0.2s;
    }

    .main-category-icon-container:hover {
        cursor: pointer;
    }

    .main-category-icon-container::-webkit-scrollbar {
        display: none;
    }

    .main-icon-item {
        text-align: center;
        height: 120px;
        width: 114px;
        flex-shrink: 0;
    }

    .category-icon-img {
        margin: 0 auto;
        width: 80px;
        height: 80px;
        object-fit: cover;
    }

    .category-icon-text {
        margin-top: 8px;
    }

    .category-container {
		position: relative;
        overflow-x: hidden;
    }

    .category-btn {
        background-color: white;
        width: 48px;
        height: 48px;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 50%;
    }
	
	.category-btn:hover {
        cursor: pointer;
    }

	.category-btn-container {
        position: absolute;
        display: flex;
        top: 0;
        width: 120px;
        height: 120px;
		align-items: center;
	}

    .category-right-btn-container {
        right: 0;
        justify-content: right;
        background: linear-gradient(to left, #ffffff 30%, rgba(255, 0, 0, 0));
        padding-right: 10px;

    }

    .category-left-btn-container {
        left: -5px;
        justify-content: left;
        background: linear-gradient(to right, #ffffff 10%, rgba(255, 0, 0, 0));
        padding-left: 10px;
    }
</style>


<div class="category-container">
	<div class="main-category-icon-container">
		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/category/store_home_categories/165698403420736265.png?w=144">
			<div class="category-icon-text">가구</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/108'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/6.webp">
			<div class="category-icon-text">데코·식물</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/2'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/7.webp">
			<div class="category-icon-text">조명</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/3'">
			<img class="category-icon-img" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/category/store_home_categories/168489250261646598.png?w=144">
			<div class="category-icon-text">가전·디지털</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/category/store_home_categories/165519431107541334.png?w=144">
			<div class="category-icon-text">패브릭</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/4.webp">
			<div class="category-icon-text">주방용품</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/5.webp">
			<div class="category-icon-text">식품</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/8.webp">
			<div class="category-icon-text">수납·정리</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/9.webp">
			<div class="category-icon-text">생활용품</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/30'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/10.webp">
			<div class="category-icon-text">생필품</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/11.webp">
			<div class="category-icon-text">유아·아동</div>
		</div>

		<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/category/1'">
			<img class="category-icon-img" src="${pageContext.request.contextPath}/resources/picture/shop/home/icon/category/12.webp">
			<div class="category-icon-text">반려동물</div>
		</div>
	</div>

	<div class="category-left-btn-container category-btn-container">
		<div id="category-left-btn" class="category-btn shadow-sm">
			<i class="bi bi-chevron-left"></i>
		</div>
	</div>

	<div class="category-right-btn-container category-btn-container">
		<div id="category-right-btn" class="category-btn shadow-sm">
			<i class="bi bi-chevron-right"></i>
		</div>
	</div>
</div>

<script>
    let $categoryLeft = $('#category-left-btn');
    let $categoryRight = $('#category-right-btn');
    let $categoryLeftContainer = $('.category-left-btn-container');
    let $categoryRightContainer = $('.category-right-btn-container');

    $(function () {
        $categoryLeftContainer.hide()
    });

    $categoryRight.click(function () {
        document.getElementsByClassName('main-category-icon-container')[0].style.transform = 'translateX(-25%)';
        $categoryRightContainer.hide()
        $categoryLeftContainer.show()
    });

    $categoryLeft.click(function () {
        document.getElementsByClassName('main-category-icon-container')[0].style.transform = 'translateX(0)';
        $categoryLeftContainer.hide()
        $categoryRightContainer.show()
    });
</script>


