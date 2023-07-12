<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>

<div class="body-container">
    <div class="body-title">
		<h2><i class="fa-brands fa-perbyte"></i> 주문상태 변경 </h2>
    </div>
    <form action="${pageContext.request.contextPath}/seller/deliveryManage/order-status-change/${order.orderItemId}" method="post">
        <label for="orderItemId">주문 번호:${order.orderItemId}</label>
        
	<div>
        <label for="status">새로운 상태:</label>
        <select id="status" name="status" required>
            <option value="2" >배송준비</option>
            <option value="3" >배송중</option>
            <option value="4" >배송완료</option>
            <option value="5" >구매확정</option>
        </select><br><br>
	</div>
        <input type="submit" value="상태 변경">
    </form>
</div>
