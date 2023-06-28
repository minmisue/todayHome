package com.sp.app.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;

@Repository
public class OrderManagementRepositoryImpl implements OrderManagementRepository{

	@Autowired
	CommonDAO commondao;
	
	@Override
	public void insertOrderBundle(Order order) throws Exception {
		commondao.insertData("order.insertOrderBundle", order);
		
	}

	@Override
	public void insertOrderItem(OrderDetail orderDetail) throws Exception {
		commondao.insertData("order.insertOrderItem", orderDetail);
		
	}

	@Override
	public void insertOrderItemStock(OrderItemStock orderItemStock) throws Exception {
		commondao.insertData("order.insertOrderItemStock", orderItemStock);
		
	}

	@Override
	public void insertOrderStatus(OrderDetail orderDetail) throws Exception {
		commondao.insertData("order.insertOrderStatus", orderDetail);
		
	}

}
