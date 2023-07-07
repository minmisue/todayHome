<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
		button{
		    padding: 11px 10px;
		    font-size: 17px;
		    line-height: 26px;
		    background-color: #35c5f0;
		    border-color: #35c5f0;
		    color: #fff;
		    border: 1px solid transparent;
		    border-radius: 4px;
		    margin-top: 20;
		    font-weight: 700;
		}
		h4{
		    margin: 0 auto;
		    margin-top: 20px;
		    font-weight: 600;
		}
	</style>
</head>
<body>
<script>
$(function() {
	// 여기에서 메뉴 선택
	// 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
	// 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택, 서브메뉴는 첫번째 메뉴 선택시 자동으로 변경됨)
	// 0 이면 아무것도 하이리이팅 X
	// 두번째 파라미터에 null 입력시 서브메뉴 없앰
	selectCurrentMenu(0, null)
});
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content" style="height: 500"> 
		<div style="margin: 0 auto;display: flex;flex-direction: column;width: 200;">
			<img class="commerce-cart-empty__content__image" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/assets/163703569663018673.png" alt="장바구니가 비었습니다.">
			
			<h4>결제완료</h4>
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/shop/home'">상품 더 담으러가기</button>
		</div>
			
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
