<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>Home</title>

<style>
.set-alarm {
	font-size: 18px;
	font-weight: bold;
}

.coupon-alarm {
	font-size: 10px;
	color: #424242;
}


.input_bundle {
	border: 1px solid; 
	border-color: #dbdbdb; 
	padding: 20px; 
	margin-bottom: 20px;
}

.container-email {
	width: 100%; 
	display: flex; 
	justify-content: space-between; 
	padding:0 0 16px;
}

.container-sms {
	width: 100%; 
	display: flex; 
	justify-content: space-between; 
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
			selectMyPage(3,1);
		});
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content">
			<div style="max-width: 765px; margin: 0 auto">
				<h1 class="set-alarm">이벤트 및 혜택 알림</h1>
				<p class="coupon-alarm">특가, 쿠폰 등 이벤트 정보를 빠르게 알려드릴게요</p>
	
				<div class="input_bundle">			
					<div class="container-email" >
						<span class="span-email" style="font-size: 12px; ">이메일</span>
						<div class="form-check form-switch form-check-reverse">
							<input class="form-check-input" type="checkbox"	id="flexSwitchCheckReverse"> 
							<label class="form-check-label" for="flexSwitchCheckReverse"></label>
						</div>
					</div>
		
					<div class="container-sms">
						<span class="span-email" style="font-size: 12px;">문자 메시지</span>
						<div class="form-check form-switch form-check-reverse">
							<input class="form-check-input" type="checkbox"	id="flexSwitchCheckReverse"> 
							<label class="form-check-label" for="flexSwitchCheckReverse"></label>
						</div>
					</div>
				</div>	
				
				<span style="font-size: 10px; color: #828c94;"> 알림 수신 동의와 함께 개인정보 마케팅 활용에 동의하시게 됩니다. </span>		
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
