<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
	.state-title{
		font-weight: 700;
		font-size: 15px;
		color: #35c5f0;
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
				<div style="height: 230px;display: flex;flex-direction: column;" onclick="location.href='${pageContext.request.contextPath}/admin/event/detail'">
					<div style="width: 100%;height: 160px;overflow: hidden;border-radius: 10px"><img style="width: 100%; height: 100%; border-radius: 10px" class="item-img" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/admins/competitions/168413740686046232.jpg?gif=1&w=720&webp=1"> </div>
					<div style="padding: 20px 15px; display: flex;flex-direction: row;">
						<div class="state-title">진행중</div>
						<div class="state-date">23/06/01~23/06/30</div>
					</div>
				</div>

				<div style="height: 230px;display: flex;flex-direction: column;">
					<div style="width: 100%;height: 160px;overflow: hidden;border-radius: 10px"><img style="width: 100%; height: 100%; border-radius: 10px" class="item-img" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/admins/competitions/168413740686046232.jpg?gif=1&w=720&webp=1"> </div>
					<div style="padding: 20px 15px; display: flex;flex-direction: row;">
						<div class="state-title">진행중</div>
						<div class="state-date">23/06/01~23/06/30</div>
					</div>
				</div>
				
				
			</div>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/event/write'">등록하기</button>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
