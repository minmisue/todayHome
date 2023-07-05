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
	public void createOrder(Order order, List<OrderDetail> orderDetails, List<OrderItemStock> orderItemStocks) throws Exception{
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

}
