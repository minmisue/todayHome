<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
		.main-container {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
	
		.content {
			width: 1000px;
			padding: 20px;
			border: 1px solid #ccc;
			border-radius: 5px;
		}
		
		
		.subject{
			margin-bottom: 50px;
			margin-top: 50px;
		}
		
		.form-group {
			margin-bottom: 40px;
		}
	
		.form-group label {
			display: inline-block;
			width: 100px;
			margin-right: 10px;
			font-weight: bold;
			font-size: 15px;
		}
		
		.form-group .required-text {
			font-size: 12px;
			color: #999;
		}
	
		.form-group input[type="text"],
		.form-group input[type="email"],
		.form-group input[type="date"],
		.form-group input[type="file"],
		.form-group input[type="url"],
		.form-group textarea {
			width: 500px;
			padding: 8px;
			border: 1px solid #ccc;
			border-radius: 4px;
		}
	
		.form-group .email-input {
			display: flex;
			align-items: center;
			margin-top: 5px;
		}
	
		.form-group .email-input input[type="email"] {
			width: 240px;
			padding: 8px;
			border: 1px solid #ccc;
			border-radius: 4px;
			text-align: center;
		}
	
		.form-group .email-input span {
			margin: 0 10px;
			font-weight: bold;
		}
	
		.form-group .profile-image-preview {
			width: 150px;
			height: 150px;
			border-radius: 50%;
			overflow: hidden;
		}
	
		.form-group .profile-image-preview img {
			width: 100%;
			height: 100%;
			object-fit: cover;
			border-radius: 50%;
		}
	
		.submit-button {
			width: 300px;
			padding: 10px;
			background-color: #35c5f0;
			border: none;
			border-radius: 4px;
			color: #fff;
			font-weight: bold;
			cursor: pointer;
		}
		
	</style>
</head>
<body>
<script>
    $(function () {
	    	// 여기에서 메뉴 선택
	        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
	        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
			// 두번째 파라미터에 null 입력시 메뉴바 숨김
	        selectCurrentMenu(0, null);
	
	        // 마이페이지일때 메뉴
			// 메인메뉴, 서브메뉴 숫자 입력
			// 첫번째 파라미터에 0 입력시 숨김
			selectMyPage(4,1);
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container">
	<div class="content">
		<div class="subject">
			<h4>회원정보 수정</h4>
		</div>
		<form action="/update-member" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<div class="email-input">
				<label for="email">이메일</label>
					<input type="email" id="email" name="email" required>
					<span>@</span>
					<input type="email" id="email-domain" name="email-domain" required>
				</div>
				<div class="required-text">* 필수항목</div>
			</div>
			
			<div class="form-group">
			    <label for="nickname">별명</label>
			    <input type="text" id="nickname" name="nickname" required>
			    <div class="required-text">* 필수항목</div>
			</div>
			
			<div class="form-group">
				<label for="website">홈페이지</label>
				<input type="url" id="website" name="website">
			</div>
			<div class="form-group">
				<label>성별</label>
				<input type="radio" id="gender-male" name="gender" value="male">
				<label for="gender-male">남성</label>
				<input type="radio" id="gender-female" name="gender" value="female">
				<label for="gender-female">여성</label>
			</div>
			<div class="form-group">
				<label for="birthdate">생년월일</label>
				<input type="text" id="birthdate" name="birthdate" placeholder="https://ohou.se">
			</div>
			<div class="form-group">
				<label for="profile-image">프로필 이미지</label>
				<input type="file" id="profile-image" name="profile-image">
			</div>
			<div class="form-group">
				<label for="bio">한줄 소개</label>
				<input type="text" id="introduce" name="introduce" required>
			</div>
			<button class="submit-button" type="submit">회원 정보 수정</button>
		</form>

	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
