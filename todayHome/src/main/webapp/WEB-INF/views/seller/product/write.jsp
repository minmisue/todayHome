<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
	<style>
		.form-container {
			border: 1px solid black;
			padding: 20px;
			display: flex;
			flex-direction: column;
			gap: 5px;
		}

		.main-container {
            display: flex;
			flex-direction: column;
			width: 800px;
			margin: 100px auto;
        }

		h3 {
			margin-top: 30px;
		}

		input {
			padding: 10px;
		}

		#default input {
            margin-bottom: 10px;
		}
		
		.fa-trash-can:hover {
            cursor: pointer;
			color: #919191;
		}

        .fa-trash-can {
			margin-left: 8px;
            font-size: 23px
		}

		.form-object {
            width: 100%;
            display: flex;
            flex-direction: row;
            gap: 5px;
            justify-content: center;
            align-items: center;
        }

        .form-box {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-bottom: 10px;
            width: 100%;
        }

		button:hover {
            cursor: pointer;
		}
	</style>
</head>

<body>
<form class="main-container" action="${pageContext.request.contextPath}/form/join" method="post">
	<div style="width: 100%; text-align: center"><h1>회원 가입</h1></div>
	<h3>기본 입력 사항</h3>
	<div class="form-container" id="default">
		아이디 <input type="text" placeholder="아이디 입력" name="userId">
		패스워드 <input type="text" placeholder="패스워드 입력" name="userPwd">
		이름 <input type="text" placeholder="이름 입력" name="userName">
	</div>

	<h3>학력 사항</h3>
	<div class="form-container" >
		<div id="formContainer" class="form-box">
			<div class="form-object">
				<input style="flex: 1" type="text" name="schoolName" placeholder="학교명을 입력하세요.">
				<input style="flex: 1" type="date" name="schoolDate1">
				<input style="flex: 1" type="date" name="schoolDate2">
			</div>
		</div>
		<button type="button" id="addSchoolName" style="padding: 5px">추가</button>
	</div>

	<h3>자격증</h3>
	<div class="form-container" >
		<div id="qualificationsFormContainer" class="form-box">
			<div class="form-object">
				<input style="flex: 1" type="text" name="licenseName" placeholder="자격증 명을 입력하세요.">
				<input style="flex: 1" type="date" name="licenseDate">
			</div>
		</div>
		<button type="button" id="addQualificationBtn" style="padding: 5px">추가</button>
	</div>

	<button style="padding: 15px; margin-top: 30px">회원 가입</button>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    let addSchoolButton = document.getElementById('addSchoolName');
    let formContainer = document.getElementById('formContainer');

    let addQualificationBtn = document.getElementById('addQualificationBtn');
    let qualificationFormContainer = document.getElementById('qualificationsFormContainer');

    addSchoolButton.addEventListener('click', function () {
		// let tag = $('#formContainer').find(':first').clone()
		let tag =
			`
			<div class="form-object">
				<input style="flex: 1" type="text" name="schoolName" placeholder="학교명을 입력하세요.">
				<input style="flex: 1" type="date" name="schoolDate1">
				<input style="flex: 1" type="date" name="schoolDate2">
				<i class="fa-regular fa-trash-can" onclick="deleteObject(this)"></i>
			</div>
			`

        addBtn(tag, $('#formContainer'))
    });


    addQualificationBtn.addEventListener('click', function () {
        // let tag = $('#qualificationsFormContainer').find(':first').clone()
		let tag =
			`
			<div class="form-object">
				<input style="flex: 1" type="text" name="licenseName" placeholder="자격증 명을 입력하세요.">
				<input style="flex: 1" type="date" name="licenseDate">
				<i class="fa-regular fa-trash-can" onclick="deleteObject(this)"></i>
			</div>
			`

        addBtn(tag, $('#qualificationsFormContainer'))
    });

    function addBtn(tag, obj) {
        obj.append(tag)

        if (obj.children().length === 2) {
            obj.find(':first').append('<i class="fa-regular fa-trash-can" onclick="deleteObject(this)"></i>')
        }
    }

	function deleteObject(obj) {
        console.log('삭제')
        let formBox = $(obj).closest('.form-box')
        let cnt = formBox.children().length

        $(obj).parent().remove()

        if (cnt === 2) {
            formBox.find(':first').children('i').remove()
		}
	}
</script>
</body>
</html>
