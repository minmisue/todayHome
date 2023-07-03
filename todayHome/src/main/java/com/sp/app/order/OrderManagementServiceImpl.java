package com.sp.app.order;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;

@Service
public class OrderManagementServiceImpl implements OrderManagementService{

	@Autowired
	OrderManagementRepository orderManagementRepository;
	
	@Override
	public void createOrder(Order order, List<OrderDetail> orderDetails, List<OrderItemStock> orderItemStocks) {
		String orderBundleId = null;
		try {
			orderManagementRepository.insertOrderBundle(order);
			orderBundleId = order.getOrderBundleId();
			
			// 상품 상세
			for(OrderDetail orderDetail : orderDetails) {
				orderDetail.setOrderBundleId(orderBundleId);
				
				orderManagementRepository.insertOrderItem(orderDetail);
				Long orderItemId = orderDetail.getOrderItemId();
				// 상품 옵션
				for(OrderItemStock orderItemStock: orderItemStocks) {
					orderItemStock.setOrderItemId(orderItemId);
					orderManagementRepository.insertOrderItemStock(orderItemStock);
				}
				
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String productOrderNumber() {
		String productOrderNumber = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", Calendar.getInstance())
				+ System.nanoTime();
		return productOrderNumber;
	}

}
