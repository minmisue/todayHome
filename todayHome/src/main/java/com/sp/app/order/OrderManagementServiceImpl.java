package com.sp.app.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;

@Service
public class OrderManagementServiceImpl implements OrderManagementService{

	@Autowired
	OrderManagementRepository orderManagementRepository;
	
	@Override
	public void createOrder(Order order, List<OrderDetail> orderDetails) {
		Long orderBundleId = null;
		try {
			orderManagementRepository.insertOrderBundle(order);
			orderBundleId = order.getOrderBundleId();
			
			for(OrderDetail orderDetail : orderDetails) {
				orderDetail.setOrderBundleId(orderBundleId);
				
				orderManagementRepository.insertOrderItem(orderDetail);
				Long orderItemId = orderDetail.getOrderItemId();
				
				orderDetail.setOrderItemId(orderItemId);
				orderManagementRepository.insertOrderStatus(orderDetail);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
