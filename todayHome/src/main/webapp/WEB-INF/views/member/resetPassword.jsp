<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>Home</title>

<style>
.confirm-btn, .codeOk-btn {
	position: absolute;
	right: 8px;
	top: 28px;
	border: none;
	border-radius: 4px;
	background-color: #62BDE5;
	color: white;
	font-size: 14px;
	padding: 4px 10px;
	font-weight: 500;
}

.confirm-btn:hover, .confirm-btn:hover {
	background-color: #4CA6D1;
}

.ep {
	padding: 13px 14px 15px;
	width: 280px;
	border: 1px solid #DBDBDB;
}

.password-top {
	border-radius: 4px 4px 0 0;
}

.password {
	border-radius: 0 0 4px 4px;
	border-top: none;
}

.login-btn {
	text-align: center;
	background-color: #35c5f0;
	padding: 15px 12px;
	font-size: 17px;
	border-color: #35c5f0;
	color: #fff;
	border-radius: 4px;
	font-weight: bold;
	margin-top: 18px;
	width: 100%;
	border: none;
}

.login-btn:hover {
	cursor: pointer;
	background-color: #4EABD7;
}

.form-row {
	align-items: center;
	margin-bottom: 10px;
}

.oh {
	margin: 50px auto;
	max-width: 300px;
	display: flex;
	align-items: center;
	flex-direction: column;
	box-sizing: border-box;
	padding: 40px 0px;
	position: relative;
	height: 80vh;
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
			selectCurrentMenu(1, null);

			// 마이페이지일때 메뉴
			// 메인메뉴, 서브메뉴 숫자 입력
		});

		function showVerificationField() {
			verificationField.style.display = "flex";
			let email = document.getElementById('email');
			$.ajax({
				url : "${pageContext.request.contextPath}/mail/send",
				type : 'POST',
				data : 'email=' + email.value,
				dataType : 'text',
				success : function(response) {

					

				},
				error : function(xhr, status, error) {
					// 요청이 실패했을 때 실행되는 코드
				}
			});

		}

		function confirmOk() {
			let button = document.getElementById("emailButton");
			let confirmBtn = document.getElementById('confirmBtn');
			let verificationField = document
					.getElementById("verificationField");

			let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			let email = document.getElementById('email');

			if (!email.value) {
				alert("이메일을 입력하세요.");
				return;

			} /* else if (! emailPattern.test(email)) {
			           	 alert( "유효한 이메일을 입력하세요.");
			             return;
			           } */

			$.ajax({
				url : "${pageContext.request.contextPath}/member/email-check",
				type : 'GET',
				data : 'email=' + email.value,
				dataType : 'text',
				success : function(response) {
					if (response === 'true') {
						$(button).attr('disabled', false);
						$(button).css('background-color', '#62BDE5')
						
						$('#email').attr('disabled', true);
						$(confirmBtn).attr('disabled', true);
						$(confirmBtn).css('background-color', '#C9E7F3')
						$(confirmBtn).text('확인완료');

					} else {
						alert("해당되는 이메일로 가입 된 아이디가 없습니다. 다시 입력해주세요.")

					}
				},
				error : function(xhr, status, error) {
					// 요청이 실패했을 때 실행되는 코드
				}
			});
		}
		function codeOk() {
			let verificationCode = document.getElementById('verificationCode');

			$.ajax({
				url : "${pageContext.request.contextPath}/mail/complete",
				type : 'POST',
				data : 'verificationCode=' + verificationCode.value,
				dataType : 'text',
				success : function(response) {
					if (response == 'true') {
						showResetForm();

					}

				},
				error : function(xhr, status, error) {
					// 요청이 실패했을 때 실행되는 코드
				}
			});

		}
		function showResetForm() {
			// 이메일 확인이 완료되면 실행되는 함수
			// 비밀번호 재설정 화면으로 변경

			// 이전 화면 요소 숨김
			document.getElementById("pre").style.display = "none";

			// 새로운 화면 요소 표시
			document.getElementById("resetPassword").style.display = "block";
		}
		
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />


	<div class="main-container">
		<div class="content">

			<div id="pre"
				style="width: 340px; margin: 0 auto; display: flex; flex-direction: column; padding-top: 50px;">
				<div style="text-align: center;">가입한 이메일 주소를 입력해주세요.</div>
				<div style="position: relative;">
					<input class="form-control" id="email"
						style="margin-top: 20px; height: 45px" name="email"
						placeholder="이메일">
					<button class="confirm-btn" id="confirmBtn" style="" type="button"
						onclick="confirmOk();">확인</button>

				</div>

				<button
					style="margin-top: 20px; border: none; padding: 13px 10px; background-color: #C9E7F3; color: white; font-weight: 700; border-radius: 4px"
					disabled="disabled" id=emailButton
					onclick="showVerificationField();" type="button">이메일로 인증코드
					받기</button>

				<div id="verificationField"
					style="position: relative; display: none;">
					<input class="form-control" type="text" id="verificationCode"
						placeholder="인증번호를 입력하세요" style="margin-top: 20px; height: 45px">
					<button class="codeOk-btn" style="" type="button"
						onclick="codeOk();">확인</button>
				</div>

				<div
					style="margin-top: 20px; background-color: #F0F1F3; text-align: center; font-size: 12px; padding: 20px 0;">
					회원가입 시 입력한 정보가 기억나지 않는다면?<br> <a href=""
						style="text-decoration: none; color: #62BDE5; font-weight: 600">고객
						센터 문의하기 (1670-0876)</a>
				</div>

			</div>
			<form class="oh" id='finalForm'
				action="${pageContext.request.contextPath}/resetPassword"
				method="POST">
				<div id="resetPassword" style="display: none;">
					<div class="form-row">
						<input class="ep password-top" type="password" id="newPassword"
							name="newPassword" placeholder="새 비밀번호" required><br>
						<input class="ep password" type="password" id="newPasswordConfirm"
							name="newPasswordConfirm"  placeholder="새 비밀번호 확인" required>
						<input type="hidden" id="finalEmail" name="finalEmail">
					</div>


					<button type="button" class="login-btn" onclick="passwordCheck();">비밀번호
						변경하기</button>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">


		function passwordCheck() {
			let newPassword = document.getElementById("newPassword");
			let newPasswordConfirm = document
					.getElementById("newPasswordConfirm");
			let email = document.getElementById("email");
			let finalEmail = document.getElementById("finalEmail");
			finalEmail.value = email.value;

			let finalForm = document.getElementById("finalForm");

			if (newPassword.value !== newPasswordConfirm.value) {
				alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요. ");
				return;
			}

			finalForm.submit();
		}
	</script>

</body>
</html>
