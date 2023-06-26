<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>

	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        // 두번째 파라미터에 null 입력시 메뉴바 숨김
        selectCurrentMenu(1, 1);

        // 마이페이지일때 메뉴
        // 메인메뉴, 서브메뉴 숫자 입력
        selectMyPage(3,3);
    });
</script>

	<div class="main-container">
		<div class="content">
 <div class="row justify-content-md-center mt-5">
            <div class="col-md-8">
                <div class="border border-primary mt-5 p-4">
                       <h4 class="text-center fw-bold">환영합니다!</h4>
                       <hr class="mt-4">
                       
	                <div class="d-grid p-3">
						<p class="text-center">김동규님의 판매자 신청이 완료되었습니다.</p>
	                </div>
                       
                       <div class="d-grid">
                           <button type="button" class="btn btn-lg btn-primary" onclick="location.href='${pageContext.request.contextPath}/';">메인화면 <i class="bi bi-check2"></i> </button>
                       </div>
                </div>

            </div>
        </div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
