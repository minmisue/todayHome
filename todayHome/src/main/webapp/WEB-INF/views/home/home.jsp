<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
		.banner-card-img {
			width: 100%;
			height: 100%;
			object-fit: cover;
			transition: 0.2s;
			border-radius: 5px;
		}

		.img-container {
            border-radius: 5px;
		}

		.banner-card-img:hover {
			transform: scale(1.05);
            cursor: pointer;
        }
		
		.banner-card-container:hover {
            cursor: pointer;
		}

        .banner-user-img {
            width: 24px;
            height: 24px;
            object-fit: cover;
			border-radius: 50%;
			margin-right: 4px;
        }

        .banner-username {
			color: white;
			font-size: 16px;
			line-height: 20px;
        }

        .main-banner-text {
			color: white;
			font-size: 32px;
			line-height: 42px;
        }

        .main-banner-info {
            position: absolute;
            left: 30px;
            bottom: 30px;
        }

        .icon-img {
			margin: 0 auto;
			width: 88px;
			height: 76px;
			object-fit: cover;
        }

        .icon-text {
			margin-top: 8px;
        }

        .main-icon-item {
			text-align: center;
        }

        .main-icon-container {
            display: grid;
            grid-template-columns: repeat(10, 1fr);
        }
		
		.icon-img, .icon-text:hover {
            cursor: pointer;
		}

        .my-gap {
            margin-top: 25px;
        }

        .main-label {
			margin-top: 20px;
            font-size: 20px;
            font-weight: 700;
            margin-bottom: 20px;
        }

        .main-best-board-container {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 15px;
			height: 237px;
        }

		.main-best-board-container div {
            overflow: hidden;
            position: relative;
		}

        .main-best-board-container img {
            transition: 0.2s;
        }

		.main-best-board-container img:hover {
            transform: scale(1.05);
            cursor: pointer;
		}


        .more-view-btn {
            color: #65C2EC;
            font-weight: 700;
            margin-right: 7px;
            font-size: 15px;
            transition: opacity .1s;
        }

        .more-view-btn:hover {
            color: #B2E0F5;
            cursor: pointer;
        }

        .home-img-container {
            width: 100%;
            height: 180px;
            border-radius: 5px;
        }
	</style>
</head>
<body>
<script>
    $(function () {
        selectCurrentMenu(1,1)
    });
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content flex-row" style="height: 508px;">
			<div class="w-75" style="padding-right: 20px">
				<div class="w-100 h-100 img-container" style="overflow: hidden; position: relative">
					<img class="banner-card-img" src="${pageContext.request.contextPath}/resources/picture/main-banner.png">
					<div class="flex-col main-banner-info">
						<div class="fw-bolder fs-2 text-white main-banner-text">컬러감이 돋보이는 24평 홈스타일 반려동물과 함께</div>
						<div class="flex-row" style="align-items: center; margin-top: 8px">
							<img class="banner-user-img" src="${pageContext.request.contextPath}/resources/picture/park.jpeg">
							<div class="banner-username">kun</div>
						</div>
					</div>
				</div>
			</div>
			<div class="w-25">
				<div class="w-100 h-100 img-container" style="overflow: hidden;">
					<img class="banner-card-img" src="${pageContext.request.contextPath}/resources/picture/main-event1.png">
				</div>
			</div>
		</div>

		<div class="my-gap"></div>

		<div class="content main-icon-container">
			<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/home'">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/shop.png">
				<div class="icon-text">쇼핑하기</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/sale.png">
				<div class="icon-text">오! 세일</div>
			</div>

			<div class="main-icon-item flex-col" onclick="location.href='${pageContext.request.contextPath}/shop/today-deals'">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/today.png">
				<div class="icon-text">오늘의딜</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/like.png">
				<div class="icon-text">취향의발견</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/jang.png">
				<div class="icon-text">장보기</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/jip.png">
				<div class="icon-text">집들이</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/honey.png">
				<div class="icon-text">꿀잼시리즈</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/quick.png">
				<div class="icon-text">빠른배송</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/easy.png">
				<div class="icon-text">쉬운이사</div>
			</div>

			<div class="main-icon-item flex-col">
				<img class="icon-img" src="${pageContext.request.contextPath}/resources/picture/icon/remodel.png">
				<div class="icon-text">리모델링</div>
			</div>
		</div>

		<%-- 인기 집들이 게시글 --%>
		<div class="content" style="margin-top: 50px">
			<div class="flex-row" style="justify-content: space-between; align-items: center">
				<div class="main-label">🏡 이주의 인기 집들이 best 🏡</div>

				<%-- 클릭시 인기 집들이 탭으로 이동 --%>
				<div class="more-view-btn">더보기</div>
			</div>

			<div class="main-best-board-container">
				<div class="flex-col banner-card-container">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168412784958746261.jpg?w=360&h=180&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col banner-card-container">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://bucketplace-v2-development.s3.amazonaws.com/uploads/cards/projects/167661874383565334.jpg">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col banner-card-container">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168339197459485679.JPG?w=1280&h=850&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col banner-card-container">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168438306650616160.jpg?w=850&h=640&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>
			</div>
		</div>

		<%-- 유용한 살림 팁 --%>
		<div class="content " style="margin-top: 50px">
			<div class="flex-row" style="justify-content: space-between; align-items: center">
				<div class="main-label">저장 필수 🚩 유용한 살림팁</div>

				<%-- 클릭시 인기 집들이 탭으로 이동 --%>
				<div class="more-view-btn">더보기</div>
			</div>

			<div class="main-best-board-container">
				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/166246625944344065.JPG?w=850&h=640&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168438319689948709.jpg?w=850">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/projects/cover_images/162280293856900243.jpg?w=850&h=640&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://bucketplace-v2-development.s3.amazonaws.com/uploads/projects/cover_images/167469927873998349.png">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>
			</div>
		</div>


		<%-- 새로운 집들이 --%>
		<div class="content" style="margin-top: 50px">
			<div class="flex-row" style="justify-content: space-between; align-items: center">
				<div class="main-label">이번 주 나온 new 집들이 ✨</div>

				<%-- 클릭시 인기 집들이 탭으로 이동 --%>
				<div class="more-view-btn">더보기</div>
			</div>

			<div class="main-best-board-container">
				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/165936125893801169.jpg?w=640&h=360&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/projects/cover_images/159364806618945549.jpg?w=640&h=360&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://bucketplace-v2-development.s3.amazonaws.com/uploads/projects/cover_images/167161229182910445.png">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://bucketplace-v2-development.s3.amazonaws.com/uploads/cards/expert_reviews/168497804300036152.JPG">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>
			</div>
		</div>

		<div class="content" style="margin-top: 50px;">
			<div class="main-label">카테고리별 상품 찾기</div>
			<jsp:include page="/WEB-INF/views/fragment/category.jsp"/>
		</div>

		<%-- 새로운 집들이 --%>
		<div class="content" style="margin-top: 50px">
			<div class="flex-row" style="justify-content: space-between; align-items: center">
				<div class="main-label">홈카페, 세팅부터 관리까지! 💁‍♀️</div>

				<%-- 클릭시 인기 집들이 탭으로 이동 --%>
				<div class="more-view-btn">더보기</div>
			</div>

			<div class="main-best-board-container">
				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/168130872193819157.jpg?w=2560&h=2560&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/168308667455982722.png?w=2560&h=2560&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/projects/cover_images/165518609078536085.jpg?w=2560&h=2560&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>

				<div class="flex-col">
					<div class="home-img-container">
						<img style="width: 100%; height: 100%; object-fit: cover; border-radius: 5px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/projects/cover_images/168508161129572623.jpg?w=1920&h=2560&c=c">
					</div>

					<div style="font-weight: 700; color: #65C2EC; margin-top: 10px">수납공간 확실하게!</div>
					<div>동선을 고려한 30평대 신축 리모델링</div>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
