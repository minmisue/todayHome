<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
	.state-titleopen{
		font-weight: 700;
		font-size: 15px;
		color: #35c5f0;
	}
	.state-titleclose{
		font-weight: 700;
		font-size: 15px;
		color: #bdbdbd;
	}
	
	.state-date{
		font-size: 13px;
		color: #bdbdbd;
		text-align: right;
		margin-left: auto
	}
    .item-img:hover {
        cursor: pointer;
        transform: scale(1.05);
        transition: transform .2s;
     }	
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
		// 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
		// 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 5)
    });
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
			<div style="display: grid;grid-template-columns: repeat(2, 1fr);gap:10px; width:100%">
			<c:forEach var="eventlist" items="${eventlist}" varStatus="status">
				<div style="height: 230px;display: flex;flex-direction: column;" onclick="location.href='${pageContext.request.contextPath}/event/detail'">
					<div style="width: 100%;height: 160px;overflow: hidden;border-radius: 10px"><img style="width: 100%; height: 100%; border-radius: 10px" class="item-img" src="${pageContext.request.contextPath}/uploads/event/${eventlist.eventImg}"> </div>
					<div style="padding: 20px 15px; display: flex;flex-direction: row;">
						<div class="state-title${sysdate < eventlist.endDate ? 'open' : 'close'}">${sysdate < eventlist.endDate ? "진행중" : "종료"}</div>
						<div class="state-date">${eventlist.startDate}~${eventlist.endDate}</div>
					</div>
				</div>
			</c:forEach>
			</div>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/event/write'">등록하기</button>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
