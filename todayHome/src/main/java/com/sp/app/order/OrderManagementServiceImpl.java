package com.sp.app.order;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.order.Delivery;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;

@Service
public class OrderManagementServiceImpl implements OrderManagementService{

	@Autowired
	OrderManagementRepository orderManagementRepository;
	
	@Override
	public void createOrder(Order order, List<OrderDetail> orderDetails, List<OrderItemStock> orderItemStocks,List<Delivery> deliverys) throws Exception{
		String orderBundleId = null;
		Long orderItemId = null;
		try {
			orderManagementRepository.insertOrderBundle(order);
			orderBundleId = order.getOrderBundleId();
			
			for(int i=0;i<orderDetails.size();i++) {
				OrderDetail orderDetail = orderDetails.get(i);
				orderDetail.setOrderBundleId(orderBundleId);
				orderManagementRepository.insertOrderItem(orderDetail);
				orderManagementRepository.insertOrderStatus(orderDetail); // 상태
				orderItemId = orderDetail.getOrderItemId();
				Delivery delivery = deliverys.get(i);
				delivery.setOrderItemId(orderItemId);
				orderManagementRepository.insertDelivery(delivery);
				for(OrderItemStock orderItemStock: orderItemStocks) {
					if(orderItemStock.getGubun().compareTo(i) == 0) {
						orderItemStock.setOrderItemId(orderItemId);
						orderManagementRepository.insertOrderItemStock(orderItemStock);
					}
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public String productOrderNumber() {
		String productOrderNumber = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", Calendar.getInstance())
				+ System.nanoTime();
		return productOrderNumber;
	}

	@Override
	public List<Order> getOrderList(Long sellerId,int offset,int size,String startDate, String endDate,String keyword,String condition) throws Exception {
		List<Order> orderList = orderManagementRepository.getOrderList(sellerId,offset,size,startDate,endDate,keyword,condition);
		return orderList;
	}

	@Override
	public List<Order> getOrderDetailList(Long sellerId, String orderBundleId) throws Exception {
		List<Order> orderDetailList = orderManagementRepository.getOrderDetailList(sellerId, orderBundleId);
		return orderDetailList;
	}

	@Override
	public Order getOrderCount(Long sellerId, String date) throws Exception {
		Order orderCount = orderManagementRepository.getOrderCount(sellerId, date);
		return orderCount;
	}

	@Override
	public int getOrderListCount(Long sellerId, String startDate, String endDate, String keyword, String condition) throws Exception{
	
		return orderManagementRepository.getOrderListCount(sellerId, startDate,endDate,keyword,condition);
	
}
}
