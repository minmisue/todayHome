<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<style>
		body {
            background-color: #FAFAFA;
        }

        .logo {
            width: 300px;
            height: 70px;
            margin-bottom: 20px;
            object-fit: scale-down;
        }

        .ep {
            padding: 13px 14px 15px;
            width: 280px;
            border: 1px solid #DBDBDB;
        }

        .email {
            border-radius: 4px 4px 0 0;
        }

        .password {
            border-radius: 0 0 4px 4px;
            border-top: none;
        }

        .form-row {
            align-items: center;
            margin-bottom: 10px;
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



        .yeah {
            text-align: center;
            margin-top: 20px;
        }

        .oh {
            margin: 0px auto;
            max-width: 300px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            box-sizing: border-box;
            padding: 40px 0px;
            position: relative;
            height: 80vh;
        }

        .pr_, .mn_ {
            text-decoration: none;
            color: black;
            font-weight: 350;
        }

		.pr_ {
            margin-right: 10px;
		}


        .wow {
            margin-top: 30px;
            font-size: 13px;
            color: #757575;
        }

        .sns-img {
            width: 45px;
            height: 45px;
            border-radius: 20px;
        }

        .social {
            text-align: center;
            margin-top: 10px;
        }

        .yah {
            text-decoration: none;
            color: #c2c8cc;
        }

        .login-error {
            text-align: center;
            margin-top: 10px;
            font-size: 14px;
        }

        .good {
            width: 100%;
            color: #757575;
            font-size: 10px;
            line-height: 20px;
            margin: -5px 0 25px;
            text-align: center;
            bottom: 0;
            position: absolute;
        }

	</style>
</head>
<body>
<div class="oh">
	<img class="logo" src="${pageContext.request.contextPath}/resources/picture/social/home3.JPG">
	<form action="${pageContext.request.contextPath}/login" method="POST">
		<div class="form-row">
			<input class="ep email" type="text" id="email" name="email" placeholder="이메일" required><br>
			<input class="ep password" type="password" id="password" name="password" placeholder="비밀번호" required>
		</div>

<%--		????? --%>
<%--		<input class="login" type="submit" value="로그인">--%>
		<button class="login-btn">
			로그인
		</button>


		<div class="yeah">
			<a class="pr_" href="${pageContext.request.contextPath}/resetPasswordForm">비밀번호 재설정</a>
			<a class="mn_" href="${pageContext.request.contextPath}/join">회원가입</a>
		</div>
	</form>

	<div class="wow">
		SNS계정으로 간편 로그인/회원가입
		<div class="social">
			<img class="sns-img" src="${pageContext.request.contextPath}/resources/picture/social/kakaotalk.png">
		</div>

		<div class="login-error">
			<a class="yah" href="">로그인에 문제가 있으신가요?</a>
		</div>
	</div>

	<footer class="good">
		<div>
			bucketplace, Co., Ltd. ". ALL Rights Reserved"
		</div>
	</footer>

</div>
</body>
</html>
