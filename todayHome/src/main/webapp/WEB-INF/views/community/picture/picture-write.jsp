<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menubar.css">
	<title>Home</title>

	<style>
        .selected-sub-item {
            font-weight: bold;
            color: #303438;
            border-bottom: 2px solid #303438;
        }

		.follow-user-item-img:hover .picture-content-container {
            color: #A0A0A0;
        }

        .upload-img-container {
			width: 40%;
			aspect-ratio: 1/1;
			background-color: #F8F9FA;
			border-radius: 4px;
			justify-content: center;
			align-items: center;
        }

        .not-available-submit-btn {
            padding: 10px 45px;
            background-color: #EBEDEF;
            color: #C3C7CC;
            border-radius: 4px
        }

        .sub-menubar-write {
            justify-content: center;
            color: #848B93
        }
	</style>
</head>
<body>
<script>

</script>

<header>
	<div class="menubar-container">
		<div class="menubar-item-bundle" style="gap: 30px">
			<img class="logo" src="${pageContext.request.contextPath}/resources/picture/logo.png" onclick="location.href='${pageContext.request.contextPath}/home'">
		</div>

		<div class="menubar-item-bundle" style="gap: 18px">
			<div class="not-available-submit-btn">
				올리기
			</div>
		</div>
	</div>

	<div class="sub-menubar-container" style="display: block">
		<div class="sub-menubar sub-menubar-write">
			<div class="sub-item selected-sub-item" onclick="location.href='#'">사진</div>
			<div class="sub-item" onclick="location.href='#'">동영상</div>
		</div>
	</div>
</header>

<div class="main-container" >
	<div class="content" style="max-width: 970px">
		<div class="flex-row">
			<div class="flex-col upload-img-container">
				<img style="width: 25px; height: 25px" src="${pageContext.request.contextPath}/resources/picture/camera.png">
				<div style="font-weight: 700; color: rgb(130, 140, 148); margin-bottom: 4px; margin-top: 10px;">사진을 끌어다 놓으세요</div>
				<div style="font-size: 14px; font-weight: 500; color: rgb(130, 140, 148); margin-bottom: 15px;">10장까지 올릴 수 있어요.</div>
				<div>
					<button style="font-size: 14px; font-weight: 350; border-radius: 4px; padding: 8px 20px; border: none; background-color: rgb(53, 197, 240); color: white;">PC에서 불러오기</button>
				</div>
			</div>
			<div class="flex-col" style="flex: 1; padding-left: 20px;">
				<textarea style="font-size: 15px; padding: 10px 15px; border: 1px solid rgb(218, 221, 224); border-radius: 4px; min-height: 150px" placeholder="어떤 사진인지 짧은 소개로 시작해보세요."></textarea>
				<select style="margin-top: 15px; padding: 10px 15px; border: 1px solid rgb(218, 221, 224); border-radius: 4px; font-size: 15px">
					<option style="color: rgb(194, 200, 204)">공간 정보 추가</option>
					<option>원룸</option>
					<option>거실</option>
					<option>침실</option>
				</select>
			</div>
		</div>
	</div>
</div>

<script>

</script>
</body>
</html>
