package com.sp.app.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.order.Delivery;
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

	@Override
	public void insertDelivery(Delivery delivery) throws Exception {
		commondao.insertData("order.insertDelivery", delivery);
		
	}

	@Override
	public List<Order> getOrderList(Long sellerId) throws Exception {
		List<Order> orderList = commondao.selectList("order.getOrderList", sellerId);
		return orderList;
	}

	@Override
	public List<Order> getOrderDetailList(Long sellerId, String orderBundleId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("sellerId", sellerId);
		map.put("orderBundleId", orderBundleId);
		
		List<Order> OrderDetailList = commondao.selectList("order.getOrderDetailList", map);
		return OrderDetailList;
	}


}
