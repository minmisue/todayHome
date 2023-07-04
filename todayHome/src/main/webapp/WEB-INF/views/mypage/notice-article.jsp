<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
	
	.customer-notice-detail__back {
    display: inline-block;
    background: none;
    font: inherit;
    display: block;
    width: 180px;
    margin: 0 auto;
    padding: 10px 0;
    font-size: 15px;
    line-height: 20px;
    text-align: center;
    font-weight: 700;
    background-color: #35c5f0;
    border: none;
    color: #fff;
    border-radius: 4px;
    transition: background-color .1s;
}

	</style>
	
<script type="text/javascript">
$(function () {
	// 여기에서 메뉴 선택
    // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)	
    // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
	// 두번째 파라미터에 null 입력시 메뉴바 숨김
    selectCurrentMenu(0, null);

    // 마이페이지일때 메뉴
	// 메인메뉴, 서브메뉴 숫자 입력
	// 첫번째 파라미터에 0 입력시 숨김
	selectMyPage(2,5);
});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
			<div>
				<h1>${noticedto.subject }</h1>
				<p>${noticedto.createdDate }</p>
				<div>${noticedto.content }</div>
				<button class="customer-notice-detail__back" onclick="location.href='${pageContext.request.contextPath}/mypage/notice'">목록으로 돌아가기</button>
			</div>
		</div>
	</div>
	
	

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
