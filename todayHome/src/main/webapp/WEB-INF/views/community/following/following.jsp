<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
        .following-grid::before {
            content: "";
            position: absolute;
            top: 25px;
            left: 50%;
            bottom: 20px;
            width: 1px;
            background: rgb(234, 235, 239);
        }

        .following-container {
            padding: 10px;
            width: 100%;
            height: 100%;
            justify-content: space-between;
        }

        .following-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            grid-auto-rows: 160px;
            gap: 20px;
            position: relative;
        }

        .follow-user-info-text {
            font-size: 13px;
            color: rgb(130, 140, 148);
            width: 280px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .follow-user-item-img {
            width: 100%;
            aspect-ratio: 1/1;
            border-radius: 10px;
            object-fit: cover;
        }
		
		.follow-user-item-img:hover {
            cursor: pointer;
        }

        .following-feed-btn {
            background-color: #65C2EC;
            width: 60%;
            margin: 50px auto 0 auto;
            color: white;
            height: 60px;
            font-weight: bold;
            font-style: inherit;
            border-radius: 5px;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 18px;
            position: relative;
            bottom: 0;
        }

        .following-feed-btn:hover {
            cursor: pointer;
            background-color: #4EABD7;
        }

        .following-feed-btn-container {
            background: linear-gradient(to top, #ffffff 20%, rgba(255, 0, 0, 0));
            position: sticky;
            bottom: 0;
            height: 130px;
            display: flex;
            justify-items: end
        }

        .check-cnt-circle {
            display: flex;
            background-color: white;
            width: 24px;
            height: 24px;
            color: #7DC0E8;
            border-radius: 50%;
            align-items: center;
            justify-content: center;
            margin-left: 5px
        }

        #check-cnt {
            font-size: 13px
        }

        .flex-check-default:checked {
            background-color: #65C2EC;
            border: none;
        }

        .follow-img-container {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 10px;
        }

        .follow-check-input {
            width: 22px;
            height: 22px;
        }
		
		.follow-check-input:hover {
            cursor: pointer;
        }

        .following-img-info-container {
            justify-content: space-between;
            align-items: center
        }

        .following-img-info {
            align-items: center;
            gap: 10px;
        }

        .profile-img {
            width: 30px;
            height: 30px;
            border-radius: 50%;
        }

        .follow-user-name {
            font-weight: 700;
            font-size: 15px;
        }

        .follow-check-container {
            width: 40px;
            padding-left: 35px;
        }

        .following-feed-container {
            background-color: #F7F8FA;
            border-radius: 5px;
            color: #848C93;
            padding: 60px
        }

        .following-feed-container-msg {
            margin: auto;
            text-align: center;
        }

        .follow-label-container {
            padding: 60px;
            justify-content: center;
            align-items: center;
        }

        .follow-label-main {
            font-size: 24px;
            font-weight: 700;
        }

        .follow-label-sub {
            margin-top: 16px;
            font-size: 14px;
            color: #2f3438;
        }

        .label-highlighting-color {
            color: #6D90E0;
        }
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 2)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container">
	<div class="content" style="padding: 0 240px;">
		<div class="following-feed-container">
			<div class="following-feed-container-msg">팔로잉 피드가 비어있어요.</div>
		</div>
	</div>

	<div class="content" style="padding: 0 240px;">
		<div class="flex-col follow-label-container">
			<div class="follow-label-main"><span class="label-highlighting-color">${member.nickName}</span>님을 위한 추천 유저</div>
			<div class="follow-label-sub">유저를 팔로우하고 새 소식을 확인하세요!</div>
		</div>
	</div>

	<div class="content" style="padding: 0 240px;">
		<div class="following-grid">
			<c:forEach begin="0" end="15" step="1">
				<%-- 팔로우 컨테이너 --%>
				<div class="flex-col following-container">
					<div class="flex-row following-img-info-container">
						<div class="flex-row following-img-info">
							<img class="profile-img"
								 src="${pageContext.request.contextPath}/resources/picture/shop/product-detail/chair/product/2.webp">
							<div class="flex-col">
								<div class="follow-user-name">리빙유</div>
								<div class="follow-user-info-text">우리 가족의 따뜻한 이야기 우리 가족의 따뜻한 이야기 우리 가족의 따뜻한 이야기</div>
							</div>
						</div>

						<div class="form-check follow-check-container">
							<input class="form-check-input follow-check-input flex-check-default" type="checkbox" value="">
						</div>
					</div>


					<%-- 이미지 4개 --%>
					<div class="follow-img-container">
						<img class="follow-user-item-img"
							 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/165465766092650606.jpg?gif=1&w=480">
						<img class="follow-user-item-img"
							 src="https://image.ohou.se/i/video-service-prd-s3-bucket-thumbnail/645b6756f5e132795a053610/645b6756f5e132795a053610.0000001.jpg?gif=1&w=480">
						<img class="follow-user-item-img"
							 src="https://image.ohou.se/i/video-service-prd-s3-bucket-thumbnail/64645b12f5e132795a053831/64645b12f5e132795a053831.0000001.jpg?gif=1&w=480">
						<img class="follow-user-item-img"
							 src="https://image.ohou.se/i/video-service-prd-s3-bucket-thumbnail/646afe0bf5e132795a053a45/646afe0bf5e132795a053a45.0000001.jpg?gif=1&w=480">
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="content following-feed-btn-container" style="padding: 0 240px;">
		<div class="following-feed-btn">팔로잉 피드 시작해보기
			<div class="check-cnt-circle">
				<div id="check-cnt"></div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

<script>
    let $follow = $('.follow-check-input');

    $follow.change(function () {
        let cnt = 0;
        for (const check of $follow) {
            if ($(check).is(':checked')) {
                cnt++;
            }
        }
        $('#check-cnt').text(cnt)
    });
</script>
</body>
</html>
