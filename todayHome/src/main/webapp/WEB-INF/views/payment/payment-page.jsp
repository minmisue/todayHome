<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>주문/결제</title>
<!-- 아임포트 -->
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<style>
.cart-img {
	width: 70px;
	height: 70px;
	border-radius: 5px;
}

.cart-img-container {
	width: 70px;
	height: 70px;
	border-radius: 5px;
}

.cart-item-container {
	width: 100%;
	background-color: white;
}

.follow-check-input {
	width: 22px;
	height: 22px;
	margin: 0;
}

.follow-check-input:hover {
	cursor: pointer;
}

.following-feed-btn-container {
	position: sticky;
	top: 100px;
}

.coupon-banner {
	justify-content: space-between;
	border: 1px solid #469DC9;
	border-radius: 5px;
	padding: 10px 16px;
	background-color: white;
	font-weight: 700;
	font-size: 14px;
	color: rgb(0, 159, 206);
	margin-bottom: 15px;
	align-items: center;
}

.quantity-btn {
	color: rgb(47, 52, 56);
	font-size: 20px
}

.quantity-btn:hover {
	cursor: pointer;
	color: #97999B;
}

.bi-x:hover {
	cursor: pointer;
	color: #C1C5C9;
}

.purchase-btn {
	width: 100%;
	padding: 15px 10px;
	background-color: #35c5f0;
	color: white;
	font-weight: 700;
	font-size: 17px;
	text-align: center;
	border-radius: 5px;
}

.purchase-btn:hover {
	cursor: pointer;
	background-color: #4EAAD6;
}

.flex-check-default:checked {
	background-color: #65C2EC;
	border: none;
}

.payment-obj-container {
	/*border: 1px solid black;*/
	margin-top: 50px;
}

.payment-obj-label {
	font-size: 20px;
	font-weight: bold;
}

.sub-label {
	gap: 10px;
	align-items: center;
	font-weight: 400;
	font-size: 12px;
	color: #424242;
}

.border-line {
	width: 100%;
	border-bottom: #F5F5F5 1px solid;
}

.form-grid {
	display: grid;
	grid-template-columns: 10% 35% 5% 35%;
	align-items: center;
}

.remain-point {
	color: rgb(53, 197, 240);
	font-size: 15px;
	font-weight: bold;
	margin-left: 5px;
}

.point-color {
	color: rgb(53, 197, 240);
	font-size: 15px;
	font-weight: bold;
	margin-left: 5px;
}

.payment-form-grid-input {
	border: 1px solid #DBDBDB;
	border-radius: 3px;
	padding: 5px 10px;
}

.payment-method-container {
	display: flex;
	flex-direction: column;
	height: 100%;
	aspect-ratio: 1/1.5;
	align-items: center;
	position: relative;
	box-sizing: border-box;
	text-align: center;
	background-color: rgb(255, 255, 255);
	border-width: 1px 1px 1px 0;
	padding: 15px 1px 15px 0px;
	border-right-color: rgb(234, 235, 239);
	border-bottom-color: rgb(234, 235, 239);
	border-top-color: rgb(234, 235, 239);
	border-right-style: solid;
	border-top-style: solid;
	border-bottom-style: solid;
	transition: background-color 0.2s ease 0s;
	word-break: keep-all;
	cursor: pointer;
}

.payment-method-bundle {
	display: flex;
	flex-wrap: wrap;
	/*border-top: 1px solid rgb(234, 235, 239);*/
	border-left: 1px solid rgb(234, 235, 239);
	height: 150px;

	/*style="margin-top: 20px; display: grid; grid-template-columns: repeat(7, 1fr); grid-auto-rows: ;*/
}

.payment-form-grid-input-label {
	font-size: 15px;
	color: rgb(117, 117, 117);
}

.delivery-cost-label {
	color: rgb(130, 140, 148);
	font-size: 14px;
}

.delivery-cost-container {
	font-size: 14px;
}

.payment-result-label {
	font-weight: 400;
	color: rgb(130, 140, 148);
}

.daum-postcode-btn{
    width: 85px;
    margin-right: 8px;
    font-size: 15px;
    background-color: #fff;
    border-color: #35c5f0;
    color: #35c5f0;
    font-weight: 700;
    border-radius: 4px;
    border: 1px solid #0dcaf0;
    padding: 6px;
    
}
.coupon-select-btn{
	background-color: #35c5f0;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 15;
    padding: 5 10;
}
</style>
</head>
<body>
	<script>
		$(function() {
			// 여기에서 메뉴 선택
			// 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
			// 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택, 서브메뉴는 첫번째 메뉴 선택시 자동으로 변경됨)
			// 0 이면 아무것도 하이리이팅 X
			// 두번째 파라미터에 null 입력시 서브메뉴 없앰
			selectCurrentMenu(0, null)
		});
		
			
		
		</script>
<script>

</script>
<script type="text/javascript">
function test() {
	
	const f = document.buyForm;
	let inputs = f.querySelectorAll("input[name=state]");
	let state = 1;

	for (let i = 0; i < inputs.length; i++) {
	  inputs[i].value = state;
	}
	
	let firstTel = $("#receive-tel-first-num").val();
	let secondTel = $("#receive-tel").val();
	
	let tel = firstTel+secondTel;
	
	$("input[name=tel]").val(tel);
	let reward = $("#reward").text().replace(/,/gi, "").trim();
	$("input[name=reward]").val(reward);
	$("input[name=payMethod]").val("카드");
	$("input[name=buyerName]").val("민주");
	$("input[name=buyerTel]").val("0101111");
	f.action = "${pageContext.request.contextPath}/payment/paymentOk";
	f.submit();
}

function usePoint() {
	let point = '${point.remainPoint}';
	$("#usePoint").val(point);
	usePointChange();
}


function usePointChange() {
	let point = $("#usePoint").val();
	if(point > '${point.remainPoint}'){
		alert('사용가능한 포인트는' + '${point.remainPoint}' +'P 입니다.');
		$("#usePoint").val(0);
		return;
	}
	$("#usedPoint").text(point);
	$('input[name="usedPoint"]').val(point);
	let remainPoint = ${point.remainPoint} - point;
	$('input[name="remainPoint"]').val(remainPoint);
	let price = $('#final-price').text().replace(/,/gi, "") - point;
	price  = Number(price);
	$('#final-price').html(price.toLocaleString());
	$('#final-tot-price').val(price);
	$('#finalTotPrice').html(price.toLocaleString());
	
}


</script>
<script type="text/javascript">
function iamport(){

    var buyerName = $("#buyer-name").val();
    var buyerTel = $("#buyerTelFirst").val() + $("#buyerTelSecond").val();
    var email = $("#email1").val() + "@" + $("#email2").val();
    var postNum = $("#postNum").val();
    var address = $("#address1").val() + " " + $("#address2").val();
    var price = $("#final-tot-price").val();
  	var name = "";
    $("input[name=productNames]").each(function(index,item) {
    	name += item.value ;
	});
    
    console.log(name);
    //가맹점 식별코드
    IMP.init("imp68385626");
    IMP.request_pay({
        pg : 'html5_inicis.INIpayTest',
        pay_method : 'card',
        merchant_uid : '${orderBundleId}',
        name : name,
        amount : 10,
        buyer_email : email,
        buyer_name : buyerName,
        buyer_tel : buyerTel,
        buyer_addr : address,
        buyer_postcode : postNum
    }, function(rsp) {
		console.log(rsp);
    	if(rsp.success){
    		console.log(rsp);
    		const f = document.buyForm;
    		let inputs = f.querySelectorAll("input[name=state]");
    		let state = 1;

    		for (let i = 0; i < inputs.length; i++) {
    		  inputs[i].value = state;
    		}
    		
    		let firstTel = $("#receive-tel-first-num").val();
    		let secondTel = $("#receive-tel").val();
    		
    		let tel = firstTel+secondTel;
    		
    		$("input[name=tel]").val(tel);
    		let reward = $("#reward").text().replace(/,/gi, "").trim();
    		$("input[name=reward]").val(reward);
    		$("input[name=payMethod]").val(rsp.pay_method);
    		$("input[name=buyerName]").val(buyerName);
    		$("input[name=buyerTel]").val(buyerTel);
    		if(f.defaultAddress.checked){
    			$('input[name=defaultAddress]').val('istrue');
    		}
    		f.action = "${pageContext.request.contextPath}/payment/paymentOk";
    		f.submit();

    	}
    });

}

$(function() {
	let email = '${member.email}';
	let index = email.indexOf('@');
	if(index!=-1){
		email = email.substr(0,index);
		$('#email1').val(email);
		$('#email1').attr("readonly",true);
		$('#email1').css("background-color","#ebebeb");
	}
});

function sendOk() {
	const f = document.buyForm;
	let firstTel = $("#receive-tel-first-num").val();
	let secondTel = $("#receive-tel").val();
	
	let tel = firstTel+secondTel;

	if(! f.name.value){
		alert('주문자의 이름을 입력해 주세요');
		return;
	}

	if(! f.buyerTelSecond.value){
		alert('주문자의 번호를 입력해 주세요');
		return;
	}
	
	if(! f.receiveName.value){
		alert('받는사람을 입력해주세요');
		return;
	}
	
	if(!$('#receive-tel').val()){
		alert('받는사람의 번호를 입력해주세요');
		return;
	}
	if(!f.postNum.value){
		alert('우편번호를 입력해주세요');
		return;
	}
	
	if(!f.address1.value){
		alert('주소를 입력해주세요');
		return;
	}
	if(!f.address2.value){
		alert('상세주소를 입력해주세요');
		return;
	}
	

}

$(function() {
	$("#orderDetailStateDialogModal").model("hide");
});

$(function(){
	$(".orderbasket-display").click(function(){
		
		$("#orderDetailStateDialogModal").modal("show");
	});
});

function couponSelectBtn(couponId,name,maxAmount,discountPercent) {
	$("#orderDetailStateDialogModal").modal("hide");
	$("input[name=couponId]").val(couponId);
	$("input[name=couponName]").val(name);
	let delivery = Number($("input[name=finalDeliveryCost]").val());
	
	let price = $('#totalPriceAmount').text().replace(/,/gi, "");
	let roundPrice =  Math.round(price * (discountPercent/100));
	if(roundPrice > maxAmount){
		$("#usedCoupon").html(maxAmount);
		$('#final-price').html((price-maxAmount+delivery).toLocaleString());
		$('#final-tot-price').val(price-maxAmount+delivery);
		$('#finalTotPrice').html((price-maxAmount+delivery).toLocaleString());

	} else{
		$("#usedCoupon").html(roundPrice);
		$('#final-price').html((price-roundPrice+delivery).toLocaleString());
		$('#final-tot-price').val(price-roundPrice+delivery);
		$('#finalTotPrice').html((price-roundPrice+delivery).toLocaleString());

	}
	
}


</script>
<!-- 장바구니 모달  -->
<div class="modal fade" id="orderDetailStateDialogModal" tabindex="-1" aria-labelledby="orderDetailStateDialogModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="orderDetailStateDialogModalLabel">장바구니쿠폰</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body pt-1">
				<div class="mt-1 p-1">
					<div class="p-1"><p class="form-control-plaintext optionDetail-value"></p></div>
					
					<table class="table board-list">
						<thead class="table-light">
							<tr>
								<td width="50">코드</td>
								<td width="150">쿠폰이름</td>
								<td width="100">할인퍼센트</td>
								<td width="120">최대할인금액</td>
								<td width="50"></td>
							</tr>
						</thead>
					<c:forEach var="coupon" items="${memberCoupon}">
							
							<tr>
								<td width="50">${coupon.couponId}</td>
								<td width="120">${coupon.name}</td>
								<td width="90">${coupon.discountPercent }</td>
								<td width="120">${coupon.maxDiscountAmount}원</td>
								<td><button type="button" class="coupon-select-btn" onclick="couponSelectBtn('${coupon.couponId}','${coupon.name }','${coupon.maxDiscountAmount }','${coupon.discountPercent }')">선택</button></td>
								
							</tr>							
						
					</c:forEach>
					</table>
				</div>
				
				
			</div>
		</div>
	</div>
</div>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />
	<form name="buyForm" method="post">
	<input type="hidden" name="payMethod" value="">
	<div class="main-container" style="margin-top: 110px;">
		<input type="hidden" name="orderBundleId" value="${orderBundleId}">
		<input type="hidden" name="memberId" value="${member.memberId}">
		 
		<!-- <input type="hidden" name="orderBundleId" value="${orderBundleId}">-->
		<div class="content flex-row">

			<div class="flex-col" style="width: 65%;">
				<div style="padding-top: 40px; font-size: 24px; font-weight: bold;">주문/결제</div>

				<div class="flex-col payment-obj-container">
					<div class="flex-row"
						style="align-items: center; justify-content: space-between; margin-bottom: 10px;">
						<div class="flex-row" style="align-items: center">
							<div class="payment-obj-label">배송지</div>
						</div>

					</div>

					<div class="border-line"></div>

					<div class="flex-row"
						style="gap: 5px; font-size: 18px; margin-top: 15px; align-items: center">
						<%-- 사용자 이름 --%>
						<div class="name" style="font-weight: bold; font-size: 18px">${member.nickName }</div>
						<div
							style="font-size: 12px; color: #65C2EC; font-weight: 700; border: 1px solid #65C2EC; padding: 0 8px; border-radius: 20px">기본배송지</div>
					</div>

					<%-- 사용자 주소 --%>


					<%-- 사용자 전화번호 --%>
					<div style="font-size: 15px; color: rgb(117, 117, 117)">
						<span class="name">${member.nickName }</span><span class="phone"
							style="margin-left: 10px;">${member.tel}</span>
					</div>
					<select
						style="margin-top: 15px; padding: 10px 15px; border-radius: 4px; border: 1px solid rgb(219, 219, 219)">
						<option>부재시 문앞에 놓아주세요</option>
						<option>기타 등등</option>
					</select>
				</div>

				<div class="flex-col payment-obj-container">
					<div class="flex-row"
						style="align-items: center; margin-bottom: 10px">
						<div class="payment-obj-label">주문자</div>
					</div>

					<div class="border-line"></div>

					<div class="flex-col" style="gap: 15px; margin-top: 20px">
						<div class="form-grid">
							<div class="payment-form-grid-input-label">이름</div>
							<input class="payment-form-grid-input" type="text" id="buyer-name" name="name">
							<input type="hidden" name="buyerName" value="">
						</div>

						<div class="form-grid">
							<div class="payment-form-grid-input-label">이메일</div>
							<input class="payment-form-grid-input" type="text" id="email1">
							<div style="text-align: center">@</div>
							<select class="payment-form-grid-input" id="email2">
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.com">daum.com</option>
								<option value="nate.com">nate.com</option>
							</select>
						</div>

						<div class="form-grid">
							<div class="payment-form-grid-input-label">휴대전화</div>
							<div style="display: grid; grid-template-columns: 35% 65%;">
								<div style="padding-right: 8px;">
									<select style="width: 100%" class="payment-form-grid-input" id="buyerTelFirst">
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="031">031</option>
										<option value="032">032</option>
										<option value="033">033</option>
									</select>
								</div>

								<input class="payment-form-grid-input" type="text" id="buyerTelSecond">
								<input type="hidden" name="buyerTel" value="">
							</div>
						</div>
					</div>
				</div>

				<div class="flex-col payment-obj-container">
					<div class="flex-row"
						style="align-items: center; margin-bottom: 10px">
						<div class="payment-obj-label">배송지</div>
						
					</div>

					<div class="border-line"></div>

					<div class="flex-col" style="gap: 15px; margin-top: 20px">
						<div class="form-grid">
							<div class="payment-form-grid-input-label">배송지명</div>
							<input class="payment-form-grid-input" type="text">

						</div>
						<div class="form-grid">
							<div class="payment-form-grid-input-label">받는사람</div>
							<input class="payment-form-grid-input" type="text" name="receiveName">
						</div>
						<div class="form-grid">
							<div class="payment-form-grid-input-label">휴대전화</div>
							<div style="display: grid; grid-template-columns: 35% 65%;">
								<div style="padding-right: 8px;">
									<select style="width: 100%" class="payment-form-grid-input" id="receive-tel-first-num">
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="031">031</option>
										<option value="032">032</option>
										<option value="033">033</option>
									</select>
									
								</div>
								<input class="payment-form-grid-input" type="text" id="receive-tel">
								<input type="hidden" name="tel">
							</div>

						</div>

						<div class="form-grid">
							<div class="payment-form-grid-input-label">주소</div>
							<div class="flex-col" style="gap: 15px;">
								<div class="flex-row">
									<div><button type="button" onclick="daumPostcode()" class="daum-postcode-btn">주소찾기</button></div>
									<div><input type="text" name="postNum" id="postNum" class="payment-form-grid-input" style="width: 163;"></div>
								</div>
								<div><input type="text" name="address1" id="address1" class="payment-form-grid-input" style="width: 554"></div>
								<div><input type="text" name="address2" id="address2" class="payment-form-grid-input" style="width: 554" placeholder="상세주소"></div>
								<div style="font-size: 15px;"><input class="form-check-input follow-check-input flex-check-default" type="checkbox" value="isNottrue" style="margin-right: 10px;" name="defaultAddress">기본 배송지로 설정하기</div>
							</div>
						</div>
					</div>
				</div>


				<div class="flex-col payment-obj-container">
					<div class="flex-row"
						style="align-items: center; margin-bottom: 10px">
						<div class="payment-obj-label">주문상품</div>
						<div style="margin-left: 10px;">
							<span></span>
							
								${fn:length(cartList)}
							
							
							건</div>
					</div>

					<div class="border-line" style=""></div>
					<%-- 상품 컨테이너 --%>
					<c:forEach var="cart" items="${cartList}" varStatus="status">
						<c:set var="finalPrice" value="0"></c:set>
						<c:set var="originalPrice" value="0"></c:set>
						<c:set var="deliveryCost" value="0"></c:set>
						<!-- 상품아이디, 상품이름 -->
						<input type="hidden" name="productNums" value="${cart.productId}">
						<input type="hidden" name="productNames" value="${cart.productName}">
						<input type="hidden" name="sellerNums" value="${cart.sellerId}">
						<!-- 할인율 -->
						<fmt:parseNumber var= "disCountPercent" integerOnly= "true" value= "${cart.discountPercent}" />
						<input type="hidden" name="disCountPercent" value="${disCountPercent}">
						<!-- 결제완료후 장바구니 비우기위한 input -->
						<c:if test="${mode != 'buyNow' }">
							<input type="hidden" name="cartIdList" value="${cart.cartId}">
						</c:if>
						<!-- 상태값 -->
						<input type="hidden" name="state">
						<c:forEach var="productStock" items="${cart.productStockList}">
							<input type="hidden" name="gubun" value="${status.index}">
							<input type="hidden" name="stockNums" value="${productStock.stockId}">
							<div class="flex-col"
								style="border: 1px solid #EAEBEF; border-radius: 5px; margin-top: 20px;">
								<div class="flex-row"
									style="justify-content: space-between; align-items: center; border-bottom: #F5F5F5 2px solid; padding: 10px 20px; font-size: 15px; font-weight: 500; background-color: #F7F8FA">
									<div>${cart.brandName }</div>
									<div class="delivery-cost-container">
										<span class="delivery-cost-label">배송비</span> <span
											class="delivery-cost-value-container"><span
											class="delivery-cost-value">${cart.deliveryCost }</span>원</span>
									</div>
								</div>

								<div class="flex-row" style="gap: 20px; padding: 20px">
									<div class="flex-col" style="gap: 10px; width: 100%">
										<div class="flex-row" style="gap: 15px">
											<div class="cart-img-container">
												<c:if test="${mode != 'buyNow' }">
													<img class="cart-img"
														src="${pageContext.request.contextPath}/resources/picture/shop/product/product/${cart.saveName}">
												</c:if>
												<c:if test="${mode == 'buyNow' }">
													<img class="cart-img"
														src="${pageContext.request.contextPath}/resources/picture/shop/product/product/${cart.productImgList[0].saveName}">
												</c:if>

											</div>
											<div class="flex-col" style="flex: 1; gap: 8px">
												<div
													style="font-size: 15px; font-weight: 500; line-height: 21px; overflow-wrap: break-word; transition: opacity 0.1s">${cart.productName}</div>
												<div>
													<div class="flex-row"
														style="font-size: 14px; line-height: 15px; color: #757575; gap: 5px">
														<div>${productStock.mainOptionName1 }:
															${productStock.subOptionName1 } /
															${productStock.mainOptionName2 }:
															${productStock.subOptionName2 }</div>
														<!-- 상품 할인율 계산한 가격 -->
														<c:set var="productPrice"
															value="${productStock.price*((cart.discountPercent)/100)*productStock.cartQuantity}"></c:set>
														<fmt:parseNumber var= "price" integerOnly= "true" value= "${productStock.price}" />
														<!-- 상품 원래가격 -->
														<input type="hidden" name="price" value="${price}">
													</div>
													<div class="flex-row"
														style="font-size: 11px; line-height: 15px; color: #757575; gap: 5px; align-items: center">
														<div
															style="line-height: 20px; font-weight: 700; font-size: 16px; color: black">
															<span><fmt:formatNumber value="${productPrice}" /></span>원
															<c:set var="finalPrice" value="${finalPrice+ productPrice}"></c:set>
							                               	<c:set var="originalPrice" value="${originalPrice + productStock.price*productStock.cartQuantity}"></c:set>
							                                <input type="hidden" name="quantityList" value="${productStock.cartQuantity}">
														</div>
														<div>|</div>
														<div>${productStock.cartQuantity}개</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 총상품 원래가격 -->
							<c:set var="orignalTotPrice"
								value="${orignalTotPrice + productStock.price*productStock.cartQuantity}"></c:set>
							
							<!-- 총상품 가격 -->
							<c:set var="totPrice" value="${totPrice + productPrice}"></c:set>
							
							<!-- 상품당 배달비 -->
							<c:set var = "deliveryCost"	value="${deliveryCost+ cart.deliveryCost}"/>
							<fmt:parseNumber var= "deliveryCosts" integerOnly= "true" value= "${deliveryCost}" />
							<input type="hidden"  name="deliveryCostList" value="${deliveryCosts}">
							
						<c:set var="totDeliveryCost"
							value="${totDeliveryCost + cart.deliveryCost}" />
						</c:forEach>
						
						<fmt:parseNumber var= "finalPrice" integerOnly= "true" value= "${finalPrice}" />
						<input type="hidden" name="finalPrices" value="${finalPrice}">
						
						<fmt:parseNumber var= "originalPrice" integerOnly= "true" value= "${originalPrice}" />
 						<input type="hidden" name="originalPrices" value="${originalPrice}">
					</c:forEach>
						<!-- 총 할인금액 -->
						<c:set var="totDisCountPrice"
							value="${orignalTotPrice - totPrice}"></c:set>

			
						<fmt:parseNumber var= "finalDiscountPrice" integerOnly= "true" value= "${totDisCountPrice}" />
						<input type="hidden" name="finalDiscountPrice" value="${finalDiscountPrice}">


				</div>
				<c:if test="${mode == 'buy' }">
				<div class="flex-col payment-obj-container">
					<div class="flex-row"
						style="align-items: center; justify-content: space-between; margin-bottom: 10px;">
						<div class="flex-row" style="align-items: center">
							<div class="payment-obj-label">장바구니 쿠폰</div>
						</div>
					</div>

					<div class="border-line"></div>

					<div class="flex-col"
						style="gap: 5px; font-size: 16px; margin-top: 15px; background-color: #F7F8FA">
						<div class="flex-col">

							<div class="flex-row" style="margin-top: 20px">
								<input
									style="border-radius: 4px; border: 1px solid #DBDBDB; width: 250px"
									type="text" name="couponName" value="">
								<input type="hidden" name="couponId" value="">
								<div
									style="background-color: #65C2EC; padding: 8px 15px; border-radius: 4px; color: white; margin-left: 10px" class="orderbasket-display">쿠폰확인하러가기</div>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<div class="flex-col payment-obj-container">
					<div class="flex-row" style="align-items: center">
						<div class="payment-obj-label">포인트</div>
					</div>

					<div class="border-line" style="margin-top: 15px;"></div>


					<div class="flex-col">
						<div class="flex-row" style="margin-top: 20px">
							<input
								style="border-radius: 4px; border: 1px solid #DBDBDB; width: 250px"
								type="text" id="usePoint" onchange="usePointChange()">
							<div
								style="padding: 8px 15px; border-radius: 4px; color: #65C2EC; border: 1px solid #65C2EC; margin-left: 10px; cursor: pointer;" onclick="usePoint()">전액사용</div>
						</div>
						<div style="margin-top: 10px; font-size: 15px">
							사용 가능 포인트 <span class="remain-point">${point.remainPoint}</span><span
								class="point-color">P</span>
						</div>
					</div>
				</div>


			</div>

			<div style="flex: 1; padding-left: 40px; margin-top: 40px">
				<div class="flex-col following-feed-btn-container"
					style="padding-top: 20px;">
					<div
						style="width: 100%; border: 1px solid #EAEAEE; border-radius: 6px;">
						<div class="flex-col"
							style="width: 100%; padding: 30px 20px; gap: 10px">
							<div
								style="font-size: 20px; margin-bottom: 20px; font-weight: bold;">결제금액</div>

							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 400;">
								<div class="payment-result-label">총 상품 금액</div>
								<div style="font-weight: 700;">
									<span id="totalPriceAmount"><fmt:formatNumber value="${totPrice}" /></span>원
								</div>
							</div>

							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242">
								<div class="payment-result-label">배송비</div>
								<div>
									<span><fmt:formatNumber value="${totDeliveryCost}" /></span>원
									<fmt:parseNumber var= "finalDeliveryCost" integerOnly= "true" value= "${totDeliveryCost}" />
									<input type="hidden" name="finalDeliveryCost"  value="${finalDeliveryCost}">
								</div>
							</div>

							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242">
								<div class="payment-result-label">쿠폰 사용</div>
								<div>
									<span id="usedCoupon">0</span>원
								</div>
							</div>

							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242">
								<div class="payment-result-label">포인트 사용</div>
								<div>
									<span id="usedPoint">0</span>원
									<c:set var="usedPoint" value=""></c:set>
									<input type="hidden" name="usedPoint" value="0">
									<input type="hidden" name="remainPoint" value="0">
								</div>
							</div>

							<div class="border-line" style="margin-top: 15px;"></div>

							<div class="flex-col">
								<div class="flex-row"
									style="justify-content: space-between; font-size: 18px; font-weight: 700; margin-top: 15px; align-items: center">
									<div style="">최종 결제 금액</div>
									<div style="font-size: 22px">
										<span style="color: #65C2EC;" id="final-price"><fmt:formatNumber value="${totPrice+ totDeliveryCost}" /></span> 원
									</div>
								</div>

								<div
									style="text-align: right; font-size: 13px; color: rgb(66, 66, 66); line-height: 16px; margin-top: 5px;">
									<span style="font-weight: bold"><span id="reward"><fmt:formatNumber type="number" pattern="###,###,###,###,###,###" value="${totPrice*0.001}" /></span> P</span> 적립 예정
									<input type="hidden" name="reward" value="${reward}">
								</div>
							</div>
						</div>

						<div class="border-line"></div>

						<div class="flex-row" style="align-items: center; padding: 20px">
							<div>
								<input
									class="form-check-input follow-check-input flex-check-default"
									type="checkbox" value="">
							</div>
							<div style="font-size: 15px; color: #424242; margin-left: 10px;">아래
								내용에 모두 동의합니다. (필수)</div>
						</div>

						<div class="border-line"></div>

						<div class="flex-col" style="padding: 20px; gap: 20px">
							<div class="flex-row" style="align-items: center;">
								<div>
									<input
										class="form-check-input follow-check-input flex-check-default"
										type="checkbox" value="">
								</div>
								<div
									style="font-size: 14px; color: rgb(101, 110, 117); margin-left: 10px;">개인정보
									수집 이용 및 제 3자 제공 동의 (필수)</div>
							</div>

							<div class="flex-"
								style="font-size: 14px; color: rgb(101, 110, 117)">
								<div>본인은 만 14세 이상이며, 주문 내용을 확인하였습니다.</div>
								<div
									style="font-size: 12px; line-height: 20px; margin-top: 10px;">
									(주)버킷플레이스는 통신판매중개자로 거래 당사자가 아니므로, 판매자가 등록한 상품정보 및 거래 등에 대해 책임을
									지지 않습니다 (단, ㈜버킷플레이스가 판매자로 등록 판매한 상품은 판매자로서 책임을 부담합니다).</div>
							</div>
						</div>
					</div>

					<div onclick="sendOk();iamport();" class="purchase-btn" style="margin-top: 20px;">
						<%-- 결제 가격 --%>
						<span id="finalTotPrice"><fmt:formatNumber value="${totPrice+ totDeliveryCost}" /></span>원 결제하기
						<fmt:parseNumber var= "finalTotPrice" integerOnly= "true" value= "${totPrice+ totDeliveryCost}" />
						<input type="hidden" id="final-tot-price" name="finalTotPrice" value="${finalTotPrice}">
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    function daumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullAddr = ''; // 최종 주소 변수
	                var extraAddr = ''; // 조합형 주소 변수
	
	                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;
	
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    fullAddr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	                if(data.userSelectedType === 'R'){
	                    //법정동명이 있을 경우 추가한다.
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있을 경우 추가한다.
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postNum').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('address1').value = fullAddr;
	
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById('address2').focus();
	            }
	        }).open();
	    }
	</script>
</form>
	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
