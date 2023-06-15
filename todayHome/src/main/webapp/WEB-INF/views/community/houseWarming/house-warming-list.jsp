<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
        .picture-content-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-auto-rows: 360px;
            gap: 20px;
        }

        .picture-container {
            /*padding: 10px;*/
            width: 100%;
            height: 100%;
        }

        .picture-user-info-text {
            font-size: 17px;
            font-weight: 700;
            width: 350px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .follow-user-item-img {
            width: 100%;
            aspect-ratio: 3/2;
            border-radius: 10px;
            object-fit: cover;
            transition: 0.2s;
        }

        .follow-user-item-img:hover {
            cursor: pointer;
            transform: scale(1.05);
        }

        .picture-img-container {
            margin-top: 15px;
            overflow: hidden;
            border-radius: 10px;
			position: relative;
        }

        .picture-img-info-container {
            margin-top: 20px;
            width: 100%;
            justify-content: space-between;
            align-items: center
        }

        .picture-img-info {
            width: 100%;
            align-items: center;
            gap: 10px;
        }

        .profile-img {
            width: 20px;
            height: 20px;
            border-radius: 50%;
        }

        .picture-user-name {
            /*font-weight: 700;*/
            font-size: 14px;
			color: #424242;
        }

        .picture-icon-container {
            text-align: center;
            font-size: 25px;
            margin-top: 15px;
            position: absolute;
			right: 15px;
			bottom: 15px;
        }

        .picture-container:hover {
            cursor: pointer;
        }

        .select-menu-item {
            border: none;
            background-color: #F5F5F5;
            padding: 8px 10px;
            border-radius: 5px;
            font-weight: 700;
            color: #757575;
        }
		
		.select-menu-item:hover {
            cursor: pointer;
        }

        .house-warming-info {
			color: #757575;
			font-size: 13px;
			line-height: 17px;
			align-items: center;
        }

        .view-container::before {
            display: inline-block;
            content: "·";
            color: rgb(117, 117, 117);
            margin: 0 4px 0 4px;
        }

        .scrap-cnt, .view-cnt {
			margin-left: 3px;
        }

        .whole-cnt-container {
            color: #424242;
			line-height: 1;
			letter-spacing: -0.4px;
			font-size: 15px;
        }

        .bookmark-fill-icon {
            color: rgba(158,158,158,0.48);
        }

		.bookmark-icon {
            z-index: 1;
            color: white;
        }

		.bookmark-icon:hover {
            cursor: pointer;
			opacity: 0.5;
        }

        .bookmark-icon:hover .bookmark-fill-icon {
            opacity: 0.1;
        }

	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 4)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container">
	<div class="content flex-row" style="gap: 5px">
		<select class="select-menu-item">
			<option>정렬</option>
		</select>

		<select class="select-menu-item">
			<option>주거형태</option>
		</select>

		<select class="select-menu-item">
			<option>평수</option>
		</select>

		<select class="select-menu-item">
			<option>예산</option>
		</select>

		<select class="select-menu-item">
			<option>가족형태</option>
		</select>

		<select class="select-menu-item">
			<option>스타일</option>
		</select>

		<select class="select-menu-item">
			<option>컬러</option>
		</select>

		<select class="select-menu-item">
			<option>세부공사</option>
		</select>

		<select class="select-menu-item">
			<option>분야</option>
		</select>

		<select class="select-menu-item">
			<option>작업자</option>
		</select>
	</div>

	<div class="content" style="margin-top: 40px;">
		<div class="whole-cnt-container">전체 <span class="whole-cnt">8,424</span></div>
		<div class="picture-content-grid">
			<c:forEach begin="0" end="15" step="1">
				<%-- 팔로우 컨테이너 --%>
				<div class="flex-col picture-container">
					<%-- 이미지 --%>
					<div class="picture-img-container">
						<img class="follow-user-item-img"
							 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168430653838517576.png?w=1920&h=2560&c=c">

						<%-- 북마크 아이콘 --%>
						<div class="picture-icon-container bookmark-icon">
							<i class="bi bi-bookmark"></i>
						</div>

						<div class="picture-icon-container bookmark-fill-icon">
							<i class="bi bi-bookmark-fill"></i>
						</div>

					</div>

					<div class="flex-row picture-img-info-container">
						<div class="flex-col picture-img-info">
							<div class="picture-user-info-text">우리 가족의 따뜻한 이야기 우리 가족의 따뜻한 이야기 우리 가족의 따뜻한 이야기</div>

							<div class="flex-row" style="flex: 1; align-items: center; gap: 10px">
								<img class="profile-img"
									 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/2.webp">
								<div class="picture-user-name">리빙유</div>
							</div>

							<div class="flex-row" style="flex: 1; align-items: center;">
								<div class="house-warming-info flex-row">
									<div>스크랩</div>
									<div class="scrap-cnt">3</div>
								</div>

								<div class="house-warming-info view-container flex-row">
									<div>조회</div>
									<div class="view-cnt">11</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

<script>

</script>
</body>
</html>
