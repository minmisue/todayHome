<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>MyNews</title>

<style>
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

.news-link {
	width: 100%;
	display: flex;
	-webkit-box-pack: justify;
	justify-content: space-between;
	-webkit-box-align: center;
	align-items: center;
	text-decoration: none;
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
.news-link:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<script>
		
	<%--
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 1)
    });
    --%>
		
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content">
			<div style="margin: 40px 108px;">
				<h1 class="main-title">내 소식</h1>
				<div class="content-container">

					<c:forEach items="${list }" var="notification">


						<div class="news-item">
							<a class="news-image"
								href="${pageContext.request.contextPath}${notification.profileUri }">
								<img
								src="${pageContext.request.contextPath}/resources/picture/member/${notification.profileImgName}">
							</a> <a class="news-link" onclick="isRead('${notification.notificationId}','${notification.bodyUri}');"
								style="text-decoration: none;"> <span class="news-title">${notification.nickName }${notification.msg }</span>
								<span class="news-date"> 
								<c:if test="${notification.regDate == 0}">
 								   오늘 
							    </c:if> 
 								<c:if test="${notification.regDate != 0}">
  								  ${notification.regDate}일
 								</c:if>
 								</span>
							</a>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
	<script type="text/javascript">
	function isRead(notificationId,bodyUri) {
		
		let isRead = document.getElementsByClassName('news-item');
		
		
		$.ajax({
			url : "${pageContext.request.contextPath}/notification/isRead",
			type : 'POST',
			data : 'notificationId=' + notificationId,
			dataType : 'text',
			success : function(response) {
				
			location.href='${pageContext.request.contextPath}'+bodyUri
			
			
			return;

		
			},
			error : function(xhr, status, error) {
				// 요청이 실패했을 때 실행되는 코드
			}
		});  
	} 
	
	
	</script>
</body>
</html>
