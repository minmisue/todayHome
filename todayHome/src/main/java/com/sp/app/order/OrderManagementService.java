package com.sp.app.order;

import java.util.List;

import com.sp.app.domain.order.Delivery;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;

public interface OrderManagementService {
	
	// 컨트롤러에서 Order 와 주문아이템들(List<OrderDetail>)을 받아옴 여기서 주문 묶음, 주문아이템들, 주문상태 한꺼번에 업데이트 할거임
	public void createOrder(Order order, List<OrderDetail> orderDetails, List<OrderItemStock> orderItemStocks, List<Delivery> deliverys) throws Exception;
	// 주문 번호
	public String productOrderNumber();
	
	// 주문 조회 
	public List<Order> getOrderList(Long sellerId,int offset,int size,String startDate, String endDate,String keyword,String condition) throws Exception;
	
	// 주문 상세 조회
	public List<Order> getOrderDetailList(String orderBundleId,int offset,int size) throws Exception; 
	
	public Order getOrderCount(Long sellerId, String date) throws Exception;

	//주문조회 카운트
	int orderListCount(Long sellerId,String startDate,String endDate,String keyword,String condition)throws Exception;

	int orderDetailCount(String orderBundleId) throws Exception;
	
	public void createOrderState(OrderDetail orderDetail) throws Exception;
}
