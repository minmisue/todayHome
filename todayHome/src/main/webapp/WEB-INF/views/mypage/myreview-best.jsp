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

.best {
	width: 120px;
	margin-left: 8px;
	display: inline-block;
	box-sizing: border-box;
	font-weight: 700;
	text-align: center;
	color: #35c5f0;
	cursor: pointer;
	padding: 7px 9px;
	background-color: #ffffff;
	border-color: #3fc5f0;
	border-style: solid;
	border-radius: 4px;
}

.fast {
	width: 120px;
	margin-left: 8px;
	display: inline-block;
	box-sizing: border-box;
	font-weight: 700;
	text-align: center;
	color: #dbdbdb;
	cursor: pointer;
	padding: 7px 9px;
	background-color: #ffffff;
	border-color: #dbdbdb;
	border-style: solid;
	border-radius: 4px;
}

.review-home-search-form-input {
	flex: 1;
	height: 40px;
	line-height: 40px;
	font-size: 15px;
}

.review-home-search-form-input::placeholder {
	color: #999;
}

.form-control {
	width: 900px;
	display: inline-block;
}

.product-content-flex {
	display: flex;
	align-items: center;
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
}

.review {
	font-size: 12px;
}

.review-home-search-form-wrap {
	align-items: center;
}

.flex-row{
	margin-bottom: 20px;
}
</style>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		const starIcons = document.querySelectorAll('.star-rating');

		starIcons.forEach(function(starIcon, index) {
			starIcon.addEventListener('click', function() {
				for (let i = 0; i <= index; i++) {
					starIcons[i].classList.add('filled');
				}
			});
		});
	});
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
				<button class="best"> 베스트순</button>
				<button class="fast" onclick="location.href='${pageContext.request.contextPath}/production-review/fast';"> 최신순</button>
					<div class="flex-col" style="margin-top: 30px; gap: 10px">
						<%
						for (int i = 0; i < 15; i++) {
						%>
						<div class="product-container flex-row"
							style="justify-content: space-between; width: 100%">
							<div class="flex-row" style="gap: 15px; align-items: center;">
								<div class="product-text-container">
									<div class="product-text subject">[루메나][오늘의딜]WARMER POT
										워머팟 미니 온풍기</div>
									<div class="product-text name">WARMER POT 코튼화이트</div>
									<div class="star-rating">
										<i class="fas fa-star"></i> 
										<i class="fas fa-star"></i> 
										<i class="fas fa-star"></i> 
										<i class="fas fa-star"></i> 
										<i class="fas fa-star-half-alt"></i>
										<span class="date"> 2023/06/12 | 오늘의집 리뷰</span>
									</div>
									<div class="product-text review">너무 좋아요.너무 하얘서 좋아요.따뜻해요</div>
								</div>
							</div>
	
							<div class="flex-col"
								style="padding-right: 5px; gap: 5px; justify-content: center; text-align: center">
								<div style="font-size: 14px">수정</div>
							</div>
						</div>
						<% } %>
					</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
