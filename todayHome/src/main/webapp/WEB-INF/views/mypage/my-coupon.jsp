<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
	.row {
	    display: -webkit-box;
	    display: -webkit-flex;
	    display: -moz-flex;
	    display: -ms-flexbox;
	    display: flex;
	    -webkit-flex-wrap: wrap;
	    -moz-flex-wrap: wrap;
	    -ms-flex-wrap: wrap;
	    flex-wrap: wrap;
	    box-sizing: border-box;
	    margin-right: -10px;
	    margin-left: -10px;
	}
	
	.coupon-feed__divider {
    display: inline-block;
    width: 100%;
    height: 1px;
    background-color: rgba(0,0,0,.07);
	}
	
	.col-md-3 {
	    padding-right: 10px;
	    padding-left: 10px;
	}
	
	.coupon-item {
    position: relative;
    box-sizing: border-box;
    padding: 31px 20px 20px;
    margin-top: 10px;
    background-color: #fff;
    border: 1px solid #ededed;
    box-shadow: 0 2px 12px 0 #ededed;
    border-radius: 10px;
	}
	
	.coupon-item {
    margin: 20px 0 10px;
    padding: 35px 20px 20px;
	}
	
	.coupon-item__title {
    font-size: 24px;
    height: 56px;
    line-height: 28px;
	}
	
	.coupon-item__title {
    margin-bottom: 2px;
    cursor: pointer;
    font-weight: 700;
    color: #000;
    display: -webkit-box;
    text-overflow: ellipsis;
    -webkit-line-clamp: 2;
    word-wrap: break-word;
    -webkit-box-orient: vertical;
    overflow: hidden;
	}
	
	.coupon-item__valuation {
    margin: 16px 0;
	}
	.coupon-item__valuation-number {
    font-size: 55px;
	}
	.coupon-item__valuation-unit {
    margin-left: 4px;
    font-size: 15px;
    font-weight: 700;
    color: #000;
	}
	
	.coupon-item__status {
    width: 100%;
	}
	
	._27do9 {
    padding: 15px 10px;
    line-height: 20px;
    font-size: 17px;
    min-height: 50px;
	}
	
	._3SroY {
    background-color: #35c5f0;
    border-color: #35c5f0;
    color: #fff;
    border: 1px solid transparent;
	}	
	
	._3JCdF {
    background-color: #dadce0;
    border-color: #dadce0;
    color: #fff;
    border: 1px solid transparent;
	}	
	
	.coupon-feed__title {
    margin: 10px 0 40px;
    font-size: 32px;
    font-weight: 700;
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
        /* selectCurrentMenu(1, 1); */

        // 마이페이지일때 메뉴
        // 메인메뉴, 서브메뉴 숫자 입력
        // 첫번째 파라미터에 0 입력시 숨김
        /* selectMyPage(3,3); */
    });
    
    function coupon_send(couponId) {
    	const f = document.couponForm;
    	f.couponId.value = couponId;

    	f.action = '${pageContext.request.contextPath}/mypage/coupon?couponId='+f.couponId.value;
    	f.mothod = 'POST';
    	f.submit();
	}
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
			<div>
				<h1 class="coupon-feed__title">쿠폰</h1>
			</div>
			<div class="row">
			<c:forEach var="memberCoupons" items="${memberCoupon}" varStatus="status">
				<div class="col-md-3">
					<div class="coupon-item">
					<a style="color: inherit; text-decoration: none;" href="">
						<div class="coupon-item__title">${memberCoupons.name }</div>
					</a><div class="coupon-item__valuation">
					<span class="coupon-item__valuation-number">${memberCoupons.discountPercent}</span>
					<span class="coupon-item__valuation-unit">%</span>
					</div>
					<div class="coupon-item__info">
					</div>
					<button class="_1eWD8 _3JCdF _27do9 coupon-item__status coupon-item__status__pc" disabled type="button">받았음</button>
					</div>
				</div>
			</c:forEach>
			</div>
			<div class="coupon-feed__divider"></div>
			<div class="row">
			<c:forEach var="coupons" items="${coupon}" varStatus="status">
				<div class="col-md-3">
					<div class="coupon-item">
					<a style="color: inherit; text-decoration: none;" href="">
						<div class="coupon-item__title">${coupons.name }</div>
					</a><div class="coupon-item__valuation">
					<span class="coupon-item__valuation-number">${coupons.discountPercent}</span>
					<span class="coupon-item__valuation-unit">%</span>
					</div>
					<div class="coupon-item__info">
					</div>
					<button class="_1eWD8 _3SroY _27do9 coupon-item__status coupon-item__status__pc" type="button" onclick="coupon_send('${coupons.couponId}')">받기</button>
					</div>
				</div>
			</c:forEach>	
			</div>
		</div>
	</div>
	
	<form name="couponForm" method="post">
		<input type="hidden" name="couponId">
	</form>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
