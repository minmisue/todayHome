<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
        .picture-content-grid {
			width: 100%;
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            grid-auto-rows: 480px;
            gap: 20px;
        }

        .picture-container {
            /*padding: 10px;*/
            width: 100%;
            height: 100%;
        }
		
		.picture-container:hover {
            cursor: pointer;
        }

        .picture-user-info-text {
            font-size: 13px;
            color: rgb(130, 140, 148);
			width: 200px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .follow-user-item-img {
            width: 100%;
            aspect-ratio: 1/1;
            border-radius: 10px;
            object-fit: cover;
			transition: 0.2s;
        }

        .follow-user-item-img:hover {
            transform: scale(1.05);
        }

        .picture-content-container:hover {
            color: #A0A0A0;
        }

        .picture-img-container {
			margin-top: 15px;
			overflow: hidden;
            border-radius: 10px;
        }

        .picture-img-info-container {
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
            width: 30px;
            height: 30px;
            border-radius: 50%;
        }

		.profile-img:hover {
            cursor: pointer;
			opacity: 0.5;
        }

        .picture-user-name:hover{
            cursor: pointer;
            opacity: 0.5;
        }

        .picture-user-name {
            font-weight: 700;
            font-size: 15px;
        }

		.picture-follow-btn {
			font-weight: 650;
			color: #35c5f0;
			font-size: 15px;
        }

        .picture-follow-btn::before {
            content: "·";
			color: black;
            margin: 0 2px 0 3px;
        }

        .picture-icon-container {
			/*width: 75px;*/
			font-size: 25px;
            margin-top: 15px;
			position: relative;
			color: #424242;
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
			gap: 5px;
        }

		.picture-icon-container:hover {
            cursor: pointer;
			color: #A0A0A0;
        }

        .icon-cnt {
            /*position: absolute;*/
			/*top: 3px;*/
			/*left: 55px;*/
			font-size: 13px;
        }

        .picture-content-container {
            margin-top: 20px;
            display: -webkit-box;
            overflow: hidden;
            font-size: 15px;
            color: #424242;
            width: 100%;
            text-overflow: ellipsis;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
        }
		
		.follow-user-item-img:hover .picture-content-container {
            color: #A0A0A0;
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
		
		.picture-follow-btn:hover {
            cursor: pointer;
			color: #B2E0F5;
        }
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 3)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container">

	<div class="content flex-row" style="gap: 5px">
		<select class="select-menu-item">
			<option>정렬</option>
		</select>

		<select class="select-menu-item">
			<option>동영상</option>
		</select>

		<select class="select-menu-item">
			<option>주거형태</option>
		</select>

		<select class="select-menu-item">
			<option>공간</option>
		</select>

		<select class="select-menu-item">
			<option>평수</option>
		</select>

		<select class="select-menu-item">
			<option>스타일</option>
		</select>

	</div>

	<div class="content" style="margin-top: 30px;">
		<div class="picture-content-grid">
			<c:forEach begin="0" end="15" step="1">
				<%-- 팔로우 컨테이너 --%>
				<div class="flex-col picture-container" onclick="location.href='${pageContext.request.contextPath}/community/picture/article'">
					<div class="flex-row picture-img-info-container">
						<div class="flex-row picture-img-info">
							<img class="profile-img"
								 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/168536494387982090.jpeg?gif=1&w=720&h=720&c=c&webp=1">
							<div class="flex-col" style="flex: 1">
								<div class="flex-row">
									<div class="picture-user-name">리빙유</div>
									<div class="picture-follow-btn">팔로우</div>
								</div>
								<div class="picture-user-info-text">우리 가족의 따뜻한 이야기 우리 가족의 따뜻한 이야기 우리 가족의 따뜻한 이야기</div>
							</div>
						</div>
					</div>

					<%-- 이미지 --%>
					<div class="picture-img-container">
						<img class="follow-user-item-img"
							 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/161866122047151511.jpeg?w=1440">
					</div>

					<div class="flex-row" style="justify-content: space-around">
						<div class="picture-icon-container">
							<i class="bi bi-heart"></i>
							<span class="icon-cnt">4</span>
						</div>
						<div class="picture-icon-container">
							<i class="bi bi-bookmark"></i>
							<span class="icon-cnt">16</span>
						</div>
						<div class="picture-icon-container">
							<i class="bi bi-chat"></i>
							<span class="icon-cnt">2</span>
						</div>
					</div>

					<div class="picture-content-container">
						비오는 날은 아파트 베란다 외부 창문과 방충망 청소하는 날~! 장마가 시작하기 전 비오는 날이면 외부 창문 청소를 해요. 이번에는 이틀동안 비가 와서 팬트리와 주방까지 모두 닦을 수 있었거든요~ 먼지와 얼룩을 제거해야 환기시킬 때 내부로 유입되는 먼지도 줄어 들고, 창문 너머로 보는 뷰도 더 깨끗하게 보이잖아요. 제가 집착하는 청소 중 하나예요. ㅋ
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
