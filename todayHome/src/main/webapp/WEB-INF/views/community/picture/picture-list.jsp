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
		
		
				<c:forEach var="board" items="${listBoard}" varStatus="status">
				<%-- 팔로우 컨테이너 --%>
				<div class="flex-col picture-container" >
					<div class="flex-row picture-img-info-container">
						<div class="flex-row picture-img-info">
							<img class="profile-img"
								 src="${pageContext.request.contextPath}/resources/picture/member/${board.profileImgName}">
							<div class="flex-col" style="flex: 1">
								<div class="flex-row">
									<div class="picture-user-name">${board.nickname}</div>
									<div class="picture-follow-btn">팔로우</div>
								</div>
								<div class="picture-user-info-text">${board.info}</div>
							</div>
						</div>
					</div>

					<%-- 이미지 --%>
					<div class="picture-img-container">
							 <a href="${articleUrl}?userBoardId=${board.userBoardId}"><img class="follow-user-item-img"
							 src="${pageContext.request.contextPath}/resources/picture/house-picture/list/${board.imgName}"></a>
					</div>

					<div class="flex-row" style="justify-content: space-around">
						<div class="picture-icon-container">
							<i class="bi bi-heart"></i>
							<span class="icon-cnt">${board.boardLikeCount}</span> 
						</div>
						<div class="picture-icon-container">
							<i class="bi bi-bookmark"></i>
							<span  class="icon-cnt">${board.boardScrapCount}</span>
						</div>
						<div class="picture-icon-container">
							<i class="bi bi-chat"></i>
  							<span class="icon-cnt">${board.replyCount}</span>
						</div>
					</div>

					<div class="picture-content-container">
						${board.content}
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
