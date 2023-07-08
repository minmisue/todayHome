<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>Home</title>

<style>
.set-alarm {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 15px;
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
	padding: 0 0 16px;
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
			selectMyPage(4,2);
		});
		
		function newpwd() {
			const f = document.passwordForm;
			
			let password = f.password.value;
			let newpassword = f.newpassword.value;
			
			if(password != newpassword){
				alert("패스워드가 일치하지않습니다. 다시입력해주세요.");
				f.password.focus();
				return false;
			}else if (!/^(?=.*[a-zA-Z])(?=.*\d).{8,}$/.test(password)) {
                alert("패스워드를 다시 입력 하세요. ");
                f.password.focus();
                return;
            }
			
			f.action = "${pageContext.request.contextPath}/mypage/${member.memberId}/pwd";
			f.submit();
		}
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content">
			<div style="max-width: 480px; margin: 0 auto">
			<form name="passwordForm" method="post">
				<div class="input_bundle">
					<h1 class="set-alarm">비밀번호 변경</h1>
					<span style="font-size: 15px; font-weight: bold;"> 새 비밀번호 </span>
					<p style="font-size: 15px"> 영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요. </p>
					<input type="password" name="password" class="form-control">
					<span style="font-size: 15px; font-weight: bold;"> 새 비밀번호 </span>
					<input type="password" name="newpassword" class="form-control">
					<button class="editPwd" type="button" onclick="newpwd();">비밀번호 변경</button>
				</div>
				<input type="hidden" name="memberId" value="${member.memberId}">
			</form>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
