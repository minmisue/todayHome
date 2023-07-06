<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>Home</title>

<style>
section {
	display: flex;
	justify-content: center;
	align-items: center;
	box-sizing: border-box;
	gap: 8%;
	height: 510px;
}

/*
		----------------
		  myinfo
		----------------
		*/
.myinfo-wrapper {
	position: sticky;
	top: 0;
	align-self: flex-start;
	min-width: 280px;
	padding: 10px 0;
}

.myinfo {
	padding: 30px 25px 18px;
	border: 1px solid #d7d7d7;
	border-radius: 5px;
	box-shadow: 0 0 8px -6px #000000;
}

.myinfo .myinfo-profile {
	position: relative;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	gap: 0px;
}

.myinfo .share-icon {
	position: absolute;
	top: -10px;
	right: -10px;
	cursor: pointer;
}

.myinfo .myinfo-profile .image-wrapper {
	width: 120px;
	height: 120px;
	margin-bottom: 20px;
}

.myinfo .myinfo-profile .image-wrapper img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.myinfo .myinfo-profile h2 {
	margin: 0;
	margin-bottom: 15px;
}

.myinfo .myinfo-profile .follow-wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 0;
	margin-bottom: 20px;
}

.myinfo .myinfo-profile .follow-wrapper dt, .myinfo .myinfo-profile .follow-wrapper dd
	{
	margin: 0;
	font-size: 13px;
	margin-right: 8px;
	line-height: 1;
}

.myinfo .myinfo-profile .follow-wrapper dt {
	color: #828C94;
}

.myinfo .myinfo-profile .follow-wrapper dd {
	color: #525B61;
	font-weight: 600;
}

.myinfo .myinfo-profile .follow-wrapper dd:nth-of-type(1)::after {
	display: inline-block;
	content: '';
	height: 10px;
	border-right: 1px solid #d1d1d1;
	margin-left: 8px;
}

.myinfo .myinfo-profile .follow-wrapper dd:nth-of-type(2) {
	margin-right: 0;
}

.myinfo .myinfo-profile .setting {
	background-color: #ffffff;
	color: #292929;
	font-size: 12px;
	padding: 7px 16px 8px;
	border: 1px solid #d1d1d1;
	border-radius: 4px;
	cursor: pointer;
}

.myinfo .myinfo-profile .setting:hover {
	opacity: .6;
}

.myinfo .line {
	border-bottom: 1px solid #d1d1d1;
	margin: 20px 0;
}

.myinfo .myinfo-history {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.myinfo .myinfo-history .myinfo-history-item {
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: center;
	cursor: pointer;
	gap: 5px;
}

.myinfo .myinfo-history .myinfo-history-item span {
	color: #424242;
	font-size: 13px;
}

.myinfo .myinfo-history .myinfo-history-item em {
	font-style: normal;
	font-weight: 600;
	color: #525B61;
}

.myinfo .myinfo-history .myinfo-history-scrap {
	
}

.myinfo-wrapper .reward-box {
	display: block;
	text-decoration: none;
	color: #3F474D;
	font-size: 14px;
	background-color: #EFFBFF;
	padding: 15px 0;
	border-radius: 5px;
	margin-top: 14px;
	text-align: center;
}

.myinfo-wrapper .reward-box strong {
	font-weight: 600;
	color: #35C5F0;
}

/*
		----------------
		  myinfo-list
		----------------
		*/
.myinfo-list {
	flex-grow: 1;
}

.myinfo-list .myinfo-list-pictures {
	margin-bottom: 100px;
}

.myinfo-list .myinfo-list-pictures .picture-header, .myinfo-list .myinfo-list-house .house-header
	{
	display: flex;
	justify-content: flex-start;
	align-items: center;
	margin-bottom: 10px;
}

.myinfo-list .myinfo-list-pictures .picture-header h2, .myinfo-list .myinfo-list-house .house-header h2
	{
	font-size: 18px;
	margin: 0;
	margin-right: 8px;
}

.myinfo-list .myinfo-list-pictures .picture-header strong, .myinfo-list .myinfo-list-house .house-header strong
	{
	color: #35C5F0;
	font-size: 18px;
}

.myinfo-list .myinfo-list-pictures .picture-list, .myinfo-list .myinfo-list-house .house-list
	{
	text-decoration: none;
	display: flex;
	justify-content: center;
	align-items: center;
	border: 1px dashed #d9d9d9;
	height: 180px;
	color: #757575;
	font-size: 13px;
	font-weight: 600;
}

.main-title {
	font-weight: 700;
	padding: 0px 16px;
	font-size: 20px;
	margin-bottom: 20px;
	line-height: 28px;
}

.content-container {
	padding-top: 0px;
	padding-bottom: 0px;
	transform: translateY(0px);
}

.news-item {
	position: relative;
	display: flex;
	-webkit-box-align: center;
	align-items: center;
	width: 100%;
	min-height: 80px;
	padding: 15px 16px;
	box-sizing: border-box;
	font-size: 14px;
	color: rgb(47, 52, 56);
	line-height: 20px;
}

.news-image {
	display: inline-block;
	margin-right: 10px;
	line-height: 0;
	text-decoration: none;
	color: inherit;
}

.news-image img {
	width: 30px;
	height: 30px;
	border-radius: 50%;
	width: 40px;
	height: 40px;
}

.nickname-link {
	width: 100%;
	display: flex;
	-webkit-box-pack: justify;
	justify-content: space-between;
	-webkit-box-align: center;
	align-items: center;
	text-decoration: none;
	font-weight: 700;
	color: #2F3438;
	margin-left: 8px
}

.news-date {
	font-size: 12px;
	line-height: 20px;
	color: gray;
}

.news-title {
	display: block;
	color: black;
}

.following-btn {
	border: solid 1px rgb(219, 219, 219);
	color: #757575;
	background-color: white;
}

.follow-btn {
	width: 60px;
	border-radius: 4px;
	padding: 5px 4px;
	margin: 0 0 0 10px;
	font-size: 14px;
}

.follower-data:hover {
	cursor: pointer;
}

.follower-btn {
	border: solid 1px #35C5F0;
	color: white;
	font-weight: 700;
	background-color: #35C5F0;
}
</style>
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
			selectMyPage(1, 1);
		});
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content" style="padding: 0 60px">
			<section>
				<div class="myinfo-wrapper">
					<div class="myinfo">
						<div class="myinfo-profile">
							<div class="share-icon">
								<i class="bi bi-share"></i>
							</div>
							<div class="image-wrapper">
								<img alt=""
									src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&w=144&h=144&c=c&webp=1">
							</div>
							<h2>${member.nickName }</h2>
							<dl class="follow-wrapper">

								<dt class="follower">팔로워</dt>
								<dd class="follower-data"
									onclick="location.href='${pageContext.request.contextPath}/mypage/${member.memberId }/follower'">${followerCount}</dd>
								<dt class="following">팔로잉</dt>
								<dd class="follower-data"
									onclick="location.href='${pageContext.request.contextPath}/mypage/${member.memberId }/followee'">${followeeCount}</dd>
							</dl>
							<button class="setting" type="button">설정</button>
						</div>

						<p class="line"></p>

						<div class="myinfo-history">
							<div class="myinfo-history-scrap myinfo-history-item">
								<i class="bi bi-bookmark-check"></i> <span>스크랩북</span> <em>9</em>
							</div>
							<div class="myinfo-history-like myinfo-history-item">
								<i class="bi bi-heart"></i> <span>좋아요</span> <em>1</em>
							</div>
							<div class="myinfo-history-coupon myinfo-history-item">
								<i class="bi bi-ticket"></i> <span>내 쿠폰</span> <em>0</em>
							</div>
						</div>
					</div>

					<a class="reward-box" href="#"> <b>취향 공유하고 </b><strong>리워드
							받기</strong>
					</a>
				</div>

				<div class="follower-list" style="flex: 1; height: 100%">

					<div
						style="margin: 20px 0; display: flex; flex-direction: column; justify-content: center'">
						<h1 class="main-title">팔로잉</h1>
						<div class="content-container">
							<c:forEach items="${followingList}" var="following" varStatus="status">
								<div class="news-item">
									<a class="news-image" href="#"> <img
										src="${pageContext.request.contextPath}/resources/picture/member/${following.fileImgName }">
									</a> 
									<a class="nickname-link" href="${pageContext.request.contextPath}/mypage/${following.followingId }">
										${following.followingNickname} 
									</a>
							
									<c:if test="${sessionScope.sessionInfo.memberId != following.followingId}">
   										<c:choose>
   									  	   <c:when test="${following.isFollow}">
         									   <button class='follow-btn following-btn' type="button" id="follow" onclick="followCheck(${status.index}, '${following.followingId}');">팔로잉</button>
      									   </c:when>
        								   <c:otherwise>
          									   <button class="follow-btn follower-btn" type="button" onclick="followCheck(${status.index}, '${following.followingId}');">팔로우</button>
       									   </c:otherwise>
   									  </c:choose>
									</c:if>
									
									
								</div>
							</c:forEach>

						</div>
					</div>

				</div>
			</section>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />

	<script>
		function followCheck(index, targetId) {
			
			let followBtn = document.getElementsByClassName('follow-btn')[index];
			
			if (${empty sessionScope.sessionInfo}) {
				location.href='${pageContext.request.contextPath}/login'
				return 
			}

			$.ajax({
				url : "${pageContext.request.contextPath}/mypage/${sessionScope.sessionInfo.memberId}/follow",
				type : 'POST',
				data : 'targetId=' + targetId,
				dataType : 'text',
				success : function(response) {
				
					if (response === 'true') {
						
						
							if (followBtn.classList.contains("follower-btn")) {
							 	followBtn.classList.remove("follower-btn");
							 	followBtn.classList.add("following-btn");
							 	followBtn.innerText = "팔로잉";
				            } else {
				            	followBtn.classList.remove("following-btn");
				            	followBtn.classList.add("follower-btn");
				            	followBtn.innerText = "팔로우";
				            }

						
						
					} else {
						if(response === 'login') {
							location.href='${pageContext.request.contextPath}/login'
							return
					
						}
					}
							
				},
				error : function(xhr, status, error) {
					// 요청이 실패했을 때 실행되는 코드
				}
			});  
		}
	</script>
</body>
</html>