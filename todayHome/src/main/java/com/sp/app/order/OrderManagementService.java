package com.sp.app.order;

import java.util.List;

import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;

public interface OrderManagementService {
	
	// 컨트롤러에서 Order 와 주문아이템들(List<OrderDetail>)을 받아옴 여기서 주문 묶음, 주문아이템들, 주문상태 한꺼번에 업데이트 할거임
	public void createOrder(Order order, List<OrderDetail> orderDetails, List<OrderItemStock> orderItemStocks) throws Exception;
	
	public String productOrderNumber();
}
