<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<div class="mt-3">
		<div class="p-3 shadow bg-body rounded">
			<p class="fs-6 fw-semibold mb-0">주문 정보</p> 
		</div>
		<div class="mt-3 p-2">
			<table class="table table-bordered mb-1">
				<tr>
					<td class="table-light" width="105">주문번호</td>
					<td width="150">${order.orderNum}</td>
					<td class="table-light" width="105">주문자</td>
					<td width="150">${order.userName}</td>
					<td class="table-light" width="105">주문일자</td>
					<td width="150">${order.orderDate}</td>
					<td class="table-light" width="110">주문상태</td>
					<td width="150">${order.orderStateInfo}</td>
				</tr>
				<tr>
					<td class="table-light">총금액</td>
					<td class="text-primary"><fmt:formatNumber value="${order.totalMoney}"/></td>
					<td class="table-light">적림금사용액</td>
					<td class="text-primary"><fmt:formatNumber value="${order.usedSaved}"/></td>
					<td class="table-light">결제금액</td>
					<td class="text-primary"><fmt:formatNumber value="${order.payment}"/></td>
					<td class="table-light">취소금액</td>
					<td class="text-warning order-cancelAmount" data-cancelAmount="${order.cancelAmount}">
						<fmt:formatNumber value="${order.cancelAmount}"/>
					</td>
				</tr>
				<tr>
					<td class="table-light">배송비</td>
					<td class="text-primary"><fmt:formatNumber value="${order.deliveryCharge}"/></td>
					<td class="table-light">배송업체</td>
					<td>${order.deliveryName}</td>
					<td class="table-light">송장번호</td>
					<td>${order.invoiceNumber}</td>
					<td class="table-light">상태변경일</td>
					<td>${order.orderStateDate}</td>
				</tr>
				<tr>
					<td class="table-light">결제구분</td>
					<td>${order.payMethod}</td>
					<td class="table-light">결제카드</td>
					<td>${order.cardName}</td>
					<td class="table-light">결제승인번호</td>
					<td>${order.authNumber}</td>
					<td class="table-light">승인일자</td>
					<td>${order.authDate}</td>
				</tr>
			</table>
			<table class="table table-borderless mb-1">
				<tr>
					<td width="50%">
						<c:if test="${order.orderState < 3}">
							<button type="button" class="btn btn-light btn-cancel-order" data-orderNum="${order.orderNum}">판매취소</button>
						</c:if>
					</td>
					<td class="text-end">
						<c:if test="${order.orderState == 1}">
							<button type="button" class="btn btn-light btn-prepare-order" data-orderNum="${order.orderNum}">발송처리</button>
						</c:if>
					
						<div class="row justify-content-end delivery-update-area">
							<c:if test="${order.orderState > 1 && order.orderState < 5 }">
								<div class="col-auto">
									<select class="form-select delivery-select">
										<option value="2" ${order.orderState==2?"selected='selected'":"" }>발송준비</option>
										<option value="3" ${order.orderState==3?"selected='selected'":"" }>배송시작</option>
										<option value="4" ${order.orderState==4?"selected='selected'":"" }>배송중</option>
										<option value="5" ${order.orderState==5?"selected='selected'":"" }>배송완료</option>
									</select>
								</div>
								<div class="col-auto">
									<button type="button" class="btn btn-light btn-delivery-order" data-orderNum="${order.orderNum}" data-orderState="${order.orderState}">배송변경</button>
								</div>
							</c:if>
							<c:if test="${order.orderState == 5}">
								<div class="col-auto">
									<label>배송완료 일자 : ${order.orderStateDate}</label>
								</div>
							</c:if>
							
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="mt-2 border-top pt-2">	
		<div class="p-3 shadow bg-body rounded">
			<p class="fs-6 fw-semibold mb-0">주문 상세정보</p> 
		</div>
		<div class="mt-3 p-3">
			
			<table class="table board-list order-detail-list">
				<thead class="table-light">
					<tr>
						<th class="bw-80">상세번호</th>
						<th>상품명</th>
						<th class="bw-90">상품가격</th>
						<th class="bw-90">할인가격</th>
						<th class="bw-130">옵션</th>
						<th class="bw-80">주문수량</th>
						<th class="bw-100">주문총금액</th>
						<th class="bw-90">적립금</th>
						<th class="bw-110">주문상태</th>
						<th class="bw-60">변경</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="dto" items="${listDetail}" varStatus="status">
						<tr valign="middle" id="orderDetail-list${dto.orderDetailNum}">
							<td>${dto.orderDetailNum}</td>
							<td>${dto.productName}</td>
							<td><fmt:formatNumber value="${dto.price}"/></td>
							<td><fmt:formatNumber value="${dto.salePrice}"/></td>
							<td>${dto.optionValue} / ${dto.optionValue2}</td>
							<td>${dto.qty}</td>
							<td><fmt:formatNumber value="${dto.productMoney}"/></td>
							<td><fmt:formatNumber value="${dto.savedMoney}"/></td>
							<td>${order.orderState==1 && dto.detailState==0?"상품준비중":dto.detailStateInfo}</td>
							<td>
								<span class="orderDetailStatus-update" 
										data-orderNum="${order.orderNum}" data-orderState="${order.orderState}"
										data-productMoney="${dto.productMoney}"
										data-orderDetailNum="${dto.orderDetailNum}" data-detailState="${dto.detailState}">수정</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</div>
	</div>
</div>
