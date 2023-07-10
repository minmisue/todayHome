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
    
    let nicknameValidateStatus = false;
    
    function sendOk() {
    	const f = document.memberForm;
    	let str;
    	
    	if (nicknameValidateStatus === false) {
            str = "닉네임 인증이 실행되지 않았습니다.";
            alert(str)
            return;
        }
    	
    	str = f.selectFileName.value;
    	if(! str){
    		alert("파일을 등록해주세요");
    		f.selectFileName.focus();
    		return false;
    	}
    	
    	f.action = "${pageContext.request.contextPath}/mypage/${sessionScope.sessionInfo.memberId}/edit";
    	f.submit();
	}
    
    function nickNameCheckOk() {

        let nickName = document.getElementById('nickName');

        let str = nickName.value;
        if (!str) {
            alert("닉네임을 입력하세요. ");
            nickName.focus();
            return;
        }

        if (!/^.{2,15}$/.test(str)) {
            alert("닉네임을 다시 입력하세요. ");
            nickName.focus();
            return;
        }

        $.ajax({
            url: "${pageContext.request.contextPath}/member/nickName-check",
            type: 'GET',
            data: 'nickName=' + nickName.value,
            dataType: 'text',
            success: function (response) {
                if (response === 'true') {
                    alert('이미 존재하는 닉네임 입니다.')
                } else {
                    alert('사용 가능한 닉네임 입니다.')
					nickName.readOnly = true;
                    nicknameValidateStatus = true;
                }
            },
            error: function (xhr, status, error) {
                // 요청이 실패했을 때 실행되는 코드
            }
        });
    }
    
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container">
	<div class="content">
		<div class="subject">
			<h4>회원정보 수정</h4>
		</div>
		<form method="post" name="memberForm" enctype="multipart/form-data">
			
			<div class="form-group">
			    <label for="nickname">별명</label>
			    <input type="text" id="nickName" name="nickName" required value="${member.nickName}">
			    <div class="required-text">* 필수항목</div>
			    <button class="nickName-certify" type="button" onclick="nickNameCheckOk();">
					닉네임 확인하기
				</button>
			</div>
			
			<div class="form-group">
				<label for="profile-image">프로필 이미지</label>
				<input type="file" id="selectFileName" name="selectFileName">
				${member.profileImgName}
			</div>
			
			<div class="form-group">
				<label for="bio">한줄 소개</label>
				<input type="text" id=info name="info" required value="${member.info}">
			</div>
			<button class="submit-button" type="button" onclick="sendOk();">회원 정보 수정</button>
			<input type="hidden" name="memberId" value="${member.memberId}">
			<input type="hidden" name="password" value="${member.password}">
		</form>
		${msg}
	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
