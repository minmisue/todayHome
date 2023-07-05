<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>장바구니</title>

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
	border-radius: 5px;
	border: 1px solid #EDEDED;
}

.follow-check-input {
	width: 22px;
	height: 22px;
	margin: 0 10px 0 15px;
}

.follow-check-input:hover {
	cursor: pointer;
}

.following-feed-btn-container {
	position: sticky;
	top: 100px;
	display: flex;
	flex-direction: column;
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

.cart-check-container {
	align-items: center;
	justify-content: space-between;
	margin-top: 50px;
	margin-bottom: 10px;
	padding: 0 15px
}

#selected-product-delete:hover {
	cursor: pointer;
}
a{
    text-decoration: none;
    color: black;
}
</style>
<script type="text/javascript">
function totCal() {
		let cartIdList = $("input[name=cartId]");
		// 상품
		// 총 상품 금액 - 원래 금액
		let finalCartPriceOriginal = 0;
		let finalCartPrice = 0;
		for(i=0;i<cartIdList.length;i++){
			cartId = cartIdList[i].value;
			stockList = document.querySelectorAll('.stockList' + cartId);
			

			let totPriceOriginal = 0;
			let totPrice = 0;

			// 옵션				
			for(j=0;j<stockList.length;j++){
				let priceList = stockList[j].querySelectorAll('input[name=price]');
				let disCountPercentList = stockList[j].querySelectorAll('input[name=discountPercent]');
				let cartQuantityList = stockList[j].querySelectorAll('input[name=cartQuantity]');
				// 할인 전 가격
				let productStockPriceOriginal = 0;
				// 할인 후 가격
				let productStockPrice = 0;
				// 옵션상세
				for(k=0;k<priceList.length;k++){
					let price = Number(priceList[k].value);
					let disCountPercent = Number(disCountPercentList[k].value);
					let cartQuantity = Number(cartQuantityList[k].value);
					productStockPriceOriginal += price * cartQuantity;
					
					productStockPrice += price * ((100-disCountPercent)/100) * cartQuantity;
					
					totPrice += productStockPrice;
					totPriceOriginal += productStockPriceOriginal;
				}
				stockList[j].querySelector(".productPrice").innerHTML = productStockPrice.toLocaleString();
			}
			finalCartPriceOriginal += totPriceOriginal;
			finalCartPrice += totPrice;
			document.querySelector(".totPrice"+cartId).innerHTML = totPrice.toLocaleString()+'원';
		}

		let totDisCountPrice= finalCartPriceOriginal - finalCartPrice
		document.querySelector(".finalCartPrice").innerHTML = finalCartPriceOriginal.toLocaleString();
		document.querySelector(".totDisCountPrice").innerHTML = '-' +  (totDisCountPrice.toLocaleString());
		
		//document.querySelector(".finalDeliveryCost").innerHTML = finalDeliveryCost;
		let totDeliveryCost = Number(document.querySelector('.finalDeliveryCost').innerText);
		//alert(totDeliveryCost);
		document.querySelector(".payPrice").innerHTML = (finalCartPriceOriginal + totDeliveryCost - totDisCountPrice).toLocaleString();

}



function ajaxFun(url, method, query, dataType, fn) {
	$.ajax({
		type:method,
		url:url,
		data:query,
		dataType:dataType,
		//contentType : "application/json;charset=UTF-8",
		success:function(data) {
			fn(data);
			//totCal();
		},
		beforeSend:function(jqXHR) {
			jqXHR.setRequestHeader("AJAX", true);
		},
		error:function(jqXHR) {
			if(jqXHR.status === 403) {
				login();
				return false;
			} else if(jqXHR.status === 400) {
				alert("요청 처리가 실패 했습니다.");
				return false;
			}
	    	
			console.log(jqXHR.responseText);
		}
	});
}

$(function() {
	totCal();
})
</script>
	<script type="text/javascript">
	function minus(stockId,cartId,quantity,event) {
		let $quantity = event.target.parentNode.nextSibling.nextSibling.innerHTML;
		
		
		if($quantity <= 1){
			alert('상품은 한개 이상 담아야합니다.');
			return;
		}
		-- $quantity;

		let url = '${pageContext.request.contextPath}/cart/checkQuantityUpdate';
		let query = 'stockId='+ stockId+"&cartId=" + cartId + "&quantity=" + $quantity;

		const fn = function(data) {

			event.target.parentNode.nextSibling.nextSibling.innerHTML = '';
			event.target.parentNode.nextSibling.nextSibling.innerHTML = $quantity;
			$('input#cartQuantity'+stockId).val($quantity);
			totCal();
		};
		ajaxFun(url, "post", query, "json", fn);
	}
	function plus(stockId,cartId,quantity,event) {
		const fn = function(data) {

			event.target.parentNode.previousElementSibling.previousElementSibling.innerHTML = '';
			event.target.parentNode.previousElementSibling.previousElementSibling.innerHTML = $quantity;
			$('input#cartQuantity'+stockId).val($quantity);
			totCal();
		};
		
		let $quantity = event.target.parentNode.previousElementSibling.previousElementSibling.innerHTML;
		let max = event.target.nextElementSibling.value
		
		++ $quantity;
		if($quantity > max){
			alert('재고가 부족합니다. 고객센터로 문의 주세요');
			return;
		}

		let url = '${pageContext.request.contextPath}/cart/checkQuantityUpdate';
		let query = 'stockId='+ stockId+"&cartId=" + cartId + "&quantity=" + $quantity;

		ajaxFun(url, "post", query, "json", fn);
	}

	</script>
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

		// 쿠폰배너 없애기
		$(function() {
			$("#close-coupon-banner").click(function() {
				$(".coupon-banner").closest("div").hide();
			});
		});

		// 전제 선택 
		$(function() {
			$("#all-check-box").click(function() {
				let chk = $(this).is(":checked");

				if (chk)
					$("input[type=checkbox]").prop('checked', true);
				else
					$("input[type=checkbox]").prop('checked', false);
			});
		});
		
		$(function() {
				$("input[type=checkbox]").prop('checked', true);

		});

		// 선택삭제    
		// 체크된 값만 가져오기
		// $(".클래스/#아이디").find('input:checked').each(function(index){}
		$(function() {
			$("#selected-product-delete").click(
							function name() {

								let checkListNum = $('input:checkbox[name=checkList]:checked');
								if (checkListNum.length === 0) {
									alert('선택된 상품이 없습니다');
									return;
								}

								var checkedCartIdList = [];

								for (var i = 0; i < checkListNum.length; i++) {
									if (checkListNum[i].checked) {
										checkedCartIdList.push(checkListNum[i].value);
									}
								}
								if (confirm('선택한 ' + checkListNum.length
										+ '개의 상품을 삭제하시겠습니까?')) {
									location.href = '${pageContext.request.contextPath}/cart/deleteCart?cartIdList='+ checkedCartIdList;
								}

							});

		});

		// 상품 옵션 하나만 삭제
		function deleteStock(stockId) {
			location.href = '${pageContext.request.contextPath}/cart/deleteStock?stockId='+ stockId;
		}


		// 상품 삭제
		function deleteCart(cartId) {
			if(confirm('상품을 삭제하시겠습니까?')){
				location.href = '${pageContext.request.contextPath}/cart/deleteCart?cartIdList='+ cartId;	
			}
			
		}
		

		
		
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container"
		style="background-color: #F5F5F5; margin-top: 70px;">
		<div class="content flex-row">

			<div class="flex-col" style="width: 65%;">
				<div class="flex-row cart-check-container">
					<div class="flex-row" style="align-items: center">
						<div>
							<input
								class="form-check-input follow-check-input flex-check-default"
								type="checkbox" id="all-check-box" value="">
						</div>
						<div style="font-size: 15px; color: #424242">모두선택</div>
					</div>

					<div class="flex-row"
						style="gap: 10px; align-items: center; font-weight: 400; font-size: 12px; color: #424242;">
						<div>품절 모두 삭제</div>
						<div style="color: #DBDBDB">|</div>
						<div id="selected-product-delete">선택삭제</div>
					</div>
				</div>


				<%-- 쿠폰 안내 배너 --%>
				<div style="position: sticky; top: 101px;">
					<div class="shadow-sm coupon-banner flex-row">
						<div>쿠폰 적용된 가격은 결제할 때 확인 가능</div>
						<div style="font-size: 24px">
							<i class="bi bi-x" id="close-coupon-banner"></i>
						</div>
					</div>
				</div>


				<c:forEach var="cart" items="${cartList}">

					<input type="hidden" value="${cart.cartId}" name="cartId">
					<input type="hidden" value="${cart.deliveryCost}"
						name="deliveryCost${cart.cartId}">
					<div class="flex-col cart-item-container"
						style="margin-bottom: 30px;">
						<div class="flex-col"
							style="justify-content: center; align-items: center; border-bottom: #F5F5F5 2px solid; padding: 10px 0; font-size: 15px; font-weight: 500;">
							<div>${cart.brandName}배송</div>
						</div>

						<div class="flex-row" style="gap: 10px; padding: 15px">
							<input
								class="form-check-input follow-check-input flex-check-default"
								type="checkbox" name="checkList" value="${cart.cartId}">

							<div class="flex-row" style="width: 100%;">
								<div class="flex-col" style="gap: 10px; width: 100%">
									<div class="flex-row" style="justify-content: space-between">
										<div class="flex-row"
											style="gap: 5px; background-color: #F8F9FA; font-size: 12px; line-height: 16px; padding: 6px 10px; border-radius: 4px">
											<div>오늘 출발 마감</div>
											<div>|</div>
											<div style="color: #65C2EC; font-weight: 700;">6/9 (금)
												발송 예정</div>
										</div>
										<div id="deleteCart" onclick="deleteCart('${cart.cartId}')">
											<i style="font-size: 22px; font-weight: 700" class="bi bi-x"></i>
										</div>
									</div>
									<div class="flex-row" style="gap: 10px">
										<div class="cart-img-container">
											<img class="cart-img"
												src="https://bucketplace-v2-development.s3.amazonaws.com/uploads/productions/168256978840040031.jpg">
										</div>
										<div class="flex-col" style="flex: 1; gap: 5px">
											<div
												style="font-size: 15px; font-weight: 500; line-height: 21px; overflow-wrap: break-word; transition: opacity 0.1s"><a href="${pageContext.request.contextPath}/product/${cart.productId}">${cart.productName}</a></div>
											<div class="flex-row"
												style="font-size: 11px; line-height: 15px; color: #757575; gap: 5px">
												<div>배송비 ${cart.deliveryCost}원</div>
											</div>
										</div>
									</div>


									<c:set var="deliveryCost" value="0"></c:set>
									<c:forEach var="productStock" items="${cart.productStockList}"  varStatus="status">
										<div class="stockList${cart.cartId}">
											<!-- 자바스크립트 계산을 위한 input태그 -->
											<input type="hidden" value="${cart.discountPercent}"
												name="discountPercent">
											<!-- 상품 원래가격 -->
											<input type="hidden" value="${productStock.price}"
												name="price">
											<!-- 옵션 별 수량-->
											<!-- <input type="hidden" value="${productStock.cartQuantity}"  name="cartQuantity"> -->

											<div class="flex-col"
												style="padding: 10px; height: 100px; border-radius: 3px; background-color: #F8F9FA; justify-content: space-between">
												<div class="flex-row"
													style="justify-content: space-between; align-items: center">
												<div
														style="font-size: 14px; line-height: 18px; color: #2F3438">
														${productStock.mainOptionName1 }:
														${productStock.subOptionName1 } 
														<c:if test="${productStock.mainOptionName2 != null}">
															/ ${productStock.mainOptionName2 }:
															${productStock.subOptionName2 }
															
														</c:if>
													</div>
													<c:choose>
														<c:when test="${fn:length(cart.productStockList)  == 1}">
															<i class="bi bi-x" style="color: #828C94; font-size: 22px;" onclick="deleteCart('${cart.cartId}')"></i>
														</c:when>
														<c:when test="${fn:length(cart.productStockList)  != 1}">
															<i class="bi bi-x" style="color: #828C94; font-size: 22px;" onclick="deleteStock('${productStock.stockId}')"></i>
														</c:when>
													</c:choose>	
												</div>
												<div class="flex-row"
													style="justify-content: space-between; align-items: center">
													<div class="flex-row"
														style="border: 1px solid rgb(218, 221, 224); width: 84px; height: 34px; justify-content: space-around; background-color: white; align-items: center; border-radius: 4px; font-size: 14px">
														<div class="quantity-btn minus-btn"
															onclick="minus('${productStock.stockId}','${cart.cartId}','${productStock.cartQuantity}',event)">
															<i class="bi bi-dash"></i>
															
														</div>
														<div class="quantity-value">${productStock.cartQuantity}</div>
														<input type="hidden" value="${productStock.cartQuantity}"
															name="cartQuantity" id="cartQuantity${productStock.stockId}">
														<div class="quantity-btn plus-btn"
															onclick="plus('${productStock.stockId}','${cart.cartId}','${productStock.cartQuantity}',event)">
															<i class="bi bi-plus"></i>
															<input type="hidden" value="${productStock.quantity }">
														</div>
													</div>
													<div style="line-height: 20px; font-weight: 700;">

														<span class="productPrice"></span>원
													</div>
												</div>
											</div>
										</div>
										<c:set var="deliveryCost"
											value="${deliveryCost + cart.deliveryCost}"></c:set>

									</c:forEach>
									<div class="flex-row" style="justify-content: space-between">
										<div class="flex-row"
											style="gap: 5px; font-size: 12px; letter-spacing: -.4px; font-weight: 400; color: #424242; padding: 5px 0">

										</div>
										<div
											style="line-height: 20px; font-weight: 700; font-size: 17px">
											<span class="totPrice${cart.cartId}">원</span>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="flex-col"
							style="justify-content: center; align-items: center; border-top: #F5F5F5 2px solid; padding: 10px 0; font-size: 15px;">
							<div>${deliveryCost}원</div>
						</div>
					</div>

					<c:set var="totDeliveryCost"
						value="${totDeliveryCost + deliveryCost}" />
				</c:forEach>

			</div>

			<div
				style="flex: 1; padding-left: 20px; padding-top: 20px; margin-top: 40px">
				<div class="following-feed-btn-container">
					<div style="width: 100%;">
						<div class="flex-col"
							style="border: 1px solid #ededed; width: 100%; background-color: white; border-radius: 6px; padding: 30px 20px; margin-bottom: 20px; gap: 10px">
							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242">
								<div style="font-weight: 400">총 상품 금액</div>
								<div style="font-weight: 700;">
									<span class="finalCartPrice"></span>원
								</div>
							</div>

							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242">
								<div style="font-weight: 400">총 배송비</div>
								<div style="font-weight: 700;">
									<span class="finalDeliveryCost">${totDeliveryCost}</span>원
								</div>
							</div>

							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242">
								<div style="font-weight: 400">총 할인 금액</div>
								<div style="font-weight: 700;">
									<span class="totDisCountPrice"></span>원
								</div>
							</div>

							<div class="flex-row"
								style="justify-content: space-between; font-size: 15px; font-weight: 700; align-items: center; margin-top: 30px;">
								<div style="">결제금액</div>
								<div style="font-size: 24px">

									<span class="payPrice"></span>원
								</div>
							</div>
						</div>
					</div>

					<div class="purchase-btn"
						onclick="location.href='${pageContext.request.contextPath}/payment/list'">
						${fn:length(cartList) }개 상품 구매하기</div>
				</div>
			</div>

		</div>
	
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
