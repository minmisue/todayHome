<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
.notification h2 {
  font-size: 24px;
}

.notification ul {
  padding: 0;
  
}

.notification ul li {
  list-style: none;
  padding: 26px 0;
  border-bottom: 1px solid #dbdbdb;
}

.notification ul li .notification_content {
  margin: 0;
  margin-bottom: 8px;
}

.notification ul li .notification_date {
  color: #828c94;
  font-size: 14px;
}

.notice_list:hover{
	color: #dbdbdb;
	cursor: pointer;
}

.content{
	padding: 0 290px;
}
	</style>
	
<script type="text/javascript">
$(function () {
	// 여기에서 메뉴 선택
    // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)	
    // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
	// 두번째 파라미터에 null 입력시 메뉴바 숨김
    selectCurrentMenu(0, null);

    // 마이페이지일때 메뉴
	// 메인메뉴, 서브메뉴 숫자 입력
	// 첫번째 파라미터에 0 입력시 숨김
	selectMyPage(2,4);
});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
		<div class="notification">
	    <h2>공지사항</h2>
	    <ul>
	    <c:forEach var="noticelist" items="${noticelist}" varStatus="status">
	      <li class="notice_list" value="${noticelist.noticeBoardId}" onclick="location.href='${pageContext.request.contextPath}/mypage/noticeaerticle?noticeBoardId=${noticelist.noticeBoardId}'">
	        <p class="notification_content">${noticelist.subject}</p>
	        <span class="notification_date">${noticelist.createdDate}</span>
	      </li>
	    </c:forEach>
	    </ul>
	  </div>
		</div>
	</div>
	
	

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
