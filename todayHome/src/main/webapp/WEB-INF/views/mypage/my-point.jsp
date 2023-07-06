<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
	.css-1h25ori {
    padding: 24px 16px;
    border: 1px solid rgb(234, 237, 239);
    color: rgb(47, 52, 56);
    width: 100%;
    box-sizing: border-box;
    border-radius: 8px;
    text-align: center;
	}
	
	.css-o538wr {
    font-size: 24px;
    line-height: 32px;
    font-weight: 700;
	}	
	
	.css-of8h0b {
	    font-size: 24px;
	    line-height: 32px;
	    font-weight: 700;
	    color: rgb(53, 197, 240);
	    margin-top: 4px;
	}
	
	.css-1yu4f1z {
    max-width: 328px;
    text-align: center;
    margin: 16px auto 0px;
    padding: 9px 0px;
    background-color: rgb(247, 249, 250);
    border-radius: 4px;
	}
	
	.css-12fah4g {
    font-size: 14px;
    line-height: 18px;
    color: rgb(130, 140, 148);
	}
	
	.css-a4hf5k {
    margin-top: 40px;
    color: rgb(47, 52, 56);
	}
	
	.css-1066lcq {
    display: flex;
    -webkit-box-pack: justify;
    justify-content: space-between;
    -webkit-box-align: center;
    align-items: center;
	}
	
	.css-o538wr {
    font-size: 24px;
    line-height: 32px;
    font-weight: 700;
	}
	
	.css-1eaft1l {
    font-size: 14px;
    line-height: 18px;
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    background-color: inherit;
    border: 0px;
    padding: 7px;
	}
	
	.css-18ewygj {
    margin-top: 20px;
	}
	
	.css-oc7sge {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    border-top: 1px solid rgb(234, 237, 239);
    padding: 20px 10px;
	}
	
	.css-oc7sge > div {
    box-sizing: border-box;
	}
	
	.css-1kwo4sf {
    width: 100%;
    display: flex;
	}	
	
	.css-3eylin {
    font-size: 14px;
    line-height: 18px;
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    color: rgb(194, 200, 204);
	}
	
	.css-15jzb03 {
    width: 100%;
    margin-top: 0px;
    margin-left: 20px;
	}
	
	.css-s5xdrg {
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-align-items: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
	}
	
	.content{
	padding: 0 290px;
	}
	
	.css-lgp5e9blue {
    text-align: right;
    margin-left: 16px;
    font-size: 20px;
    line-height: 28px;
    font-weight: 700;
    flex-shrink: 0;
    color: rgb(53, 197, 240);
	}
	
	.css-lgp5e9red {
    text-align: right;
    margin-left: 16px;
    font-size: 20px;
    line-height: 28px;
    font-weight: 700;
    flex-shrink: 0;
    color: rgb(255, 119, 119);
	}
	
	.css-y3863iblue {
    background-color: rgb(239, 251, 255);
    color: rgb(53, 197, 240);
	}
	
	.css-y3863ired {
    background-color: rgb(239, 251, 255);
    color: rgb(255, 119, 119);
	}
	
	.css-1kzfo6n {
    font-size: 16px;
    line-height: 20px;
    margin-left: 8px;
    font-weight: 700;
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
			<div class="css-1h25ori">
				<div>
					<h2 class="css-o538wr">사용 가능한 포인트</h2>
					<c:choose>
						<c:when test="${not empty point.remainPoint}">
							<p class="css-of8h0b">${point.remainPoint} P</p>
						</c:when>
						<c:otherwise>
							<p class="css-of8h0b">0 P</p>
						</c:otherwise>
					</c:choose>
				</div>	
			</div>
			<div class="css-a4hf5k">
				<div class="css-1066lcq">
					<h2 class="css-o538wr">포인트 내역</h2>
					<button class="css-1eaft1l">오늘의집 포인트 사용 안내</button>
				</div>
				<div class="css-18ewygj">
				<c:forEach var="memberCoupon" items="${memberCoupon}" varStatus="status">
					<div class="css-oc7sge">
						<div class="css-1kwo4sf">
							<div class="css-3eylin">${memberCoupon.regDate }</div>
							<div class="css-15jzb03 e1rx7pum5">
								<div class="css-s5xdrg e1rx7pum4">
									<div class="css-y3863i${memberCoupon.status==1 ? 'blue':'red'}">${memberCoupon.status == 1 ? "적립" : "소멸" }</div>
									<h2 class="css-1kzfo6n">오늘의집 포인트</h2>
								</div>
							</div>
						</div>
						
						<div class="css-lgp5e9${memberCoupon.status==1 ? 'blue':'red'}">${memberCoupon.status == 1 ? '+':'-' } ${memberCoupon.amount }P</div>
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
