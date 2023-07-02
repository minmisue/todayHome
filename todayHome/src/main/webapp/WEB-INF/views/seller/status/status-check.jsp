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

</script>

	<div class="main-container">
		<div class="content">
 <div class="row justify-content-md-center mt-5">
            <div class="col-md-8">
                <div class="border border-primary mt-5 p-4">
                       <h4 class="text-center fw-bold">판매자 상태 확인</h4>
                       <hr class="mt-4">
                       
						<div class="d-grid p-3">
						  <p class="text-center" id="sellerStatus">
						    판매자님은 ${seller.status == 0 ? '대기' : seller.status == 1 ? '승인' : seller.status == 2 ? '거절' : '알 수 없는'} 상태 입니다.
						  </p>
						</div>

                       
                       <div class="d-grid">
                           <button type="button" class="btn btn-lg btn-primary" onclick="location.href='${pageContext.request.contextPath}/seller';">판매자화면 <i class="bi bi-check2"></i> </button>
                       </div>
                </div>

            </div>
        </div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
