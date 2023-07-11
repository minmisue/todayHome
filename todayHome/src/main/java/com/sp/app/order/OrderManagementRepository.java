package com.sp.app.order;

import java.util.List;

import com.sp.app.domain.order.Delivery;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;

public interface OrderManagementRepository {
	
	// 주문 묶음 테이블 insert
	public void insertOrderBundle(Order order) throws Exception;
	
	// 주문 아이템 테이블 insert
	public void insertOrderItem(OrderDetail orderDetail) throws Exception;
	
	// 상품 옵션 테이블 insert
	public void insertOrderItemStock(OrderItemStock orderItemStock) throws Exception;
	
	// 주문 상태 테이블 insert
	public void insertOrderStatus(OrderDetail orderDetail) throws Exception;
	
	public void insertDelivery(Delivery delivery) throws Exception;
	
	// 셀러별 주문 조회
	public List<Order> getOrderList(Long sellerId,int offset,int size,String startDate,String endDate,String keyword,String condition) throws Exception;
	
	// 셀러별 주문 조회 상세
	public List<Order> getOrderDetailList(String orderBundleId,int offset , int size) throws Exception;
	
	// 카운트
	public Order getOrderCount(Long sellerId, String date) throws Exception;
	
	int orderListCount(Long sellerId,String startDate,String endDate,String keyword,String condition)throws Exception;

	int orderDetailCount(String orderBundleId) throws Exception;
	
	public Integer dateCountByStatus(Long memberId, Integer status) throws Exception;
}
