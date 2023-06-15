<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.flex-row{
		display: flex;
		flex-direction: row;
	}

	.flex-col{
		display: flex;
		flex-direction: column;
	}


</style>
</head>
<body>

<div class="flex-row">
	<div>
		<img alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/1686126806_kakao_1955084745.jpg?gif=1&w=36&webp=1">
	</div>
	<div class="flex-col">
		<div>
			김민주1234
		</div>
		<div>
			댓글
		</div>
		<div>
			<span>5분전</span> <a>좋아요</a> <a>답글 달기</a> <a>신고</a> 
		</div>
	</div>
</div>

</body>
</html>